package vista.ingresos;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelos.bd.DetalleRegistroBD;
import modelos.bd.PersonaBD;
import modelos.md.DetalleRegistro;
import modelos.md.Persona;
import vista.login.Login;

/**
 *
 * @author MrRainx
 */
public class Registro extends javax.swing.JFrame {

    //DEFINIMOS :
    //UNA VARIABLE QUE ALMACENE LA INFORMACION DE LA PERSONA
    private Persona persona = null;
    //UNA VARIABLE QUE ALMACENE LA FECHA ACTUAL
    private LocalDate fechaActual = null;
    //UNA VARIABLE QUE ALAMACENE LA HORA ACTUAL
    private LocalTime horaActual = null;
    //UNA BANDERA BOOLEANA PARA SABER SI SE PUEDE O NO GUARDAR EL REGISTRO EN LA BASE DE DATOS
    private boolean puedeGuardar = false;

    //EL CONTRUCTOR DE LA CLASE
    public Registro() {
        initComponents();
    }

    //ESTE METODO REINICIA EL FORMULARIO
    private void limpiarFormulario() {
        this.txtCedula.setText("");
        this.txtFechaActual.setText("");
        this.txtInformacion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnIrAlPanel = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtHoraActual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE INGRESOS/SALIDAS");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ingrese su cedula:");

        jLabel3.setText("Informacion de la Persona:");

        txtInformacion.setEditable(false);
        txtInformacion.setColumns(20);
        txtInformacion.setRows(5);
        jScrollPane1.setViewportView(txtInformacion);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingreso", "Salida" }));

        btnIrAlPanel.setText("Ir al Panel del Control");
        btnIrAlPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAlPanelActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha actual:");

        txtFechaActual.setEditable(false);
        txtFechaActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        txtHoraActual.setEditable(false);
        txtHoraActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Hora actual:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar)
                                .addGap(171, 171, 171)
                                .addComponent(btnIrAlPanel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFechaActual)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnBuscar))
                                    .addComponent(txtHoraActual))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIrAlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ESTE METODO INICIA LA VENTANA DE LOGIN
    private void btnIrAlPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlPanelActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnIrAlPanelActionPerformed

    //ESTE METODO BUSCA LA PERSONA EN LA BASE DE DATOS
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        //REALIZAMOS LA BUSQUEDA EN LA BASE  DE DATOS
        this.persona = PersonaBD.getPersonaPor(txtCedula.getText());

        if (this.persona == null) {
            //SI NO ENCUENTRA NINGUN RESULTADO ENTONCES PONE UN MENAJE DE ERROR EN EL TEXT-AREA
            this.txtInformacion.setText(""
                    + "NO SE HA ENCONTRADO\n"
                    + "NINGUN RESULTADO CON\n"
                    + "LA CEDULA: " + this.txtCedula.getText()
            );
            //PONEMOS LA BANDERA EN FALSE PARA QUE NO SE PUEDA GUARDAR EL REGISTRO
            this.puedeGuardar = false;

        } else {
            //SI ENCUENTRA EL REGISTRO EN LA BASE DE LO ESCRIBE EN EL TEXT-AREA DE LA PARTE DERECHA DE LA PANTALLA
            this.txtInformacion.setText(""
                    + "Cedula: " + this.persona.getIdentificacion() + "\n"
                    + "Nombres: " + this.persona.getNombres() + "\n"
                    + "Apellidos: " + this.persona.getApellidos() + "\n"
            );

            //SACAMOS LA FECHA Y HORA ACTUAL PARA LUEGO GUARDARLAS
            this.fechaActual = LocalDate.now();
            this.horaActual = LocalTime.now();

            //SETTEAMOS ESA FECHA Y HORA EN LOS TEXT-FIELDS
            this.txtFechaActual.setText(this.fechaActual.toString());
            this.txtHoraActual.setText(this.horaActual.getHour() + ":" + this.horaActual.getMinute());

            //PONEMOS LA BANDERA EN TRUE PARA QUE SE PUEDA GAURDAR EL REGISTRO
            this.puedeGuardar = true;
        }


    }//GEN-LAST:event_btnBuscarActionPerformed
    //  ESTE METODO SIRVE PARA CANCELAR LAS ACCIONES
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //LIMPIAMOS EL FORMULARIO Y CAMBIAMOS EL ETADO DE LA BANDERA A FALSE
        //PARA QUE NO DEJE GUARDAR NADA
        this.limpiarFormulario();
        this.puedeGuardar = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    //ESTE METODO MANDA A GUARDAR EN LA BASE DE DATOS EL REGISTRO DE INGRESO O SALIDA 
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        //SI LA BANDERA ESTA EN TRUE ENTONCES REALIZAMOS EL PROCESO DE GAURADO
        if (this.puedeGuardar) {

            //CREAMOS UNA VARIABLE QUE ALMACENE LOS VALORES A GUARDAR
            DetalleRegistro detalle = new DetalleRegistro();

            //RELLENAMOS LA VARIABLE
            detalle.setPersona(this.persona);
            detalle.setTipo(this.cmbTipo.getSelectedItem().toString());
            detalle.setFecha(this.fechaActual);
            detalle.setHora(this.horaActual);

            //INSERTAMOS EL REGISTRO EN LA BASE DE DATOS
            DetalleRegistroBD.insertar(detalle);

            //LIMPIAMOS EL FORMULARIO
            limpiarFormulario();
            //CAMBIAMOS EL ESTADO A QUE YA NO SE PUEDA GUARDAR
            this.puedeGuardar = false;

            //ENVIAMOS UN MENSAJE AL USUARIO INDICANDO QUE SE HA GUARDADO CORRECAMENTE
            JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
        } else {
            //EN CASO DE QUE HAYAN CAMPOS VACIOS .. ENVIAMOS UN MENSAJE ALERTANDO AL USUARIO
            JOptionPane.showMessageDialog(this, "Campos Vacios", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIrAlPanel;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtHoraActual;
    private javax.swing.JTextArea txtInformacion;
    // End of variables declaration//GEN-END:variables
}
