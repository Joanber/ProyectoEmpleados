/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.personas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.bd.PersonaBD;
import modelos.md.Persona;
import vista.VtnPrincipal;
import vista.ingresos.VtnAtrasos;
import vista.ingresos.VtnIngresos;

/**
 *
 * @author Skull
 */
public class VtnPersonas extends javax.swing.JInternalFrame {

    private DefaultTableModel table;
    private ArrayList<Persona> personas;
    private final VtnPrincipal desktop;

    private String pkPersona = null;

    public VtnPersonas(VtnPrincipal desktop) {
        this.desktop = desktop;
        initComponents();
        Init();
    }

    private void Init() {

        table = (DefaultTableModel) tbl.getModel();

        cargarTabla();
    }

    private void cargarTabla() {
        personas = PersonaBD.getPersonas(txtBuscar.getText());
        table.setRowCount(0);

        for (Persona persona : personas) {

            table.addRow(new Object[]{
                persona.getIdentificacion(),
                persona.getNombres(),
                persona.getApellidos(),
                persona.getEdad(),
                persona.getCorreo(),
                persona.getTelefono(),
                persona.getDireccion()
            });

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnVerHistorial = new javax.swing.JButton();
        btnVerPermisos = new javax.swing.JButton();
        btnVerIngresos = new javax.swing.JButton();
        btnVerAtrasos = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombres", "Apellidos", "Edad", "Correo", "Telefono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Personas");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnVerHistorial.setText("Ver Historial de Trabajo");
        btnVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialActionPerformed(evt);
            }
        });

        btnVerPermisos.setText("Ver Historial de Permisos");
        btnVerPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPermisosActionPerformed(evt);
            }
        });

        btnVerIngresos.setText("Ver Historial de Ingresos");
        btnVerIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerIngresosActionPerformed(evt);
            }
        });

        btnVerAtrasos.setText("Ver Historial de Atrasos");
        btnVerAtrasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAtrasosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerHistorial)
                                .addGap(18, 18, 18)
                                .addComponent(btnVerPermisos)
                                .addGap(18, 18, 18)
                                .addComponent(btnVerIngresos)
                                .addGap(18, 18, 18)
                                .addComponent(btnVerAtrasos)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerAtrasos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FormPersona form = new FormPersona(null, desktop);
        this.desktop.desk.add(form);
        form.show();


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            FormPersona form = new FormPersona(pkPersona, desktop);
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
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            int reply = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                PersonaBD.delete(pkPersona);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                cargarTabla();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            VtnHistorialPersona vtn = new VtnHistorialPersona(pkPersona, desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerHistorialActionPerformed

    private void btnVerPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPermisosActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            VtnPermisos vtn = new VtnPermisos(pkPersona, desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerPermisosActionPerformed

    private void btnVerIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerIngresosActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            VtnIngresos vtn = new VtnIngresos(pkPersona, desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerIngresosActionPerformed

    private void btnVerAtrasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAtrasosActionPerformed
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (row != -1) {
            pkPersona = String.valueOf(tbl.getValueAt(row, 0).toString());
            VtnAtrasos vtn = new VtnAtrasos(pkPersona);
            this.desktop.desk.add(vtn);
            vtn.show();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerAtrasosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVerAtrasos;
    private javax.swing.JButton btnVerHistorial;
    private javax.swing.JButton btnVerIngresos;
    private javax.swing.JButton btnVerPermisos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
