/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.usuarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.bd.UsuarioBD;
import modelos.md.Usuario;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class VtnUsuarios extends javax.swing.JInternalFrame {

    //VARIABLE DE LA VENTANA PRINCIPAL DESKTOP_PANE
    private final VtnPrincipal desktop;

    //VARIABLE DE MODELO DE UNA TABLA
    private DefaultTableModel table;

    //ARRAYLIST DE USUARIOS
    private ArrayList<Usuario> usuarios;

    //VARIABLE QUE HACE REFERENCIA AL ID DE USUARIO
    private String pkUsuario = null;

    //CONSTRUCTOR SOBRECARGADO CON LA VARIABLE DE LA VENTANA PRINCIPAL
    public VtnUsuarios(VtnPrincipal desktop) {
        this.desktop = desktop;

        //INICIA LOS COMPONENTES DE LA VISTA
        initComponents();

        //INICIA LOS LINEAS DE CODIGO DENTRO DE ESTE METODO
        Init();
    }

    //METODO
    private void Init() {
        //OBTIENE EL MODELO DE LA TABLA USUARIOS
        table = (DefaultTableModel) tbUsuarios.getModel();

        //METODO QUE CARGA LOS USUARIOS EN LA TABLA
        cargarTabla();

    }

    //METODO QUE CARGA TODOS LOS REGISTROS DE USUARIOS DESDE LA BASE DE DATOS
    private void cargarTabla() {
        //OBTENEMOS TODOS LOS REGISTROS DE USUARIOS DE LA BASE DE DATOS MEDIANTE ESTE METODO ESTATICO Y LO AGREGAMOS A LA VARIABLE DE ARRAYLIST DE USUARIOS CREADA EN LA PARTE DE ARRIBA
        usuarios = UsuarioBD.getUsuarios(txtBuscarUsuario.getText());
        table.setRowCount(0);

        //ELIMINA FILAS DE LA TABLA DE USUARIOS CUANDO ENCUENTRE REGISTROS BUSCADOS DESDE EL TEXTFIELD BUSCAR
        for (int j = tbUsuarios.getModel().getRowCount() - 1; j >= 0; j--) {
            table.removeRow(j);
        }

        //ITERA LOS REGISTROS OBTENIDOS DE USUARIOS Y AÑADE A LA TABLA CADA UNO DE LOS REGISTROS OBTENIDOS
        for (Usuario usuario : usuarios) {
            table.addRow(new Object[]{
                usuario.getUsername(),
                usuario.getPersona().getIdentificacion(),
                usuario.getPersona().getNombres() + " " + usuario.getPersona().getApellidos()
            });
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        txtBuscarUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel2.setText("Buscar");

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Identificacion", "Nombres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbUsuarios);

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

        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 136, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        //CREAMOS UNA INSTANCIA DEL FORMULARIO DE USUARIOS CON UN CONTRUCTOR SOBRECARGADO
        FormUsuarios form = new FormUsuarios(null, desktop);
        //AGREGAMOS ESTA VISTA DE USUARIOS AL DESKTOP_PANE PRINCIPAL 
        this.desktop.desk.add(form);
        //LA VENTANA DE FORMULARIO DE USUARIOS SE HACE VISIBLE DENTRO DEL DESKTOP_PANE
        form.show();
        //CIERRA LA VENTANA DEL LISTADO DE USUARIOS
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //VARIABLE INT QUE SE OBTIENE AL MOMENTO DE SELECCIONAR UNA FILA DE LA TABLA
        int row = tbUsuarios.getSelectedRow();
        //UN IF QUE VALIDA QUE SI AL MOMENTO DE DAR CLICK EN ESTE BOTON DEVUELVE UN NUMERO DIERENTE DE -1 REALIZA LAS SIGUIENTES INSTRUCCI0NES
        if (row != -1) {
            //OBTENEMOS EL ID DE USUUARIO DE LA FILA SELECCIONADA DE LA COLUMNA 0 DE LA TABLA DE USUARIOS
            pkUsuario = tbUsuarios.getValueAt(row, 0).toString();
            //CREAMOS UNA INSTANCIA DEL FORMULARIO DE USUARIOS CON UN CONTRUCTOR SOBRECARGADO CON EL ID OBTENIDO DE LA TABLA PARA MODIFICAR LOS DATOS CON EL ID
            FormUsuarios form = new FormUsuarios(pkUsuario, desktop);
            //AGREGAMOS ESTA VISTA DE USUARIOS AL DESKTOP_PANE PRINCIPAL 
            this.desktop.desk.add(form);
            //LA VENTANA DE FORMULARIO DE USUARIOS SE HACE VISIBLE DENTRO DEL DESKTOP_PANE
            form.show();
            //CIERRA LA VENTANA DEL LISTADO DE USUARIOS
            this.dispose();

            //SINO MUESTRA EL SIGUIENTE MENSAJE QUE DEBE SELLECCIONAR UNA FILA
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //VARIABLE INT QUE SE OBTIENE AL MOMENTO DE SELECCIONAR UNA FILA DE LA TABLA
        int row = tbUsuarios.getSelectedRow();
        //UN IF QUE VALIDA QUE SI AL MOMENTO DE DAR CLICK EN ESTE BOTON DEVUELVE UN NUMERO DIERENTE DE -1 REALIZA LAS SIGUIENTES INSTRUCCI0NES
        if (row != -1) {
            //OBTENEMOS EL ID DE USUUARIO DE LA FILA SELECCIONADA Y DE LA COLUMNA 0 DE LA TABLA DE USUARIOS PARA ELIMINAR EL REGISTRO CON EL ID OBTENIDO
            pkUsuario = tbUsuarios.getValueAt(row, 0).toString();
            //MESAJE DE CONFIRMACION QUE SI AL DAR CLICK EN EL BOTON ELIMINAR EJECUTA LAS INSTRUCCIONES DESIGNADAS
            int reply = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
            //SI DA CLICK EN ELIMINAR EJECUTA LAS SIGUIENTES INTRUCCIONES
            if (reply == JOptionPane.YES_OPTION) {
                //METODO ESTATICO QUE ELIMINA UN REGISTRO CON EL ID OBTENIDO DE LA FILA SELECCIONADA
                UsuarioBD.delete(pkUsuario);
                //MENSAJE DE VALIDACION DE QUE SE ELIMINO CORRECTAMENTE EL REGISTRO
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                //DESPUES DE ELIMINAR UN REGISTRO CARGA NUEVAMENTE LA TABLA CON LOS REGISTROSS EXISTENTES
                cargarTabla();
            }
            //SINO MUESTRA EL SIGUIENTE MENSAJE QUE DEBE SELLECCIONAR UNA FILA
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed
    //EVENTO KEYRELEASED DEL TEXTFIELD DE BUSCAR USUARIO QUE CADA QUE DIGITE UN CARACTER BUSCARA EL REGISTRO BUSCADO Y MOSTRARA EN LA TABLA
    private void txtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyReleased
        cargarTabla();
    }//GEN-LAST:event_txtBuscarUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
