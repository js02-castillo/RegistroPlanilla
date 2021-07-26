
package com.AppPlanilla.data;

import java.sql.*;
/**
 * @author usuario
 */
public class ConnectionDB {
    private ConnectionDB(){} 
    private static Connection cn=null;
    public static Connection GetConnection() throws SQLException,
            ClassNotFoundException{
        if(cn==null){
            try{
                String server,database,user,password="";
                server="localhost";
                database="Planilla";
                user="soporte";
                password="123456";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                cn=DriverManager.getConnection("jdbc:sqlserver://"+server +":1433;databaseName="+database,
                        user,
                        password);     
            }catch(Exception ex){
                throw ex;
            }
        }
        return cn;
    }
    public static void CloseConnection() throws SQLException{
        try{
            if(cn!=null){
                cn.close();
            }
        }catch(Exception ex){
            throw ex;
        }
    }
}
