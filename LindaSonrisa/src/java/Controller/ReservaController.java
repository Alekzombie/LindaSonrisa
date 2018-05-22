
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
                    reserva.setModuloTiempo(rs.getString("id_modulo"));
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
            System.out.println("Error en ClienteController.agregar " + ex.getMessage());
        }
        return lista;
    }
    
    public static Reserva buscarReservaPorId(int id){
        try (Connection con = Oracle.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("select * from reserva where id_reserva=?")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id_reserva"));
                    reserva.setEstadoReserva(rs.getString("estado_reserva"));
                    reserva.setModuloTiempo(rs.getString("id_modulo"));
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
            System.out.println("Error en ClienteController.agregar " + ex.getMessage());
        }
        return null;
    }
}
