package main;

import controlador.ControladorBiblioteca;
import vista.VistaConsola;

// Punto de entrada: crea la vista, crea el controlador y arranca el menú.
public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorBiblioteca controlador = new ControladorBiblioteca(vista);
        controlador.iniciar();
    }
}
