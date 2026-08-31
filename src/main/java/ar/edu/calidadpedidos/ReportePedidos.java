package ar.edu.calidadpedidos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportePedidos {

    public void mostrarPedido(Pedido pedido, double descuento) {
        System.out.println("\n=== DETALLE DEL PEDIDO ===");
        System.out.println("Pedido: #" + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println();
        System.out.printf("%-25s %10s %15s%n", "Producto", "Cantidad", "Subtotal");

        for (ItemPedido item : pedido.getItems()) {
            System.out.printf("%-25s %10d %15.2f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getSubtotal());
        }

        System.out.println();
        System.out.printf("Subtotal: %.2f%n", pedido.getTotal());
        System.out.printf("Descuento: %.2f%n", descuento);
        System.out.printf("Total: %.2f%n", pedido.getTotal() - descuento);
        System.out.println("Estado: " + pedido.getEstado());
    }

    public void exportarResumen(List<Pedido> pedidos, String archivo) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(archivo);
            writer.write("numero,cliente,total,estado\n");
            for (Pedido pedido : pedidos) {
                writer.write(pedido.getNumero() + ","
                        + pedido.getCliente().getNombre() + ","
                        + pedido.getTotal() + ","
                        + pedido.getEstado() + "\n");
            }
            writer.close();
        } catch (IOException e) {
        }
    }
}
