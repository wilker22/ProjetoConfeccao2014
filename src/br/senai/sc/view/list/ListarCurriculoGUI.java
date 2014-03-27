package br.senai.sc.view.list;

import br.senai.sc.controller.CurriculoController;
import br.senai.sc.model.negocio.Curriculo;
import br.senai.sc.view.inserir.InserirCurriculoGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarCurriculoGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarCurriculoGUI() {
        initComponents();
        criaJTable();
        scroll.setViewportView(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PeinalFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisa = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PeinalFundo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Pesquisar.:   ");

        txPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaActionPerformed(evt);
            }
        });

        btRemover.setBackground(new java.awt.Color(0, 51, 51));
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btRemover.setBorderPainted(false);
        btRemover.setContentAreaFilled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btEditar.setBackground(new java.awt.Color(0, 51, 51));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btInserir.setForeground(new java.awt.Color(0, 51, 51));
        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserir.setBorderPainted(false);
        btInserir.setContentAreaFilled(false);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PeinalFundoLayout = new javax.swing.GroupLayout(PeinalFundo);
        PeinalFundo.setLayout(PeinalFundoLayout);
        PeinalFundoLayout.setHorizontalGroup(
            PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeinalFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addGroup(PeinalFundoLayout.createSequentialGroup()
                        .addGroup(PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PeinalFundoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PeinalFundoLayout.setVerticalGroup(
            PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeinalFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PeinalFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(PeinalFundo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        InserirCurriculoGUI jp = new InserirCurriculoGUI(modelo);
        jp.setLocationRelativeTo(null);
        jp.setVisible(true);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCurriculo = (int) tabela.getValueAt(linhaSelecionada, 0);
            CurriculoController fc = new CurriculoController();
            if (fc.excluir(idCurriculo)) {
                modelo.removeRow(linhaSelecionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCurriculo = (int) tabela.getValueAt(linhaSelecionada, 0);
            CurriculoController fc = new CurriculoController();
            InserirCurriculoGUI ifu = new InserirCurriculoGUI(modelo, linhaSelecionada, idCurriculo);
            ifu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
        }

    }//GEN-LAST:event_btEditarActionPerformed

    private void txPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaActionPerformed
//        CurriculoController fc = new CurriculoController();
//        modelo.setNumRows(0);
//        for (Curriculo c : fc.pesquisar(txPesquisa.getText())) {
//            modelo.addRow(new Object[]{c.getCodigo(), c.getNome(),c.getStatus()});
//        }
    }//GEN-LAST:event_txPesquisaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PeinalFundo;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txPesquisa;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Status");
        preencherTabela();
    }

    private void preencherTabela() {
        CurriculoController fc = new CurriculoController();
        for (Curriculo f : fc.listarCurriculos()) {
            modelo.addRow(new Object[]{f.getCodigo(), f.getNome(), f.getStatus()});
        }
    }
}