package ar.edu.calidadpedidos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPedidos {
    private final List<Pedido> pedidos = new ArrayList<>();

    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido buscarPorNumero(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    public void eliminar(int numero) {
        Pedido pedido = buscarPorNumero(numero);
        if (pedido != null) {
            pedidos.remove(pedido);
        }
    }
}
