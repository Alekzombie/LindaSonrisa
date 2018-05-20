package Model;

import java.io.Serializable;

public class Proveedor extends PersonaJuridica implements Serializable {

    private int id;

    public Proveedor() {
    }

    public Proveedor(int id, String giro, String rut, String nombre, Contacto contacto) {
        super(giro, rut, nombre, contacto);
        this.id = id;
    }

    public Proveedor(String giro, String rut, String nombre, Contacto contacto) {
        super(giro, rut, nombre, contacto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + getId() + " giro=" + this.getGiro() + " rut=" + this.getRut() + " nombre=" + this.getNombre() + '}';
    }
}
