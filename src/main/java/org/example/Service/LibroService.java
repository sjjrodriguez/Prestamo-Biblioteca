package org.example.Service;

import org.example.Model.Libro;
import java.util.List;

// aquí se definen los métodos que usará el servicio
public interface LibroService {

    void registrarLibro(int id, String titulo, String autor);
    // metodo para registrar un libro con id, título y autor

    List<Libro> listarLibros();
    // metodo para mos

    void prestarLibro(int id);
    // metodo para prestar un libro usando su id

    void devolverLibro(int id);
    // metodo para devolver un libro usando su id

    Libro buscarLibroPorId(int id);
    // metodo para buscar un libro por su id
}
