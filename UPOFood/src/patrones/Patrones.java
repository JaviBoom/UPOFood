/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

import empleados.Cocinero;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class Patrones {

    public static void main(String[] args) {
        //DEBUG
        Restaurante restaurante = Restaurante.obtenerRestaurante();
        Cocinero cocinero1 = new Cocinero("Javi");
        Cocinero cocinero2 = new Cocinero("Carlos");
        Cocinero cocinero3 = new Cocinero("Victor");
        restaurante.addCocineros(cocinero1);
        restaurante.addCocineros(cocinero2);
        restaurante.addCocineros(cocinero3);
        Cliente cliente = new Cliente(-1, "a", "a", restaurante);
        restaurante.añadirCliente(cliente);
        //DEBUG

        //LOGGIN
        System.out.println("""
                              __  ______  ____  __________  ____  ____ 
                             / / / / __ \\/ __ \\/ ____/ __ \\/ __ \\/ __ \\
                            / / / / /_/ / / / / /_  / / / / / / / / / /
                           / /_/ / ____/ /_/ / __/ / /_/ / /_/ / /_/ / 
                           \\____/_/    \\____/_/    \\____/\\____/_____/  
                                                                       """);
        Scanner s = new Scanner(System.in);
        String usr;
        String psw;
        String direccion;
        while (true) {
            int opcion = -1;
            do {
                System.out.println("\n\n[Menu]\nSeleccione una opcion\n1.Iniciar Sesion\n2.Registrarse");
                opcion = s.nextInt();
                s.nextLine();
                if (opcion == 1) {
                    System.out.println("---INICIAR SESION---\nUSUARIO: ");
                    usr = s.nextLine();
                    System.out.println("CONTRASEÑA: ");
                    psw = s.nextLine();
                    Cliente clienteAux = new Cliente(-1, usr, psw, restaurante);
                    Cliente clienteLogueado = null;
                    int i = 0;
                    boolean enc = false;

                    while (i < restaurante.getClientesRegistrados().size() && !enc) {
                        if (restaurante.getClientesRegistrados().get(i).equals(clienteAux)) {
                            enc = true;
                            clienteLogueado = restaurante.getClientesRegistrados().get(i);
                        } else {
                            i++;
                        }
                    }
                    if (enc) {
                        System.out.println("->LOGUEADO");
                        opcion = -1;
                        do {
                            System.out.println("\n\n[Menu Cliente]\nSeleccione una opcion\n1.Añadir pedido a favoritos\t2.Realizar pedido\t3.Mostrar lista de pedidos favoritos\t4.Cambiar contraseña\t0.Salir");
                            opcion = s.nextInt();
                            s.nextLine();
                            while (opcion < 0 || opcion > 4) {

                                System.out.println("->Introduzca una opcion valida");
                                opcion = s.nextInt();
                            }
                            if (opcion != 0) {
                                switch (opcion) {
                                    case 1:
                                        System.out.println("->Añadir pedido a favoritos\nIntroduzca direccion de envio:");
                                        direccion = s.nextLine();
                                        clienteLogueado.addFavorito(direccion);
                                        break;
                                    case 2:
                                        System.out.println("->Realizar pedido");
                                        System.out.println("¿Desea realizar el pedido desde la lista de favoritos o crear uno nuevo?\n1.Desde la lista de favoritos\t2.Pedido nuevo");
                                        opcion = s.nextInt();
                                        s.nextLine();
                                        while (opcion < 1 || opcion > 2) {
                                            System.out.println("Introduzca una opcion valida");
                                            opcion = s.nextInt();
                                        }
                                        switch (opcion) {
                                            case 1:
                                                if (clienteLogueado.getFavoritos().isEmpty()) {
                                                    System.out.println("No tienes ningun pedido favorito");
                                                    break;
                                                }
                                                System.out.println("->Selecciones un pedido de su lista de favoritos");
                                                clienteLogueado.mostratFavoritos();
                                                opcion = s.nextInt();
                                                s.nextLine();
                                                while (opcion < 1 || opcion > clienteLogueado.getFavoritos().size()) {
                                                    System.out.println("Introduzca una opcion valida");
                                                    opcion = s.nextInt();
                                                }
                                                clienteLogueado.realizarPedidoFavorito(opcion - 1);
                                                break;
                                            case 2:
                                                System.out.println("->Realizar nuevo pedido\nIntroduzca direccion de envio:");
                                                direccion = s.nextLine();
                                                clienteLogueado.realizarPedido(direccion);
                                                break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("->Mostrar lista de pedidos favoritos");
                                        clienteLogueado.mostratFavoritos();
                                        break;
                                    case 4:
                                        System.out.println("->Cambiar contraseña");
                                        clienteLogueado.cambiarContraseña();
                                        break;
                                }
                            }
                        } while (opcion != 0);
                    } else if (usr.equals(restaurante.getAdmin().getUsuario()) && psw.equals(restaurante.getAdmin().getContraseña())) {
                        System.out.println("SESSION DE ADMINISTRADOR");
                        Administrador admin = restaurante.getAdmin();
                        int opA = -1;
                        do {
                            System.out.println("\n\n[Menu Administrador]\nSeleccione una opcion\n1-Gestionar cocineros\t2-Gestionar clientes\t0-Salir");
                            opA = s.nextInt();
                            s.nextLine();
                            while (opA < 0 || opA > 2) {
                                System.out.println("Introduzca una opcion valida");
                                opA = s.nextInt();
                            }
                            if (opA != 0) {
                                switch (opA) {
                                    case 1:
                                        System.out.println("Gestionar cocineros");
                                        admin.gestionarCocineros();
                                        break;
                                    case 2:
                                        System.out.println("Gestionar clientes");
                                        admin.gestionarClientes();
                                        break;
                                }
                            }
                        } while (opA != 0);

                    } else {
                        System.out.println("Fallo al iniciar sesion");
                    }
                } else if (opcion == 2) {
                    System.out.println("---REGISTRARSE---\nUSUARIO: ");
                    usr = s.nextLine();
                    System.out.println("CONTRASEÑA: ");
                    psw = s.nextLine();
                    Cliente clienteAux = new Cliente(restaurante.getnClientes(), usr, psw, restaurante);
                    restaurante.añadirCliente(clienteAux);
                    System.out.println("Cliente registrado con exito");
                } else {
                    System.out.println("Elija una opcion correcta");
                }
            } while (opcion == 1 || opcion == 2);
        }
    }
}
