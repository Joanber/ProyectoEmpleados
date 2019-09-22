/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.personas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.bd.DetallePermisoBD;
import modelos.bd.PersonaBD;
import modelos.md.DetallePermiso;
import modelos.md.Persona;
import vista.VtnPrincipal;

/**
 *
 * @author MrRainx
 */
public class VtnPermisos extends javax.swing.JInternalFrame {

    private Persona persona = null;
    private VtnPrincipal desktop = null;

    private String pkPersona = null;

    private DefaultTableModel table = null;
    private ArrayList<DetallePermiso> permisos = null;

    public VtnPermisos(String pkPersona, VtnPrincipal desktop) {

        this.persona = PersonaBD.getPersonaPor(pkPersona);
        this.desktop = desktop;
        this.pkPersona = pkPersona;

        initComponents();

        this.lblPersona.setText("HISTORIAL DE PERMISOS DE: " + this.persona.informacion());

        this.table = (DefaultTableModel) this.tbl.getModel();
        cargarTabla();
    }

    private void cargarTabla() {
        this.permisos = DetallePermisoBD.getPermisosPor(pkPersona);
        table.setRowCount(0);

        for (DetallePermiso permiso : permisos) {
            this.table.addRow(new Object[]{
                permiso.getId(),
                permiso.getFechaInicio(),
                permiso.getFechaFin(),
                permiso.getObservaciones(),
                permiso.getTipo().getNombre()
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPersona = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        lblPersona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersona.setText("HISTORIAL DE PERMISOS DE: {persona}");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha Inicio", "Fecha Fin", "Observaciones", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setMinWidth(50);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl.getColumnModel().getColumn(1).setMinWidth(80);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(1).setMaxWidth(80);
            tbl.getColumnModel().getColumn(2).setMinWidth(80);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(2).setMaxWidth(80);
            tbl.getColumnModel().getColumn(4).setMinWidth(80);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersona)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        this.dispose();
        FormPermiso form = new FormPermiso(0, this.pkPersona, this.desktop);
        this.desktop.desk.add(form);
        form.show();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {

            int idHistorial = Integer.valueOf(tbl.getValueAt(row, 0).toString());

            FormPermiso form = new FormPermiso(idHistorial, pkPersona, desktop);

            this.desktop.desk.add(form);
            form.show();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        int row = tbl.getSelectedRow();
        if (row != -1) {
            int idPermiso = Integer.valueOf(tbl.getValueAt(row, 0).toString());
            int reply = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION) {
                DetallePermisoBD.delete(idPermiso);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                cargarTabla();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
