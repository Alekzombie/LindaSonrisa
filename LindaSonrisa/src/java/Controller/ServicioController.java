package Controller;

import Model.Persona;
import Model.Servicio;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lmerino
 */
public class ServicioController {
    
    private static String INSERT_SERVICE = "INSERT INTO servicio (id_servicio,dsc_servicio,precio_servico,duracion) VALUES(?,?,?,?)";
//     private static String MODIFY_SERVICE = "UPDATE servicio SET dsc_servicio=? precio_servicio=? WHERE id_servicio=? ";
    private static String MODIFY_SERVICE = "UPDATE servicio SET dsc_servicIo=? ,precio_servico=? ,duracion=?,disponible=? WHERE id_servicio=? ";
    
    
     public static boolean agregarServicio(Servicio servicio) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_SERVICE)) {
                stmt.setInt(1,servicio.getId());
                stmt.setString(2, servicio.getDescripcion());
                stmt.setInt(3, servicio.getPrecio());
                stmt.setInt(4, servicio.getDuracion());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR EN SERVICIOCONTROLLER.agregarServicio " + ex.getMessage());
        }
        return false;
    }
     
     public static boolean modificarServicio(Servicio servicio) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(MODIFY_SERVICE)) {
                stmt.setString(1, servicio.getDescripcion());
                stmt.setInt(2, servicio.getPrecio());
                stmt.setInt(3, servicio.getDuracion());
                stmt.setBoolean(4, servicio.isDisponible());
                stmt.setInt(5, servicio.getId());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR EN SERVICIOCONTROLLER.modificarServicio " + ex.getMessage());
        }
        return false;
    }    
}
