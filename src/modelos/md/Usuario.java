/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.md;

/**
 *
 * @author MrRainx
 */
public class Usuario {
    //ATRIBUTOS DE CLASE
    private String username;
    private String password;
    private Persona persona;
     
    //CONSTRUCTOR VACIO
    public Usuario() {
        this.persona=new Persona();
    }
    //METODOS GETTER Y SETTER
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    //METODO TOSTRING
    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", persona=" + persona + '}';
    }

}
