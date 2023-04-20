/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida;

import java.util.ArrayList;
import java.util.List;
import patrones.Observador;
import patrones.Sujeto;

/**
 *
 * @author Victor
 */
public class Pedido implements Sujeto{
    private String cliente;
    private List<Comida> comidas;
    private FactoriaComida factoria;
    private List<Observador> observadores;
    private double precioTotal;
    private String direccion;
    
    public Pedido(String cliente, FactoriaComida factoria, String direccion) {
        this.comidas=new ArrayList<Comida>();
        this.factoria=factoria;
        this.observadores=new ArrayList<Observador>();
        this.cliente=cliente;
        this.precioTotal=0;
        this.direccion=direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Observador> getObservadores() {
        return observadores;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    @Override
    public String toString() {
        String cadena="[ ";
        for (Comida comida : this.getComidas()) {
            cadena=cadena+comida.toString()+"("+comida.getPrecio()+" €"+")"+" ";
        }
        cadena=cadena+"] Precio Total= "+this.getPrecioTotal()+" €";
        return cadena;
    }

    @Override
    public void añadirObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for(Observador observador : this.getObservadores()){
            observador.actualizarObservador(this.getCliente(), this.getDireccion(), this.getComidas());
        }
    }
    
    public void añadirAlPedido(String tipoComida, String nombreComida, String preparacion){
        
            this.comidas.add(this.factoria.añadirComida(tipoComida, nombreComida, preparacion));
            this.precioTotal+=this.comidas.get(this.comidas.size()-1).getPrecio();
            notificarObservadores();
    }
    
}
