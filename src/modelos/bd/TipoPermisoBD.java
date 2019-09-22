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
import modelos.md.TipoPermiso;

/**
 *
 * @author Skull
 */
public class TipoPermisoBD extends TipoPermiso {

    public static boolean insertar(TipoPermiso tipoPermiso) {
        String INSERT = "INSERT INTO public.\"TipoPermiso\"(\n"
                + "	nombre)\n"
                + "	VALUES ( '" + tipoPermiso.getNombre() + "');";
        return Conexion.PrepareStatement(INSERT) == null;
    }

    public static boolean update(TipoPermiso tipoPermiso) {
        String UPDATE = "UPDATE public.\"TipoPermiso\"\n"
                + "	SET  nombre='" + tipoPermiso.getNombre() + "'\n"
                + "	WHERE id=" + tipoPermiso.getId() + ";";

        System.out.println(UPDATE);
        return Conexion.PrepareStatement(UPDATE) == null;
    }

    public static boolean delete(int id) {
        String DELETE = "DELETE FROM public.\"TipoPermiso\"\n"
                + "	WHERE id=" + id + ";";

        System.out.println(DELETE);
        return Conexion.PrepareStatement(DELETE) == null;
    }

    public static ArrayList<TipoPermiso> getTipoPermisos(String nombre) {
        String SELECT = "SELECT id, nombre\n"
                + "	FROM public.\"TipoPermiso\" where nombre ILIKE '%" + nombre + "%'; ";
        ArrayList<TipoPermiso> lista = new ArrayList<>();
        ResultSet rs = Conexion.Query(SELECT);
        try {
            while (rs.next()) {
                TipoPermiso tipoPermiso = generarTipoPermiso(rs);
                lista.add(tipoPermiso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPermisoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static TipoPermiso getTipoPermisoPor(int id) {
        String SELECT = "SELECT id, nombre\n"
                + "	FROM public.\"TipoPermiso\" WHERE id=" + id + "";
        TipoPermiso tipoPermiso = null;
        ResultSet rs = Conexion.Query(SELECT);
        try {
            while (rs.next()) {
                tipoPermiso = generarTipoPermiso(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPermisoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoPermiso;
    }

    public static TipoPermiso generarTipoPermiso(ResultSet rs) {

        try {
            TipoPermiso tipoPermiso = new TipoPermiso();
            tipoPermiso.setId(rs.getInt(1));
            tipoPermiso.setNombre(rs.getString(2));
            return tipoPermiso;
        } catch (SQLException ex) {
            Logger.getLogger(TipoPermisoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
