package com.nombreCompania.appfacturas.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private itemFactura[] items;
    private int indiceItems;
    private static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 0;

    // Constructor
    public factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = new Date(); // Fecha actual
        this.items = new itemFactura[MAX_ITEMS];
        this.indiceItems = 0;
        this.folio = ++ultimoFolio;
    }

    // Getters y Setters
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public itemFactura[] getItems() {
        return items;
    }

    public void setItems(itemFactura[] items) {
        this.items = items;
    }

    // Añadir ítem a la factura
    public void addItemFactura(itemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            items[indiceItems++] = item;
        } else {
            System.out.println("No se pueden añadir más ítems a la factura.");
        }
    }

    // Calcular el total de la factura
    public float calcularTotal() {
        float total = 0;
        for (itemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    // Generar el detalle de la factura
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (itemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nTotal Final: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
