package modelo;

// INTERFAZ PROPIA: define un contrato (qué debe poder hacer algo "prestable"),
// pero no dice cómo. No tiene atributos ni constructor.
public interface Prestable {
    String getTitulo();
    boolean estaDisponible();
    boolean prestar();
    void devolver();
    int getDiasPrestamo();
}
