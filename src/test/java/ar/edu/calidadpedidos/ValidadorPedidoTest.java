package ar.edu.calidadpedidos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorPedidoTest {

    @Test
    void aceptaPedidoConClienteEItemsValidos() {
        Cliente cliente = new Cliente(1, "Carla", "MINORISTA", false);
        Pedido pedido = new Pedido(10, cliente, LocalDate.now());
        pedido.agregarItem(new Producto(1, "Monitor", 200_000), 1);

        assertTrue(new ValidadorPedido().esValido(pedido));
    }

    @Test
    void rechazaPedidoSinItems() {
        Cliente cliente = new Cliente(1, "Carla", "MINORISTA", false);
        Pedido pedido = new Pedido(10, cliente, LocalDate.now());

        assertFalse(new ValidadorPedido().esValido(pedido));
    }
}
