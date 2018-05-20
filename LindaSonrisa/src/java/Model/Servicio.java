package Model;

public class Servicio {

    private int id;
    private String descripcion;
    private int precio;
    private int duracion;
    private int disponible;
    private Empleado[] empleados;
        
    public Servicio(int id, String descripcion, int precio, int duracion, int disponible, Empleado[] empleados) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.disponible = disponible;
        this.empleados = empleados;
    }

    public Servicio() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the disponible
     */
    public int getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the empleados
     */
    public Empleado[] getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

}
