package main;

import controlador.ControladorBiblioteca;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorBiblioteca controlador = new ControladorBiblioteca(vista);
        controlador.iniciar();
    }
}
