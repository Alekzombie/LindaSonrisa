package Controller;

import Model.Persona;
import Model.Servicio;
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
public class ServicioController {
    
      private static String INSERT_SERVICE = "INSERT INTO servicio (id_servicio,dsc_servicio,precio_servico,duracion,disponible) VALUES(?,?,?,?,1)";
//     private static String MODIFY_SERVICE = "UPDATE servicio SET dsc_servicio=? precio_servicio=? WHERE id_servicio=? ";
    private static String MODIFY_SERVICE = "UPDATE servicio SET precio_servico=? ,duracion=?,disponible=? WHERE id_servicio=? ";
    private static String VERIFICAR_REGISTRO ="SELECT * FROM SERVICIO WHERE id_servicio=?";
    
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
                stmt.setInt(1, servicio.getPrecio());
                stmt.setInt(2, servicio.getDuracion());
                stmt.setInt(3, servicio.getDisponible());
                stmt.setInt(4, servicio.getId());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR EN SERVICIOCONTROLLER.modificarServicio " + ex.getMessage());
        }
        return false;
    } 
     
    public String idToNombre(int id) {
        String nombre = "";
        try (Connection con = Oracle.getConnection()) {
            String query = "select dsc_servicio from servicio where id_servicio=?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {

                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        nombre = rs.getString("dsc_servicio");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en SERVICIOCONTROLLER.idToNombre " + ex.getMessage());
        }
        return nombre;
    }
    
      public int nombreToId(String nombre) {
        int id = 0;
        try (Connection con = Oracle.getConnection()) {
            String query = "select id_servicio from servicio where dsc_servicio=?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {

                stmt.setString(1, nombre);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        id = rs.getInt("id_servicio");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en SERVICIOCONTROLLER.nombreToId " + ex.getMessage());
        }
        return id;
    }
      
    public ArrayList<String> listarServicios() {
        ArrayList<String> lista = new ArrayList<>();
        String query = "select dsc_servicio from servicio order by dsc_servicio asc";
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String nombre = rs.getString("dsc_servicio");
                        lista.add(nombre);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en SERVICIOCONTROLLER.listarServicios " + ex.getMessage());
        }
        return lista;
    }
    
        public static boolean existeRegistro(int id) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(VERIFICAR_REGISTRO)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR EN ServicioController.existeRegistro" + ex.getMessage());
        }
        return false;
    }
}
