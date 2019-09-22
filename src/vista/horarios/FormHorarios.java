/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.horarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;
import modelos.bd.HorarioBD;
import modelos.md.Horario;
import vista.VtnPrincipal;

/**
 *
 * @author Skull
 */
public class FormHorarios extends javax.swing.JInternalFrame {
    
    private final VtnPrincipal desktop;
    private int pkHorario = 0;
    private Horario horarioID;
    
    public FormHorarios(int pkHorario, VtnPrincipal desktop) {
        this.desktop = desktop;
        this.pkHorario = pkHorario;
        
        initComponents();
        initSpinners();
        cargarHorarioBD(pkHorario);
    }
    
    private Horario getHorario() {
        Horario horario = new Horario();
        if (pkHorario == 0) {
            String timeInicio = new SimpleDateFormat("HH:mm:ss").format(spnInicio.getValue());
            String timeFin = new SimpleDateFormat("HH:mm:ss").format(spnFin.getValue());
            LocalTime inicio = LocalTime.parse(timeInicio);
            LocalTime fin = LocalTime.parse(timeFin);
            horario.setInicio(inicio);
            horario.setFin(fin);
            horario.setJornada(cmbJornadas.getSelectedItem().toString());
        } else {
            horario.setId(pkHorario);
            String timeInicio = new SimpleDateFormat("HH:mm:ss").format(spnInicio.getValue());
            String timeFin = new SimpleDateFormat("HH:mm:ss").format(spnFin.getValue());
            LocalTime inicio = LocalTime.parse(timeInicio);
            LocalTime fin = LocalTime.parse(timeFin);
            horario.setInicio(inicio);
            horario.setFin(fin);
            horario.setJornada(cmbJornadas.getSelectedItem().toString());
        }
        return horario;
    }
    private void cargarHorarioBD(int pkHorario){
        if(pkHorario!=0){
            try {
                horarioID=HorarioBD.getHorarioPor(pkHorario);
                cmbJornadas.setSelectedItem(horarioID.getJornada());
                String fechaInicio=horarioID.getInicio().toString();
                String fechaFin=horarioID.getFin().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date fechaInicioS = sdf.parse(fechaInicio);
                Date fechaFinS=sdf.parse(fechaFin);
                spnInicio.setValue(fechaInicioS);
                spnFin.setValue(fechaFinS);
            } catch (ParseException ex) {
                Logger.getLogger(FormHorarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void initSpinners() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        SpinnerDateModel model = new SpinnerDateModel();
        SpinnerDateModel model2 = new SpinnerDateModel();
        model.setValue(calendar.getTime());
        model2.setValue(calendar.getTime());
        
        this.spnInicio.setModel(model);
        this.spnFin.setModel(model2);
        
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.spnInicio, "HH:mm");
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(this.spnFin, "HH:mm");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        DateFormatter formatter2 = (DateFormatter) editor2.getTextField().getFormatter();
        
        formatter.setOverwriteMode(true);
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter2.setOverwriteMode(true);
        formatter2.setAllowsInvalid(false); // this makes what you want
        this.spnInicio.setEditor(editor);
        this.spnFin.setEditor(editor2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbJornadas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spnInicio = new javax.swing.JSpinner();
        spnFin = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);

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

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Registro de Horarios");

        jLabel2.setText("Hora Inicio:");

        jLabel3.setText("Hora Fin:");

        cmbJornadas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));

        jLabel4.setText("Jornada:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnInicio)
                            .addComponent(cmbJornadas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnFin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(spnFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar)
                        .addComponent(btnGuardar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        VtnHorarios vtn = new VtnHorarios(desktop);
        this.desktop.desk.add(vtn);
        vtn.show();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        if (pkHorario == 0) {
            HorarioBD.insertar(getHorario());
            JOptionPane.showMessageDialog(this, "Se guardó correctamente!");
            System.out.println("INSERTAR HORARIO");
        } else {
            HorarioBD.update(getHorario());
            JOptionPane.showMessageDialog(this, "Se modificó correctamente!");
            System.out.println(pkHorario + "---------------->>>>>>>>>>IDDDDDDDD");
        }
        this.dispose();
        VtnHorarios vtn = new VtnHorarios(desktop);
        this.desktop.desk.add(vtn);
        vtn.show();

    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbJornadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner spnFin;
    private javax.swing.JSpinner spnInicio;
    // End of variables declaration//GEN-END:variables
}
