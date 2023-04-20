/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comida;

import comida.Hamburguesas.*;
import comida.Pizzas.*;
import comida.Preparar.*;
import comida.Serranitos.*;

/**
 *
 * @author Victor
 */
public class FactoriaComida {
    public Comida añadirComida(String tipoComida, String nombre, String preparacion){
        Comida comida=null;
        if(tipoComida.equals("Hamburguesa")){
            if(nombre.equals("Chicken")){
                comida=new Chicken();
            }else if(nombre.equals("Completa")){
                comida=new Completa();
            }else if(nombre.equals("Simple")){
                comida=new Simple();
            }
        }else if (tipoComida.equals("Pizza")) {
            if (nombre.equals("Barbacoa")) {
                comida = new Barbacoa();
            } else if (nombre.equals("CuatroQuesos")) {
                comida = new CuatroQuesos();
            } else if (nombre.equals("Margarita")) {
                comida = new Margarita();
            }
        } else if (tipoComida.equals("Serranito")) {
            if (nombre.equals("Adobado")) {
                comida = new Adobado();
            } else if (nombre.equals("Bacon")) {
                comida = new Bacon();
            } else if (nombre.equals("Tortilla")) {
                comida = new Tortilla();
            }
        }
        
        if(preparacion.equals("Patatas")){
            comida.setPreparacion(new PrepararConPatatas());
        } else if (preparacion.equals("Refresco")){
            comida.setPreparacion(new PrepararConRefresco());
        }
        return comida;
    }
}

