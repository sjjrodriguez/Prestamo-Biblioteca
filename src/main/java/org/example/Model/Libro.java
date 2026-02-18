package org.example.Model;
//la clase modelo en el que especifica al objeto libro
public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private EstadoLibro estado;
//constructor del objeto libro y siempre que se cree un objeto libre tendra el estado disponible
    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = EstadoLibro.DISPONIBLE;
    }
//GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return this.estado == EstadoLibro.DISPONIBLE;
    }
//to string
    @Override
    public String toString() {
        return "Libro: {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", estado=" + estado +
                '}';
    }
}