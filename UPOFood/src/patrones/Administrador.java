/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

/**
 *
 * @author Victor
 */
public class Administrador {
    private String usuario;
    private String contraseña;
    private static Administrador administradorUnico =null;
    private Fachada fachada;
    private Restaurante restaurante;
    
    private Administrador(Restaurante restaurante){
        this.usuario="admin";
        this.contraseña="admin";
        this.restaurante=restaurante;
        this.fachada=new Fachada(restaurante);
    }
    
    public static Administrador obtenerAdministrador(Restaurante restaurante){
        if (administradorUnico == null) {
            administradorUnico = new Administrador(restaurante);
        }
        return administradorUnico;
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

    void gestionarCocineros() {
        this.fachada.gestionarCocineros(this.getRestaurante().getCocineros());
    }

    void gestionarClientes() {
        this.fachada.gestionarClientes(this.getRestaurante().getClientesRegistrados());
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}
