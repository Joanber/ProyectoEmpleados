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

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

   // private static final String JDBC_URL = "jdbc:postgresql://35.192.7.211:5432/MVC";
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/MVC";

    private static final String JDBC_USER = "postgres";

    //private static final String JDBC_PASSWORD = "3113";
    private static final String JDBC_PASSWORD = "CuencaE77";

    private static Driver driver = null;

    private static Connection conn = null;

    public static synchronized void generarConexion() throws SQLException {

        if (driver == null) {
            try {

                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);

                driver = (Driver) jdbcDriverClass.newInstance();

                DriverManager.registerDriver(driver);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

                System.out.println("Error al Inicializar el Driver de Postgres");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

            }
            System.out.println("TE HAZ CONECTADO HA" + JDBC_URL);
        }

        conn = DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD
        );

    }

    public static Connection getConnection() {
        return conn;
    }

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
