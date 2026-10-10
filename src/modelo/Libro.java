package modelo;

public class Libro extends Recurso implements Prestable {
    private String autor;

    public Libro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
    }

    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void devolver() {
        disponible = true;
    }

    @Override
    public int getDiasPrestamo() {
        return 14;
    }

    @Override
    public String toString() {
        return "[Libro] " + titulo + " de " + autor + " | " + getEstado();
    }
}
