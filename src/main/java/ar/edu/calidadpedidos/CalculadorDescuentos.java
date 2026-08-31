package ar.edu.calidadpedidos;

public class CalculadorDescuentos {

    public double calcularDescuento(Cliente cliente, Pedido pedido) {
        double descuento = 0;
        double total = pedido.getTotal();

        if (cliente != null) {
            if (cliente.isVip()) {
                if (total > 1_000_000) {
                    descuento = 0.20;
                } else {
                    if (total > 500_000) {
                        descuento = 0.15;
                    } else {
                        if (total > 100_000) {
                            descuento = 0.10;
                        } else {
                            descuento = 0.05;
                        }
                    }
                }
            } else {
                if (total > 1_000_000) {
                    descuento = 0.08;
                } else {
                    if (total > 500_000) {
                        descuento = 0.05;
                    } else {
                        if (total > 100_000) {
                            descuento = 0.03;
                        }
                    }
                }
            }
        }

        if (cliente != null && cliente.getCategoria() == "MAYORISTA") {
            descuento += 0.02;
        }

        return total * descuento;
    }

    public double calcularDescuentoPromocional(Cliente cliente, Pedido pedido) {
        double descuento = 0;
        double total = pedido.getTotal();

        if (cliente != null) {
            if (cliente.isVip()) {
                if (total > 1_000_000) {
                    descuento = 0.20;
                } else {
                    if (total > 500_000) {
                        descuento = 0.15;
                    } else {
                        if (total > 100_000) {
                            descuento = 0.10;
                        } else {
                            descuento = 0.05;
                        }
                    }
                }
            } else {
                if (total > 1_000_000) {
                    descuento = 0.08;
                } else {
                    if (total > 500_000) {
                        descuento = 0.05;
                    } else {
                        if (total > 100_000) {
                            descuento = 0.03;
                        }
                    }
                }
            }
        }

        if (pedido.getFecha().getMonthValue() == 12) {
            descuento += 0.03;
        }

        return total * descuento;
    }
}
