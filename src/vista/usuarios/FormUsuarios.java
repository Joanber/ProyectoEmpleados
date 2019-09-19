/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.usuarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.bd.PersonaBD;
import modelos.bd.UsuarioBD;
import modelos.md.Persona;
import modelos.md.Usuario;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class FormUsuarios extends javax.swing.JInternalFrame {

    private final VtnPrincipal desktop;
    private ArrayList<Persona> personas;
    private String pkUsuario = null;
    private Usuario usuarioID;

    public FormUsuarios(String pkUsuario, VtnPrincipal desktop) {
        this.pkUsuario = pkUsuario;
        this.desktop = desktop;
        initComponents();
        cargarUsuarioBD(pkUsuario);
        cargarComboPersonas();
    }
    
    private Usuario getUsuario(){
        Usuario usuario=new Usuario();
        if (pkUsuario==null) {
            usuario.setUsername(txtUsername.getText());
            usuario.setPassword(txtPassword.getText());
            String identificacion=cmbPersonas.getSelectedItem().toString();
            String[] cortarSoloIdentificacionComboBox=identificacion.split("-");
            String identificacionCortada=cortarSoloIdentificacionComboBox[0];
            System.out.println("IDENTIFICACION CORTADA--->>>"+identificacionCortada);
            usuario.getPersona().setIdentificacion(identificacionCortada);
        } else {
            
            usuario.setUsername(txtUsername.getText());
            usuario.setPassword(txtPassword.getText());
            String identificacion=cmbPersonas.getSelectedItem().toString();
            String[] cortarSoloIdentificacionComboBox=identificacion.split("-");
            String identificacionCortada=cortarSoloIdentificacionComboBox[0];
            usuario.getPersona().setIdentificacion(identificacionCortada);
            
        }
        return usuario;
    }
    private void cargarComboPersonas(){
        cmbPersonas.removeAllItems();
        personas=PersonaBD.getPersonas();
        if(personas==null){
            System.out.println("NO HAY PERSONAS");
        }else{
            personas.forEach((per)->{
                cmbPersonas.addItem(per.getIdentificacion()+"-"+per.getNombres()+" "+per.getApellidos());
            });
        }
    }
    private void cargarUsuarioBD(String pkUsuario){
        if(pkUsuario!=null){
            usuarioID=UsuarioBD.getUsuarioPor(pkUsuario);
            txtUsername.setText(usuarioID.getUsername());
            txtPassword.setText(usuarioID.getPassword());
            cmbPersonas.setSelectedItem(usuarioID.getPersona().getIdentificacion()+"-"+usuarioID.getPersona().getNombres()+" "+usuarioID.getPersona().getApellidos());
            cmbPersonas.setEnabled(false);
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
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        cmbPersonas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        chkboxPassword = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Registro de Usuarios");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        cmbPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Persona:");

        chkboxPassword.setText("Mostrar");
        chkboxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkboxPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(txtUsername))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar))
                                .addComponent(cmbPersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkboxPassword))
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkboxPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtUsernameKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        VtnUsuarios vtn = new VtnUsuarios(desktop);
        this.desktop.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtUsername.getText().equals("") || txtPassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Campos Vacios", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            if (pkUsuario == null) {
                UsuarioBD.insertar(getUsuario());
                JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
                System.out.println("INSERTAR USUARIO");
            } else {
                UsuarioBD.update(getUsuario(),pkUsuario);
                JOptionPane.showMessageDialog(this, "Se modificó correctamente!");
                System.out.println("MODIFICAR USUARIO");
            }
            this.dispose();
            VtnUsuarios vtn = new VtnUsuarios(desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void chkboxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkboxPasswordActionPerformed
        // TODO add your handling code here:
        if(chkboxPassword.isSelected()){
            txtPassword.setEchoChar((char)0);
        }else{
            txtPassword.setEchoChar('*');
            
        }
    }//GEN-LAST:event_chkboxPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkboxPassword;
    private javax.swing.JComboBox<String> cmbPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}