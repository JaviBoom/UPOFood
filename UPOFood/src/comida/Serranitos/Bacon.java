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
public class Bacon extends Serranito{
    public Bacon(){
        super("Bacon", 5.5, Arrays.asList("bacon", "tomate", "pimiento", "jamon"));
    }
    
    public void preparar(){
        System.out.println("->Preparando serranito Serranito de Bacon");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
