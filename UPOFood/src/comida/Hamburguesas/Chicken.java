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
public class Chicken extends Hamburguesa {

    public Chicken() {

        super("Chicken", 4.5, Arrays.asList("pan", "pollo", "lechuga"));
    }

    public void preparar() {
        System.out.println("->Preparando hamburguesa Chicken");
        for (String ingrediente : this.getIngredientes()) {
            System.out.println("\t-Añadiendo " + ingrediente);
        }
    }
}
