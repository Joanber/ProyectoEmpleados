/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Conexion;
import modelos.md.Usuario;

/**
 *
 * @author MrRainx
 */
//CLASE QUE EXTIENDE DE USUARIO CON TODOS SUS ATRIBUTOS Y REALIZA LOS PROCESOS CON LA BASE DE DATOS
public class UsuarioBD extends Usuario {
   //METODO ESTATICO DE USUARIO QUE OBTIENE UN USUARIO CON EL PARAMETRO DE USERNAME
    public static Usuario getUsuarioPor(String username) {
        //SELECT SQL 
        String SELECT = ""
                + "SELECT\n"
                + "	\"Usuario\".username,\n"
                + "	\"Usuario\".\"password\",\n"
                + "	\"Usuario\".persona_id \n"
                + "FROM\n"
                + "	\"Usuario\" \n"
                + "WHERE\n"
                + "	\"Usuario\".username = '" + username + "';";
        System.out.println(SELECT);
        //OBJETO DE USUARIO 
        Usuario usuario = null;
        //RESULTSET DEVUELVE DATOS DE UNA CONSULTA SQL 
        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                //EL OBJETO USUARIO SE LLENA CON EL USUARIO GENERADO POR EL RESULTSET 
                usuario = generarUsuario(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNA UN USUARIO 
        return usuario;
    }

    public static Usuario login(String username, String password) {

        String SELECT = ""
                + "SELECT\n"
                + "	\"public\".\"Usuario\".username,\n"
                + "	\"public\".\"Usuario\".\"password\",\n"
                + "	\"public\".\"Usuario\".persona_id \n"
                + "FROM\n"
                + "	\"public\".\"Usuario\" \n"
                + "WHERE\n"
                + "	\"Usuario\".username = '" + username + "' \n"
                + "	AND \"Usuario\".\"password\" = '" + password + "';";
        Usuario usuario = null;
        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                usuario = generarUsuario(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
   // METODO ESTATICO QUE INSERTA UN REGISTRO EN LA BASE DATOS CON EL PARAMETRO DE USUARIO
    public static boolean insertar(Usuario usuario) {
        //INSTRUCCION DE INSERT SQL
        String INSERT = "INSERT INTO public.\"Usuario\"(\n"
                + "	username, password, persona_id)\n"
                + "	VALUES ('" + usuario.getUsername() + "','" + usuario.getPassword() + "' ,'" + usuario.getPersona().getIdentificacion() + "' );";
        System.out.println(INSERT);
        return Conexion.PrepareStatement(INSERT) == null;
    }

   // METODO ESTATICO QUE MODIFICA UN REGISTRO EN LA BASE DATOS CON EL PARAMETRO DE USUARIO Y EL USERNAME
    public static boolean update(Usuario usuario, String username) {
        //INSTRUCCION DE UPDATE SQL
        String UPDATE = "UPDATE public.\"Usuario\"\n"
                + "	SET username='" + usuario.getUsername() + "', password='" + usuario.getPassword() + "', persona_id='" + usuario.getPersona().getIdentificacion() + "'\n"
                + "	WHERE username='" + username + "';";
        System.out.println(UPDATE);
        return Conexion.PrepareStatement(UPDATE) == null;
    }

   // METODO ESTATICO QUE ELIMINA UN REGISTRO EN LA BASE DATOS CON EL PARAMETRO DE USERNAME
    public static boolean delete(String username) {
        //INSTRUCCION DELETE SQL
        String DELETE = "DELETE FROM public.\"Usuario\"\n"
                + "	WHERE username='" + username + "'";
        System.out.println(DELETE);
        return Conexion.PrepareStatement(DELETE) == null;
    }
    //METODO ESTATICO QUE DEVUELVE UNA LISTA DE USUARIOS DE LA BASE DE DATOS
    public static ArrayList<Usuario> getUsuarios(String username) {
        //INSTRUCCION SELECT SQL
        String SELECT = "SELECT username, password, persona_id\n"
                + "	FROM public.\"Usuario\" WHERE username ILIKE '%" + username + "%'";
        System.out.println(SELECT + "--------------------->>>>>>>>>>SELECT");
        ResultSet rs = Conexion.Query(SELECT);
        //CREO UNA LISTA DE USUARIOS
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                //AÑADO A LA LISTA DE USUARIOS  LOS USUARIOS GENERADOS POR EL RESULTSET
                lista.add(generarUsuario(rs));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RETORNA UNA LISTA DE USUARIOS
        return lista;
    }
    //METODO ESTATICO QUE GENERA UN USUARIO POR UNA CONSULTA RESULTSET 
    private static Usuario generarUsuario(ResultSet rs) {
        // INSTANCIA DE USUARIO
        Usuario usuario = new Usuario();

        try {
            //SETEAMOS EN CADA UNO DE LOS ATRIBUTOS  DEL OBJETO USUARIO LOS DATOS CORRESPONDIENTES DESDE LA BASE DE DATOS
            usuario.setUsername(rs.getString(1));
            usuario.setPassword(rs.getString(2));
            usuario.setPersona(PersonaBD.getPersonaPor(rs.getString(3)));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
