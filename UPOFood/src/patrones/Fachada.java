/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

import comida.FactoriaComida;
import comida.Pedido;
import empleados.Cocinero;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class Fachada {

    private Restaurante restaurante;

    public Fachada(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Pedido crearPedido(String cliente, String direccion) {
        FactoriaComida fc = new FactoriaComida();
        Pedido pedido = new Pedido(cliente, fc, direccion);
        Scanner s = new Scanner(System.in);
        int opcionTipo = -1;
        int opcionComida = -1;
        int opcionPreparacion = -1;
        int opcion = -1;
        String tipoComida = "", nombreComida = "", tipoPreparacion = "";
        do {
            System.out.println("---Seleccionar tipo de comida---\nPor favor seleccione un tipo de comida:\t1.Hamburguesa\t2.Pizza\t3.Serranito");
            opcionTipo = s.nextInt();
            s.nextLine();
            while (opcionTipo < 1 || opcionTipo > 3) {
                System.out.println("Introduzca una opcion valida");
                opcionTipo = s.nextInt();
            }
            System.out.println("---Seleccionar comida---\nPor favor seleccione una comida:");

            switch (opcionTipo) {
                case 1:
                    tipoComida = "Hamburguesa";
                    System.out.println("\t1.Chicken\t2.Completa\t3.Simple");
                    break;
                case 2:
                    tipoComida = "Pizza";
                    System.out.println("\t1.Barbacoa\t2.CuatroQuesos\t3.Margarita");
                    break;
                case 3:
                    tipoComida = "Serranito";
                    System.out.println("\t1.Adobado\t2.Bacon\t3.Tortilla");
                    break;
            }
            opcionComida = s.nextInt();
            s.nextLine();
            while (opcionComida < 1 || opcionComida > 3) {
                System.out.println("Introduzca una opcion valida");
                opcionComida = s.nextInt();
            }
            switch (opcionComida) {
                case 1:
                    if (tipoComida.equals("Hamburguesa")) {
                        nombreComida = "Chicken";
                    } else if (tipoComida.equals("Pizza")) {
                        nombreComida = "Barbacoa";
                    } else if (tipoComida.equals("Serranito")) {
                        nombreComida = "Adobado";
                    }
                    break;
                case 2:
                    if (tipoComida.equals("Hamburguesa")) {
                        nombreComida = "Completa";
                    } else if (tipoComida.equals("Pizza")) {
                        nombreComida = "CuatroQuesos";
                    } else if (tipoComida.equals("Serranito")) {
                        nombreComida = "Bacon";
                    }
                    break;
                case 3:
                    if (tipoComida.equals("Hamburguesa")) {
                        nombreComida = "Simple";
                    } else if (tipoComida.equals("Pizza")) {
                        nombreComida = "Margarita";
                    } else if (tipoComida.equals("Serranito")) {
                        nombreComida = "Tortilla";
                    }
                    break;
            }
            System.out.println("---Seleccionar añadidos---\nPor favor seleccione un añadido al menu:\t1.Patatas\t2.Refresco");
            opcionPreparacion = s.nextInt();
            s.nextLine();
            while (opcionPreparacion < 1 || opcionPreparacion > 2) {
                System.out.println("Introduzca una opcion valida");
                opcionPreparacion = s.nextInt();
            }
            switch (opcionPreparacion) {
                case 1:
                    tipoPreparacion = "Patatas";
                    break;
                case 2:
                    tipoPreparacion = "Refresco";
                    break;
            }
            pedido.añadirAlPedido(tipoComida, nombreComida, tipoPreparacion);
            System.out.println(pedido.toString());
            System.out.println("---¿Desea añadir mas comidas al pedido?---\nPor favor seleccione una opcion:\t1.Si\t0.No");
            opcion = s.nextInt();
            s.nextLine();
            while (opcion < 0 || opcion > 1) {
                System.out.println("Introduzca una opcion valida");
                opcion = s.nextInt();
            }
        } while (opcion != 0);
        return pedido;
    }

    public void mostrarFavoritos(List<Pedido> listaFavoritos) {
        int num = 1;
        if (listaFavoritos.isEmpty()) {
            System.out.println("No hay ningun pedido en la lista de favoritos");
        } else {
            for (Pedido pedido : listaFavoritos) {
                System.out.println(Integer.toString(num) + pedido.toString());
                num++;
            }
        }

    }

    public String cambiarContraseña() {
        Scanner s = new Scanner(System.in);
        String psw;
        System.out.println("Introduzca una nueva contraseña");
        psw = s.nextLine();
        return psw;
    }

    public void realizarPedido(String cliente, String direccion) {
        Pedido pedido = crearPedido(cliente, direccion);
        Cocinero cocinero = this.restaurante.getCocineros().get(new Random().nextInt(this.restaurante.getCocineros().size()));//Selecciona un cocinero al azar
        pedido.añadirObservador(cocinero);
        pedido.notificarObservadores();
        pedido.eliminarObservador(cocinero);
    }

    public void realizarPedidoFavorito(Pedido pedido) {
        Cocinero cocinero = this.restaurante.getCocineros().get(new Random().nextInt(this.restaurante.getCocineros().size()));//Selecciona un cocinero al azar
        pedido.añadirObservador(cocinero);
        pedido.notificarObservadores();
        pedido.eliminarObservador(cocinero);
    }

    public void gestionarClientes(List<Cliente> clientes) {
        int num = 0;
        Scanner s = new Scanner(System.in);
        int opC = -1;
        int opO = -1;
        if (clientes.size() == 0) {
            System.out.println("No hay clientes registrados");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println((num + 1) + "." + cliente.getUsuario());
                num++;
            }
            System.out.println("Por favor seleccione el cliente que quiere gestionar");
            opC = s.nextInt();
            s.nextLine();
            while (opC < 1 || opC > clientes.size()) {
                System.out.println("Introduzca una opcion valida");
                opC = s.nextInt();
            }

            System.out.println("Por favor introduzca seleccione una operacion a realizar\n1.Eliminar\t2.Ver informacion");
            opO = s.nextInt();
            s.nextLine();
            while (opO < 1 || opO > 2) {
                System.out.println("Introduzca una opcion valida");
                opO = s.nextInt();
            }
            switch (opO) {
                case 1:
                    clientes.remove(opC - 1);
                    break;
                case 2:
                    System.out.println(clientes.get(opC - 1).toString());
                    break;
            }
        }

    }

    void gestionarCocineros(List<Cocinero> cocineros) {
        int num = 0;
        Scanner s = new Scanner(System.in);
        int opC = -1;
        int opO = -1;
        if (cocineros.size() == 0) {
            System.out.println("No hay cocineros registrados");
        } else {
            for (Cocinero cocinero : cocineros) {
                System.out.println((num + 1) + "." + cocinero.getNombre());
                num++;
            }
            System.out.println("Por favor introduzca seleccione una operacion a realizar\n1.Eliminar\t2.Ver informacion\t3.Contratar nuevo cocinero");
            opO = s.nextInt();
            s.nextLine();

            while (opO < 1 || opO > 3) {
                System.out.println("Introduzca una opcion valida");
                opO = s.nextInt();
            }
            switch (opO) {
                case 1:
                    System.out.println("Por favor seleccione el cocinero que quiere eliminar");
                    opC = s.nextInt();
                    s.nextLine();
                    while (opC < 1 || opC > cocineros.size()) {
                        System.out.println("Introduzca una opcion valida");
                        opC = s.nextInt();
                    }
                    if(cocineros.size()==1){
                        System.out.println("El cocinero no se puede eliminar porque debe haber un minimo de un cocinero para poder realizar los pedidos");
                    }else{
                        cocineros.remove(opC - 1);
                    }
                    break;
                case 2:
                    System.out.println("Por favor seleccione el cocinero que quiere ver");
                    opC = s.nextInt();
                    s.nextLine();
                    while (opC < 1 || opC > cocineros.size()) {
                        System.out.println("Introduzca una opcion valida");
                        opC = s.nextInt();
                    }
                    System.out.println(cocineros.get(opC - 1).toString());
                    break;
                case 3:
                    System.out.println("Introduzca el nombre del nuevo cocinero");
                    cocineros.add(new Cocinero(s.nextLine()));
                    break;
            }
        }
    }
}
