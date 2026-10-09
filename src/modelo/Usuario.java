package modelo;

import java.util.ArrayList;


public abstract class Usuario {
    protected String nombre;
    protected String carnet;
    protected ArrayList<Prestable> prestados = new ArrayList<>();


    public Usuario(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    public abstract int getLimitePrestamos();


    public String presentarse() {
        return nombre + " (" + carnet + ")";
    }


    public boolean puedePrestar() {
        return puedePrestar(1);
    }


    public boolean puedePrestar(int cantidad) {
        return prestados.size() + cantidad <= getLimitePrestamos();
    }

    public void agregarPrestamo(Prestable recurso) {
        prestados.add(recurso);
    }

    public void quitarPrestamo(Prestable recurso) {
        prestados.remove(recurso);
    }

    public boolean tienePrestado(Prestable recurso) {
        return prestados.contains(recurso);
    }

    public int getCantidadPrestados() {
        return prestados.size();
    }

    public String getNombre() {
        return nombre;
    }
}
