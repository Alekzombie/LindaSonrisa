package Model;

public class Comuna {

    private int id;
    private String nombre;
    private int nroRegion;

    public Comuna(int id, String nombre, int nroRegion) {
        this.id = id;
        this.nombre = nombre;
        this.nroRegion = nroRegion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroRegion() {
        return nroRegion;
    }

    public void setNroRegion(int nroRegion) {
        this.nroRegion = nroRegion;
    }

}
