package ar.edu.calidadpedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final int numero;
    private final Cliente cliente;
    private final LocalDate fecha;
    private final List<ItemPedido> items = new ArrayList<>();
    private String estado = "NUEVO";

    public Pedido(int numero, Cliente cliente, LocalDate fecha) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemPedido(producto, cantidad));
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<ItemPedido> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        double total = 0;
        for (ItemPedido item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
}
