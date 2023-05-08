/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JhonM
 */
public class Libro {
    
     private String titulo;
    private String editorial;
    private int año;
    private String autor;
    private boolean reservado;

    public Libro(String titulo, String autor, String editorial, int año) {
    this.titulo = titulo;
    this.autor = autor;
    this.editorial = editorial;
    this.año = año;
}

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAño() {
        return año;
    }

    public String getAutor() {
        return autor;
    }

    public boolean getReserva() {
        return reservado;
    }

    public void setReserva(boolean estadoReserva) {
        this.reservado = estadoReserva;
    }
    
@Override
public String toString() {
    return "Título: " + this.titulo + ", Autor: " + this.autor + ", Año: " + this.año + ", Reserva: " + this.reservado;
}
    
}
