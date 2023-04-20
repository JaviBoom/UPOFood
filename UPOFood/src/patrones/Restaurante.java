/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

import empleados.Cocinero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Restaurante {
    private static Restaurante instance = null;
    private List<Cliente> clientesRegistrados;
    private List<Cocinero> cocineros;
    private Administrador admin;
    private int nClientes;
    
    private Restaurante(){
        this.clientesRegistrados= new ArrayList();
        this.nClientes=0;
        this.cocineros=new ArrayList<Cocinero>();
        this.admin=Administrador.obtenerAdministrador(this);
    }
    
    public static Restaurante obtenerRestaurante() {
        if (instance == null) {
            instance = new Restaurante();
        }
        return instance;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public List<Cocinero> getCocineros() {
        return cocineros;
    }

    public void addCocineros(Cocinero cocinero) {
        this.cocineros.add(cocinero);
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void añadirCliente(Cliente cliente) {
        this.clientesRegistrados.add(cliente);
        this.nClientes++;
    }

    public int getnClientes() {
        return nClientes;
    }
    
    
    
}
