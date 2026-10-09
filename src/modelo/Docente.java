package modelo;


public class Docente extends Usuario {
    private String facultad;

    public Docente(String nombre, String carnet, String facultad) {
        super(nombre, carnet);
        this.facultad = facultad;
    }


    @Override
    public int getLimitePrestamos() {
        return 5;
    }


    @Override
    public String presentarse() {
        return "Prof. " + super.presentarse();
    }
}
