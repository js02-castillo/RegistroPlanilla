<%-- 
    Document   : Register
    Created on : 22/07/2021, 12:49:21 PM
    Author     : usuario
--%>

<%@page import="com.AppPlanilla.models.Planilla"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planilla</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        
    </head>
    <body>
        <%
            if(request.getAttribute("code")!=null){
                if( Integer.parseInt(request.getAttribute("code").toString())==200){
                    
        %>
        <script>
                alert('200-Registro con Exito')
        </script>
        <%
                }else{
        %>
        <script>
                alert('500-Error en el proceso')
        </script>
        <%
                    
                }
            }
        %>
        
        <div class="container">
            
            <div class="card" >
                <p class="h1" style="text-align: center" >Cálculo de Planilla</p>
                <form method="post" action="AccountPlanillaController">
                    <div class="input-group">
                        <input id="txtmes" name="txtmes" type="number" min="1" pattern="^[0-9]+" class="form-control" placeholder="Ingrese Mes" aria-label="Recipient's username with two button addons">
                        
                        <button class="btn btn-outline-secondary" type="submit" id="btnregister" name="btnregister" value="Register" >Calcular</button>
                    </div>
                </form>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                  <tr>
                    <th scope="col">idPlanilla</th>
                    <th scope="col">idAfp</th>
                    <th scope="col">idTrabajador</th>
                    <th scope="col">idMes</th>
                    <th scope="col">DiasFalta</th>
                    <th scope="col">HorasFalta</th>
                    <th scope="col">TotalIngresos</th>
                    <th scope="col">TotalDescuentos</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                        if(request.getAttribute("listPlanilla")!=null){
                            for(Planilla item : (List<Planilla>) request.getAttribute("listPlanilla")){  
                    %>
                  <tr>
                    <th scope="row"><%= item.getIdPlanilla() %></th>
                    <td><%= item.getIdAfp() %></td>
                    <td><%= item.getIdTrabajador() %></td>
                    <td><%= item.getIdMes() %></td>
                    <td><%= item.getDiasFalta() %></td>
                    <td><%= item.getHorasFalta() %></td>
                    <td><%= item.getTotalIngresos() %></td>
                    <td><%= item.getTotalDescuentos() %></td>
                  </tr>
                  
                  <%
                        }
                      }
                  %>
                  
                </tbody>
              </table>
        </div> <br><br>
        
        <div class="card" >
                <p class="h5" style="text-align: left" >Integrantes:</p>
                <li  style="text-align: left" >Caiguaray Cotrina, Luis Fernando.</li>
                <li  style="text-align: left" >Castillo Campos, Johnny Stuar.</li>
                <li style="text-align: left" >García Horna, Francisco Alejandro.</li>
                <li  style="text-align: left" >Guevara Segura, Jair Erinson.</li>
                <li  style="text-align: left" >Ortiz Noriega, Keyly Esperanza.</li>
                <li  style="text-align: left" >Puelles Caldas, Miuler.</li>
                <li  style="text-align: left" >Reyes Julca, Christian Steven.</li>
                <li  style="text-align: left" >Vera Paredes, Tania Maribel.</li>
        </div>
        
        
        
    </body>
</html>
