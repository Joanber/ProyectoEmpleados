package modelos.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Conexion;
import modelos.md.HistorialTrabajo;

/**
 *
 * @author MrRainx
 */
public class HistorialTrabajoBD {

    public static boolean insertar(HistorialTrabajo historial) {

        String INSERT = "INSERT INTO \"HistorialTrabajo\"\n"
                + "( fecha_inicio, fecha_finalizo, estado, persona_id, cargo_id, horario_id )\n"
                + "VALUES\n"
                + "(\n"
                + "     '" + historial.getFechaInicio() + "',\n"
                + "     '" + historial.getFechaFinalizo() + "',\n"
                + "     '" + historial.getEstado() + "',\n"
                + "     '" + historial.getPersona().getIdentificacion() + "',\n"
                + "     " + historial.getCargo().getId() + ",\n"
                + "     " + historial.getHorario().getId() + "\n"
                + ");";

        return Conexion.PrepareStatement(INSERT) == null;
    }

    public static ArrayList<HistorialTrabajo> getHistorialesPor(String pkPersona) {

        String SELECT = "SELECT\n"
                + "	\"HistorialTrabajo\".\"id\",\n"
                + "	\"HistorialTrabajo\".fecha_inicio,\n"
                + "	\"HistorialTrabajo\".fecha_finalizo,\n"
                + "	\"HistorialTrabajo\".estado,\n"
                + "	\"HistorialTrabajo\".cargo_id,\n"
                + "	\"HistorialTrabajo\".horario_id \n"
                + "FROM\n"
                + "	\"HistorialTrabajo\" \n"
                + "WHERE\n"
                + "	\"HistorialTrabajo\".persona_id = '" + pkPersona + "';";

        ResultSet rs = Conexion.Query(SELECT);

        ArrayList<HistorialTrabajo> historiales = new ArrayList<>();

        try {
            while (rs.next()) {
                historiales.add(generarHistorial(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historiales;
    }

    public static HistorialTrabajo getHistorialPor(int id) {
        String SELECT = "SELECT\n"
                + "	\"HistorialTrabajo\".\"id\",\n"
                + "	\"HistorialTrabajo\".fecha_inicio,\n"
                + "	\"HistorialTrabajo\".fecha_finalizo,\n"
                + "	\"HistorialTrabajo\".estado,\n"
                + "	\"HistorialTrabajo\".cargo_id,\n"
                + "	\"HistorialTrabajo\".horario_id \n"
                + "FROM\n"
                + "	\"HistorialTrabajo\" \n"
                + "WHERE\n"
                + "	\"HistorialTrabajo\".id = " + id;

        HistorialTrabajo historial = null;

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                historial = generarHistorial(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historial;
    }

    private static HistorialTrabajo generarHistorial(ResultSet rs) {
        HistorialTrabajo historial = new HistorialTrabajo();
        try {

            historial.setId(rs.getInt(1));
            historial.setFechaInicio(rs.getDate(2));
            historial.setFechaFinalizo(rs.getDate(3));
            historial.setEstado(rs.getString(4));
            historial.setCargo(CargoBD.getCargoPor(rs.getInt(5)));
            historial.setHorario(HorarioBD.getHorarioPor(rs.getInt(6)));
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historial;
    }

    public static boolean editar(HistorialTrabajo historial, int pk) {
        String UPDATE = "UPDATE \"HistorialTrabajo\" \n"
                + "SET \n"
                + "	fecha_inicio = '" + historial.getFechaInicio() + "',\n"
                + "	fecha_finalizo = '" + historial.getFechaFinalizo() + "',\n"
                + "	estado = '" + historial.getEstado() + "',\n"
                + "	persona_id = '" + historial.getPersona().getIdentificacion() + "',\n"
                + "	cargo_id = " + historial.getCargo().getId() + ",\n"
                + "	horario_id = " + historial.getHorario().getId() + " \n"
                + "WHERE\n"
                + "	id = " + pk;
        return Conexion.PrepareStatement(UPDATE) == null;
    }

    public static boolean delete(int pk) {
        String DELETE = "DELETE \n"
                + "FROM\n"
                + "	\"HistorialTrabajo\" \n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(DELETE) == null;
    }

}
