package br.senai.sc.view.list;

import br.senai.sc.controller.ColecaoController;
import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.view.inserir.InserirColecaoGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Arsênio
 */
public class ListarColecaoGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabela;

    public ListarColecaoGUI() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        criarTabela();
        srollLista.setViewportView(tabela);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        srollLista = new javax.swing.JScrollPane();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        lbPesquisar = new javax.swing.JLabel();
        txPesquisa = new javax.swing.JTextField();
        lbBanner = new javax.swing.JLabel();
        btCategoriaColecao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btNovo.setBorderPainted(false);
        btNovo.setContentAreaFilled(false);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        lbPesquisar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbPesquisar.setText("Pesquisar");

        txPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaActionPerformed(evt);
            }
        });

        lbBanner.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBanner.setText("Lista de Coleções");

        btCategoriaColecao.setText("Categorias");
        btCategoriaColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCategoriaColecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(lbBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCategoriaColecao))
                    .addComponent(srollLista)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addGap(18, 18, 18)
                        .addComponent(lbPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(txPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(lbBanner)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addComponent(btCategoriaColecao)
                        .addGap(18, 18, 18)))
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btEditar)
                    .addComponent(btNovo)
                    .addComponent(lbPesquisar)
                    .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(srollLista, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        InserirColecaoGUI ic = new InserirColecaoGUI();
        ic.setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;

        linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int idColecao = (int) tabela.getValueAt(linhaSelecionada, 0);

            InserirColecaoGUI icc = new InserirColecaoGUI(modelo, linhaSelecionada, idColecao);
            icc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma linha foi selecionada.");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = -1;

        linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada >= 0) {

            int idColecao = (int) tabela.getValueAt(linhaSelecionada, 0);

            ColecaoController ccc = new ColecaoController();
            if (ccc.deletar(idColecao)) {
                modelo.removeRow(linhaSelecionada);
            }

        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void txPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaActionPerformed
        String estacao = txPesquisa.getText();
        modelo.setNumRows(0);
        ColecaoController ccc = new ColecaoController();
        for (Colecao c : ccc.listEstacao(estacao)) {
            modelo.addRow(new Object[]{c.getCodColecao(), c.getEstacaoColecao(), c.getAnoColecao()});
        }
    }//GEN-LAST:event_txPesquisaActionPerformed

    private void btCategoriaColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCategoriaColecaoActionPerformed
        ListarCategoriaColecaoGUI gui = new ListarCategoriaColecaoGUI();
        gui.setVisible(true);
    }//GEN-LAST:event_btCategoriaColecaoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ListarColecaoGUI().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCategoriaColecao;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel lbBanner;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane srollLista;
    private javax.swing.JTextField txPesquisa;
    // End of variables declaration//GEN-END:variables

    private void criarTabela() {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Estação");
        modelo.addColumn("Ano");
        System.out.println("tabela criada");
        preencherTabela();
    }

    private void preencherTabela() {
        ColecaoController ccc = new ColecaoController();
        for (Colecao c : ccc.listarTodas()) {
            modelo.addRow(new Object[]{c.getCodColecao(), c.getEstacaoColecao(), c.getAnoColecao()});
        }
    }
}
