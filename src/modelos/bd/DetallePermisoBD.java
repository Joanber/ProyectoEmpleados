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
import modelos.md.DetallePermiso;

/**
 *
 * @author MrRainx
 */
public class DetallePermisoBD {

    public static ArrayList<DetallePermiso> getPermisosPor(String pkPersona) {
        String SELECT = ""
                + "SELECT\n"
                + "	\"DetallePermisos\".id,\n"
                + "	\"DetallePermisos\".fecha_inicio,\n"
                + "	\"DetallePermisos\".fecha_fin,\n"
                + "	\"DetallePermisos\".observaciones,\n"
                + "	\"DetallePermisos\".tipo_permiso_id \n"
                + "FROM\n"
                + "	\"DetallePermisos\" \n"
                + "WHERE\n"
                + "	\"DetallePermisos\".persona_id = '" + pkPersona + "';";

        ArrayList<DetallePermiso> permisos = new ArrayList<>();

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                permisos.add(generarPermiso(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetallePermisoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return permisos;
    }

    private static DetallePermiso generarPermiso(ResultSet rs) {
        DetallePermiso permiso = new DetallePermiso();
        try {

            permiso.setId(rs.getInt(1));
            permiso.setFechaInicio(rs.getDate(2));
            permiso.setFechaFin(rs.getDate(3));
            permiso.setObservaciones(rs.getString(4));
            permiso.setTipo(TipoPermisoBD.getTipoPermisoPor(rs.getInt(5)));
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return permiso;
    }

}
