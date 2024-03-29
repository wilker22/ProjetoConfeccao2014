/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.view.inserir;

import br.senai.sc.controller.CategoriaMateriaPrimaControllerNova;
import br.senai.sc.controller.FornecedorController;
import br.senai.sc.model.negocio.MateriaPrima;
import br.senai.sc.controller.MateriaPrimaController;
import br.senai.sc.model.negocio.CategoriaMateriaPrima;
import br.senai.sc.model.negocio.Fornecedor;
import br.senai.sc.validador.Validadores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Letícia de Jesus Ribeiro
 * @version 1.0 06/11/2013
 */
public class InserirMateriaPrimaGUI extends javax.swing.JFrame {
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private DefaultTableModel modelo;
    private int linhaSelecionada;
    private DefaultComboBoxModel combo;

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public InserirMateriaPrimaGUI(DefaultTableModel modelo, int linhaSelecionada, int CodMateriaPrima) {
        initComponents();

        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        MateriaPrimaController mpc = new MateriaPrimaController();
        MateriaPrima mp = mpc.listarMateriaPrimaById(CodMateriaPrima);
        txId.setText(String.valueOf(mp.getCodigo()));
        txNome.setText(mp.getNome());
        txPreco.setText(String.valueOf(mp.getPreco()));
        txQuantidade.setText(String.valueOf(mp.getQuantidade()));
        txTipoUnidade.setText(mp.getTpUnidade());
        carregarComboFornecedor();
        carregarComboCategoria();


    }
    /*
     * Invocando os métodos carregar combo fornecedor e carregar combo categoria.
     */

    public InserirMateriaPrimaGUI(DefaultTableModel modelo) {
        initComponents();
        this.modelo = modelo;
        carregarComboFornecedor();
        carregarComboCategoria();

        //

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txPreco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txTipoUnidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txQuantidade = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox();
        cbFornecedor = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matéria-Prima"));

        jLabel1.setText("Id.: ");

        jLabel2.setText("Fornecedor.:");

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
        btLimpar.setToolTipText("");
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel4.setText("Categoria.:");

        jLabel5.setText("Preço.:");

        jLabel6.setText("Tipo Unidade.:");

        jLabel7.setText("Quantidade.:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTipoUnidade))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txQuantidade)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txTipoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7))
                    .addComponent(txQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txNome.setText("");
        txPreco.setText("");
        txQuantidade.setText("");
        txTipoUnidade.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Validadores.validaCampoVazio(txNome.getText(), "Nome")
                && Validadores.validaCampoVazio(txPreco.getText(), "Preço")
                && Validadores.validaCampoVazio(txQuantidade.getText(), "Quantidade")
                && Validadores.validaCampoVazio(txTipoUnidade.getText(), "Tipo Unidade")
                && Validadores.somenteLetras(txNome.getText(), "Nome")
                && Validadores.somenteLetras(txTipoUnidade.getText(), "Tipo Unidade")
                && Validadores.validaDouble(txPreco.getText(), "Preço")
                && Validadores.somenteNumeros(txQuantidade.getText(), "Quantidade")) {

            MateriaPrima mp = new MateriaPrima();
            mp.setNome(txNome.getText());
            mp.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());
            mp.setCategoria((CategoriaMateriaPrima) cbCategoria.getSelectedItem());
            mp.setPreco(Double.parseDouble(txPreco.getText()));
            mp.setQuantidade(Integer.parseInt(txQuantidade.getText()));
            mp.setTpUnidade(txTipoUnidade.getText());

            MateriaPrimaController mpc = new MateriaPrimaController();
            if (txId.getText().equals("")) {

                // int CodMateriaPrima = mpc.salvar(mp);

                modelo.addRow(new Object[]{mp.getNome(), mp.getCategoria(), mp.getFornecedor(), mp.getPreco(), mp.getTpUnidade(), mp.getQuantidade()});
                dispose();
            } else {
                mp.setCodigo(Integer.parseInt(txId.getText()));
                //   int estado = mpc.salvar(mp);
                //   if (estado > 0) {
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{mp.getCodigo(), mp.getNome(), mp.getCategoria(), mp.getFornecedor(), mp.getPreco(), mp.getTpUnidade(), mp.getQuantidade()});
                //  }
            }
        }







    }//GEN-LAST:event_btSalvarActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        carregarComboCategoria();
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed
        carregarComboFornecedor();
    }//GEN-LAST:event_cbFornecedorActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txPreco;
    private javax.swing.JTextField txQuantidade;
    private javax.swing.JTextField txTipoUnidade;
    // End of variables declaration//GEN-END:variables
/*
     * Método responásavel por carregar o combo fornecedor
     *@author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param 
     * @return
     */

    private void carregarComboFornecedor() {

        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbFornecedor.getModel();
        comboModel.removeAllElements();
        List<Fornecedor> fornecedores = new ArrayList<>();
        FornecedorController f = new FornecedorController();
        fornecedores = f.listAll();

        for (int linha = 0; linha < fornecedores.size(); linha++) {
            Fornecedor fo = fornecedores.get(linha);
            comboModel.addElement(fo);
        }
    }

    /*
     * Método responásavel por carregar o combo categoria
     *@author Letícia de Jesus Ribeiro
     * @since 1.0 05/11/2013
     * @param 
     * @return
     */
    private void carregarComboCategoria() {

        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbCategoria.getModel();
        comboModel.removeAllElements();
        List<CategoriaMateriaPrima> categoriamateriasprima = new ArrayList<>();
        CategoriaMateriaPrimaControllerNova cc = new CategoriaMateriaPrimaControllerNova();
        categoriamateriasprima = cc.listAll();
        System.out.println(categoriamateriasprima.size());

        for (int linha = 0; linha < categoriamateriasprima.size(); linha++) {
            CategoriaMateriaPrima cmp = categoriamateriasprima.get(linha);
            comboModel.addElement(cmp);
        }
    }
}
