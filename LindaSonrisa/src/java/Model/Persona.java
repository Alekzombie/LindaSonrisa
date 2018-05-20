package Model;

public abstract class Persona {

    private String rut;
    private String nombre;
    private Contacto contacto;

    public Persona() {
    }

    public Persona(String rut, String nombre, Contacto contacto) {
        this.rut = rut;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }

}
