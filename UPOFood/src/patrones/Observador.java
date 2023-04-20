/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package patrones;

import comida.Comida;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface Observador {
    void actualizarObservador(String cliente, String direccion, List<Comida> comidas);
}
