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
    
}
