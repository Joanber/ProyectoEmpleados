/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.personas;

import javax.swing.JOptionPane;
import modelos.bd.PersonaBD;
import modelos.md.Persona;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class FormPersona extends javax.swing.JInternalFrame {

    private final VtnPrincipal desktop;
    private Persona persona;

    private String pkPersona = null;

    public FormPersona(String pkPersona, VtnPrincipal desktop) {
        this.pkPersona = pkPersona;
        this.desktop = desktop;
        this.setTitle("Personas");
        initComponents();
        cargarPersonaBD(pkPersona);
    }

    private Persona getPersona() {

        Persona persona = new Persona();

        persona.setIdentificacion(txtIdentificacion.getText());
        persona.setNombres(txtNombres.getText());
        persona.setApellidos(txtApellidos.getText());
        persona.setEdad(Integer.valueOf(txtEdad.getText()));
        persona.setCorreo(txtEmail.getText());
        persona.setTelefono(txtTelefono.getText());
        persona.setDireccion(txtDireccion.getText());

        return persona;
    }

    private void cargarPersonaBD(String pkPersona) {
        if (pkPersona != null) {
            persona = PersonaBD.getPersonaPor(pkPersona);
            txtIdentificacion.setText(persona.getIdentificacion());
            txtNombres.setText(persona.getNombres());
            txtApellidos.setText(persona.getApellidos());
            txtEdad.setText(String.valueOf(persona.getEdad()));
            txtEmail.setText(persona.getCorreo());
            txtTelefono.setText(persona.getTelefono());
            txtDireccion.setText(persona.getDireccion());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Registro de Personas");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Cedula:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setText("Edad:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setText("Email:");

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(txtIdentificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtIdentificacion.getText().equals("") || txtNombres.getText().equals("") || txtApellidos.getText().equals("")
                || txtEdad.getText().equals("") || txtEmail.getText().equals("") || txtTelefono.getText().equals("") || txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campos Vacios", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            if (pkPersona == null) {
                PersonaBD.insertar(getPersona());
                JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
                System.out.println("INSERTAR");
            } else {
                PersonaBD.update(getPersona(), pkPersona);
                JOptionPane.showMessageDialog(this, "Se modificó correctamente!");
                System.out.println("MODIFICAR");
            }
            this.dispose();
            VtnPersonas vtn = new VtnPersonas(desktop);
            this.desktop.desk.add(vtn);
            vtn.show();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
