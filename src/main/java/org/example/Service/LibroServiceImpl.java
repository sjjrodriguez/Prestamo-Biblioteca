package org.example.Service;

import org.example.Model.EstadoLibro;
import org.example.Model.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroServiceImpl implements LibroService {

    private final List<Libro> libros = new ArrayList<>();

    @Override
    public void registrarLibro(int id, String titulo, String autor) {
        // Verificar que el ID no esté duplicado
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                System.out.println("Error: Ya existe un libro con el ID " + id);
                return;
            }
        }
        libros.add(new Libro(id, titulo, autor));
        System.out.println("Libro registrado correctamente: " + titulo);
    }

    @Override
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    @Override
    public boolean prestarLibro(int id) {
        Libro libro = buscarLibroPorId(id);
        if (libro == null) {
            System.out.println("Error: No se encontró un libro con ID " + id);
            return false;
        }
        if (!libro.isDisponible()) {
            System.out.println("Error: El libro \"" + libro.getTitulo() + "\" ya está prestado.");
            return false;
        }
        libro.setEstado(EstadoLibro.PRESTADO);
        System.out.println("Libro \"" + libro.getTitulo() + "\" prestado correctamente.");
        return true;
    }

    @Override
    public boolean devolverLibro(int id) {
        Libro libro = buscarLibroPorId(id);
        if (libro == null) {
            System.out.println("Error: No se encontró un libro con ID " + id);
            return false;
        }
        if (libro.isDisponible()) {
            System.out.println("Error: El libro \"" + libro.getTitulo() + "\" ya está disponible, no fue prestado.");
            return false;
        }
        libro.setEstado(EstadoLibro.DISPONIBLE);
        System.out.println("Libro \"" + libro.getTitulo() + "\" devuelto correctamente.");
        return true;
    }

    @Override
    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
}