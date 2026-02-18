package org.example.View;

import org.example.Model.Libro;

import java.util.List;
import java.util.Scanner;

public class LibroView {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE PRÉSTAMO DE LIBROS ---");
        System.out.println("1. Registrar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("\n--- Lista de Libros ---");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOpcionInvalida() {
        System.out.println("Opción no válida. Intenta de nuevo.");
    }
}