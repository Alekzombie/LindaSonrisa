
package Controller;
import Model.Cliente;
import Model.Reserva;
import Model.Servicio;
import Sql.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaController {
    public static ArrayList<Reserva> buscarReservasPorRutCliente(String rut){
        ArrayList lista = new ArrayList();
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select * from reserva where rut_cliente=?")) {
                stmt.setString(1, rut);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id_reserva"));
                    reserva.setEstadoReserva(rs.getString("estado_reserva"));
                    //reserva.setModuloTiempo(rs.getString("id_modulo_tiempo"));  // set modulo inicio para recuperar hora inicio
                    Cliente cliente = new Cliente();
                    cliente.setRut(rs.getString("rut_cliente"));
                    reserva.setCliente(cliente);
                    Servicio servicio = new Servicio();
                    servicio.setId(rs.getInt("id_servicio"));
                    reserva.setServicio(servicio);
                    lista.add(reserva);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.buscarReservasPorRutCliente " + ex.getMessage());
        }
        return lista;
    }
    
    public static ArrayList<Reserva> buscarReservasPorConfirmar(){
        ArrayList lista = new ArrayList();
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select * from reserva where estado_reserva = 'POR CONFIRMAR'")) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id_reserva"));
                    reserva.setEstadoReserva(rs.getString("estado_reserva"));
                    //reserva.setModuloTiempo(rs.getString("id_modulo_tiempo"));
                    Cliente cliente = new Cliente();
                    cliente.setRut(rs.getString("rut_cliente"));
                    reserva.setCliente(cliente);
                    Servicio servicio = new Servicio();
                    servicio.setId(rs.getInt("id_servicio"));
                    reserva.setServicio(servicio);
                    lista.add(reserva);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.buscarReservasPorConfirmar " + ex.getMessage());
        }
        return lista;
    }
    
    public static Reserva buscarReservaPorId(int id){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select * from reserva join tiempo_reserva using (id_reserva) where id_reserva = ? and ROWNUM=1")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id_reserva"));
                    reserva.setEstadoReserva(rs.getString("estado_reserva"));
                    reserva.setModuloTiempo(rs.getString("id_modulo_tiempo")); // set modulo inicio para recuperar hora inicio
                    Cliente cliente = new Cliente();
                    cliente.setRut(rs.getString("rut_cliente"));
                    reserva.setCliente(cliente);
                    Servicio servicio = new Servicio();
                    servicio.setId(rs.getInt("id_servicio"));
                    reserva.setServicio(servicio);
                    return reserva;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.buscarReservaPorId " + ex.getMessage());
        }
        return null;
    }
    
    public static boolean confirmarReserva(int id){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("update reserva set estado_reserva = 'CONFIRMADA' where id_reserva=?")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (stmt.executeUpdate()==1){                    
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.confirmarReserva " + ex.getMessage());
        }
        return false;
    }
    
    public static boolean anularReserva(int id){
        
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("update reserva set estado_reserva = 'ANULADA' where id_reserva=?")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (stmt.executeUpdate()==1){                    
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.anularReserva " + ex.getMessage());
        }
        return false;
    }
    public static boolean borrarDeTiempoReserva(int id){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("delete from tiempo_reserva where id_reserva=?")) {
                stmt.setInt(1, id);
                if (stmt.executeUpdate()>0){                    
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en ReservaController.anularReserva " + ex.getMessage());
        }
        return false;
    }
}
