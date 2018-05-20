package Controller;

import Model.Persona;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactoController {
    private static String UPDATE_CONTACTO = "UPDATE CONTACTO SET correo_electronico = ?, telefono_fijo = ?, telefono_movil = ?";
    
    public static boolean modificar(Persona persona){
        try(Connection con = Oracle.getConnection()){
            try(PreparedStatement stmt = con.prepareStatement(UPDATE_CONTACTO)){
                stmt.setString(1, persona.getContacto().getCorreoElectronico());
                stmt.setString(2, persona.getContacto().getTelefonoFijo());
                stmt.setString(3, persona.getContacto().getTelefonoMovil());
                stmt.setString(4, persona.getRut());
                
                if(stmt.executeUpdate()==1){
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContactoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
