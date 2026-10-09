package modelo;

// Clase base de los recursos de la biblioteca (Libro y Revista heredan de aquí).
// Aquí va lo que es IGUAL para todos los recursos: título y disponibilidad.
public class Recurso {
    protected String titulo;
    protected boolean disponible;

    public Recurso(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    // Estos dos métodos ya cumplen parte del contrato de Prestable
    // y las subclases los heredan sin volver a escribirlos.
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

    // Este toString() será SOBRESCRITO en Libro y Revista.
    @Override
    public String toString() {
        return titulo + " | " + getEstado();
    }
}
