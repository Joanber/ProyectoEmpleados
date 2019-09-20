package vista;

import vista.cargos.VtnCargos;
import vista.horarios.VtnHorarios;
import vista.login.Login;
import vista.personas.VtnPersonas;
import vista.tipopermisos.VtnTipoPermisos;
import vista.usuarios.VtnUsuarios;


/**
 *
 * @author Skull
 */
public class VtnPrincipal extends javax.swing.JFrame {

    public VtnPrincipal() {
        initComponents();
        this.setTitle("Sistema de Registros de Empleados");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desk = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnPersonas = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnCargos = new javax.swing.JButton();
        btnHorarios = new javax.swing.JButton();
        BtnPermisos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desk.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        btnPersonas.setBackground(new java.awt.Color(153, 153, 0));
        btnPersonas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/empleado.png"))); // NOI18N
        btnPersonas.setText("Personas");
        btnPersonas.setToolTipText("Registrar Persona");
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(153, 153, 0));
        btnCerrarSesion.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/cerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setText("Salir");
        btnCerrarSesion.setToolTipText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnCargos.setBackground(new java.awt.Color(153, 153, 0));
        btnCargos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/cargos.png"))); // NOI18N
        btnCargos.setText("Cargos");
        btnCargos.setToolTipText("Registrar Cargos");
        btnCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargosActionPerformed(evt);
            }
        });

        btnHorarios.setBackground(new java.awt.Color(153, 153, 0));
        btnHorarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/horario.png"))); // NOI18N
        btnHorarios.setText("Horarios");
        btnHorarios.setToolTipText("Registrar Horarios");
        btnHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorariosActionPerformed(evt);
            }
        });

        BtnPermisos.setBackground(new java.awt.Color(153, 153, 0));
        BtnPermisos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        BtnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/permisos.png"))); // NOI18N
        BtnPermisos.setText("Permisos");
        BtnPermisos.setToolTipText("Registrar Permisos");
        BtnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPermisosActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(153, 153, 0));
        btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/usuarios.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setToolTipText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPersonas)
                .addGap(18, 18, 18)
                .addComponent(btnCargos)
                .addGap(18, 18, 18)
                .addComponent(btnHorarios)
                .addGap(18, 18, 18)
                .addComponent(BtnPermisos)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desk))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desk)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasActionPerformed
        // TODO add your handling code here:
        VtnPersonas vtn = new VtnPersonas(this);
        this.desk.add(vtn);
        vtn.show();

    }//GEN-LAST:event_btnPersonasActionPerformed

    private void btnHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorariosActionPerformed
        // TODO add your handling code here:
        VtnHorarios vtn=new VtnHorarios(this);
        this.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnHorariosActionPerformed

    private void BtnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPermisosActionPerformed
        // TODO add your handling code here:
        VtnTipoPermisos vtn=new VtnTipoPermisos(this);
        this.desk.add(vtn);
        vtn.show();
        
    }//GEN-LAST:event_BtnPermisosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        VtnUsuarios vtn=new VtnUsuarios(this);
        this.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        // TODO add your handling code here:
        VtnCargos vtn =new VtnCargos(this);
        this.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnCargosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login login=new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPermisos;
    private javax.swing.JButton btnCargos;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnHorarios;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnUsuarios;
    public javax.swing.JDesktopPane desk;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
