package Model;

import java.io.Serializable;

public class Empleado extends PersonaNatural implements Serializable {

    private String cargo;

    public Empleado() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{ rut=" + this.getRut() + ",cargo=" + cargo + '}';
    }
    
    
}
