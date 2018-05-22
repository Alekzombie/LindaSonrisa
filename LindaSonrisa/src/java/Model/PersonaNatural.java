package Model;

import Model.PlanSalud.PlanSalud;
import java.util.Date;

abstract public class PersonaNatural extends Persona {

    private String apellidoPaterno;
    private String apellidoMaterno;
    private java.util.Date fechaNacimiento;
    private int cantidadCargas;
    private PlanSalud planSalud;

    public PersonaNatural() {
    }

    public PersonaNatural(String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int cantidadCargas, PlanSalud planSalud, String rut, String nombre, Contacto contacto) {
        super(rut, nombre, contacto);
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.cantidadCargas = cantidadCargas;
        this.planSalud = planSalud;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getCantidadCargas() {
        return cantidadCargas;
    }

    public void setCantidadCargas(int cantidadCargas) {
        this.cantidadCargas = cantidadCargas;
    }

    public PlanSalud getPlanSalud() {
        return planSalud;
    }

    public void setPlanSalud(PlanSalud planSalud) {
        this.planSalud = planSalud;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
