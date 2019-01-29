/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPensiun;

import PengajuPangkat.*;
import javax.swing.*;


/**
 *
 * @author lyandaf
 */
public class Rektor_PengajuPensiunRektor extends javax.swing.JPanel {

    /**
     * Creates new form PengajuPangkatBK
     */
    Rektor_ControllerPengPens cr;
    public Rektor_PengajuPensiunRektor() {
        initComponents();
       // cr=new Rektor_ControllerPengPens(this);
        cr.isiTable();
    }    
//
//    public JTextField getTxtAksi() {
//        return txtAksi;
//    }
    
    public JComboBox getCmbAksi() {
        return cmbAksi;
    }

    public JButton getCmdVerifikasi() {
        return cmdVerifikasi;
    }

    public JTable getTblDataPensR() {
        return tblDataPensR;
    }

    public JTextField getTxtIDPensR() {
        return txtIDPensR;
    }

    public JTextField getTxtNipPensR() {
        return txtNipPensR;
    }

    public JTable tblDataPensR(){
        return tblDataPensR;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel200 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        txtIDPensR = new javax.swing.JTextField();
        txtNipPensR = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDataPensR = new javax.swing.JTable();
        cmbAksi = new javax.swing.JComboBox();
        cmdVerifikasi = new javax.swing.JButton();

        jLabel200.setText("Daftar Pegawai Pengaju Pensiun");

        jLabel182.setText("ID");

        jLabel183.setText("NIP");

        jLabel203.setText("Status");

        tblDataPensR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NIP", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDataPensR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataPensRMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDataPensR);

        cmbAksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUNGGU", "DISETUJUI" }));
        cmbAksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAksiActionPerformed(evt);
            }
        });

        cmdVerifikasi.setText("Verifikasi Data");
        cmdVerifikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerifikasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel200))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel182, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel203, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdVerifikasi))
                            .addComponent(txtIDPensR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txtNipPensR, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel200)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182)
                    .addComponent(txtIDPensR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel183)
                    .addComponent(txtNipPensR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel203)
                    .addComponent(cmbAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(cmdVerifikasi)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdVerifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerifikasiActionPerformed
        cr.update();
        cr.isiTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdVerifikasiActionPerformed

    private void tblDataPensRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataPensRMouseClicked
        cr.isiField(tblDataPensR.getSelectedRow());// TODO add your handling code here:
    }//GEN-LAST:event_tblDataPensRMouseClicked

    private void cmbAksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAksiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbAksi;
    private javax.swing.JButton cmdVerifikasi;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable tblDataPensR;
    private javax.swing.JTextField txtIDPensR;
    private javax.swing.JTextField txtNipPensR;
    // End of variables declaration//GEN-END:variables
}
