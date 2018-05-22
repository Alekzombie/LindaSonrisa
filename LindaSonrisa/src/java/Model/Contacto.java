package Model;

public class Contacto {

    private String correoElectronico;
    private String telefonoMovil;
    private String telefonoFijo;
    
    private Persona persona;

    public Contacto() {
    }

   public Contacto(String correoElectronico, String telefonoMovil, String telefonoFijo , Persona persona) {
        this.correoElectronico = correoElectronico;
        this.telefonoMovil = telefonoMovil;
        this.telefonoFijo = telefonoFijo;
         this.persona = persona;
    }
   
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    @Override
    public String toString() {
        return "Contacto{" + "correoElectronico=" + correoElectronico + ", telefonoMovil=" + telefonoMovil + ", telefonoFijo=" + telefonoFijo + '}';
    }

}
