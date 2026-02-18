package org.example.Service;

import org.example.Model.EstadoLibro;
import org.example.Model.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroServiceImpl implements LibroService {

    private final List<Libro> libros = new ArrayList<>();
    // se crea la lista donde se guardan los libros

    @Override
    public void registrarLibro(int id, String titulo, String autor) {

        // verificar que el id no esté duplicado
        for (Libro libro : libros) {
            // recorre la lista de libros
            if (libro.getId() == id) {
                // pregunta si el id ya existe
                System.out.println("Error: Ya existe un libro con el ID " + id);
                // mensaje de error
                return;
                // no registra el libro y sale del metodo
            }
        }

        libros.add(new Libro(id, titulo, autor));
        // registra el nuevo libro en la lista
        System.out.println("Libro registrado correctamente: " + titulo);
        // mensaje de confirmación
    }

    @Override
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
        // retorna una copia de la lista de libros
    }

    @Override
    public void prestarLibro(int id) {

        Libro libro = buscarLibroPorId(id);
        // busca el libro por su id

        if (libro == null) {
            // verifica si el libro no existe
            System.out.println("Error: No se encontró un libro con ID " + id);
            // mensaje de error
            return;
            // sale del metodo
        }

        if (!libro.isDisponible()) {
            // verifica si el libro ya está prestado
            System.out.println("Error: El libro \"" + libro.getTitulo() + "\" ya está prestado.");
            // mensaje de error
            return;
            // sale del metodo
        }

        libro.setEstado(EstadoLibro.PRESTADO);
        // cambia el estado del libro a PRESTADO
        System.out.println("Libro \"" + libro.getTitulo() + "\" prestado correctamente.");
        // mensaje de confirmación
    }

    @Override
    public void devolverLibro(int id) {

        Libro libro = buscarLibroPorId(id);
        // busca el libro por su id

        if (libro == null) {
            // verifica si el libro no existe
            System.out.println("Error: No se encontró un libro con ID " + id);
            // mensaje de error
            return;
            // sale del metodo
        }

        if (libro.isDisponible()) {
            // verifica si el libro ya está disponible
            System.out.println("Error: El libro \"" + libro.getTitulo() + "\" ya está disponible.");
            // mensaje de error
            return;
            // sale del metodo
        }

        libro.setEstado(EstadoLibro.DISPONIBLE);
        // cambia el estado del libro a DISPONIBLE
        System.out.println("Libro \"" + libro.getTitulo() + "\" devuelto correctamente.");
        // mensaje de confirmación
    }

    @Override
    public Libro buscarLibroPorId(int id) {

        for (Libro libro : libros) {
            // recorre la lista de libros
            if (libro.getId() == id) {
                // compara el id
                return libro;
                // retorna el libro encontrado
            }
        }
        return null;
        // retorna null si no se encuentra el libro
    }
}
