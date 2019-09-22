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

/**
 *
 * @author MrRainx
 */
public class Queries {

    public static ArrayList<Object[]> getRetrasosDe(String pkPersona) {

        String SELECT = ""
                + "SELECT\n"
                + "	\"Horario\".hora_inicio || ' - ' || \"Horario\".hora_fin AS \"HORARIO\",\n"
                + "	\"Horario\".jornada AS \"JORNADA\",\n"
                + "	\"DetalleRegistros\".hora AS \"HORA DE INGRESO\",\n"
                + "	\"DetalleRegistros\".fecha AS \"FECHA DE INGRESO\",\n"
                + "	\"Horario\".hora_inicio - \"DetalleRegistros\".hora AS \"ATRASADO POR\",\n"
                + "	\"Cargo\".nombre AS \"CARGO\"\n"
                + "FROM\n"
                + "	\"Persona\"\n"
                + "	INNER JOIN \"HistorialTrabajo\" ON \"HistorialTrabajo\".persona_id = \"Persona\".identificacion\n"
                + "	INNER JOIN \"Horario\" ON \"HistorialTrabajo\".horario_id = \"Horario\".\"id\"\n"
                + "	INNER JOIN \"DetalleRegistros\" ON \"DetalleRegistros\".persona_id = \"Persona\".identificacion\n"
                + "	INNER JOIN \"Cargo\" ON \"HistorialTrabajo\".cargo_id = \"Cargo\".\"id\" \n"
                + "WHERE\n"
                + "	\"Horario\".hora_inicio > \"DetalleRegistros\".hora \n"
                + "	AND \"Persona\".identificacion = '" + pkPersona + "' \n"
                + "ORDER BY\n"
                + "	\"HistorialTrabajo\".fecha_inicio, \"Cargo\".nombre";

        ResultSet rs = Conexion.Query(SELECT);

        ArrayList<Object[]> registros = new ArrayList<>();

        try {
            while (rs.next()) {

                Object[] row = new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                };

                registros.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registros;
    }

}
