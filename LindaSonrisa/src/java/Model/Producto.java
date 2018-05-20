package Model;

import java.io.Serializable;
import java.sql.Date;

public class Producto implements Serializable {

    private String id;
    private String descripcion;
    private Date fechaVencimiento;
    private String tipoProducto;
    private String familiaProducto;
    private Proveedor proveedor;
    
    public Producto(String id, String descripcion, Date fechaVencimiento, String tipoProducto, String familiaProducto, Proveedor proveedor) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoProducto = tipoProducto;
        this.familiaProducto = familiaProducto;
        this.proveedor = proveedor;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getFamiliaProducto() {
        return familiaProducto;
    }

    public void setFamiliaProducto(String familiaProducto) {
        this.familiaProducto = familiaProducto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

}
