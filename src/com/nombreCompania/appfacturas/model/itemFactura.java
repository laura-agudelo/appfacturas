package com.nombreCompania.appfacturas.model;

public class itemFactura {
    private producto producto;
    private int cantidad;

    public itemFactura(producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para calcular el importe del ítem
    public float calcularImporte() {
        return (float) (producto.getPrecio() * cantidad);
    }

    @Override
    public String toString() {
        return producto + "\t" + cantidad + "\t" + calcularImporte();
    }
}
