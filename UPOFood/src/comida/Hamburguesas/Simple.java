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
public class Simple extends Hamburguesa{
    
    public Simple(){
        super("Simple", 2.5, Arrays.asList("pan", "carne"));
    }
    
    public void preparar(){
        System.out.println("->Preparando hamburguesa Simple");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
