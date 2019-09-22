package modelos.bd;

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
                + "	" + detalle.getTipo() + ",\n"
                + "	'" + detalle.getPersona().getIdentificacion() + "'\n"
                + ");";

        return Conexion.PrepareStatement(INSERT) == null;

    }

}
