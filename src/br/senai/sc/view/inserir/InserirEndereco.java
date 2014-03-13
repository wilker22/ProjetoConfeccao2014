package br.senai.sc.view.inserir;

import br.senai.sc.controller.EnderecoController;
import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.validador.Validadores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo_cm
 * @version 1.0 06/11/2013
 */
public class InserirEndereco extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;
 //Metodo que abre a janela para inserir o endereço.
    public InserirEndereco(DefaultTableModel modelo) {
        initComponents();
        this.modelo = modelo;

    }
//Metodo que edita todos os dados prenchidos.
    public InserirEndereco(DefaultTableModel modelo, int linhaSelecionada, int codigoEndereco) {
        initComponents();
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;

        EnderecoController ec = new EnderecoController();
        Endereco editar = ec.listbyId(codigoEndereco);

        tfCodigo.setText(String.valueOf(editar.getCodigo()));
        tfRua.setText(editar.getRua());
        tfBairro.setText(editar.getBairro());
        tfCidade.setText(editar.getCidade());
        ftfCep.setText(String.valueOf(editar.getCep()));
        tfComplemento.setText(editar.getComplemento());
        tfNumero.setText(String.valueOf(editar.getNumero()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelFundo = new javax.swing.JPanel();
        lbRua = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        tfCodigo = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        lbCep = new javax.swing.JLabel();
        lbComplemento = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        ftfCep = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PainelFundo.setBackground(new java.awt.Color(255, 255, 255));
        PainelFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        lbRua.setText("Rua: ");

        lbTelefone.setText("Bairro: ");

        lbCodigo.setText("Codigo: ");

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

        tfCodigo.setEditable(false);
        tfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoActionPerformed(evt);
            }
        });

        tfRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRuaActionPerformed(evt);
            }
        });

        tfBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBairroActionPerformed(evt);
            }
        });

        lbCidade.setText("Cidade:");

        lbCep.setText("Cep: ");

        lbComplemento.setText("Complemento: ");

        lbNumero.setText("Numero: ");

        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });

        try {
            ftfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**.***-***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout PainelFundoLayout = new javax.swing.GroupLayout(PainelFundo);
        PainelFundo.setLayout(PainelFundoLayout);
        PainelFundoLayout.setHorizontalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(lbRua)
                    .addComponent(lbTelefone)
                    .addComponent(lbCidade)
                    .addComponent(lbCep)
                    .addComponent(lbComplemento)
                    .addComponent(lbNumero))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelFundoLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfNumero)
                            .addComponent(tfComplemento)
                            .addComponent(tfBairro)
                            .addComponent(tfRua)
                            .addComponent(tfCidade)
                            .addComponent(tfCodigo))
                        .addGap(143, 143, 143))
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addComponent(ftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PainelFundoLayout.setVerticalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelFundoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCidade)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCep)
                    .addComponent(ftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComplemento))
                .addGap(18, 18, 18)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero))
                .addGap(27, 27, 27)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoActionPerformed

    private void tfRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRuaActionPerformed

    private void tfBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBairroActionPerformed

    private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
   //Metodo que valida todos endereços.
        if(      
            Validadores.somenteNumeros(tfCodigo.getText(), "CODIGO"));
            Validadores.validaCampoVazio(tfRua.getText(), "RUA");
            Validadores.validaCampoVazio(tfBairro.getText(), "BAIRRO");
            Validadores.validaCampoVazio(tfCidade.getText(), "CIDADE");
            Validadores.somenteNumeros(ftfCep.getText(), "CEP");
            Validadores.validaCampoVazio(tfComplemento.getText(), "COMPLEMENTO");
            Validadores.validaCampoVazio(tfNumero.getText(), "NUMERO");
        
        Endereco e = new Endereco();
       
        e.setRua(tfRua.getText());
        e.setBairro(tfBairro.getText());
        e.setCidade(tfCidade.getText());
        e.setCep(ftfCep.getText());
        e.setComplemento(tfComplemento.getText());
        e.setNumero((Integer.parseInt(tfNumero.getText())));

        EnderecoController ec = new EnderecoController();
        if (tfCodigo.getText().equals("")) {
            int id = ec.inserir(e);
            if (id > 0) {
                JOptionPane.showMessageDialog(null, "Endereço cadastro com sucesso.");
                modelo.addRow(new Object[]{id, e.getRua(), e.getBairro(),
                    e.getCidade(), e.getCep(), e.getComplemento(), e.getNumero()});
            }
        } else {
            e.setCodigo((Integer.parseInt(tfCodigo.getText())));
            if (ec.update(e) > 0) {
                modelo.removeRow(linhaSelecionada);

                modelo.addRow(new Object[]{e.getCodigo(), e.getRua(), e.getBairro(),
                    e.getCidade(), e.getCep(), e.getComplemento(), e.getNumero()});
                JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso.");
            }
        }
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftfCep;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables
}