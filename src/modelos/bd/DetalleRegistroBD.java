package modelos.bd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Conexion;
import modelos.md.DetalleRegistro;

/**
 *
 * @author MrRainx
 */
public class DetalleRegistroBD {

    public static boolean insertar(DetalleRegistro detalle) {

        String INSERT = ""
                + "INSERT INTO \"DetalleRegistros\"\n"
                + "	( fecha, hora, tipo, persona_id )\n"
                + "VALUES\n"
                + "( \n"
                + "	'" + Date.valueOf(detalle.getFecha()) + "',\n"
                + "	'" + Time.valueOf(detalle.getHora()) + "',\n"
                + "	'" + detalle.getTipo() + "',\n"
                + "	'" + detalle.getPersona().getIdentificacion() + "'\n"
                + ");";

        return Conexion.PrepareStatement(INSERT) == null;

    }

    public static ArrayList<DetalleRegistro> getRegistrosDe(String pkPersona) {

        String SELECT = ""
                + "SELECT\n"
                + "	\"DetalleRegistros\".id,\n"
                + "	\"DetalleRegistros\".fecha,\n"
                + "	\"DetalleRegistros\".hora,\n"
                + "	\"DetalleRegistros\".tipo \n"
                + "FROM\n"
                + "	\"DetalleRegistros\" \n"
                + "WHERE\n"
                + "	\"DetalleRegistros\".persona_id = '" + pkPersona + "'";

        ArrayList<DetalleRegistro> registros = new ArrayList<>();

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                DetalleRegistro detalle = new DetalleRegistro();

                detalle.setId(rs.getInt(1));
                detalle.setFecha(rs.getDate(2).toLocalDate());
                detalle.setHora(rs.getTime(3).toLocalTime());
                detalle.setTipo(rs.getString(4));

                registros.add(detalle);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleRegistroBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registros;

    }

    public static DetalleRegistro getRegistrosPor(int pk) {

        String SELECT = ""
                + "SELECT\n"
                + "	\"DetalleRegistros\".id,\n"
                + "	\"DetalleRegistros\".fecha,\n"
                + "	\"DetalleRegistros\".hora,\n"
                + "	\"DetalleRegistros\".tipo \n"
                + "FROM\n"
                + "	\"DetalleRegistros\" \n"
                + "WHERE\n"
                + "	\"DetalleRegistros\".id = " + pk;

        DetalleRegistro detalle = null;

        ResultSet rs = Conexion.Query(SELECT);

        try {
            while (rs.next()) {
                detalle = new DetalleRegistro();

                detalle.setId(rs.getInt(1));
                detalle.setFecha(rs.getDate(2).toLocalDate());
                detalle.setHora(rs.getTime(3).toLocalTime());
                detalle.setTipo(rs.getString(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleRegistroBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detalle;

    }

    public static boolean editar(DetalleRegistro detalle, int pk) {

        String UPDATE = ""
                + "UPDATE \"DetalleRegistros\" \n"
                + "SET \n"
                + "	fecha = '" + Date.valueOf(detalle.getFecha()) + "',\n"
                + "	hora = '" + Time.valueOf(detalle.getHora()) + "',\n"
                + "	tipo = '" + detalle.getTipo() + "' \n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(UPDATE) == null;

    }

    public static boolean delete(int pk) {

        String DELETE = ""
                + "DELETE \n"
                + "FROM\n"
                + "	\"DetalleRegistros\" \n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(DELETE) == null;
    }

}
