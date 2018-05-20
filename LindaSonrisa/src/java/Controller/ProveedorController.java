package Controller;

import Model.Proveedor;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorController extends PersonaController {

    private static String INSERT_PROVEEDOR = "INSERT INTO proveedor VALUES (?,proveedores_seq.NEXTVAL)";
    private static String SELECT_PROVEEDOR = "SELECT * FROM proveedor WHERE rut = ?";
    private static String DELETE_PROVEEDOR = "DELETE FROM proveedor WHERE rut = ?";

    public static boolean agregar(Proveedor prov) {
        if (!agregarJuridica(prov)) {
            return false;
        }
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_PROVEEDOR)) {
                stmt.setString(1, prov.getRut());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error agregar Proveedor. " + ex.getMessage());
        }
        return false;
    }

    public static boolean eliminar(String rut) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(DELETE_PROVEEDOR)) {
                stmt.setString(1, rut);
                if (stmt.executeUpdate() == 1) {
                    if (eliminarJuridica(rut)) {
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al eliminar Proveedor. " + ex.getMessage());
        }
        return false;
    }

    public static boolean existeRegistro(String rut) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(SELECT_PROVEEDOR)) {
                stmt.setString(1, rut);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error agregar buscar registro. " + ex.getMessage());
        }
        return false;
    }
}
