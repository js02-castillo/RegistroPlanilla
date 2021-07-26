use Planilla
go
drop procedure if exists _Calculando_Planilla_Mes 
go
create PROCEDURE _Calculando_Planilla_Mes
@Mes int
AS
DECLARE @uit numeric(9,2), @idPlanilla int, @ingresos numeric(9,2), @egresos numeric(9,2)
DECLARE @idtrabajador int, @afp smallint,  @tasa numeric(6,2), @faltas int
DECLARE @horas numeric(7,2), @basico numeric(9,2)

SELECT @uit = uit FROM Parametro where Parametro.Estado =1

DECLARE c_planilla CURSOR FOR 
	SELECT t.idTrabajador, t.idAfp, afp.Tasa/100 AS Tasa, ISNULL(rh.DiasFalta,0) as Faltas,
			isnull(rh.HorasFalta,0 ) as Horas, t.Basico
	FROM Trabajador t INNER JOIN afp ON afp.idAfp = t.idAfp
			LEFT JOIN ResumenHorario rh ON rh.idTrabajador =t.idTrabajador AND rh.idMes =@Mes 
	WHERE t.Estado =1

OPEN c_planilla

FETCH c_planilla into @idtrabajador, @afp ,  @tasa , @faltas , @horas, @basico
WHILE @@FETCH_STATUS =0
 BEGIN
	SET @ingresos=0
	SET @egresos =0
	INSERT Planilla (idAfp, idTrabajador,DiasFalta, HorasFalta, idMes, TotalDescuentos, TotalIngresos )
	values	(@afp, @idtrabajador, @faltas , @horas , @Mes ,0, 0)
	SET @idPlanilla =@@IDENTITY 
	----- ingresos
	INSERT DetaPlanilla (idPlanilla , idConcepto , Monto )
		VALUES (@idPlanilla , '010', @basico )
	SET @ingresos =@ingresos +@basico 
	----- egresos
		---a. Asistencia
	IF @horas >0 or @faltas >0
		BEGIN
			IF @faltas>0
				BEGIN
					INSERT DetaPlanilla (idPlanilla , idConcepto , Monto )
					VALUES (@idPlanilla , '200', @faltas * @basico/26 )
					SET @egresos=@egresos +@faltas * @basico/26
				END
			IF @horas >0
				BEGIN
					INSERT DetaPlanilla (idPlanilla , idConcepto , Monto )
					VALUES (@idPlanilla , '100', @horas  * @basico/26/8 )
					SET @egresos=@egresos +@horas* @basico/26/8
				END		
		END
		---b. afp
	INSERT DetaPlanilla (idPlanilla , idConcepto , Monto )
	VALUES (@idPlanilla , '400', @ingresos * @tasa )
	SET @egresos=@egresos +@ingresos * @tasa
		---c. renta
	IF	@ingresos > @uit*7/12
		BEGIN
			INSERT DetaPlanilla (idPlanilla , idConcepto , Monto )
			VALUES (@idPlanilla , '300',  (@ingresos - @uit*7/12) * 0.15)
			SET @egresos=@egresos +(@ingresos - @uit*7/12) * 0.15
		END
	
	UPDATE Planilla SET TotalIngresos=@ingresos, TotalDescuentos=@egresos WHERE idPlanilla=@idPlanilla


	FETCH c_planilla into @idtrabajador, @afp ,  @tasa , @faltas , @horas, @basico
	

 END
 select * from Planilla where idMes=@Mes

 CLOSE c_planilla
 DEALLOCATE c_planilla
 go

 --Probando
go
execute _Calculando_planilla_mes '2'
go


delete DetaPlanilla
delete Planilla

select* from trabajador

select* from MesProceso

select* from ResumenHorario

select* from Planilla
select*from DetaPlanilla



