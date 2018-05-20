package Model.PlanSalud;


public interface Fonasa extends PlanSalud{
    double calcularDescuento(double precio);
    double calcularCopago(double precio);
}
