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

    /**
     * ESTE METODO SIRVE PARA INSERTAR UN HISTORIAL DE TRABAJO DE LA PERSONA
     *
     * @param historial(HistorialTrabajo):RECIBIMOS EL OBJETO QUE VAMOS A
     * INSERTAR
     * @return(boolean): SI TODO SE EJECUTA CORRECTAMENTE RETORNAMOS "true" Y
     * SINO "false"
     */
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

    /**
     * ESTE METODO SIRVE PARA CONSULTAR LOS HISTORIALES DE TRAJO DE UNA PERSONA
     * ESTE METODO RETORNA MULTIPLES REGISTROS U OBJETOS
     *
     * @param pkPersona(String): RECIBIMOS LA "cedula" PARA BUSCAR LOS
     * HISTORIALES DE TRABAJO DE LA PERSONA
     * @return(ArrayList<HistorialTrabajo>): SI HAY RESULTADOS RETORNAMOS UN
     * ARRALIST CON LOS RESULTADOS DESDE LA BASE DE DATOS Y SINO DEVOLVEMOS UN
     * ARRAY VACIO
     */
    public static ArrayList<HistorialTrabajo> getHistorialesPor(String pkPersona) {

        /*
            CREAMOS NUESTRA SENTENCIA SQL PARA HACER LA CONSULTA
         */
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

        //USAMOS EL METODO DE LA CLASE "Conexion" PARA REALIZAR LA BUSQUEDA EN LA BASE DE DATOS
        ResultSet rs = Conexion.Query(SELECT);
        //CREAMOS UN OBJECTO DE TIPO "ARRAYLIST" PARA ALMACENAR LOS RESULTADOS DEL "ResultSet (rs)"
        ArrayList<HistorialTrabajo> historiales = new ArrayList<>();

        try {
            /*
                ESTA PARTE DEL CODIGO PUEDE LANZAR UNA EXCEPCION POR LO TANTO LO PONEMOS EN UN TRY Y CATCH
             */
            while (rs.next()) {//ITERAMOS EL RESULTSET(rs)
                /*
                    USAMOS EL METODO "generarHistorial(ResultSet rs)"
                    PARA QUE NOS GENERE UN OBJETO A PARTIR DEL "ResultSet rs"
                    LUEGO LO ALMACENAMOS EN EL ARRAYLIST QUE CREAMOS ANTERIORMENTE
                    
                 */
                historiales.add(generarHistorial(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historiales;
    }

    /**
     * ESTE METODO SIRVE PARA CONSULTAR UN SOLO HISTORIAL DE TRABAJO
     *
     * @param id(String): RECIBIMOS EL "id" PARA BUSCAR EL HISTORIAL DE TRABAJO
     * @return(HistorialTrabajo): SI HAY RESULTADOS RETORNAMOS UN OBJETO DE TIPO
     * "HistorialTrabajo" EN CASO DE QUE NO EXISTA EL REGISTRO EN LA BASE DE
     * DATOS RETORNAMOS "null"
     */
    public static HistorialTrabajo getHistorialPor(int id) {
        /*
            CREAMOS LA SENTENCIA SQL PARA HACER LA CONSULTA
         */
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

        // CREAMOS UNA VARIABLE QUE ALMACENE EL RESULTADO DE LA BUSQUEDA
        HistorialTrabajo historial = null;

        //USAMOS EL METODO DE LA CLASE "Conexion" PARA REALIZAR LA BUSQUEDA EN LA BASE DE DATOS
        ResultSet rs = Conexion.Query(SELECT);

        try {
            /*
                ESTA PARTE DEL CODIGO PUEDE LANZAR UNA EXCEPCION POR LO TANTO LO PONEMOS EN UN TRY Y CATCH
             */
            while (rs.next()) {
                /*
                    USAMOS EL METODO "generarHistorial(ResultSet rs)"
                    PARA QUE NOS GENERE UN OBJETO A PARTIR DEL "ResultSet rs"
                    LUEGO LO ALMACENAMOS EN LA VARIABLE QUE DEFINIMOS EN LA PARTE SUPERIOR DE ESTE METODO
                    
                 */
                historial = generarHistorial(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historial;
    }

    /*
        ESTE METODO SIRVE PARA GENERAR OBJECTOS DE TIPO "HistorialTrabajo"
        A PARTIR DE UN "(ResultSet rs)"
     */
    private static HistorialTrabajo generarHistorial(ResultSet rs) {

        /*
            CREAMOS UNA VARIABLE QUE ALMACENE EL RESULTADO DE LA BASE DE DATOS
         */
        HistorialTrabajo historial = new HistorialTrabajo();

        try {

            /*
            
                VAMOS TOMANDO LOS ATRIBUTOS DE LA CONSULTA Y LOS VAMOS SETEANDO 
                EN LA VARIABLE DEFINIDA EN LA PARTE SUPERIOR DEL METODO
            
                
                POR EJEMPLO ESTA ES LA CONSULTA QUE EJECUTAMOS
                "SELECT\n"
                + "	\"HistorialTrabajo\".id, "(1)<--ESTA ES LA POSICION DEL ATRIBUTO
                + "	\"HistorialTrabajo\".fecha_inicio, "(2)<--LA POSICION DEL ATRIBUTO
                + "	\"HistorialTrabajo\".fecha_finalizo, "(3)<--LA POSICION DEL ATRIBUTO
                + "	\"HistorialTrabajo\".estado, "(4)<--LA POSICION DEL ATRIBUTO
                + "	\"HistorialTrabajo\".cargo_id, "(5)<--LA POSICION DEL ATRIBUTO
                + "	\"HistorialTrabajo\".horario_id "(6)<--LA POSICION DEL ATRIBUTO
            
            

                historial.setId(rs.getInt(1));<-- EL NUMERO QUE LE PASAMOS COMO PARAMETRO AL rs.getInt()
                
                ES EN BASE A LA POSICION DEL ATRIBUTO EN EL SELECT
                Y LO MISMO PARA EL RESTO DE LOS ATRIBUTOS
                
             */
            historial.setId(rs.getInt(1));
            historial.setFechaInicio(rs.getDate(2));
            historial.setFechaFinalizo(rs.getDate(3));
            historial.setEstado(rs.getString(4));
            historial.setCargo(CargoBD.getCargoPor(rs.getInt(5)));
            historial.setHorario(HorarioBD.getHorarioPor(rs.getInt(6)));
            /*
                AQUI VAMOS CREANDO EL OBJETO A PARTIR DEL "ResultSet"
             */

        } catch (SQLException ex) {
            Logger.getLogger(HistorialTrabajoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historial;
    }

    /**
     * ESTE METODO NOS SIRVE PARA EDITAR UN REGISTRO DE LA BASE DE DATOS
     *
     * @param historial(HistorialTrabajo):ESTE ATRIBUTO CONTIENE LA INFORMACION
     * QUE VAMOS A MANDAR A EDITAR
     *
     * @param pk(int): LA LLAVE PRIMARIA DEL REGISTRO QUE VAMOS A EDITAR
     * @return(boolean): SI TODO SE EJECUTA CORRECTAMENTE RETORNAMOS "true" Y
     * SINO "false"
     */
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

    /**
     * ESTE METODO SIRVE PARA ELIMINAR UN REGISTRO DE LA BASE DE DATOS
     *
     * @param pk(int): RECIBIMOS LA LLAVE PRIMARIA DEL REGISTRO QUE VAMOS A
     * ELIMINAR
     * @return(boolean): SI TODO SE EJECUTA CORRECTAMENTE RETORNAMOS "true" Y
     * SINO "false"
     */
    public static boolean delete(int pk) {
        String DELETE = "DELETE \n"
                + "FROM\n"
                + "	\"HistorialTrabajo\" \n"
                + "WHERE\n"
                + "	id = " + pk;

        return Conexion.PrepareStatement(DELETE) == null;
    }

}
