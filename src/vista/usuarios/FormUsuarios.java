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

    //VARIABLE DE LA VENTANA PRINCIPAL DESKTOP_PANE QUE REQUIERE ESTAR DENTRO DEL CONSTRUCTOR DE FORM_USUARIOS 
    private final VtnPrincipal desktop;
    //ARRAYLIST DE PERSONAS PARA CARGAR EN EL COMBOBOX DE PERSONAS
    private ArrayList<Persona> personas;
    //VARIABLE QUE HACE REFERENCIA AL ID DE USUARIO
    private String pkUsuario = null;
    //VARIABLE DE USUARIO PARA AGREGAR EL REGISTRO OBTENIDO MEDIANTE EL ID DE USUARIO
    private Usuario usuarioID;

    //CONTRUCTOR SOBRECARGADO DE FORM_USUARIOS
    public FormUsuarios(String pkUsuario, VtnPrincipal desktop) {
        this.pkUsuario = pkUsuario;
        this.desktop = desktop;
        //INICIA LOS COMPONENTES DE LA VISTA
        initComponents();
        //TITULO EN EL FORMULARIO DE USUARIOS
        this.setTitle("Registro de usuarios");
        //METODO QUE CARGA TODOS LOS REGISTROS DE PERSONAS EN ESTE COMBO BOX
        cargarComboPersonas();
        //METODO QUE CARGA EL REGISTRO DE UN USUARIO CON TODOS SUS ATRIBUTOS DESDE LA BASE DE DATOS
        cargarUsuarioBD();
    }
    //METODO QUE OBTIENE DE CADA UNO DE LOS COMPONENTES DEL FORMULARIO DE USUARIOS PARA INSERTAR UN REGISTRO Y LO AGREGA AL OBJETO DE USUARIO 

    private Usuario getUsuario() {
        //CREA UNA INSTANCIA DE USUARIO PARA PODER SETEAR CADA UNO DE SUS ATRIBUTOS DE ESTE OBJETO OBTENIDOS DE LOS COMPONENTES DEL FORMULARIO
        Usuario usuario = new Usuario();
        //SETEA EN EL ATRIBUTO DE USERNAME CON EL TEXTO OBTENIDO DEL TXT_USERNAME
        usuario.setUsername(txtUsername.getText());
        //SETEA EN EL ATRIBUTO DE PASSWORD CON EL TEXTO OBTENIDO DEL TXT_PASSWORD
        usuario.setPassword(txtPassword.getText());
        //VARIABLE STRING QUE ALMACENA EL ITEM SELECCIONADO DEL COMBO DE PERSONAS
        String identificacion = cmbPersonas.getSelectedItem().toString();
        //ARRAY QUE CORTA EL STRING OBTENIDO DEL ITEM SELECCIONADO CON EL METODO SPLIT Y LO ALMACENA EN LA VARIBALE DE CORTAR
        String[] cortarSoloIdentificacionComboBox = identificacion.split("-");
        //VARIABLE QUE ALMACENA EL ITEM CORTADO DEL COMBO OBTENIENDO SOLO LA CEDULA
        String identificacionCortada = cortarSoloIdentificacionComboBox[0];
        //SETEA EN EL ATRIBUTO DE PASSWORD CON LA CEDULA
        usuario.getPersona().setIdentificacion(identificacionCortada);
        //RETORNA UN OBJETO DE USUARIO CON TODOS LOS ATRIBUTOS OBTENIDOS DESDE LOS COMPONENTES DE LA VISTA.
        return usuario;
    }
    //METODO QUE CARGA LOS REGISTRO DE PERSONAS DESDE LA BASE DE DATOS
    private void cargarComboPersonas() {
        //REMUEVE LOS ITEMS POR DEFECTO DEL COMBO BOX DE LA VISTA DE USUARIOS
        cmbPersonas.removeAllItems();
        //OBTENEMOS TODOS LOS REGISTROS DE PERSONAS DE LA BASE DE DATOS MEDIANTE ESTE METODO ESTATICO Y LO AGREGAMOS A LA VARIABLE DE ARRAYLIST PERSONAS CREADA EN LA PARTE DE ARRIBA
        personas = PersonaBD.getPersonas("");
        //SI NO DEVUELVE REGISTROS, ES DECIR ES NULLO, IMPRIME UN MENSAJE EN CONSOLA QUE NO HAY PERSONAS EN LA BASE DE DATOS
        if (personas == null) {
            System.out.println("NO HAY PERSONAS");
            //POR EL CONTRARIO 
        } else {
            //SINO ES NULO AÑADE AL COMBO BOX TODOS LOS REGISTROS OBTENIDOS DE LA BASE DE DATOS CON EL METODO FOR_EACH CON LOS ATRIBUTOS DE IDENTIFACION, NOMBRES, Y APELLIDOS DE LA PERSONA.
            personas.forEach((per) -> {
                cmbPersonas.addItem(per.getIdentificacion() + "-" + per.getNombres() + " " + per.getApellidos());
            });
        }
    }
    
    //METODO QUE CARGA LOS DATOS DE USUARIO CON SUS ATRIBUTOS CON EL ID DE USUARIO
    private void cargarUsuarioBD() {
        //SI EL ID DE USUARIO ES DIFERENTE REALIZA LAS SIGUIENTES INSTRUCCIONES
        if (pkUsuario != null) {
            //CON ESTE METODOO ESTATICO SE OBTIENE UN REGISTRO MEDIANTE EL ID Y LO AGREGA AL OBJETO DE USUARIO_ID
            usuarioID = UsuarioBD.getUsuarioPor(pkUsuario);
            //EL OBJETO USUARIO YA TIENE TODOS SUS ATRIBUTOS OBTENIDOS DESDE LA BASE DE DATOS 
            //PONE EN EL TXT_USERNAME EL USERNAME OBTENIDO DE LA BASE DE BATOS
            txtUsername.setText(usuarioID.getUsername());
            //PONE EN EL TXT_PASSWORD EL USERNAME OBTENIDO DE LA BASE DE BATOS
            txtPassword.setText(usuarioID.getPassword());
            //PONE EN EL COMBO_BOX LA IDENTIFICACION Y LOS NOMBRES Y APELLIDOS DE LA PERSONA OBTENIDO DE LA BASE DE BATOS
            cmbPersonas.setSelectedItem(usuarioID.getPersona().getIdentificacion() + "-" + usuarioID.getPersona().getNombres() + " " + usuarioID.getPersona().getApellidos());
            //METODO QUE INABILITA LA SELECCION DE ITEMS DEL COMBO PERSONAS
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
        jLabel1.setText("REGISTRO DE USUARIOS");

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
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        //CIERRA ESTA VENTANA DE FORMULARIOS DE USUARIOS
        this.dispose();
        //CREO UNA INSTANCIA DE LA VENTANA DE USUARIO EN DONDE MUESTRA EL LISTADO DE USUARIOS
        VtnUsuarios vtn = new VtnUsuarios(desktop);
        //AGREGAMOS ESTA VISTA DEL LISTADO USUARIOS AL DESKTOP_PANE PRINCIPAL 
        this.desktop.desk.add(vtn);
        //LA VENTANA DEL LISTADO DE USUARIOS SE HACE VISIBLE DENTRO DEL DESKTOP_PANE
        vtn.show();
    }//GEN-LAST:event_btnCancelarActionPerformed
    //ACCION DEL BOTON GUARDAR AL MOMENTO DE DAR CLICK
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //IF QUE VALIDA SI LOS CAMPOS DEL TXT_USRNAME O DEL TXT_PASSWORD ESTAN VACIOS MUESTRA UN MENSAJE DE AVISO QUE LOS CAMPOS ESTAN VACIOS
        if (txtUsername.getText().equals("") || txtPassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Campos Vacios", "Aviso", JOptionPane.ERROR_MESSAGE);
            //POR EL CONTRARIO
        } else {
            //SI LA VARIABLE DE PK_USUARIO ES NULA EJECUTA UN INSERT
            if (pkUsuario == null) {
                //METODO ESTATICO QUE INSERTA EN LA BASE DATOS CON EL PARAMETRO DEL OBJETO OBTENIDO DE USUARIO
                UsuarioBD.insertar(getUsuario());
                //MENSAJE QUE SE MUESTRA QUE EL REGISTRO SE INSERTO CORRECTAMENTE
                JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
                
                //POR EL CONTRARIO
            } else {
                //METODO ESTATICO QUE MODIFICA EN LA BASE DATOS CON LOS PARAMETROS DEL OBJETO OBTENIDO DE USUARIO Y EL ID OBTENIDO DE USUARIO
                UsuarioBD.update(getUsuario(), pkUsuario);
                //MENSAJE QUE SE MUESTRA QUE EL REGISTRO SE MODIFICO CORRECTAMENTE
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
    //METODO DEL CHECK BOX DEL FORMULARIO DE USUARIOS AL MOMENTO DE DAR CLICK
    private void chkboxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkboxPasswordActionPerformed
        // TODO add your handling code here:
        //SI EL CHECK BOX ES SELECCIONADA EJECUTA LO SIGUIENTE
        if (chkboxPassword.isSelected()) {
            //MUETRA LOS CARACTARES OCULTOS DE LA CONTRASEÑA
            txtPassword.setEchoChar((char) 0);
            
            //POR EL CONTRARIO
        } else {
            //OCULTA NUEVAMENTE LA CONTRASEÑA
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
