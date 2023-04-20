/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

import comida.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Victor
 */
public class Cliente {

    private int idCliente;
    private String usuario;
    private String contraseña;
    private Fachada fachada;
    private List<Pedido> favoritos;
    //private Pedido pedido;

    public Cliente(int idCliente, String usuario, String contraseña, Restaurante restaurante) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fachada = new Fachada(restaurante);
        this.favoritos = new ArrayList<Pedido>();
    }

    public void addFavorito(String direccion) {
        this.favoritos.add(this.fachada.crearPedido(this.getUsuario(), direccion));
    }

    public void mostratFavoritos() {
        this.fachada.mostrarFavoritos(this.getFavoritos());
    }

    public List<Pedido> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Pedido> favoritos) {
        this.favoritos = favoritos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

    public void cambiarContraseña() {
        this.setContraseña(this.getFachada().cambiarContraseña());
    }

    public void realizarPedido(String direccion) {
        this.getFachada().realizarPedido(this.getUsuario(), direccion);
    }

    public void realizarPedidoFavorito(int nPedido) {
        this.getFachada().realizarPedidoFavorito(this.getFavoritos().get(nPedido));
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", usuario=" + usuario + ", favoritos=" + favoritos + '}';
    }
}
