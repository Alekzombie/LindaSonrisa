package Model.PlanSalud;

public class Grupo_D extends Grupo {

    public Grupo_D() {
        this.id = "GPD";
        this.copago = 0.3;
        this.descuento = 0.7;
    }

    @Override
    public String toString() {
        return "Grupo_D{" + '}';
    }

}
