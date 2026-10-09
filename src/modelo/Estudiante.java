package modelo;

// HERENCIA: Estudiante extends Usuario (subclase de la clase abstracta)
public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String nombre, String carnet, String carrera) {
        super(nombre, carnet); // super(): primera línea, construye la parte de Usuario
        this.carrera = carrera;
    }

    // SOBRESCRITURA: implementa el método abstracto de Usuario (contrato cumplido).
    // Sin este método, Estudiante no compilaría.
    @Override
    public int getLimitePrestamos() {
        return 3;
    }
}
