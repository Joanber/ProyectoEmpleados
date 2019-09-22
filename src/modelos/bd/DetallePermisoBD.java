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

    public static boolean insertar(DetallePermiso detalle) {
        String INSERT = ""
                + "INSERT INTO \"DetallePermisos\"\n"
                + "	( fecha_inicio, fecha_fin, observaciones, persona_id, tipo_permiso_id )\n"
                + "VALUES\n"
                + "(\n"
                + "	'" + detalle.getFechaInicio() + "',\n"
                + "	'" + detalle.getFechaFin() + "',\n"
                + "	'" + detalle.getObservaciones() + "',\n"
                + "	'" + detalle.getPersona().getIdentificacion() + "',\n"
                + "	" + detalle.getTipo().getId() + "\n"
                + ");";
        return Conexion.PrepareStatement(INSERT) == null;
    }

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

    public static DetallePermiso getPermisosPor(int pk) {
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
                + "	\"DetallePermisos\".id = " + pk;

        DetallePermiso detalle = null;

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                detalle = generarPermiso(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetallePermisoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detalle;
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

    public static boolean editar(DetallePermiso detalle, int pk) {
        String UPDATE = ""
                + "UPDATE \"DetallePermisos\" \n"
                + "SET \n"
                + "	fecha_inicio = '" + detalle.getFechaInicio() + "',\n"
                + "	fecha_fin = '" + detalle.getFechaInicio() + "',\n"
                + "	observaciones = '" + detalle.getObservaciones() + "',\n"
                + "	persona_id = '" + detalle.getPersona().getIdentificacion() + "',\n"
                + "	tipo_permiso_id = " + detalle.getTipo().getId() + "\n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(UPDATE) == null;
    }

    public static boolean delete(int pk) {
        String DELETE = ""
                + "DELETE \n"
                + "FROM\n"
                + "	\"DetallePermisos\" \n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(DELETE) == null;
    }

}
