package Controller;

import Model.PersonaNatural;
import Model.PlanSalud.Fonasa;
import Model.PlanSalud.Grupo;
import Model.PlanSalud.Isapre;
import Model.PlanSalud.PlanSalud;
import Model.Usuario;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {

    private static final String SELECT_USER = "SELECT * FROM USUARIO WHERE nombre_usuario = ?";
    private static final String ADD_USER = "INSERT INTO USUARIO VALUES(?,?,?,0,?)";
    private static final String VERIFY_USER = "SELECT * FROM usuario WHERE nombre_usuario = ? and contraseña = ?";
    private static final String CHANGE_PASS = "UPDATE USUARIO SET cambiar_contraseña = 1, contraseña = (SELECT SUBSTR(rut,1,LENGTH(rut)-2) FROM CONTACTO WHERE correo_electronico = ?) WHERE rut = (SELECT RUT FROM CONTACTO WHERE correo_electronico = ?)";

    private static final String MODIFY_USER = "UPDATE NATURAL SET CANT_DE_CARGAS=?,ID_ISAPRE=?,ID_GRUPO_FONASA=? WHERE RUT=?;"
            + "UPDATE CONTACTO SET CORREO_ELECTRONICO=?,TELEFONO_FIJO=?,TELEFONO_MOVIL=? WHERE RUT=?;"
            + "UPDATE DOMICILIO SET NOMBRE_CALLE=?,NRO_CALLE=?,CASA_DEPTO=?,NRO_DEPTO=?,ID_COMUNA=? WHERE RUT=?;";

    public static boolean agregarUsuario(Usuario user) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(ADD_USER)) {
                stmt.setString(1, user.getNombreUsuario());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getRutPersona());
                stmt.setString(4, user.getTipoUsuario());
                stmt.execute();
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en UsuarioController.agregarUsuario. " + ex.getMessage());
        }
        return false;
    }

    public static boolean solicitudRestablerContraseña(String correoElectronico) {
        try (Connection con = Oracle.getConnection()) {
            try(PreparedStatement stmt = con.prepareStatement(CHANGE_PASS)){
                stmt.setString(1, correoElectronico);
                stmt.setString(2, correoElectronico);
                if(stmt.executeUpdate()==1){
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en UsuarioController.cambiarContraseña. " + ex.getMessage());
        }
        return false;
    }
    
//      "UPDATE NATURAL SET CANT_DE_CARGAS=?,ID_ISAPRE=?,ID_GRUPO_FONASA=? WHERE RUT=?"
//      "UPDATE CONTACTO SET CORREO_ELECTRONICO=?,TELEFONO_FIJO=?,TELEFONO_MOVIL=? WHERE RUT=?"
//      "UPDATE DOMICILIO SET NOMBRE_CALLE=?,NRO_CALLE=?,CASA_DEPTO=?,NRO_DEPTO=?,ID_COMUNA=? WHERE RUT=?";

    public static boolean modificar(PersonaNatural usuario) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(MODIFY_USER)) {
                if (stmt.executeUpdate() == 1) {
                    stmt.setInt(1, usuario.getCantidadCargas());
                    PlanSalud auxps = usuario.getPlanSalud();
                    if (auxps instanceof Fonasa) {
                        stmt.setString(3, ((Grupo) auxps).getId());
                        stmt.setString(2, "NONE");
                    } else {
                        stmt.setString(3, "NONE");
                        stmt.setString(2, ((Isapre) auxps).getId());
                    }
                    stmt.setString(4,usuario.getRut());
                    //------------
                    stmt.setString(5,usuario.getContacto().getCorreoElectronico());
                    stmt.setString(6,usuario.getContacto().getTelefonoFijo());
                    stmt.setString(7,usuario.getContacto().getTelefonoMovil());
                    stmt.setString(8,usuario.getRut());
                    //------------
              
                 
                    
                    
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en UsuarioController.modificar. " + ex.getMessage());
        }
        return false;
    }
    
    public static Usuario buscar(String username){
        Usuario user = new Usuario();
        try(Connection con = Oracle.getConnection()){
            try(PreparedStatement stmt = con.prepareStatement(SELECT_USER)){
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    user = new Usuario(rs.getString("nombre_usuario"), rs.getString("contraseña"), rs.getString("rut"), rs.getBoolean("cambiar_contraseña"), rs.getString("id_tipo_usuario"));
                    return user;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en UsuarioController.buscar. "+ex.getMessage());
        }
        return user;
    }

    public static boolean verificar(String username, String password) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(VERIFY_USER)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.execute();
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en UsuarioController.verificar. " + ex.getMessage());
        }
        return false;
    }
}
