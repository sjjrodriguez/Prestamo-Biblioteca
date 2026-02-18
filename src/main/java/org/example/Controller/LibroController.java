package org.example.Controller;

import org.example.Service.LibroService;
import org.example.View.LibroView;

import java.util.List;
import org.example.Model.Libro;

public class LibroController {

    private final LibroService libroService;
    private final LibroView libroView;

    public LibroController(LibroService libroService, LibroView libroView) {
        this.libroService = libroService;
        this.libroView = libroView;
    }

    public void registrarLibro() {
        int id = libroView.leerInt("ID del libro: ");
        String titulo = libroView.leerTexto("Título: ");
        String autor = libroView.leerTexto("Autor: ");
        libroService.registrarLibro(id, titulo, autor);
    }

    public void listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        libroView.mostrarLibros(libros);
    }

    public void prestarLibro() {
        int id = libroView.leerInt("ID del libro a prestar: ");
        libroService.prestarLibro(id);
    }

    public void devolverLibro() {
        int id = libroView.leerInt("ID del libro a devolver: ");
        libroService.devolverLibro(id);
    }

    public void ejecutar() {
        boolean continuar = true;
        while (continuar) {
            libroView.mostrarMenu();
            int opcion = libroView.leerOpcion();
            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    libroView.mostrarMensaje("¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    libroView.mostrarOpcionInvalida();
            }
        }
    }
}