/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CETECOM
 */
public class ClienteController extends PersonaController {
    
    private static String AGREGAR_CLIENTE = "INSERT INTO CLIENTE (RUT) VALUES (?)";
    
    public static boolean agregar(Cliente cliente) {
        if (!agregarNatural(cliente)) {
            return false;
        }
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(AGREGAR_CLIENTE)) {
                stmt.setString(1, cliente.getRut());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ClienteController.agregar " + ex.getMessage());
        }
        return false;
    }
    
    public static Cliente buscarCliente(String rut){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select nombre, ap_paterno, ap_materno, rut from cliente join natural using (rut) join persona using (rut) where rut = ?")) {
                stmt.setString(1, rut);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellidoPaterno(rs.getString("ap_paterno"));
                    cliente.setApellidoMaterno(rs.getString("ap_materno"));
                    cliente.setRut(rs.getString("rut"));  
                    return cliente;
                }                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ClienteController.buscarCliente " + ex.getMessage());
        }
        return null;
    }
}
