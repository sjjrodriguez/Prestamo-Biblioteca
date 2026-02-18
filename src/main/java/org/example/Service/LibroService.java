package org.example.Service;

import org.example.Model.Libro;
import java.util.List;

public interface LibroService {

    void registrarLibro(int id, String titulo, String autor);

    List<Libro> listarLibros();

    boolean prestarLibro(int id);

    boolean devolverLibro(int id);

    Libro buscarLibroPorId(int id);
}