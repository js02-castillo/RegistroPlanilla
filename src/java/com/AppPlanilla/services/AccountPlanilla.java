/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppPlanilla.services;

import java.sql.*;
import com.AppPlanilla.data.ConnectionDB;
import com.AppPlanilla.models.Planilla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AccountPlanilla {
    
    
    
    public List<Planilla> Register(int mes)throws SQLException, ClassNotFoundException{
        try{
            Connection cn=ConnectionDB.GetConnection();
            PreparedStatement ps=cn.prepareStatement("{call _Calculando_Planilla_Mes(?)}");
            ps.setInt(1, mes);
            ResultSet rs = ps.executeQuery();
            
            List<Planilla> ListPlanilla= new ArrayList<>() ; 
           
            
            while(rs.next()){
               Planilla planilla = new Planilla();
               planilla.setIdPlanilla(rs.getInt("idPlanilla"));
               planilla.setIdAfp(rs.getString("idAfp"));
               planilla.setIdTrabajador(rs.getString("idTrabajador"));
               planilla.setIdMes(rs.getString("idMes"));
               planilla.setDiasFalta(rs.getString("DiasFalta"));
               planilla.setHorasFalta(rs.getString("HorasFalta"));
               planilla.setTotalIngresos(rs.getDouble("TotalIngresos"));
               planilla.setTotalDescuentos(rs.getDouble("TotalDescuentos"));
               
               ListPlanilla.add(planilla);
            }
            
            return ListPlanilla;
            
        }catch(Exception ex){
            throw ex;
        }
    }
}
