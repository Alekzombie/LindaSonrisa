package Model;

import Model.PlanSalud.PlanSalud;
import java.io.Serializable;
import java.sql.Date;

public class Cliente extends PersonaNatural implements Serializable {

    public Cliente() {
    }

    public Cliente(String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int cantidadCargas, PlanSalud planSalud, String rut, String nombre, Contacto contacto) {
        super(apellidoPaterno, apellidoMaterno, fechaNacimiento, cantidadCargas, planSalud, rut, nombre, contacto);
    }

}
