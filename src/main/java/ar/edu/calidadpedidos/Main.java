package ar.edu.calidadpedidos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Producto notebook = new Producto(1, "Notebook", 850_000);
        Producto mouse = new Producto(2, "Mouse", 25_000);
        Producto teclado = new Producto(3, "Teclado", 70_000);

        Cliente cliente = new Cliente(101, "Laura Gómez", "MAYORISTA", false);
        Pedido pedido = new Pedido(1001, cliente, LocalDate.now());
        pedido.agregarItem(notebook, 1);
        pedido.agregarItem(mouse, 2);
        pedido.agregarItem(teclado, 1);

        RepositorioPedidos repositorio = new RepositorioPedidos();
        ValidadorPedido validador = new ValidadorPedido();
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        ReportePedidos reporte = new ReportePedidos();
        ServicioPedidos servicio = new ServicioPedidos(repositorio, validador, calculador, reporte);

        System.out.println("=== SISTEMA DE PEDIDOS ===");
        servicio.procesar(pedido);
        reporte.exportarResumen(repositorio.listarTodos(), "pedidos.csv");
    }
}
