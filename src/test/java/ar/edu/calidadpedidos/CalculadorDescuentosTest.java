package ar.edu.calidadpedidos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadorDescuentosTest {

    @Test
    void aplicaDescuentoVipParaPedidoGrande() {
        Cliente cliente = new Cliente(1, "Ana", "MINORISTA", true);
        Pedido pedido = new Pedido(1, cliente, LocalDate.of(2026, 8, 1));
        pedido.agregarItem(new Producto(1, "Equipo", 600_000), 1);

        CalculadorDescuentos calculador = new CalculadorDescuentos();

        assertEquals(90_000, calculador.calcularDescuento(cliente, pedido), 0.01);
    }

    @Test
    void noAplicaDescuentoCuandoNoCorresponde() {
        Cliente cliente = new Cliente(2, "Luis", "MINORISTA", false);
        Pedido pedido = new Pedido(2, cliente, LocalDate.of(2026, 8, 1));
        pedido.agregarItem(new Producto(2, "Accesorio", 50_000), 1);

        CalculadorDescuentos calculador = new CalculadorDescuentos();

        assertEquals(0, calculador.calcularDescuento(cliente, pedido), 0.01);
    }
}
