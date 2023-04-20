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
public class Barbacoa extends Pizza{
    public Barbacoa(){
        super("Barbacoa", 5.5, Arrays.asList("ternera picada", "bacon", "salsa barbacoa"));
    }
    
    public void preparar(){
        System.out.println("->Preparando pizza Barbacoa");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
