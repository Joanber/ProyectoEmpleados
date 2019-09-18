package vista;

import vista.cargos.VtnCargos;
import vista.personas.VtnPersonas;
import vista.tipopermisos.VtnTipoPermisos;


/**
 *
 * @author Skull
 */
public class VtnPrincipal extends javax.swing.JFrame {

    public VtnPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desk = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnPersonas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnCargos = new javax.swing.JButton();
        btnHorarios = new javax.swing.JButton();
        BtnPermisos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desk.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        btnPersonas.setBackground(new java.awt.Color(153, 153, 0));
        btnPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/empleado.png"))); // NOI18N
        btnPersonas.setToolTipText("Registrar Empleado");
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/cerrarSesion.png"))); // NOI18N
        jButton2.setToolTipText("Cerrar Sesión");

        btnCargos.setBackground(new java.awt.Color(153, 153, 0));
        btnCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/cargos.png"))); // NOI18N
        btnCargos.setToolTipText("Registrar Cargos");
        btnCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargosActionPerformed(evt);
            }
        });

        btnHorarios.setBackground(new java.awt.Color(153, 153, 0));
        btnHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/horario.png"))); // NOI18N
        btnHorarios.setToolTipText("Registrar Horarios");
        btnHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorariosActionPerformed(evt);
            }
        });

        BtnPermisos.setBackground(new java.awt.Color(153, 153, 0));
        BtnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/permisos.png"))); // NOI18N
        BtnPermisos.setToolTipText("Registrar Permisos");
        BtnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPermisosActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(153, 153, 0));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/usuarios.png"))); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPersonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHorarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPermisos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jButton2)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }//GEN-LAST:event_btnHorariosActionPerformed

    private void BtnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPermisosActionPerformed
        // TODO add your handling code here:
        VtnTipoPermisos vtn=new VtnTipoPermisos(this);
        this.desk.add(vtn);
        vtn.show();
        
    }//GEN-LAST:event_BtnPermisosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        // TODO add your handling code here:
        VtnCargos vtn =new VtnCargos(this);
        this.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnCargosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPermisos;
    private javax.swing.JButton btnCargos;
    private javax.swing.JButton btnHorarios;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnUsuarios;
    public javax.swing.JDesktopPane desk;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
