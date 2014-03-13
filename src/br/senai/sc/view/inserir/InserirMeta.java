/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.view.inserir;

import br.senai.sc.controller.MetaController;
import br.senai.sc.model.negocio.Meta;
import br.senai.sc.validador.Validadores;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author douglas_ghisleri
 */
public class InserirMeta extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    /**
     * Creates new form InserirMeta
     */
    public InserirMeta() {
        this.modelo = modelo;
        initComponents();

        setLocationRelativeTo(null);
    }

    public InserirMeta(DefaultTableModel modelo, int linhaSelecionada, int Cod_meta) {
        initComponents();

        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;


        MetaController mc = new MetaController();
        //Meta me = mc.listById(Cod_meta);


//        tdID.setText(String.valueOf(me.getCod_meta()));
//        SimpleDateFormat formataDataN = new SimpleDateFormat("dd/MM/yyyy");
//        String dataN = formataDataN.format(me.getDataInicio());
//        tfdi.setText(dataN);
//        SimpleDateFormat formataDataF = new SimpleDateFormat("dd/MM/yyyy");
//        String dataF = formataDataF.format(me.getDataFim());
//        tfdata.setText(dataF);
//        tfvalor.setText(String.valueOf(me.getValor()));
//        tfquant.setText(String.valueOf(me.getQuantidade()));


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        tdID = new javax.swing.JTextField();
        tfquant = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        lbTelefone1 = new javax.swing.JLabel();
        tfvalor = new javax.swing.JTextField();
        lbTelefone2 = new javax.swing.JLabel();
        tfdi = new javax.swing.JFormattedTextField();
        tfdata = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Meta"));

        lbID.setText("Codigo:");

        lbNome.setText("Data inicio:");

        lbTelefone.setText("Quantidade:");

        tfquant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfquantActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btSalvar.setBorderPainted(false);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        lbTelefone1.setText("Data fim:");

        tfvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfvalorActionPerformed(evt);
            }
        });

        lbTelefone2.setText("Valor produto:");

        try {
            tfdi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btSalvar)
                        .addGap(28, 28, 28)
                        .addComponent(btLimpar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTelefone2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfvalor, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfdata, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(tdID, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbID))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(tfdi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTelefone1)
                            .addComponent(lbTelefone))
                        .addGap(18, 18, 18)
                        .addComponent(tfquant)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID)
                    .addComponent(tdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone1)
                    .addComponent(tfdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone2)
                    .addComponent(tfvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(tfquant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btSalvar))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         
        if(
                Validadores.validaCampoVazio(tdID.getText(), "Codigo") &&
                Validadores.validaCampoVazio(tfdi.getText(), "Data inicio") &&
                Validadores.validaCampoVazio(tfdata.getText(), "Data fim") &&
                Validadores.validaCampoVazio(tfvalor.getText(), "Valor") &&
                Validadores.validaCampoVazio(tfquant.getText(), "Quantidade") && 
                Validadores.somenteNumeros(tdID.getText(), "Codigo") &&
                Validadores.somenteNumeros(tfvalor.getText(), "Valor") &&
                Validadores.somenteNumeros(tfquant.getText(), "Quantidade") 
         ) {
        
        Meta m = new Meta();
        m.setCod_meta(Integer.parseInt(tdID.getText()));
        try {
            String data = tfdi.getText();

            m.setDataInicio(new SimpleDateFormat("dd/mm/yyyy").parse(data));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
        }
        try {
            String data = tfdata.getText();

            m.setDataFim(new SimpleDateFormat("dd/mm/yyyy").parse(data));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
        }
        m.setValor(Double.parseDouble(tfvalor.getText()));
        m.setQuantidade(Integer.parseInt(tfquant.getText()));
        MetaController pc = new MetaController();
//        modelo.addRow(new Object[]{pc.inserir(m), m.getDataInicio(), m.getDataFim(),});
        dispose();

    }//GEN-LAST:event_btSalvarActionPerformed
}
    
    private void tfquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfquantActionPerformed

    private void tfvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfvalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfvalorActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        tdID.setText(null);
        tfdi.setText(null);
        tfdata.setText(null);
        tfquant.setText(null);
        tfvalor.setText(null);
    }//GEN-LAST:event_btLimparActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTelefone1;
    private javax.swing.JLabel lbTelefone2;
    private javax.swing.JTextField tdID;
    private javax.swing.JFormattedTextField tfdata;
    private javax.swing.JFormattedTextField tfdi;
    private javax.swing.JTextField tfquant;
    private javax.swing.JTextField tfvalor;
    // End of variables declaration//GEN-END:variables
}
