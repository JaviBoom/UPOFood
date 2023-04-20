/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida.Pizzas;

import comida.Comida;
import java.util.List;

/**
 *
 * @author Victor
 */
public abstract class Pizza extends Comida {
    protected String tipo;
    public Pizza(String nombre, double precio, List<String> ingredientes){
        super(nombre, precio, ingredientes);
        this.tipo="Pizza";
    }
}
