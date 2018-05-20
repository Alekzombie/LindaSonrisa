package Model.PlanSalud;


public class Isapre implements PlanSalud{
    private String id;
    private String nombre;

    public Isapre(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Isapre() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Isapre{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
        
}
