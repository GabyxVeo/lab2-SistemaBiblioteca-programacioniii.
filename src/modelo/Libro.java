package modelo;

// HERENCIA: Libro es un Recurso (extends) y además cumple el contrato Prestable (implements).
public class Libro extends Recurso implements Prestable {
    private String autor;

    public Libro(String titulo, String autor) {
        super(titulo); // super(): construye primero la parte heredada (Recurso)
        this.autor = autor;
    }

    // INTERFAZ: implementación propia de Libro del método prestar()
    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        } else {
            return false;
        }
    }

    // INTERFAZ: Libro implementa devolver()
    @Override
    public void devolver() {
        disponible = true;
    }

    // INTERFAZ: un libro se presta 14 días (Revista lo hace distinto)
    @Override
    public int getDiasPrestamo() {
        return 14;
    }

    // SOBRESCRITURA (overriding): reemplaza el toString() de Recurso
    @Override
    public String toString() {
        return "[Libro] " + titulo + " de " + autor + " | " + getEstado();
    }
}
