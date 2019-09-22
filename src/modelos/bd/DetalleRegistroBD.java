package modelos.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                + "	( fecha_hora, tipo, persona_id )\n"
                + "VALUES\n"
                + "( \n"
                + "	'" + detalle.getFechaHora() + "',\n"
                + "	'" + detalle.getTipo() + "',\n"
                + "	'" + detalle.getPersona().getIdentificacion() + "'\n"
                + ");";

        return Conexion.PrepareStatement(INSERT) == null;

    }

    public static ArrayList<DetalleRegistro> getRegistrosDe(String pkPersona) {

        String SELECT = ""
                + "SELECT\n"
                + "	\"DetalleRegistros\".id,\n"
                + "	\"DetalleRegistros\".fecha_hora,\n"
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
                detalle.setFechaHora(rs.getTimestamp(2));
                detalle.setTipo(rs.getString(3));

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
                + "	\"DetalleRegistros\".fecha_hora,\n"
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
                detalle.setFechaHora(rs.getTimestamp(2));
                detalle.setTipo(rs.getString(3));

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
                + "	fecha_hora = '" + detalle.getFechaHora() + "',\n"
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
