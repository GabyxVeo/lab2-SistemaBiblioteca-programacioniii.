package controlador;

import java.util.ArrayList;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Libro;
import modelo.Prestable;
import modelo.Revista;
import modelo.Usuario;
import vista.VistaConsola;

// CONTROLADOR: conecta la vista con el modelo. Aquí viven las listas.
public class ControladorBiblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestable> catalogo = new ArrayList<>();
    private VistaConsola vista;

    public ControladorBiblioteca(VistaConsola vista) {
        this.vista = vista;
        cargarDatosIniciales();
    }

    // Datos "quemados" para que el sistema funcione de inmediato.
    private void cargarDatosIniciales() {
        // UPCASTING: guardamos un Estudiante y un Docente en una lista de tipo Usuario
        usuarios.add(new Estudiante("Ana Lopez", "20231234", "Ing. Software"));
        usuarios.add(new Estudiante("Luis Perez", "20231235", "Ing. Software"));
        usuarios.add(new Docente("Marta Diaz", "D-001", "Ingenieria"));
        usuarios.add(new Docente("Jose Andres", "PM-69686-25","Ing. Sistemas y Computacion"));
        usuarios.add(new Docente("Oscar Alvarez","CA-12675-25","Ing. Sistemas y Computacion"));

        // UPCASTING A INTERFAZ: un Libro y una Revista se guardan como Prestable
        catalogo.add(new Libro("Java Como Programar", "Deitel"));
        catalogo.add(new Libro("Clean Code", "Robert Martin"));
        catalogo.add(new Revista("Revista Tecnologia", 45));
        catalogo.add(new Revista("Ciencia Hoy", 12));
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
        // Se llama la versión que recibe int (ver SOBRECARGA #2 abajo)
        Prestable recurso = buscarRecurso(vista.leerEntero("Numero de recurso: "));

        if (usuario == null || recurso == null) {
            vista.mostrarMensaje("Numero invalido.");
        } else if (!usuario.puedePrestar()) {
            vista.mostrarMensaje(usuario.getNombre() + " llego a su limite de "
                    + usuario.getLimitePrestamos() + " prestamos.");
        } else if (recurso.prestar()) { // LIGADURA DINÁMICA: prestar() de Libro o de Revista
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
            recurso.devolver(); // LIGADURA DINÁMICA: devolver() del objeto real
            usuario.quitarPrestamo(recurso);
            vista.mostrarMensaje("Devolucion exitosa.");
        } else {
            vista.mostrarMensaje("Ese usuario no tiene prestado ese recurso.");
        }
    }

    private void buscarPorTitulo() {
        String titulo = vista.leerTexto("Titulo a buscar: ");
        // Se llama la versión que recibe String (ver SOBRECARGA #2 abajo)
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

    // SOBRECARGA (overloading) #2: mismo nombre buscarRecurso, parámetros distintos.
    // El compilador elige la versión según el tipo del argumento (int o String).
    private Prestable buscarRecurso(int numero) {
        if (numero >= 1 && numero <= catalogo.size()) {
            return catalogo.get(numero - 1);
        } else {
            return null;
        }
    }

    // SOBRECARGA (overloading) #2: versión que busca por título (String)
    private Prestable buscarRecurso(String titulo) {
        for (Prestable recurso : catalogo) {
            if (recurso.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return recurso;
            }
        }
        return null;
    }
}
