/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrRainx
 */
public class Conexion {

    /*
        ESTE ATRIBUTO INDICA QUE DRIVER DE BASE DE DATOS USAR EN ESTE CASO "POSTGRESQL"
     */
    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    /*
        AQUI DEFINIMOS LA DIRECCION, PUERTO Y NOMBRE DE NUESTRA BASE DE DATOS
     */
    private static final String JDBC_URL = "jdbc:postgresql://35.192.7.211:5432/MVC";
//    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/MVC";
    /*
        AQUI DEFINIMOS EL USUARIO DE NUESTRA BASE DE DATOS
     */
    private static final String JDBC_USER = "postgres";

    /*
        AQUI DEFINIMOS EL PASSWORD DE NUESTRA BASE DE DATOS
     */
    private static final String JDBC_PASSWORD = "3113";
//    private static final String JDBC_PASSWORD = "CuencaE77";

    /*
        AQUI GUARDAREMOS EL DRIVER CONEXION DE POSTGRESQL
     */
    private static Driver driver = null;

    /*
        ESTA VARIABLE ALMACENARA LA CONEXION A LA BASE DE DATOS
     */
    private static Connection conn = null;

    /**
     * ESTE METODO GENERA LA CONEXION CON LA BASE DE DATOS, USA LA VARIABLES
     * DEFINIDAS ANTERIORMENTE PARA CONECTARCE CON LA BASE DE DATOS
     *
     * @throws SQLException --> EN CASO DE UN ERROR LANZA UNA EXCEPCION
     */
    public static synchronized void generarConexion() throws SQLException {

        if (driver == null) {
            try {

                /*
                    AQUI REGISTRAMOS EL DRIVER PARA QUE USE POSTGRESQL
                 */
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);

                driver = (Driver) jdbcDriverClass.newInstance();

                DriverManager.registerDriver(driver);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

                System.out.println("Error al Inicializar el Driver de Postgres");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

            }
            System.out.println("TE HAZ CONECTADO HA: " + JDBC_URL);
        }

        /*
            SI EL DRIVER SE REGISTRA CORRECTAMENTE GENERAMOS LA CONEXION CON LA BASE DE DATOS
         */
        conn = DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD
        );

    }

    /*
        ESTE METODO SOLO ES UN GETTER DE LA VARIABLE "conn"
     */
    public static Connection getConnection() {
        return conn;
    }

    /**
     * ESTE METODO SIRVE PARA EJECUTAR: INSERTS, UPDATES, Y DELETES
     *
     * @param Statement(String): RECIBE LA SENTENCIA SQL PARA EJECUTARLA
     * @return SI TODO SE EJECUTA CORRECTAMENTE RETORNA NULL Y SI NO RETORNA UNA
     * EXCEPCION DE TIPO "SQLException"
     */
    public static SQLException PrepareStatement(String Statement) {

        try {

            //System.out.println(Statement);
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(Statement);
            stmt.executeUpdate();

            return null;

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return e;
        }

    }

    /**
     * ESTE METODO SRIVE PARA EJECUTAR: SELECTS
     *
     * @param Query(String): RECIBE LA SENTENCIA SQL PARA EJECUTARLA
     * @return SI TODO SE EJECUTA CORRECTAMENTE DEVUELVE UN OBJETO DE TIPO
     * "ResultSet" EN CASO DE QUE NO RETORNA "null"
     */
    public static ResultSet Query(String Query) {

        try {

            //System.out.println(Query);
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(Query);
            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

}
