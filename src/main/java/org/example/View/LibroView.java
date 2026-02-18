package org.example.View;

import org.example.Model.Libro;

import java.util.List;
import java.util.Scanner;

public class LibroView {

    private final  Scanner scanner = new Scanner(System.in);
//menu de opciones
    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE PRÉSTAMO DE LIBROS ---");
        System.out.println("1. Registrar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }
//le la opcion seleccionada por el usuario
    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }
//le el numero seleccionado por el usuario
    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }
//lee el texto puesto por el usuario
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
//lista de libros
    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados."); //si no hay libros resgistrado, si la lista esta vacia
            return;
        }
        System.out.println("\n--- Lista de Libros ---"); //si hay libros imprime la lista de libros
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarMensaje(String mensaje) { //escribir un mensaje
        System.out.println(mensaje);
    }

    public void mostrarOpcionInvalida() {
        System.out.println("Opción no válida. Intenta de nuevo."); //mensaje de opcion invalida
    }
}