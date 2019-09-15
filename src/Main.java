/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Conexion;
import vista.login.Login;

/**
 *
 * @author Skull
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            //HACEMOS QUE EL SISTEMA SE CONECTE A LA BASE DE DATOS(registramos el driver de postgres)
            Conexion.generarConexion();

            //Iniciamos el Component o ventana de Login
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
