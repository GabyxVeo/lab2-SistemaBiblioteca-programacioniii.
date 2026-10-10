package controlador;

import java.util.ArrayList;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Libro;
import modelo.Prestable;
import modelo.Revista;
import modelo.Usuario;
import vista.VistaConsola;


public class ControladorBiblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestable> catalogo = new ArrayList<>();
    private VistaConsola vista;

    public ControladorBiblioteca(VistaConsola vista) {
        this.vista = vista;
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {

        usuarios.add(new Estudiante("William Alfaro", "20231234", "Ing. Software"));
        usuarios.add(new Estudiante("Chelsea Castellanos", "20231235", "Ing. Software"));
        usuarios.add(new Estudiante("Jonathan Mercado", "MM-69751-25", "Ing. Sitemas y computacion"));
        usuarios.add(new Estudiante("Aldo Portillo", "MP-67677-25", "Ciencias y Tecnologia"));

        usuarios.add(new Docente("Marta Diaz", "D-001", "Ingenieria"));
        usuarios.add(new Docente("Jose Andres", "PM-69686-25","Ing. Sistemas y Computacion"));
        usuarios.add(new Docente("Oscar Alvarez","CA-12675-25","Ing. Sistemas y Computacion"));


        catalogo.add(new Libro("Java Como Programar", "Deitel"));
        catalogo.add(new Libro("Clean Code", "Robert Martin"));
        catalogo.add(new Revista("Revista Tecnologia", 45));
        catalogo.add(new Revista("Ciencia Hoy", 12));
        catalogo.add(new Libro("El lenguaje de programación Java", "Ken Arnold"));
        catalogo.add(new Libro("Fundamentos de Java", "Herbert Schildt"));
        catalogo.add(new Libro("Java para principiantes", "John Pollock"));
        catalogo.add(new Libro("Introducción a la programación", "Luis Joyanes Aguilar"));
        catalogo.add(new Libro("Estructuras de datos", "Mark Allen Weiss"));
        catalogo.add(new Libro("Algoritmos y programación", "Thomas H. Cormen"));
        catalogo.add(new Libro("Patrones de diseño", "Erich Gamma"));
        catalogo.add(new Libro("Código completo", "Steve McConnell"));
        catalogo.add(new Libro("El programador pragmático", "Andrew Hunt"));
        catalogo.add(new Libro("Refactoring", "Martin Fowler"));
        catalogo.add(new Libro("Python Crash Course", "Eric Matthes"));
        catalogo.add(new Libro("Aprendiendo Git", "Anna Skoulikari"));
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 6) {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Elija una opcion: ");

            if (opcion == 1) {
                vista.mostrarCatalogo(catalogo);
            } else if (opcion == 2) {
                vista.mostrarUsuarios(usuarios);
            } else if (opcion == 3) {
                prestarRecurso();
            } else if (opcion == 4) {
                devolverRecurso();
            } else if (opcion == 5) {
                buscarPorTitulo();
            } else if (opcion == 6) {
                vista.mostrarMensaje("Hasta luego.");
            } else {
                vista.mostrarMensaje("Opcion invalida.");
            }
        }
    }

    private void prestarRecurso() {
        vista.mostrarUsuarios(usuarios);
        Usuario usuario = buscarUsuario(vista.leerEntero("Numero de usuario: "));
        vista.mostrarCatalogo(catalogo);

        Prestable recurso = buscarRecurso(vista.leerEntero("Numero de recurso: "));

        if (usuario == null || recurso == null) {
            vista.mostrarMensaje("Numero invalido.");
        } else if (!usuario.puedePrestar()) {
            vista.mostrarMensaje(usuario.getNombre() + " llego a su limite de "
                    + usuario.getLimitePrestamos() + " prestamos.");
        } else if (recurso.prestar()) {
            usuario.agregarPrestamo(recurso);
            vista.mostrarMensaje("Prestamo exitoso. Debe devolverlo en "
                    + recurso.getDiasPrestamo() + " dias.");
        } else {
            vista.mostrarMensaje("El recurso ya esta prestado.");
        }
    }

    private void devolverRecurso() {
        vista.mostrarUsuarios(usuarios);
        Usuario usuario = buscarUsuario(vista.leerEntero("Numero de usuario: "));
        vista.mostrarCatalogo(catalogo);
        Prestable recurso = buscarRecurso(vista.leerEntero("Numero de recurso a devolver: "));

        if (usuario == null || recurso == null) {
            vista.mostrarMensaje("Numero invalido.");
        } else if (usuario.tienePrestado(recurso)) {
            recurso.devolver();
            usuario.quitarPrestamo(recurso);
            vista.mostrarMensaje("Devolucion exitosa.");
        } else {
            vista.mostrarMensaje("Ese usuario no tiene prestado ese recurso.");
        }
    }

    private void buscarPorTitulo() {
        String titulo = vista.leerTexto("Titulo a buscar: ");

        Prestable recurso = buscarRecurso(titulo);
        if (recurso == null) {
            vista.mostrarMensaje("No se encontro ningun recurso.");
        } else {
            vista.mostrarMensaje("Encontrado: " + recurso);
        }
    }

    private Usuario buscarUsuario(int numero) {
        if (numero >= 1 && numero <= usuarios.size()) {
            return usuarios.get(numero - 1);
        } else {
            return null;
        }
    }

    private Prestable buscarRecurso(int numero) {
        if (numero >= 1 && numero <= catalogo.size()) {
            return catalogo.get(numero - 1);
        } else {
            return null;
        }
    }

    private Prestable buscarRecurso(String titulo) {
        for (Prestable recurso : catalogo) {
            if (recurso.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return recurso;
            }
        }
        return null;
    }
}
