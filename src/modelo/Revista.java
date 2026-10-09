package modelo;

// HERENCIA: Revista también es un Recurso e implementa la MISMA interfaz que Libro.
public class Revista extends Recurso implements Prestable {
    private int edicion;

    public Revista(String titulo, int edicion) {
        super(titulo); // super(): llama al constructor de Recurso
        this.edicion = edicion;
    }

    // INTERFAZ: misma firma que en Libro, pero implementación propia de Revista
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

    // INTERFAZ: una revista se presta solo 3 días
    @Override
    public int getDiasPrestamo() {
        return 3;
    }

    // SOBRESCRITURA (overriding): su propia versión de toString()
    @Override
    public String toString() {
        return "[Revista] " + titulo + " (Edicion " + edicion + ") | " + getEstado();
    }
}
