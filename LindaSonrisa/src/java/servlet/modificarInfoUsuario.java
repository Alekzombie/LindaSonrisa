/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.ComunaController;
import Controller.UsuarioController;
import Model.Comuna;
import Model.Contacto;
import Model.Domicilio;
import Model.Persona;
import Model.PersonaNatural;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lmerino
 */
@WebServlet(name = "modificarInfoUsuario", urlPatterns = {"/modificarInfoUsuario"})
public class modificarInfoUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            PersonaNatural prs = new PersonaNatural() {};
            prs.setRut(request.getParameter("txtRut"));
            
            Contacto cnt = new Contacto() {};
            cnt.setCorreoElectronico(request.getParameter("txtMail"));
            cnt.setTelefonoFijo(request.getParameter("txtTelefonoFijo"));
            cnt.setTelefonoMovil(request.getParameter("txtTelefonoMovil"));
            cnt.setPersona(prs);
            
            prs.setContacto(cnt);
            
            Domicilio dmc = new Domicilio();
            dmc.setNombreCalle(request.getParameter("txtNombreCalle"));
            dmc.setNro_calle(Integer.parseInt(request.getParameter("txtNroCalle")));
            dmc.setCasa_depto(Integer.parseInt(request.getParameter("rdTipoVivienda")));
            dmc.setNro_depto(request.getParameter("txtNroDepto"));
            String nombreComuna = request.getParameter("cmbComuna");
            Comuna comuna = new ComunaController().nombreToId(nombreComuna);
            dmc.setComuna(comuna); 
            dmc.getComuna().setNombre(nombreComuna);
            dmc.setPersona(prs);          
 
            System.out.println(prs.toString());
            System.out.println(dmc.toString());
            
//            if (new UsuarioController().modificarNatural(prs)) {
//                request.setAttribute("mensaje", "Modificacion Existosa");
//            } else {
//                request.setAttribute("mensaje", "No hubo Modificacion");
//            }
//
//            if (new UsuarioController().modificarDomicilio(dmc)) {
//                request.setAttribute("mensaje", "Modificacion Existosa");
//            } else {
//                request.setAttribute("mensaje", "No hubo Modificacion");
//            }
            
            request.getRequestDispatcher("paginas/ModificarInformacionUsuario.jsp").forward(request, response);

            
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
