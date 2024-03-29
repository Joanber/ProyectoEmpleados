/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cargos;

import javax.swing.JOptionPane;
import modelos.bd.CargoBD;
import modelos.md.Cargo;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class FormCargos extends javax.swing.JInternalFrame {

    private final VtnPrincipal desktop;
    private int pkCargo = 0;
    private Cargo cargoID;

    public FormCargos(int pkCargo, VtnPrincipal desktop) {
        this.pkCargo = pkCargo;
        this.desktop = desktop;

        initComponents();
        cargarCargoBD();
    }

    private Cargo getCargo() {
        Cargo cargo = new Cargo();
        cargo.setNombre(txtNombreCargo.getText());

        return cargo;
    }

    private void cargarCargoBD() {
        if (pkCargo != 0) {
            cargoID = CargoBD.getCargoPor(pkCargo);
            txtNombreCargo.setText(cargoID.getNombre());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCargo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE CARGOS");

        jLabel2.setText("Descripción:");

        txtNombreCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCargoActionPerformed(evt);
            }
        });
        txtNombreCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCargoKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(31, 31, 31)
                        .addComponent(btnGuardar))
                    .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCargoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        VtnCargos vtn = new VtnCargos(desktop);
        this.desktop.desk.add(vtn);
        vtn.show();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNombreCargo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campos Vacios", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            if (pkCargo == 0) {
                CargoBD.insertar(getCargo());
                JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
                System.out.println("INSERTAR CARGO");
            } else {
                CargoBD.update(getCargo(),pkCargo);
                JOptionPane.showMessageDialog(this, "Se modificó correctamente!");
                System.out.println("MODIFICAR CARGO");
            }
            this.dispose();
            VtnCargos vtn = new VtnCargos(desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    //EVENTO DE KEYTYPED AL MOMENTO DE DIGITAR CARACTERES EN EL TXT_NOMBRE_CARGO
    private void txtNombreCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCargoKeyTyped
        // TODO add your handling code here:
       //TODO ESTE CODIGO SE EJECUTA CUANDO SE DIGITE LETRAS AUTOMATICAMENTE SE CONVIERTE EN MAYUSCULAS EL TEXTO INTRODUCIDO
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtNombreCargoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombreCargo;
    // End of variables declaration//GEN-END:variables
}
