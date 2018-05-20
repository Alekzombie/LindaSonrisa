package Model.PlanSalud;

public class Grupo implements Fonasa {

    protected String id;
    protected double copago;
    protected double descuento;

    public String getId() {
        return id;
    }

    public double getCopago() {
        return copago;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public double calcularDescuento(double precio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularCopago(double precio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
