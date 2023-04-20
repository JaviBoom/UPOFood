/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida.Preparar;

import patrones.EstrategiaPreparacion;

/**
 *
 * @author Victor
 */
public class PrepararConPatatas implements EstrategiaPreparacion {

    @Override
    public String preparacion() {
        System.out.println("\t->Añadiendo patatas al menu");
        return "patatas";
    }
    
    public double precio(){
        return 1.5;
    }
    
}
