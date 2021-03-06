package Model;

public class Reserva {
    private int id;
    private String estadoReserva;
    private String moduloTiempo;
    private Servicio servicio;
    private Cliente cliente;

    public Reserva(String estadoReserva, String moduloTiempo, Servicio servicio, Cliente cliente) {
        this.estadoReserva = estadoReserva;
        this.moduloTiempo = moduloTiempo;
        this.servicio = servicio;
        this.cliente = cliente;
    }

    public Reserva() {
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    /**
     * @return the estadoReserva
     */
    public String getEstadoReserva() {
        return estadoReserva;
    }

    /**
     * @param estadoReserva the estadoReserva to set
     */
    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    /**
     * @return the moduloTiempo
     */
    public String getModuloTiempo() {
        return moduloTiempo;
    }

    /**
     * @param moduloTiempo the moduloTiempo to set
     */
    public void setModuloTiempo(String moduloTiempo) {
        this.moduloTiempo = moduloTiempo;
    }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}
