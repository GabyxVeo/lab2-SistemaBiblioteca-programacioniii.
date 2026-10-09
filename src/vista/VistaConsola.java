package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Prestable;
import modelo.Usuario;

// VISTA: solo muestra datos y lee lo que escribe el usuario. No tiene lógica de negocio.
public class VistaConsola {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println();
        System.out.println("===== BIBLIOTECA =====");
        System.out.println("1. Ver catalogo");
        System.out.println("2. Ver usuarios");
        System.out.println("3. Prestar recurso");
        System.out.println("4. Devolver recurso");
        System.out.println("5. Buscar recurso por titulo");
        System.out.println("6. Salir");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerTexto(String pregunta) {
        System.out.print(pregunta);
        return scanner.nextLine();
    }

    public int leerEntero(String pregunta) {
        System.out.print(pregunta);
        String texto = scanner.nextLine();
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1; // si escribe letras, devuelve -1 (opcion invalida)
        }
    }

    // POLIMORFISMO con interfaz: la lista es de Prestable, no de Libro ni de Revista.
    public void mostrarCatalogo(ArrayList<Prestable> catalogo) {
        System.out.println("--- Catalogo ---");
        for (int i = 0; i < catalogo.size(); i++) {
            Prestable recurso = catalogo.get(i);
            // LIGADURA DINÁMICA: println llama toString() y Java ejecuta el de Libro o el de Revista
            System.out.println((i + 1) + ". " + recurso + " | " + recurso.getDiasPrestamo() + " dias");
        }
    }

    public void mostrarUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("--- Usuarios ---");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            // LIGADURA DINÁMICA: presentarse() y getLimitePrestamos() dependen del objeto real
            // (Estudiante o Docente), aunque la variable sea de tipo Usuario.
            System.out.println((i + 1) + ". " + usuario.presentarse()
                    + " | Prestamos: " + usuario.getCantidadPrestados()
                    + "/" + usuario.getLimitePrestamos());
        }
    }
}
