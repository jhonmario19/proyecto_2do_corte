/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Prestamo> librosPrestados;



    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();

    }
    
    public int generarIdCliente() {
    int maxId = 0;
    for (Cliente cliente : listaClientes) {
        if (cliente.getId() > maxId) {
            maxId = cliente.getId();
        }
    }
    return maxId;
}


    // Constructor y métodos de la clase
    public void agregarCliente(String nombre, String direccion, int edad, String telefono) {
        int id = generarIdCliente();
        Cliente cliente = new Cliente(id, nombre, direccion, edad, telefono);
        listaClientes.add(cliente);
        System.out.println("Se ha agregado un nuevo cliente con ID " + id);
    }


    public void guardarDatosEnArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            FileWriter escritor = new FileWriter(archivo);

            // Escribir información de libros
            escritor.write("LIBROS\n");
            for (Libro libro : libros) {
                escritor.write(libro.getTitulo() + ";" + libro.getAutor() + ";" + libro.getEditorial() + ";" + libro.getAño() + ";" + libro.getReserva() + "\n");
            }
            escritor.write("\n");

            // Escribir información de clientes
            escritor.write("CLIENTES\n");
            for (Cliente cliente : clientes) {
                escritor.write(cliente.getNombre() + ";" + cliente.getDireccion() + ";" + cliente.getEdad() + ";" + cliente.getTelefono() + "\n");
            }
            escritor.write("\n");

            // Escribir información de préstamos
            escritor.write("PRESTAMOS\n");
            for (Prestamo prestamo : prestamos) {
                escritor.write(prestamo.getIdUsuario() + ";" + prestamo.getTituloLibro() + ";" + prestamo.getFechaPrestamo() + ";" + prestamo.getFechaRegreso() + "\n");
            }
            escritor.write("\n");

            escritor.close();
            System.out.println("Datos guardados en el archivo " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar datos en el archivo " + rutaArchivo);
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Cliente buscarClientePorId(int idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarLibro(String titulo, String autor, String editorial, int año) {
        Libro libro = new Libro(titulo, autor, editorial, año);
        libros.add(libro);
    }

    public void devolverLibro(int idUsuario, String tituloLibro) {
        // Verificar si el libro está prestado
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        if (libro == null) {
            System.out.println("El libro " + tituloLibro + " no existe en la biblioteca");
            return;
        } else if (!libro.getReserva()) {
            System.out.println("El libro " + tituloLibro + " no está prestado actualmente");
            return;
        }

        // Buscar el préstamo correspondiente
        Prestamo prestamo = null;
        for (Prestamo p : prestamos) {
            if (p.getIdUsuario() == idUsuario && p.getTituloLibro().equalsIgnoreCase(tituloLibro)) {
                prestamo = p;
                break;
            }
        }

        // Verificar si el préstamo existe
        if (prestamo == null) {
            System.out.println("El cliente con id " + idUsuario + " no tiene registrado un préstamo del libro " + tituloLibro);
            return;
        }

        // Eliminar el préstamo de la lista de préstamos
        prestamos.remove(prestamo);

        // Cambiar el estado del libro a disponible
        libro.setReserva(false);

        // Mostrar mensaje de éxito
        Cliente cliente = buscarClientePorId(idUsuario);
        System.out.println("El libro " + tituloLibro + " ha sido devuelto por el cliente " + cliente.getNombre() + " con éxito");
    }

    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor) && !libro.getReserva()) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public ArrayList<Libro> buscarLibroPorEditorial(String editorial) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEditorial().equals(editorial) && !libro.getReserva()) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public void mostrarLibrosDisponiblesPorAutor(String autor) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor) && !libro.getReserva()) {
                librosEncontrados.add(libro);
            }
        }
        if (librosEncontrados.isEmpty()) {
            System.out.println("No hay libros disponibles del autor " + autor);
        } else {
            System.out.println("Libros disponibles del autor " + autor + ":");
            for (Libro libroEncontrado : librosEncontrados) {
                System.out.println(libroEncontrado);
            }
        }
    }

    public void mostrarLibrosDisponiblesPorEditorial(String editorial) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEditorial().equals(editorial) && !libro.getReserva()) {
                librosEncontrados.add(libro);
            }
        }
        if (librosEncontrados.size() == 0) {
            System.out.println("No hay libros disponibles de la editorial " + editorial);
        } else {
            System.out.println("Libros disponibles de la editorial " + editorial + ":");
            for (Libro libroEncontrado : librosEncontrados) {
                System.out.println(libroEncontrado);
            }
        }
    }

    public void mostrarEstadoReservaLibro(String titulo) {
    for (Libro libro : libros) {
        if (libro.getTitulo().equalsIgnoreCase(titulo)) {
            if (libro.getReserva()) {
                System.out.println("El libro " + titulo + " está reservado.");
            } else {
                System.out.println("El libro " + titulo + " está disponible.");
            }
            return;
        }
    }
    System.out.println("El libro " + titulo + " no está registrado en la biblioteca.");
}

    public void mostrarInfoClientes() {
    for (Cliente cliente : clientes) {
        System.out.println(cliente.toString());
    }
}

    public void eliminarCliente(int id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con el ID ingresado.");
            return;
        }
        listaClientes.remove(cliente);
        System.out.println("El cliente ha sido eliminado exitosamente.");
    }

    public void modificarInfoCliente(int id, String propiedad, String nuevoValor) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con el ID ingresado.");
            return;
        }
        switch (propiedad.toLowerCase()) {
            case "nombre":
                cliente.setNombre(nuevoValor);
                System.out.println("El nombre del cliente ha sido modificado exitosamente.");
                break;
            case "direccion":
                cliente.setDireccion(nuevoValor);
                System.out.println("La dirección del cliente ha sido modificada exitosamente.");
                break;
            case "edad":
                int edad = Integer.parseInt(nuevoValor);
                cliente.setEdad(edad);
                System.out.println("La edad del cliente ha sido modificada exitosamente.");
                break;
            case "telefono":
                cliente.setTelefono(nuevoValor);
                System.out.println("El teléfono del cliente ha sido modificado exitosamente.");
                break;
            default:
                System.out.println("La propiedad ingresada no es válida.");
                break;
        }
    }

    public void prestarLibro(int idUsuario, String tituloLibro, String fechaPrestamo, String fechaRegreso) {
        // Verificar si el libro está disponible
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        if (libro == null) {
            System.out.println("El libro " + tituloLibro + " no existe en la biblioteca");
            return;
        } else if (libro.getReserva()) {
            System.out.println("El libro " + tituloLibro + " está reservado y no puede ser prestado en este momento");
            return;
        }

        // Verificar si el cliente existe
        Cliente cliente = buscarClientePorId(idUsuario);
        if (cliente == null) {
            System.out.println("El cliente con id " + idUsuario + " no está registrado en la biblioteca");
            return;
        }

        // Crear un nuevo préstamo y agregarlo a la lista de préstamos
        Prestamo prestamo = new Prestamo(idUsuario, tituloLibro, fechaPrestamo, fechaRegreso);
        prestamos.add(prestamo);

        // Cambiar el estado del libro a prestado
        libro.setReserva(true);

        // Mostrar mensaje de éxito
        System.out.println("El libro " + tituloLibro + " ha sido prestado al cliente " + cliente.getNombre() + " con éxito");
    }
    
}
