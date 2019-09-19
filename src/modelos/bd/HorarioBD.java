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
import modelos.md.Horario;

/**
 *
 * @author Skull
 */
public class HorarioBD extends Horario {

    public static boolean insertar(Horario horario) {
        String INSERT = "INSERT INTO public.\"Horario\"(\n"
                + "	 hora_inicio, hora_fin, jornada)\n"
                + "	VALUES ( '" + horario.getInicio() + "', '" + horario.getFin() + "', '" + horario.getJornada() + "');";
        return Conexion.PrepareStatement(INSERT) == null;
    }

    public static ArrayList<Horario> getHorarios(String jornada) {
        String SELECT = "SELECT id, hora_inicio, hora_fin, jornada\n"
                + "	FROM public.\"Horario\"  WHERE jornada ILIKE '%" + jornada + "%';";
        ArrayList<Horario> lista = new ArrayList<>();
        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                Horario horario = generarHorario(rs);
                lista.add(horario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static boolean update(Horario horario) {
        String UPDATE = "UPDATE public.\"Horario\"\n"
                + "	SET  hora_inicio='" + horario.getInicio() + "', hora_fin='" + horario.getFin() + "', jornada='" + horario.getJornada() + "'\n"
                + "	WHERE id=" + horario.getId() + ";";
        System.out.println(UPDATE);
        return Conexion.PrepareStatement(UPDATE) == null;
    }

    public static boolean delete(int id) {
        String DELETE = "DELETE FROM public.\"Horario\"\n"
                + "	WHERE id=" + id + "";
        return Conexion.PrepareStatement(DELETE) == null;
    }

    public static Horario getHorariopor(int id) {
        String SELECT = "SELECT id, hora_inicio, hora_fin, jornada\n"
                + "	FROM public.\"Horario\" WHERE id=" + id + ";";
        Horario horario = null;
        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                horario = generarHorario(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;
    }

    public static Horario generarHorario(ResultSet rs) {

        try {
            Horario horario = new Horario();
            horario.setId(rs.getInt(1));
            horario.setInicio(rs.getTime(2).toLocalTime());
            horario.setFin(rs.getTime(3).toLocalTime());
            horario.setJornada(rs.getString(4));
            return horario;
        } catch (SQLException ex) {
            Logger.getLogger(HorarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
