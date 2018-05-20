package Controller;

import Model.Empleado;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoController extends PersonaController {

    private static String INSERT_EMPLEADO = "INSERT INTO empleado VALUES(?,?)";
    private static String UPDATE_EMPLEADO = "UPDATE empleado SET id_cargo WHERE rut = ?";
    
    public static boolean agregar(Empleado empleado) {
        if (!agregarNatural(empleado)) {
            return false;
        }
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement(INSERT_EMPLEADO)) {
                stmt.setString(1, empleado.getRut());
                stmt.setInt(2, CargoConvert.nameToId(empleado.getCargo()));

                if (stmt.executeUpdate() == 1) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al agregar Empleado. " + ex.getMessage());
        }
        return false;
    }

    public static boolean modificar(Empleado empleado) {
        if(!ContactoController.modificar(empleado)){
            return false;
        }
        try(Connection con = Oracle.getConnection()){
            try(PreparedStatement stmt = con.prepareStatement(UPDATE_EMPLEADO)){
                stmt.setInt(1, CargoConvert.nameToId(empleado.getCargo()));
                stmt.setString(2, empleado.getRut());
                
                if(stmt.executeUpdate()==1){
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al modificar Empleado. " + ex.getMessage());
        }
        return false;
    }
    
    
    
}
