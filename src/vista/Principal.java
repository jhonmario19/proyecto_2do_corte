/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.util.Scanner;
import modelo.*;

/**
 *
 * @author JhonM
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar libro");
            System.out.println("2. Gestionar información de clientes");
            System.out.println("3. Gestionar préstamos");
            System.out.println("4. Mostrar informe de inventario general");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese título del libro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Ingrese autor del libro:");
                    String autor = scanner.nextLine();

                    System.out.println("Ingrese editorial del libro:");
                    String editorial = scanner.nextLine();

                    System.out.println("Ingrese año del libro:");
                    int año = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    biblioteca.registrarLibro(titulo, autor, editorial, año);
                    break;

                case 2:
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Agregar cliente");
                    System.out.println("2. Mostrar información de clientes");
                    System.out.println("3. Modificar información de cliente");
                    System.out.println("4. Eliminar cliente");

                    int opcionClientes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionClientes) {
                        case 1:
                            System.out.println("Ingrese nombre del cliente:");
                            String nombreCliente = scanner.nextLine();

                            System.out.println("Ingrese dirección del cliente:");
                            String direccionCliente = scanner.nextLine();

                            System.out.println("Ingrese edad del cliente:");
                            int edadCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            System.out.println("Ingrese teléfono del cliente:");
                            String telefonoCliente = scanner.nextLine();

                            biblioteca.agregarCliente(nombreCliente, direccionCliente, edadCliente, telefonoCliente);     
                            break;
                        case 2:
                            biblioteca.mostrarInfoClientes();
                            break;
                        case 3:
                            System.out.println("Ingrese el ID del cliente que desea modificar:");
                            int idCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            System.out.println("Seleccione el dato que desea modificar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. Dirección");
                            System.out.println("3. Edad");
                            System.out.println("4. Teléfono");
                            int opcionModificarCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            switch (opcionModificarCliente) {
                                case 1:
                                    System.out.println("Ingrese el nuevo nombre:");
                                    String nuevoNombre = scanner.nextLine();
                                    biblioteca.modificarInfoCliente(idCliente, "nombre", nuevoNombre);
                                    break;
                                case 2:
                                    System.out.println("Ingrese la nueva dirección:");
                                    String nuevaDireccion = scanner.nextLine();
                                    biblioteca.modificarInfoCliente(idCliente, "direccion", nuevaDireccion);
                                    break;
                                case 3:
                                    System.out.println("Ingrese la nueva edad:");
                                    int nuevaEdad = scanner.nextInt();
                                    scanner.nextLine(); // Consumir el salto de línea
                                    biblioteca.modificarInfoCliente(idCliente, "edad", String.valueOf(nuevaEdad));
                                    break;
                                case 4:
                                    System.out.println("Ingrese el nuevo teléfono:");
                                    String nuevoTelefono = scanner.nextLine();
                                    biblioteca.modificarInfoCliente(idCliente, "telefono", nuevoTelefono);
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("Ingrese el ID del cliente que desea eliminar:");
                            int idClienteEliminar = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            biblioteca.eliminarCliente(idClienteEliminar);
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Prestar libro");
                    System.out.println("2. Devolver libro");

                    int opcionPrestamos = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionPrestamos) {
                        case 1:
                            System.out.println("Ingrese ID del usuario:");
                            int idUsuario = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            System.out.println("Ingrese título del libro:");
                            String tituloLibro = scanner.nextLine();

                            System.out.println("Ingrese fecha de préstamo (en formato dd/mm/aaaa):");
                            String fechaPrestamo = scanner.nextLine();

                            System.out.println("Ingrese fecha de regreso (en formato dd/mm/aaaa):");
                            String fechaRegreso = scanner.nextLine();

                            biblioteca.prestarLibro(idUsuario, tituloLibro, fechaPrestamo, fechaRegreso);
                            break;
                        case 2:
                            System.out.println("Ingrese ID del usuario:");
                            int idUsuario2 = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            System.out.println("Ingrese título del libro:");
                            String tituloLibro2 = scanner.nextLine();

                            biblioteca.devolverLibro(idUsuario2, tituloLibro2);
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Mostrar libros disponibles por autor");
                    System.out.println("2. Mostrar libros disponibles por editorial");
                    System.out.println("3. Mostrar estado de reserva de un libro");
                    int opcionInformes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionInformes) {
                        case 1:
                            System.out.println("Ingrese nombre del autor:");
                             autor = scanner.nextLine();
                            biblioteca.mostrarLibrosDisponiblesPorAutor(autor);
                            break;
                        case 2:
                            System.out.println("Ingrese nombre de la editorial:");
                            editorial = scanner.nextLine();
                            biblioteca.mostrarLibrosDisponiblesPorEditorial(editorial);
                            break;
                        case 3:
                            System.out.println("Ingrese título del libro:");
                            titulo = scanner.nextLine();
                            biblioteca.mostrarEstadoReservaLibro(titulo);
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Gracias por utilizar la biblioteca");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
        
    
    

