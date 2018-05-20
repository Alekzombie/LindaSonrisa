/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.ServicioController;
import Model.Servicio;
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
@WebServlet(name = "modificarServicio", urlPatterns = {"/modificarServicio"})
public class modificarServicio extends HttpServlet {

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
           Servicio dto = new Servicio();
            
            String servicio = request.getParameter("cmbServicio");
            int id = new ServicioController().nombreToId(servicio);
            dto.setId(id);
            
            
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));
            int duracion = Integer.parseInt(request.getParameter("cmbModulo"));
            int disponible = Integer.parseInt(request.getParameter("rdDisponible"));
            
            dto.setPrecio(precio);
            dto.setDuracion(duracion);
            dto.setDisponible(disponible);

            if (new ServicioController().modificarServicio(dto)) {
                request.setAttribute("mensaje", "Modificacion Servicio Existoso");
            } else {
                request.setAttribute("mensaje", "No hubo Modificacion del Servicio");
            }

            request.getRequestDispatcher("paginas/VentanaModificarServicio.jsp").forward(request, response);
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
