/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Controller.ClienteController;
import Controller.ComunaController;
import Controller.UsuarioController;
import Model.Cliente;
import Model.Contacto;
import Model.Domicilio;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hozonov
 */
@WebServlet(name = "crearUsuario", urlPatterns = {"/crearUsuario"})
public class crearUsuario extends HttpServlet {

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
            Cliente cliente = new Cliente();
            cliente.setRut(request.getParameter("txtRut"));
            cliente.setNombre(request.getParameter("txtNombre"));
            cliente.setApellidoPaterno(request.getParameter("txtPaterno"));
            cliente.setApellidoMaterno(request.getParameter("txtMaterno"));
            DateFormat df = new SimpleDateFormat("yyyy-M-d");
            Date fechaNacimiento = df.parse(request.getParameter("calFechaNacimiento".trim()));
            cliente.setFechaNacimiento(new java.sql.Date(fechaNacimiento.getTime()));
            Contacto contacto = new Contacto();
            contacto.setCorreoElectronico(request.getParameter("txtMail"));
            contacto.setTelefonoFijo(request.getParameter("txtTelefonoFijo"));
            contacto.setTelefonoMovil(request.getParameter("txtTelefonoMovil"));
            cliente.setContacto(contacto);
            Domicilio domicilio = new Domicilio();
            domicilio.setNombreCalle(request.getParameter("txtDireccion"));
            domicilio.setNro_calle(Integer.parseInt(request.getParameter("txtNroCasa")));
            if (request.getParameter("txtNroDepto").isEmpty()){
                domicilio.setCasa_depto(0);
            }else{
                domicilio.setCasa_depto(1);
                domicilio.setNro_depto(request.getParameter("txtNroDepto"));
            }
            domicilio.setPersona(cliente);
            domicilio.setComuna(new ComunaController().nombreToId(request.getParameter("cmbComuna")));
            
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(request.getParameter("txtUsuario"));
            usuario.setPassword(request.getParameter("txtContraseña"));
            usuario.setRutPersona(cliente.getRut());
            usuario.setTipoUsuario("CLT");
            
            String mensaje = "";
            if (new ClienteController().agregar(cliente)){
                if (new ClienteController().agregarContacto(cliente)){
                    if (new ClienteController().agregarDomicilio(domicilio)){
                        if (new UsuarioController().agregarUsuario(usuario)){
                            mensaje = "Éxito";
                        }
                    }
                }
            }
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/pages/RegistrarServicio.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(crearUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
