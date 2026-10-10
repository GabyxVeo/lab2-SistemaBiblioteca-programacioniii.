package modelo;


public class Revista extends Recurso implements Prestable {
    private int edicion;

    public Revista(String titulo, int edicion) {
        super(titulo);
        this.edicion = edicion;
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
        return 3;
    }

    @Override
    public String toString() {
        return "[Revista] " + titulo + " (Edicion " + edicion + ") | " + getEstado();
    }
}
