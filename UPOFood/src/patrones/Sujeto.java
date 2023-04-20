/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package patrones;

/**
 *
 * @author Victor
 */
public interface Sujeto {
    void añadirObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores();
}
