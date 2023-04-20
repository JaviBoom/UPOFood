/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida;

import java.util.ArrayList;
import java.util.List;
import patrones.EstrategiaPreparacion;

/**
 *
 * @author Victor
 */
public abstract class Comida {
    protected String nombre;
    protected double precio;
    protected List<String> ingredientes;
    private EstrategiaPreparacion preparacion;

    public void setPreparacion(EstrategiaPreparacion preparacion) {
        this.preparacion = preparacion;
        preparacion();
    }
    
    public void preparacion(){
        addIngrediente(this.preparacion.preparacion());
        actualizarPrecio(this.preparacion.precio());
        
    }
    
    public abstract void preparar();
    
    public void addIngrediente(String ingrediente){
        List<String> lista = new ArrayList<String>();
        for (String ing : this.getIngredientes()) {
            lista.add(ing);
        }
        lista.add(ingrediente);
        this.setIngredientes(lista);
    }
    
    public void actualizarPrecio(double num){
        this.setPrecio(this.getPrecio()+num);
    }
    
    public Comida(String nombre, double precio, List<String> ingredientes){
        this.nombre=nombre;
        this.precio=precio;
        this.ingredientes=ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
