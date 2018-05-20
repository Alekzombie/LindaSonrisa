package Model;

public class Contacto {

    private String correoElectronico;
    private String telefonoMovil;
    private String telefonoFijo;

    public Contacto() {
    }

    public Contacto(String correoElectronico, String telefonoMovil, String telefonoFijo) {
        this.correoElectronico = correoElectronico;
        this.telefonoMovil = telefonoMovil;
        this.telefonoFijo = telefonoFijo;
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

    @Override
    public String toString() {
        return "Contacto{" + "correoElectronico=" + correoElectronico + ", telefonoMovil=" + telefonoMovil + ", telefonoFijo=" + telefonoFijo + '}';
    }

}
