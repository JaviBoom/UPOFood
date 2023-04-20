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
public class CuatroQuesos extends Pizza{
    public CuatroQuesos(){
        super("CuatroQuesos", 5.5, Arrays.asList("mozzarella", "cheddar", "cabra", "roquefort"));
    }
    
    public void preparar(){
        System.out.println("->Preparando pizza Cuatro Quesos");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
