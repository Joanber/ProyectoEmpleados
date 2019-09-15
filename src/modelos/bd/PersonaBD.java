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
import modelos.md.Persona;

/**
 *
 * @author MrRainx
 */
public class PersonaBD {

    public static boolean insertar(Persona persona) {

        String INSERT = ""
                + "INSERT INTO \"Persona\"\n"
                + "( \"identificacion\", \"nombres\", \"apellidos\", \"edad\", \"correo\", \"telefono\", \"direccion\" )\n"
                + "VALUES\n"
                + "( \n"
                + "     '" + persona.getIdentificacion() + "',\n"
                + "     '" + persona.getNombres() + "',\n"
                + "     '" + persona.getApellidos() + "',\n"
                + "     " + persona.getEdad() + ",\n"
                + "     '" + persona.getCorreo() + "',\n"
                + "     '" + persona.getTelefono() + "',\n"
                + "     '" + persona.getDireccion() + "'\n"
                + ");";

        return Conexion.PrepareStatement(INSERT) == null;

    }

    public static ArrayList<Persona> getPersonas() {

        String SELECT = ""
                + "SELECT\n"
                + "     \"Persona\".identificacion,\n"
                + "     \"Persona\".nombres,\n"
                + "     \"Persona\".apellidos,\n"
                + "     \"Persona\".edad,\n"
                + "     \"Persona\".correo,\n"
                + "     \"Persona\".telefono,\n"
                + "     \"Persona\".direccion \n"
                + "FROM\n"
                + "     \"Persona\" \n";

        ArrayList<Persona> lista = new ArrayList<>();

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                Persona persona = generarPersona(rs);
                lista.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public static Persona getPersonaPor(String identificacion) {

        String SELECT = ""
                + "SELECT\n"
                + "     \"Persona\".identificacion,\n"
                + "     \"Persona\".nombres,\n"
                + "     \"Persona\".apellidos,\n"
                + "     \"Persona\".edad,\n"
                + "     \"Persona\".correo,\n"
                + "     \"Persona\".telefono,\n"
                + "     \"Persona\".direccion \n"
                + "FROM\n"
                + "     \"Persona\" \n"
                + "WHERE\n"
                + "	\"Persona\".identificacion = '" + identificacion + "'";
        Persona persona = null;

        ResultSet rs = Conexion.Query(SELECT);

        try {

            while (rs.next()) {
                persona = generarPersona(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persona;

    }

    private static Persona generarPersona(ResultSet rs) {

        try {
            Persona persona = new Persona();
            persona.setIdentificacion(rs.getString(1));
            persona.setNombres(rs.getString(2));
            persona.setApellidos(rs.getString(3));
            persona.setEdad(rs.getInt(4));
            persona.setCorreo(rs.getString(5));
            persona.setTelefono(rs.getString(6));
            persona.setDireccion(rs.getString(7));
            return persona;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
