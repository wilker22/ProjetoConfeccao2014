package br.senai.sc.view.inserir;

import br.senai.sc.controller.CategoriaColecaoController;
import br.senai.sc.controller.ColecaoController;
import br.senai.sc.controller.FuncionarioController;
import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.validador.Validadores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel_arsenio
 */
public class InserirColecaoGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    public InserirColecaoGUI() {
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
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        carregarComboCategoria();
        carregarComboFuncionario();
        setLocationRelativeTo(null);
        cbCategoriaColecao.setSelectedItem(null);
        cbFuncionario.setSelectedItem(null);
    }

    public InserirColecaoGUI(DefaultTableModel modelo, int linhaSelecionada, int idColecao) {
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
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirColecaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        initComponents();
        setLocationRelativeTo(null);
        carregarComboCategoria();
        carregarComboFuncionario();
        ColecaoController cc = new ColecaoController();
        Colecao c = cc.listarColecaoById(idColecao);
        txCodigo.setText(String.valueOf(c.getCodColecao()));
        txEstacao.setText(c.getEstacaoColecao());
        txAno.setText(String.valueOf(c.getAnoColecao()));
        txPubAlvo.setText(c.getPubAlvoColecao());
        cbCategoriaColecao.setSelectedItem(c.getCategoriaColecao());
        cbFuncionario.setSelectedItem(c.getFunResponsavelColecao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        lbBanner = new javax.swing.JLabel();
        lbEstacao = new javax.swing.JLabel();
        txEstacao = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        lbAno = new javax.swing.JLabel();
        txAno = new javax.swing.JTextField();
        lbPubAlvo = new javax.swing.JLabel();
        txPubAlvo = new javax.swing.JTextField();
        lbFuncionario = new javax.swing.JLabel();
        cbFuncionario = new javax.swing.JComboBox();
        lbCategoriaColecao = new javax.swing.JLabel();
        cbCategoriaColecao = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));

        lbBanner.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lbBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBanner.setText("Cadastro de Coleção");

        lbEstacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEstacao.setText("Estação:");

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Código:");

        txCodigo.setEditable(false);

        lbAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAno.setText("Ano:");

        lbPubAlvo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPubAlvo.setText("Público Alvo:");

        lbFuncionario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFuncionario.setText("Funcionário Responsável:");

        lbCategoriaColecao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCategoriaColecao.setText("Categoria da Coleção:");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
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

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFundoLayout.createSequentialGroup()
                                .addComponent(lbEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelFundoLayout.createSequentialGroup()
                                .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelFundoLayout.createSequentialGroup()
                                .addComponent(lbAno, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txAno, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelFundoLayout.createSequentialGroup()
                                .addComponent(lbCategoriaColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoriaColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(painelFundoLayout.createSequentialGroup()
                                    .addComponent(btSalvar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btCancelar))
                                .addGroup(painelFundoLayout.createSequentialGroup()
                                    .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addComponent(lbPubAlvo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txPubAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBanner)
                .addGap(71, 71, 71)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstacao)
                    .addComponent(txEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAno)
                    .addComponent(txAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPubAlvo)
                    .addComponent(txPubAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFuncionario)
                    .addComponent(cbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoriaColecao)
                    .addComponent(cbCategoriaColecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        boolean camposCorretos = false;

        Colecao c = new Colecao();
        if (!(txCodigo.getText().equals("")) || (txCodigo.getText().equals(null))) {
            c.setCodColecao(Integer.parseInt(txCodigo.getText()));
        }
        if (Validadores.validaCampoVazio(txEstacao.getText(), "Preencha o campo com o nome da estação.")
                && Validadores.validaCampoVazio(txAno.getText(), "Preencha o campo com o ano.")
                && Validadores.validaCampoVazio(txPubAlvo.getText(), "Preencha o campo com o público alvo da coleção.")
                && Validadores.somenteLetras(txEstacao.getText(), "É permitido apenas letras no nome da estação.")
                && Validadores.somenteNumeros(txAno.getText(), "É permitido apenas números no ano.")) {

            c.setEstacaoColecao(txEstacao.getText());
            c.setAnoColecao(Integer.parseInt(txAno.getText()));
            c.setPubAlvoColecao(txPubAlvo.getText());
            if (cbCategoriaColecao.getSelectedItem() != "" && cbFuncionario.getSelectedItem() != "") {
                c.setFunResponsavelColecao((Funcionario) cbFuncionario.getSelectedItem());
                c.setCategoriaColecao((CategoriaColecao) cbCategoriaColecao.getSelectedItem());
                camposCorretos = true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione um funcionário ou uma categoria");
                camposCorretos = false;
            }
        }


        ColecaoController cc = new ColecaoController();
        if (camposCorretos == true) {
            if (c.getCodColecao() == 0) {
                int id = cc.salve(c).getCodColecao();
                if (id > 0) {
                    System.out.println("Cadastrado com sucesso.");
                }
            } else {

                int id = cc.salve(c).getCodColecao();
                if (id > 0) {
                    System.out.println("Atualizado com sucesso.");
                    modelo.removeRow(linhaSelecionada);
                    modelo.addRow(new Object[]{id, c.getEstacaoColecao(), c.getAnoColecao()});
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        txAno.setText(null);
        txCodigo.setText(null);
        txEstacao.setText(null);
        txPubAlvo.setText(null);
        cbCategoriaColecao.setSelectedItem("");
        cbFuncionario.setSelectedItem("");
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCategoriaColecao;
    private javax.swing.JComboBox cbFuncionario;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbBanner;
    private javax.swing.JLabel lbCategoriaColecao;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbEstacao;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbPubAlvo;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JTextField txAno;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txEstacao;
    private javax.swing.JTextField txPubAlvo;
    // End of variables declaration//GEN-END:variables

    private void carregarComboCategoria() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) cbCategoriaColecao.getModel();
        combo.removeAllElements();
        List<CategoriaColecao> categorias = new ArrayList<CategoriaColecao>();
        CategoriaColecaoController ccc = new CategoriaColecaoController();
        categorias = ccc.listarTodas();
        for (int linha = 0; linha < categorias.size(); linha++) {
            CategoriaColecao cc = categorias.get(linha);
            combo.addElement(cc);
        }
    }

    private void carregarComboFuncionario() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) cbFuncionario.getModel();
        combo.removeAllElements();
        List<Funcionario> funcionarios = new ArrayList<>();
        FuncionarioController fc = new FuncionarioController();
        funcionarios = fc.listAll();
        for (int linha = 0; linha < funcionarios.size(); linha++) {
            Funcionario fu = funcionarios.get(linha);
            combo.addElement(fu);
        }
    }
}
