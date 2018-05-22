/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.PersonaController;
import Controller.UsuarioController;
import Model.Persona;
import Model.PersonaNatural;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lmerino
 */
@WebServlet(name = "agregarEmpleado", urlPatterns = {"/agregarEmpleado"})
public class agregarEmpleado extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            DateFormat df = new SimpleDateFormat("yyyy-MM-d");
            String mensaje = "";
            
            PersonaNatural persona = new PersonaNatural() {
            };
            persona.setRut(request.getParameter("txtRut"));
            persona.setNombre(request.getParameter("txtNombre"));
            persona.setApellidoPaterno(request.getParameter("txtPaterno"));
            persona.setApellidoMaterno(request.getParameter("txtMaterno"));

            persona.setFechaNacimiento(df.parse(request.getParameter("calFechaNacimiento")));
            persona.setCantidadCargas(Integer.parseInt(request.getParameter("txtCargas")));

            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(request.getParameter("txtNombreUsuario"));
            usuario.setPassword(request.getParameter("txtPassword"));
            usuario.setRutPersona(request.getParameter("txtRut"));
            usuario.setTipoUsuario(request.getParameter("SS_TipoUsuario"));
            
            System.out.println(persona.toString());

            if (new PersonaController().agregarNatural(persona)) {
                mensaje = "EMPLEADO REGISTRADO";
            } else {
                mensaje = "EMPLEADO NO REGISTRADO";
            }
            if (new UsuarioController().agregarUsuario(usuario)) {
                mensaje = "USUARIO REGISTRADO";
            } else {
                mensaje = "USUARIO NO REGISTRADO";
            }

            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/paginas/RegistrarEmpleado.jsp").forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(agregarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
