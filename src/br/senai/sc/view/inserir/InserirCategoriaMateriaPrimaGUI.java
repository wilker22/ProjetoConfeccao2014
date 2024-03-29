/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.view.inserir;

import br.senai.sc.controller.CategoriaMateriaPrimaControllerNova;
import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import br.senai.sc.validador.Validadores;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leticia_jesus
 */
public class InserirCategoriaMateriaPrimaGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    /**
     * Creates new form InserirCategoriaMateriaPrimaGUI
     */
    public InserirCategoriaMateriaPrimaGUI(DefaultTableModel modelo, int linhaSelecionada, int IdCategoriaMateriaPrima) {
        initComponents();
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        CategoriaMateriaPrimaControllerNova cmpc = new CategoriaMateriaPrimaControllerNova();
        CategoriaMateriaPrima mpc = cmpc.listById(IdCategoriaMateriaPrima);
        //Preencher o formulário
        txId.setText(String.valueOf(mpc.getCod()));
        txNome.setText(mpc.getNome());
        txDescricao.setText(mpc.getDescricao());


    }

    public InserirCategoriaMateriaPrimaGUI(DefaultTableModel modelo) {
        initComponents();
        this.modelo = modelo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Categoria Matéria-Prima"));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Id.: ");

        jLabel3.setText("Nome.:");

        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
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

        jLabel6.setText("Descrição.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                            .addComponent(txNome))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 432, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addGap(84, 84, 84)
                        .addComponent(btLimpar)
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar))
                .addContainerGap(301, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txDescricao.setText("");
        txNome.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (Validadores.validaCampoVazio(txDescricao.getText(), "Descrição")
                && Validadores.validaCampoVazio(txNome.getText(), "Nome")
                && Validadores.somenteLetras(txDescricao.getText(), "Descrição")
                && Validadores.somenteLetras(txNome.getText(), "Nome")) {





            CategoriaMateriaPrima cmp = new CategoriaMateriaPrima();

            cmp.setNome(txNome.getText());
            cmp.setDescricao(txDescricao.getText());


            CategoriaMateriaPrimaControllerNova cmpc = new CategoriaMateriaPrimaControllerNova();
            if (txId.getText().equals("")) {
                int codCategoriaMateriaPrima = cmpc.inserir(cmp);

                modelo.addRow(new Object[]{codCategoriaMateriaPrima, cmp.getNome(), cmp.getDescricao()});
                dispose();
            } else {
                cmp.setCod(Integer.parseInt(txId.getText()));
                int estado = cmpc.update(cmp);

                if (estado > 0) {
                    modelo.removeRow(linhaSelecionada);
                    modelo.addRow(new Object[]{cmp.getCod(),
                        cmp.getNome(), cmp.getDescricao()});
                }
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txNome;
    // End of variables declaration//GEN-END:variables
}
