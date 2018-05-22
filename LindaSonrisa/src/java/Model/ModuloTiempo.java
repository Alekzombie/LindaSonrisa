
package Model;

import java.sql.Date;


public class ModuloTiempo {
    private String idModulo;
    private Date fecha;
    private String horaInicio;
    private String horaTermino;
    private String estadoModulo;
    private String rutEmpleado;

    public ModuloTiempo() {
    }

    public ModuloTiempo(String idModulo, Date fecha, String horaInicio, String horaTermino, String estadoModulo, String rutEmpleado) {
        this.idModulo = idModulo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.estadoModulo = estadoModulo;
        this.rutEmpleado = rutEmpleado;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getEstadoModulo() {
        return estadoModulo;
    }

    public void setEstadoModulo(String estadoModulo) {
        this.estadoModulo = estadoModulo;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }
    
    
}
