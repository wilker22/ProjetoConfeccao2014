package br.senai.sc.view.list;

import br.senai.sc.controller.CategoriaProdutoController;
import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.view.inserir.InserirCategoriaProdutosGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarCategoriaProdutoGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarCategoriaProdutoGUI() {
        initComponents();
        criaJTable();
        scroll.setViewportView(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        txPesquisa = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        btEditar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserir.setBorderPainted(false);
        btInserir.setContentAreaFilled(false);
        btInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btInserir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btDeletar.setBorderPainted(false);
        btDeletar.setContentAreaFilled(false);
        btDeletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDeletar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar:");

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDeletar))
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addComponent(scroll))
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDeletar)
                    .addComponent(btEditar)
                    .addComponent(btInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelFundo, java.awt.BorderLayout.CENTER);
        painelFundo.getAccessibleContext().setAccessibleName("Categoria de Produtos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        InserirCategoriaProdutosGUI icp = new InserirCategoriaProdutosGUI(modelo);

        icp.setLocationRelativeTo(null);
        icp.setVisible(true);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCategoria = (int) tabela.getValueAt(linhaSelecionada, 0);
            CategoriaProdutoController cp = new CategoriaProdutoController();
            if (cp.delete(idCategoria)) {
                modelo.removeRow(linhaSelecionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
        }

    }//GEN-LAST:event_btDeletarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idCategoria = (int) tabela.getValueAt(linhaSelecionada, 0);
            CategoriaProdutoController fc = new CategoriaProdutoController();
            InserirCategoriaProdutosGUI ifu = new InserirCategoriaProdutosGUI(modelo, linhaSelecionada, idCategoria);
            ifu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
        }

    }//GEN-LAST:event_btEditarActionPerformed

    private void txPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaActionPerformed
        CategoriaProdutoController cp = new CategoriaProdutoController();
        modelo.setNumRows(0);
        for (CategoriaProduto c : cp.search(txPesquisa.getText())) {
            modelo.addRow(new Object[]{c.getCodCategoriaProduto(), c.getNomeCategoriaProduto(), c.getDescricaoCategoriaProduto()});
        }

    }//GEN-LAST:event_txPesquisaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btInserir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txPesquisa;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        preencherJTable();
    }

    private void preencherJTable() {
        CategoriaProdutoController cpc = new CategoriaProdutoController();
        for (CategoriaProduto cp : cpc.listAll()) {
            modelo.addRow(new Object[]{cp.getCodCategoriaProduto(), cp.getNomeCategoriaProduto(), cp.getDescricaoCategoriaProduto()});
        }

    }
}
