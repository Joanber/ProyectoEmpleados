/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ingresos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.bd.PersonaBD;
import modelos.bd.Queries;
import modelos.md.Persona;

/**
 *
 * @author MrRainx
 */
public class VtnAtrasos extends javax.swing.JInternalFrame {

    /**
     * ESTE ES EL CONSTRUCTOR DE LA VISTA
     *
     * @param pkPersona RECIBIMOS LA pkPersona(cedula)
     */
    public VtnAtrasos(String pkPersona) {
        initComponents();

        //BUSCAMOS LA PERSONA EN LA BASE DE DATOS
        Persona persona = PersonaBD.getPersonaPor(pkPersona);
        //SETEAMOS LA INFORMACION DE LA PERSONA EN EL LABEL DE LA VENTANA
        this.lblPersona.setText("HISTORIAL DE ATRASOS DE: " + persona.informacion());

        //DAMOS MODELO A LA TABLA PARA PODER AGREGAR FILAS
        DefaultTableModel table = (DefaultTableModel) this.tbl.getModel();

        //EJECUTAMOS UN QUERIE PARA TRAER TODOS LOS ATRASOS DE LA PERSONA A PARTIR DE SU CEDULA
        ArrayList<Object[]> filas = Queries.getRetrasosDe(pkPersona);

        //AGREGAMOS LA FILA A LA TABLA DE JAVA
        for (Object[] fila : filas) {
            table.addRow(fila);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPersona = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setClosable(true);

        lblPersona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersona.setText("HISTORIAL DE ATRASOS DE: {persona}");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HORARIO", "JORNADA", "HORA DE INGRESO", "FECHA DE INGRESO", "ATRASADO POR ", "CARGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(1).setMinWidth(80);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
