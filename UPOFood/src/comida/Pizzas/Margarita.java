/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida.Pizzas;

import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Margarita extends Pizza{
    public Margarita(){
        super("Margarita", 5.5, Arrays.asList("tomate", "mozzarella", "oregano"));
    }
    
    public void preparar(){
        System.out.println("->Preparando pizza Margarita");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
