package Model;

abstract public class PersonaJuridica extends Persona {

    private String giro;

    public PersonaJuridica() {
    }

    public PersonaJuridica(String giro, String rut, String nombre, Contacto contacto) {
        super(rut, nombre, contacto);
        this.giro = giro;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

}
