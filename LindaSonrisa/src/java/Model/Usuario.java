package Model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombreUsuario;
    private String password;
    private String rutPersona;
    private boolean cambiarPassword;
    private String tipoUsuario;

    public Usuario(String nombreUsuario, String contraseña, String rutPersona, boolean cambiarPassword, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.password = contraseña;
        this.rutPersona = rutPersona;
        this.cambiarPassword = cambiarPassword;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getRutPersona() {
        return rutPersona;
    }

    public boolean isCambiarPassword() {
        return cambiarPassword;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRutPersona(String rutPersona) {
        this.rutPersona = rutPersona;
    }

    public void setCambiarPassword(boolean cambiarPassword) {
        this.cambiarPassword = cambiarPassword;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

     @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", rutPersona=" + rutPersona + ", cambiarPassword=" + cambiarPassword + ", tipoUsuario=" + tipoUsuario + '}';
    }
}
