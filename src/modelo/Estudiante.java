package modelo;


public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String nombre, String carnet, String carrera) {
        super(nombre, carnet);
        this.carrera = carrera;
    }


    @Override
    public int getLimitePrestamos() {
        return 3;
    }
}
