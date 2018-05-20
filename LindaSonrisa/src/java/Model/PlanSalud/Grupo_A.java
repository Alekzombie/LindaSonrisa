package Model.PlanSalud;

public class Grupo_A extends Grupo{

    public Grupo_A(){
        this.id = "GPA";
        this.copago = 1;
        this.descuento = 0;
    }

    @Override
    public String toString() {
        return "Grupo_A{" + '}';
    }
    
    
}
