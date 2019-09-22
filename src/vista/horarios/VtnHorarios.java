/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.horarios;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.bd.CargoBD;
import modelos.bd.HorarioBD;
import modelos.md.Horario;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class VtnHorarios extends javax.swing.JInternalFrame {
private final VtnPrincipal desktop;
private ArrayList<Horario> horarios;
private DefaultTableModel table;
private  int pkHorario=0;
    public VtnHorarios(VtnPrincipal desktop) {
        this.desktop=desktop;
        this.setTitle("Horarios");
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void init(){
         table = (DefaultTableModel) tbHoraios.getModel();
         cargarTabla();
        
    }
    private void cargarTabla(){
        horarios=HorarioBD.getHorarios(txtBuscarHoraios.getText());
        for(int j=tbHoraios.getModel().getRowCount()-1;j>=0;j--){
             table.removeRow(j);
         }
        for(Horario hor:horarios){
          table.addRow(new Object[]{
              hor.getId(),
              hor.getInicio(),
              hor.getFin(),
              hor.getJornada()
          });
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoraios = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarHoraios = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        tbHoraios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Hora Inicio", "Hora Fin", "Jornada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoraios.getTableHeader().setResizingAllowed(false);
        tbHoraios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbHoraios);
        if (tbHoraios.getColumnModel().getColumnCount() > 0) {
            tbHoraios.getColumnModel().getColumn(0).setMinWidth(0);
            tbHoraios.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbHoraios.getColumnModel().getColumn(0).setMaxWidth(0);
        }

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

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        txtBuscarHoraios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarHoraiosKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Horarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtBuscarHoraios))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarHoraios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        FormHorarios form=new FormHorarios(0,desktop);
        this.desktop.desk.add(form);
        form.show();
        this.dispose();
        
       
    }//GEN-LAST:event_btnNuevoActionPerformed
   
            
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int row =tbHoraios.getSelectedRow();
        if(row!=-1){
            pkHorario=Integer.parseInt(tbHoraios.getValueAt(row, 0).toString());
            FormHorarios form=new FormHorarios(pkHorario,desktop);
            this.desktop.desk.add(form);
            form.show();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        int row =tbHoraios.getSelectedRow();
        if(row!=-1){
            pkHorario=Integer.parseInt(tbHoraios.getValueAt(row, 0).toString());
            int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            HorarioBD.delete(pkHorario);
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            cargarTabla();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtBuscarHoraiosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarHoraiosKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             cargarTabla();
         }
    }//GEN-LAST:event_txtBuscarHoraiosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHoraios;
    private javax.swing.JTextField txtBuscarHoraios;
    // End of variables declaration//GEN-END:variables
}
