/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.ClienteController;
import Controller.EmpleadoController;
import Controller.ModuloController;
import Controller.ReservaController;
import Model.Cliente;
import Model.Empleado;
import Model.ModuloTiempo;
import Model.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yarredondo
 */
@WebServlet(name = "detalleReservaConfirmar", urlPatterns = {"/detalleReservaConfirmar"})
public class detalleReservaConfirmar extends HttpServlet {

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
            Reserva reserva = new ReservaController().buscarReservaPorId(Integer.parseInt(request.getParameter("txtCodigoReserva")));
            Cliente cliente = new ClienteController().buscarCliente(reserva.getCliente().getRut());
            ModuloTiempo modulo = new ModuloController().buscarModuloPorId(reserva.getModuloTiempo());
            Empleado empleado = new EmpleadoController().buscarEmpleadoPorRut(modulo.getRutEmpleado());
            HttpSession sesion = request.getSession();
            sesion.setAttribute("reservaCodigo", reserva.getId());
            sesion.setAttribute("reservaNombreCliente", cliente.getNombre()+" "+cliente.getApellidoPaterno()+" "+cliente.getApellidoMaterno());
            sesion.setAttribute("reservaRutCliente", cliente.getRut());
            sesion.setAttribute("reservaFecha", modulo.getFecha());
            sesion.setAttribute("reservaHora", modulo.getHoraInicio());
            sesion.setAttribute("reservaEmpleado", empleado.getNombre()+" "+empleado.getApellidoPaterno()+" "+empleado.getApellidoMaterno());
            response.sendRedirect("/LindaSonrisa/pages/confirmarReserva.jsp");
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
