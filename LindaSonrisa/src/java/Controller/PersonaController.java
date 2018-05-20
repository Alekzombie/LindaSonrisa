package Controller;

import Model.Contacto;
import Model.Domicilio;
import Model.Persona;
import Model.PersonaJuridica;
import Model.PersonaNatural;
import Model.PlanSalud.Fonasa;
import Model.PlanSalud.Grupo;
import Model.PlanSalud.PlanSalud;
import Model.PlanSalud.Isapre;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonaController {

    //INSERTS
    private static String INSERT_PERSONA = "INSERT INTO PERSONA VALUES(?,?)";
    private static String INSERT_NATURAL = "INSERT INTO NATURAL VALUES(?,?,?,?,?,?,?)";
    private static String INSERT_JURIDICA = "INSERT INTO JURIDICA VALUES(?,?)";
    private static String INSERT_DOMICILIO = "INSERT INTO DOMICILIO VALUES (?,?,?,?,?,?)";
    private static String INSERT_CONTACTO = "INSERT INTO CONTACTO VALUES (?,?,?,?)";
    //DELETES
    private static String DELETE_PERSONA = "DELETE FROM persona WHERE rut = ?";
    private static String DELETE_NATURAL = "DELETE FROM natural WHERE rut = ?";
    private static String DELETE_JURIDICA = "DELETE FROM juridica WHERE rut = ?";

    private static boolean agregarPersona(Persona persona) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_PERSONA)) {
                stmt.setString(1, persona.getRut());
                stmt.setString(2, persona.getNombre());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR AL AGREGAR PERSONA. " + ex.getMessage());
        }
        return false;
    }

    public static boolean agregarJuridica(PersonaJuridica juridica) {
        if (!agregarPersona(juridica)) {
            return false;
        }
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_JURIDICA)) {
                stmt.setString(1, juridica.getRut());
                stmt.setString(2, juridica.getGiro());

                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al agregar juridica. " + ex.getMessage());
        }
        return false;
    }

    public static boolean agregarNatural(PersonaNatural natural) {
        if(!agregarPersona(natural)){
            return false;
        }
        
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_NATURAL)) {
                stmt.setString(1, natural.getRut());
                stmt.setString(2, natural.getApellidoPaterno());
                stmt.setString(3, natural.getApellidoMaterno());
                stmt.setDate(4, natural.getFechaNacimiento());
                stmt.setInt(5, natural.getCantidadCargas());
                PlanSalud auxps = natural.getPlanSalud();
                if (auxps instanceof Fonasa) {
                    stmt.setString(7, ((Grupo) auxps).getId());
                    stmt.setString(6, "NONE");
                } else {
                    stmt.setString(7, "NONE");
                    stmt.setString(6, ((Isapre) auxps).getId());
                }
                if (stmt.executeUpdate() > 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR AL AGREGAR PERSONA NATURAL. " + ex.getMessage());
        }
        return false;
    }

    public static boolean eliminarJuridica(String rut) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(DELETE_JURIDICA)) {
                stmt.setString(1, rut);

                if (stmt.executeUpdate() == 1) {
                    if (eliminarPersona(rut)) {
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al eliminar Persona Juridica. " + ex.getMessage());
        }

        return false;
    }

    public static boolean eliminarNatural(String rut) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(DELETE_NATURAL)) {
                stmt.setString(1, rut);

                if (stmt.executeUpdate() == 1) {
                    if (eliminarPersona(rut)) {
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al eliminar Persona Natural. " + ex.getMessage());
        }
        return false;
    }

    private static boolean eliminarPersona(String rut) {
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(DELETE_PERSONA)) {
                stmt.setString(1, rut);

                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al eliminar Persona. " + ex.getMessage());
        }
        return false;
    }
    
    public static boolean agregarDomicilio(Domicilio domicilio){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_DOMICILIO)) {
                stmt.setString(1, domicilio.getNombreCalle());
                stmt.setInt(2, domicilio.getNro_calle());
                stmt.setInt(3, domicilio.getCasa_depto());
                stmt.setString(4,domicilio.getNro_depto());
                stmt.setString(5,domicilio.getPersona().getRut());
                stmt.setInt(6, domicilio.getComuna().getId());

                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en PersonaController.agregarDomicilio " + ex.getMessage());
        }
        return false;
    }
    
    
    public static boolean agregarContacto(Persona contacto){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_CONTACTO)) {
                stmt.setString(1, contacto.getContacto().getCorreoElectronico());
                stmt.setString(2,contacto.getContacto().getTelefonoFijo());
                stmt.setString(3, contacto.getContacto().getTelefonoMovil());
                stmt.setString(4, contacto.getRut());
                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en PersonaController.agregarContacto " + ex.getMessage());
        }
        return false;
    }
    
}
