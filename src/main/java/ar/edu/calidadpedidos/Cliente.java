package ar.edu.calidadpedidos;

public class Cliente {
    private final int id;
    private final String nombre;
    private final String categoria;
    private final boolean vip;

    public Cliente(int id, String nombre, String categoria, boolean vip) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isVip() {
        return vip;
    }
}
