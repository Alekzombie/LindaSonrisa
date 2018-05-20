package Controller;

import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoConvert {

    private static String NAME_TO_ID = "SELECT id_cargo FROM cargo WHERE dsc_cargo = ?";
    private static String ID_TO_NAME = "SELECT dsc_cargo FROM cargo WHERE id_cargo = ?";

    public static String idToName(int id) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(ID_TO_NAME)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return rs.getString("dsc_cargo");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en CargoConvert.idToName. " + ex.getMessage());
        }
        return null;
    }

    public static int nameToId(String name) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(NAME_TO_ID)) {
                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_cargo");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en CargoConvert.nameToId. " + ex.getMessage());
        }
        return -1;
    }
}
