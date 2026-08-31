package ar.edu.calidadpedidos;

public class ValidadorPedido {

    public boolean esValido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }

        if (pedido.getCliente() == null) {
            return false;
        }

        if (pedido.getItems().isEmpty()) {
            return false;
        }

        if (pedido.getTotal() < 0) {
            return false;
        }

        if (pedido.getTotal() < 0) {
            System.out.println("El total del pedido no puede ser negativo");
            return false;
        }

        for (ItemPedido item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                return false;
            }
            if (item.getProducto() == null) {
                return false;
            }
            if (item.getProducto().getPrecio() < 0) {
                return false;
            }
        }

        return true;
    }

    private boolean validarNumeroPedido(int numero) {
        return numero > 0;
    }
}
