package Model.PlanSalud;


public class Grupo_B extends Grupo {

    public Grupo_B() {
        this.id = "GPB";
        this.copago = 0.1;
        this.descuento = 0.9;
    }

    @Override
    public String toString() {
        return "Grupo_B{" + '}';
    }
    
    
    
    
    
}
