package Model;


public class Domicilio {
    private String nombreCalle;
    private int nro_calle;
    private int casa_depto;
    private String nro_depto;
    private Persona persona;
    private Comuna comuna;

    public Domicilio(String nombreCalle, int nro_calle, int casa_depto, String nro_depto, Persona persona, Comuna comuna) {
        this.nombreCalle = nombreCalle;
        this.nro_calle = nro_calle;
        this.casa_depto = casa_depto;
        this.nro_depto = nro_depto;
        this.persona = persona;
        this.comuna = comuna;
    }

    public Domicilio() {
        
    }


    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNro_calle() {
        return nro_calle;
    }

    public void setNro_calle(int nro_calle) {
        this.nro_calle = nro_calle;
    }

    public int getCasa_depto() {
        return casa_depto;
    }

    public void setCasa_depto(int casa_depto) {
        this.casa_depto = casa_depto;
    }

    public String getNro_depto() {
        return nro_depto;
    }

    public void setNro_depto(String nro_depto) {
        this.nro_depto = nro_depto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
    
    
    
}
