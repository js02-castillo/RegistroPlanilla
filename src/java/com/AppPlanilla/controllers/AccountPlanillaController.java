/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppPlanilla.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.AppPlanilla.services.AccountPlanilla;
import com.AppPlanilla.models.Planilla;
import java.util.List;

/**
 *
 * @author usuario
 */
@WebServlet(name = "AccountPlanillaController", urlPatterns = {"/AccountPlanillaController"})
public class AccountPlanillaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("btnregister")!=null){
            RegisterPlanilla(request,response);
        }
    }
    private void RegisterPlanilla(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            
        try{
             int mes=Integer.parseInt(request.getParameter("txtmes")) ;
             
             if(mes<=0){
                 throw new Exception("Mes no valido");
             }
             
             AccountPlanilla ap= new AccountPlanilla();
             
             List<Planilla> listPlanilla= ap.Register(mes);
            
             
             request.setAttribute("listPlanilla",listPlanilla);
             request.setAttribute("message","Registro con Exito");
             request.setAttribute("code",200);
             request.getRequestDispatcher("Register.jsp").forward(request, response);
             
        }catch(Exception ex){
            request.setAttribute("message",ex.getMessage());
            request.setAttribute("code",500);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
           
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
