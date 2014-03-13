package br.senai.sc.view.inserir;

import br.senai.sc.controller.CategoriaProdutoController;
import br.senai.sc.controller.ColecaoController;
import br.senai.sc.controller.FabricantesController;
import br.senai.sc.controller.ProdutoController;
import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.negocio.Produto;
import br.senai.sc.validador.Validadores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InserirProdutoGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private int linhaSelecionada;

    public InserirProdutoGUI(DefaultTableModel modelo) {
        initComponents();
        this.modelo = modelo;
        carregarComboCategoria();
        carregarComboFabricante();
        carregarComboColecao();
    }

    public InserirProdutoGUI(DefaultTableModel modelo, int linhaSelecionada, int idProduto) {
        initComponents();
        this.modelo = modelo;
        carregarComboCategoria();
        carregarComboFabricante();
        carregarComboColecao();

        this.linhaSelecionada = linhaSelecionada;
        ProdutoController pc = new ProdutoController();
        Produto p = pc.listById(idProduto);
        txId.setText(String.valueOf(p.getCodProduto()));
        txNome.setText(p.getNome());
        cbFabricante.setSelectedItem(p.getFabricante().getNmFantasia());
        txModelo.setText(p.getModelo());
        cbCategoria.setSelectedItem(p.getCategoria().getNomeCategoriaProduto());
        cbColecao.setSelectedItem(p.getColecao().getEstacaoColecao());
        txPreco.setText(String.valueOf(p.getPreco()));
        txTamanho.setText(p.getTamanho());
        txCor.setText(p.getCor());
        txQTD.setText(String.valueOf(p.getQtProdutos()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        txModelo = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txPreco = new javax.swing.JTextField();
        txTamanho = new javax.swing.JTextField();
        txCor = new javax.swing.JTextField();
        txQTD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        cbColecao = new javax.swing.JComboBox();
        cbFabricante = new javax.swing.JComboBox();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserir Produto"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Id.: ");

        jLabel2.setText("Nome.:  ");

        jLabel3.setText("Modelo.:");

        txId.setEditable(false);

        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
            }
        });

        txModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txModeloActionPerformed(evt);
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

        jLabel4.setText("Preço.:");

        jLabel5.setText("Tamanho.:");

        jLabel7.setText("Cor.:");

        jLabel8.setText("QTD.:");

        txPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrecoActionPerformed(evt);
            }
        });

        jLabel9.setText("Categoria.:");

        jLabel10.setText("Coleção.:");

        jLabel11.setText("Fabricante.:");

        cbFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addGap(18, 18, 18)
                .addComponent(btLimpar)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addComponent(jLabel9)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txNome)
                    .addComponent(txModelo)
                    .addComponent(txPreco)
                    .addComponent(cbFabricante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbColecao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txQTD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbColecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txQTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Produto");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txModeloActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        double valorTeste;
        if (txNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome precisa ser preenchido.");
            txNome.requestFocus();
        } else if (txModelo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo modelo precisa ser preenchido.");
            txModelo.requestFocus();
        } else if (txPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo preço precisa ser preenchido.");
            txPreco.requestFocus();
        } else if (!validaDouble(txPreco.getText())) {
            JOptionPane.showMessageDialog(null, "Valor inválido para o campo preço.");
            txPreco.setText("");
            txPreco.requestFocus();
        } else if (txTamanho.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo tamanho precisa ser preenchido.");
            txTamanho.requestFocus();
        } else if (txTamanho.getText().length() > 3) {
            JOptionPane.showMessageDialog(null, "Campo tamanho permite apenas 3 caracteres.");
            txTamanho.setText("");
            txTamanho.requestFocus();
        } else if (txCor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo cor precisa ser preenchido.");
            txCor.requestFocus();
        } else if (txQTD.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo QTD precisa ser preenchido.");
            txQTD.requestFocus();
        } else if (!validaInt(txQTD.getText())) {
            JOptionPane.showMessageDialog(null, "Valor inválido para o campo QTD.");
            txQTD.setText("");
            txQTD.requestFocus();
        } else {

            Produto p = new Produto();
            p.setNome(txNome.getText());
            p.setFabricante((Fabricante) cbFabricante.getSelectedItem());
            p.setModelo(txModelo.getText());
            p.setCategoria((CategoriaProduto) cbCategoria.getSelectedItem());
            p.setColecao((Colecao) cbColecao.getSelectedItem());
            p.setPreco(Double.parseDouble(txPreco.getText()));
            p.setTamanho(txTamanho.getText());
            p.setCor(txCor.getText());
            p.setQtProdutos(Integer.parseInt(txQTD.getText()));

            ProdutoController pc = new ProdutoController();

            if (!((txId.getText().equals("")) || (txId.getText().equals(null)))) {
                p.setCodProduto(Integer.parseInt(txId.getText()));
                pc.update(p);
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{
                    p.getCodProduto(),
                    p.getNome(),
                    p.getFabricante().getNmFantasia(),
                    p.getModelo(),
                    p.getCategoria().getNomeCategoriaProduto(),
                    p.getColecao().getEstacaoColecao(),
                    p.getPreco(),
                    p.getTamanho(),
                    p.getCor(),
                    p.getQtProdutos()
                });

                this.dispose();
            } else {
                pc.insert(p);
                modelo.addRow(new Object[]{
                    p.getCodProduto(),
                    p.getNome(),
                    p.getFabricante().getNmFantasia(),
                    p.getModelo(),
                    p.getCategoria().getNomeCategoriaProduto(),
                    p.getColecao().getEstacaoColecao(),
                    p.getPreco(),
                    p.getTamanho(),
                    p.getCor(),
                    p.getQtProdutos()
                });
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txNome.setText("");
        cbFabricante.setSelectedItem("");
        txModelo.setText("");
        cbCategoria.setSelectedItem("");
        cbColecao.setSelectedItem("");
        txPreco.setText("");
        txTamanho.setText("");
        txCor.setText("");
        txQTD.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void txPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecoActionPerformed

    private void cbFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFabricanteActionPerformed
    }//GEN-LAST:event_cbFabricanteActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbColecao;
    private javax.swing.JComboBox cbFabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txCor;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txModelo;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txPreco;
    private javax.swing.JTextField txQTD;
    private javax.swing.JTextField txTamanho;
    // End of variables declaration//GEN-END:variables

    /**
     * Método responsável por carregar o combobox da categoria_produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 06/11/2013
     * @return
     */
    private void carregarComboCategoria() {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbCategoria.getModel();
        comboModel.removeAllElements();
        List<CategoriaProduto> lcp = new ArrayList<>();
        CategoriaProdutoController cpc = new CategoriaProdutoController();
        lcp = cpc.listAll();

        for (int linha = 0; linha < lcp.size(); linha++) {
            CategoriaProduto cp = lcp.get(linha);
            comboModel.addElement(cp);
        }
    }

    /**
     * Método responsável por carregar o combobox da colecao
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 06/11/2013
     * @return
     */
    private void carregarComboColecao() {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbColecao.getModel();
        comboModel.removeAllElements();
        List<Colecao> c = new ArrayList<>();
        ColecaoController fc = new ColecaoController();
        c = fc.listarTodas();

        for (int linha = 0; linha < c.size(); linha++) {
            Colecao fb = c.get(linha);
            comboModel.addElement(fb);
        }
    }

    /**
     * Método responsável por carregar o combobox do fabricante
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 06/11/2013
     * @return
     */
    private void carregarComboFabricante() {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbFabricante.getModel();
        comboModel.removeAllElements();
        List<Fabricante> f = new ArrayList<>();
        FabricantesController fc = new FabricantesController();
        f = fc.listAll();

        for (int linha = 0; linha < f.size(); linha++) {
            Fabricante fb = f.get(linha);
            comboModel.addElement(fb);
        }
    }

    /**
     * Método responsável por validar Double
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 06/11/2013
     * @return
     */
    private boolean validaDouble(String valor) {
        double valorTeste;
        boolean retorno;
        try {
            valorTeste = Double.parseDouble(valor);
            retorno = true;
        } catch (NumberFormatException e) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método responsável por validar Inteiro
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 06/11/2013
     * @return
     */
    private boolean validaInt(String valor) {
        double valorTeste;
        boolean retorno;
        try {
            valorTeste = Integer.parseInt(valor);
            retorno = true;
        } catch (NumberFormatException e) {
            retorno = false;
        }
        return retorno;
    }
}