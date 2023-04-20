/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida.Serranitos;

import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Tortilla extends Serranito{
    public Tortilla(){
        super("Tortilla", 5.5, Arrays.asList("tortilla", "tomate", "pimiento", "jamon"));
    }
    
    public void preparar(){
        System.out.println("->Preparando serranito Serranito de Tortilla");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
