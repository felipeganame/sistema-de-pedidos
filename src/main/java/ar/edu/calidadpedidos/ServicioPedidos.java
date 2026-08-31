package ar.edu.calidadpedidos;

public class ServicioPedidos {
    private final RepositorioPedidos repositorio;
    private final ValidadorPedido validador;
    private final CalculadorDescuentos calculador;
    private final ReportePedidos reporte;

    public ServicioPedidos(RepositorioPedidos repositorio,
                           ValidadorPedido validador,
                           CalculadorDescuentos calculador,
                           ReportePedidos reporte) {
        this.repositorio = repositorio;
        this.validador = validador;
        this.calculador = calculador;
        this.reporte = reporte;
    }

    public boolean procesar(Pedido pedido) {
        if (!validador.esValido(pedido)) {
            System.out.println("El pedido no es válido");
            return false;
        }

        if (pedido.getEstado().equals("CANCELADO")) {
            System.out.println("No se puede procesar un pedido cancelado");
            return false;
        }

        double descuento = calculador.calcularDescuento(pedido.getCliente(), pedido);
        pedido.setEstado("PROCESADO");
        repositorio.guardar(pedido);
        reporte.mostrarPedido(pedido, descuento);
        return true;
    }

    public void cancelar(int numero) {
        Pedido pedido = repositorio.buscarPorNumero(numero);
        if (pedido != null) {
            pedido.setEstado("CANCELADO");
        }
    }

    public void imprimirTodos() {
        for (Pedido pedido : repositorio.listarTodos()) {
            double descuento = calculador.calcularDescuento(pedido.getCliente(), pedido);
            reporte.mostrarPedido(pedido, descuento);
        }
    }
}
