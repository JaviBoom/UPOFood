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
public class PrepararConRefresco implements EstrategiaPreparacion {

    @Override
    public String preparacion() {
        System.out.println("\t->Añadiendo refresco al menu");
        return "refresco";
    }
    
    public double precio(){
        return 2;
    }
    
}
