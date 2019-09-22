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
public class UsuarioBD extends Usuario {

    public static Usuario getUsuarioPor(String username) {

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

    public static boolean insertar(Usuario usuario) {
        String INSERT = "INSERT INTO public.\"Usuario\"(\n"
                + "	username, password, persona_id)\n"
                + "	VALUES ('" + usuario.getUsername() + "','" + usuario.getPassword() + "' ,'" + usuario.getPersona().getIdentificacion() + "' );";
        System.out.println(INSERT);
        return Conexion.PrepareStatement(INSERT) == null;
    }

    public static boolean update(Usuario usuario, String username) {
        String UPDATE = "UPDATE public.\"Usuario\"\n"
                + "	SET username='" + usuario.getUsername() + "', password='" + usuario.getPassword() + "', persona_id='" + usuario.getPersona().getIdentificacion() + "'\n"
                + "	WHERE username='" + username + "';";
        System.out.println(UPDATE);
        return Conexion.PrepareStatement(UPDATE) == null;
    }

    public static boolean delete(String username) {
        String DELETE = "DELETE FROM public.\"Usuario\"\n"
                + "	WHERE username='" + username + "'";
        System.out.println(DELETE);
        return Conexion.PrepareStatement(DELETE) == null;
    }

    public static ArrayList<Usuario> getUsuarios(String username) {
        String SELECT = "SELECT username, password, persona_id\n"
                + "	FROM public.\"Usuario\" WHERE username ILIKE '%" + username + "%'";
        System.out.println(SELECT + "--------------------->>>>>>>>>>SELECT");
        ResultSet rs = Conexion.Query(SELECT);
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(generarUsuario(rs));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private static Usuario generarUsuario(ResultSet rs) {
        Usuario usuario = new Usuario();

        try {
            usuario.setUsername(rs.getString(1));
            usuario.setPassword(rs.getString(2));
            usuario.setPersona(PersonaBD.getPersonaPor(rs.getString(3)));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
