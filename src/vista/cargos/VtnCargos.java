/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cargos;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.bd.CargoBD;
import modelos.md.Cargo;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class VtnCargos extends javax.swing.JInternalFrame {
    private final VtnPrincipal desktop;
    
    private ArrayList<Cargo> cargos;
    private DefaultTableModel table;
    private int pkCargo=0;
    /**
     * Creates new form VtnCargos
     * @param desktop
     */
    public VtnCargos(VtnPrincipal desktop) {
        this.desktop = desktop;
        this.setTitle("Cargos");
        initComponents();
        Init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     private void Init() {

        table = (DefaultTableModel) tbCargos.getModel();

        cargarTabla();
    }
     private void cargarTabla(){
         cargos=CargoBD.getCargos(txtBuscarCargo.getText());
         for(int j=tbCargos.getModel().getRowCount()-1;j>=0;j--){
             table.removeRow(j);
         }
         
         for(Cargo cargo: cargos){
             table.addRow(new Object[]{
                 cargo.getId()
                 ,cargo.getNombre()
             });
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCargos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtBuscarCargo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel2.setText("Buscar");

        tbCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCargos);
        if (tbCargos.getColumnModel().getColumnCount() > 0) {
            tbCargos.getColumnModel().getColumn(0).setMinWidth(0);
            tbCargos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbCargos.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        txtBuscarCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCargoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(13, 13, 13)
                        .addComponent(btnModificar)
                        .addGap(11, 11, 11)
                        .addComponent(BtnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        FormCargos form =new FormCargos(0,desktop);
        this.desktop.desk.add(form);
        form.show();
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int row =tbCargos.getSelectedRow();
        if(row!=-1){
           pkCargo=Integer.parseInt(tbCargos.getValueAt(row, 0).toString());
           FormCargos form=new FormCargos(pkCargo,desktop);
            this.desktop.desk.add(form);
            form.show();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        int row =tbCargos.getSelectedRow();
        if(row!=-1){
            pkCargo=Integer.parseInt(tbCargos.getValueAt(row, 0).toString());
            int reply = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            CargoBD.delete(pkCargo);
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            cargarTabla();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtBuscarCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCargoKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             cargarTabla();
         }
    }//GEN-LAST:event_txtBuscarCargoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCargos;
    private javax.swing.JTextField txtBuscarCargo;
    // End of variables declaration//GEN-END:variables
}
