package org.example;

import org.example.Controller.LibroController;
import org.example.Service.LibroService;
import org.example.Service.LibroServiceImpl;
import org.example.View.LibroView;

public class Main {

    public static void main(String[] args) {
        LibroService libroService = new LibroServiceImpl();
        LibroView libroView = new LibroView();
        LibroController controller = new LibroController(libroService, libroView);
        controller.ejecutar();
    }
}