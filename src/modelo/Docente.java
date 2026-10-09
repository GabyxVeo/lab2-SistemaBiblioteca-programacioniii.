package modelo;

// HERENCIA: Docente extends Usuario
public class Docente extends Usuario {
    private String facultad;

    public Docente(String nombre, String carnet, String facultad) {
        super(nombre, carnet); // super(): llama al constructor de Usuario
        this.facultad = facultad;
    }

    // SOBRESCRITURA: implementa el método abstracto, con un valor distinto al de Estudiante
    @Override
    public int getLimitePrestamos() {
        return 5;
    }

    // SOBRESCRITURA de un método CONCRETO: cambia presentarse() de Usuario.
    // super.presentarse() reutiliza el código del padre y le agrega algo nuevo.
    @Override
    public String presentarse() {
        return "Prof. " + super.presentarse();
    }
}
