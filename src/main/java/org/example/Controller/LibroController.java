package org.example.Controller;

import org.example.Service.LibroService;
import org.example.View.LibroView;

import java.util.List;
import org.example.Model.Libro;

public class LibroController {
//aplicamos encapsulamiento aqui
    private final LibroService libroService;
    private final LibroView libroView;

    public LibroController(LibroService libroService, LibroView libroView) {
        this.libroService = libroService;
        this.libroView = libroView;
    }
//Clase para registrar libro
    public void registrarLibro() {
        int id = libroView.leerInt("ID del libro: ");
        String titulo = libroView.leerTexto("Título: ");
        String autor = libroView.leerTexto("Autor: ");
        libroService.registrarLibro(id, titulo, autor);
    }
//listar libros
    public void listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        libroView.mostrarLibros(libros);
    }
//prestar libro  por id
    public void prestarLibro() {
        int id = libroView.leerInt("ID del libro a prestar: ");
        libroService.prestarLibro(id);
    }
//devolver libro por id
    public void devolverLibro() {
        int id = libroView.leerInt("ID del libro a devolver: ");
        libroService.devolverLibro(id);
    }

    public void ejecutar() {

        while (true) {
            // ciclo infinito hasta que el usuario decida salir

            libroView.mostrarMenu();
            // muestra el menú de opciones

            int opcion = libroView.leerOpcion();
            // lee la opción ingresada por el usuario

            switch (opcion) {

                case 1 -> registrarLibro();
                // opción para registrar un libro

                case 2 -> listarLibros();
                // opción para listar los libros

                case 3 -> prestarLibro();
                // opción para prestar un libro

                case 4 -> devolverLibro();
                // opción para devolver un libro

                case 5 -> {
                    libroView.mostrarMensaje("¡Hasta luego!");
                    // mensaje de despedida
                    return;
                    // sale completamente del metodo ejecutar()
                }

                default -> libroView.mostrarOpcionInvalida();
                // opción inválida
            }
        }
    }
}