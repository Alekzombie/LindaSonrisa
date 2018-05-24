
package Controller;
import Model.ModuloTiempo;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloController {
    public static ModuloTiempo buscarModuloPorId(String idModulo){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select * from modulo_tiempo where id_modulo=?")) {
                stmt.setString(1, idModulo);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    ModuloTiempo moduloInicio = new ModuloTiempo();
                    moduloInicio.setIdModulo(rs.getString("id_modulo"));
                    moduloInicio.setFecha(rs.getDate("fecha"));
                    moduloInicio.setHoraInicio(rs.getString("hora_inicio"));
                    moduloInicio.setHoraTermino(rs.getString("hora_fin"));
                    moduloInicio.setEstadoModulo("estado_modulo");
                    moduloInicio.setRutEmpleado(rs.getString("rut_empleado"));
                    return moduloInicio;
                }                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ModuloController.buscarModuloPorId " + ex.getMessage());
        }
        return null;
    }
    public static ArrayList<String> listaModulosAnular(int idReserva){
        ArrayList lista = new ArrayList();
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select id_modulo from modulo_tiempo m join tiempo_reserva t on m.id_modulo=t.id_modulo_tiempo where id_reserva = ?")) {
                stmt.setInt(1, idReserva);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    lista.add(rs.getString("id_modulo"));
                }                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ModuloController.listaModulosAnular " + ex.getMessage());
        }
        return lista;
    }
    public static boolean hacerDisponible(String idModulo){
        ArrayList lista = new ArrayList();
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("update modulo_tiempo set estado_modulo='DISPONIBLE' where id_modulo = ?")) {
                stmt.setString(1, idModulo);
                if(stmt.executeUpdate()==1){
                    return true;
                }              
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ModuloController.hacerDisponible " + ex.getMessage());
        }
        return false;
    }
}
