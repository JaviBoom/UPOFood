/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida.Hamburguesas;

import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Completa extends Hamburguesa{
    
    public Completa(){
        super("Completa", 5.5, Arrays.asList("pan", "carne", "lechuga", "tomate", "cebolla", "queso", "jamon york"));
    }
    
    public void preparar(){
        System.out.println("->Preparando hamburguesa Completa");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
