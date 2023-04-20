/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import comida.Comida;
import comida.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import patrones.Observador;

/**
 *
 * @author Victor
 */
public class Cocinero implements Observador{
    private String nombre;
    private Pedido pedido;

    
    public Cocinero(String nombre){
        this.nombre=nombre;
        this.pedido=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    @Override
    public void actualizarObservador(String cliente, String direccion, List<Comida> comidas) {
        System.out.println("["+this.getNombre()+"]"+"Preparando pedido de "+cliente+"...");
        for (Comida comida : comidas) {
            comida.preparar();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("["+this.getNombre()+"]"+"El pedido de "+cliente+" esta listo\n["+this.getNombre()+"]"+"Enviando pedido a "+direccion+"...");
        try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("["+this.getNombre()+"]"+"El pedido de "+cliente+" ha sido completado y enviado");
    }

    @Override
    public String toString() {
        return "Cocinero{" + "nombre=" + nombre + '}';
    }
    
}
