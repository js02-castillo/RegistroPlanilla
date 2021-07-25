/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppPlanilla.models;

/**
 *
 * @author usuario
 */
public class Planilla {
    public int idPlanilla;
    public String idAfp;
    public String idTrabajador; 
    public String idMes;
    public String DiasFalta;
    public String HorasFalta;
    public double TotalIngresos;
    public double TotalDescuentos;

    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public String getIdAfp() {
        return idAfp;
    }

    public void setIdAfp(String idAfp) {
        this.idAfp = idAfp;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getIdMes() {
        return idMes;
    }

    public void setIdMes(String idMes) {
        this.idMes = idMes;
    }

    public String getDiasFalta() {
        return DiasFalta;
    }

    public void setDiasFalta(String DiasFalta) {
        this.DiasFalta = DiasFalta;
    }

    public String getHorasFalta() {
        return HorasFalta;
    }

    public void setHorasFalta(String HorasFalta) {
        this.HorasFalta = HorasFalta;
    }

    public double getTotalIngresos() {
        return TotalIngresos;
    }

    public void setTotalIngresos(double TotalIngresos) {
        this.TotalIngresos = TotalIngresos;
    }

    public double getTotalDescuentos() {
        return TotalDescuentos;
    }

    public void setTotalDescuentos(double TotalDescuentos) {
        this.TotalDescuentos = TotalDescuentos;
    }
    
}
