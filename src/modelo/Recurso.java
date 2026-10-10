package modelo;


public class Recurso {
    protected String titulo;
    protected boolean disponible;

    public Recurso(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public String getEstado() {
        if (disponible) {
            return "Disponible";
        } else {
            return "Prestado";
        }
    }

    @Override
    public String toString() {
        return titulo + " | " + getEstado();
    }
}
