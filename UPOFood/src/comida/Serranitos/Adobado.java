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
public class Adobado extends Serranito{
    public Adobado(){
        super("Adobado", 5.5, Arrays.asList("lomo adobado", "tomate", "pimiento", "jamon"));
    }
    
    public void preparar(){
        System.out.println("->Preparando serranito Serranito Adobado");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
