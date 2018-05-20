package Model;

import java.sql.Date;

public class Boleta {

    private int numero;
    private Date fechaEmision;
    private int valor;
    private Reserva Reserva;
    private String metodoPago;

    public Boleta(Date fechaEmision, int valor, Reserva Reserva, String metodoPago) {
        this.fechaEmision = fechaEmision;
        this.valor = valor;
        this.Reserva = Reserva;
        this.metodoPago = metodoPago;
    }

    public Boleta(int numero, Date fechaEmision, int valor, Reserva Reserva, String metodoPago) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.valor = valor;
        this.Reserva = Reserva;
        this.metodoPago = metodoPago;
    }

    public int getNumero() {
        return numero;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public int getValor() {
        return valor;
    }

    public Reserva getReserva() {
        return Reserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

}
