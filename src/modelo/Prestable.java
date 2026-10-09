package modelo;


public interface Prestable {
    String getTitulo();
    boolean estaDisponible();
    boolean prestar();
    void devolver();
    int getDiasPrestamo();
}
