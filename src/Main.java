/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import modelos.Conexion;
import modelos.bd.Queries;
import vista.ingresos.Registro;

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
            //AQUI DAMOS ESTILO DE WINDOWS AL PROYECTO
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            //HACEMOS QUE EL SISTEMA SE CONECTE A LA BASE DE DATOS(registramos el driver de postgres)
            Conexion.generarConexion();
            
            
            Queries.getRetrasosDe("0102030405");
            
            
            //Iniciamos el Component o ventana Registro de Ingresos/Salidas
            Registro vtn = new Registro();
            vtn.setVisible(true);
            vtn.setLocationRelativeTo(null);

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
