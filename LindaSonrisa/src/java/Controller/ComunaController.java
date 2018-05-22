/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comuna;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lmerino
 */
public class ComunaController {
     public Comuna nombreToId(String nombre) {
        Comuna comuna = new Comuna();
        try (Connection con = Oracle.getConnection()) {
            String query = "select * from comuna where nombre_comuna=?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1, nombre);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id_comuna");
                        comuna.setId(id);
                        comuna.setNombre(rs.getString("nombre_comuna"));
                        comuna.setNroRegion(rs.getInt("nro_region"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al agregar Empleado. " + ex.getMessage());
        }
        return comuna;
    }

    public String idToNombre(int id) {
        String nombre = "";
        try (Connection con = Oracle.getConnection()) {
            String query = "select nombre_comuna from comuna where id_comuna=?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {

                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        nombre = rs.getString("nombre_comuna");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al agregar Empleado. " + ex.getMessage());
        }
        return nombre;
    }

    public ArrayList<String> listarComunas() {
        ArrayList<String> lista = new ArrayList<>();
        String query = "select nombre_comuna from comuna";
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String nombre = rs.getString("nombre_comuna");
                        lista.add(nombre);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en COMUNACONTROLLER.listarComunas " + ex.getMessage());
        }
        return lista;
    }
}
