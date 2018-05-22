/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.UsuarioController;
import Model.Usuario;
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
 * @author hozonov
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            String action = request.getParameter("action");
            if(action.equals("login")){
                String mensaje = "";                
                String user = request.getParameter("txtUsuario");
                String pass = new util.Encriptacion().Encriptar(request.getParameter("txtContrasena"));
                Usuario usuario = new UsuarioController().buscar(user);
                if (usuario!=null && usuario.getPassword().equals(pass)) {             
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", usuario);
                    String home ="";
                    String perfil = usuario.getTipoUsuario();
                    switch (perfil) {
                        case "ADMIN":
                            home = "/LindaSonrisa/pages/homeAdministrador.jsp";
                            break;
                        case "SCTR":
                            home = "/LindaSonrisa/pages/homeSecretaria.jsp";
                            break;
                        case "MDC":
                            home = "/LindaSonrisa/pages/homeMedico.jsp";
                            break;
                        case "CLT":
                            home = "/LindaSonrisa/pages/homeCliente.jsp";
                            break;
                        case "PRV":
                            home = "/LindaSonrisa/pages/homeProveedor.jsp";
                            break;
                    }
                    sesion.setAttribute("perfil", perfil);
                    sesion.setAttribute("home", home);
                    response.sendRedirect(home);
                } else {
                    mensaje = "Datos no coinciden";
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/pages/Login.jsp").forward(request, response);
                }               
            }
            if(action.equals("signin")){
                response.sendRedirect("/LindaSonrisa/pages/crearUsuario.jsp");
            }
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
