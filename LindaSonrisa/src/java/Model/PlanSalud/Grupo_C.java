package Model.PlanSalud;

public class Grupo_C extends Grupo {

    public Grupo_C() {
        this.id = "GPC";
        this.copago = 0.2;
        this.descuento = 0.8;
    }

    @Override
    public String toString() {
        return "Grupo_C{" + '}';
    }
    
    
}
