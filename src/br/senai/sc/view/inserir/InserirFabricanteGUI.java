package br.senai.sc.view.inserir;

import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.persistencia.FabricanteDaoJDBC;
import br.senai.sc.model.persistencia.dao.FabricanteDAO;
import javax.swing.table.DefaultTableModel;
import br.senai.sc.controller.FabricanteController;
import br.senai.sc.validador.Validadores;
import br.senai.sc.view.list.ListarFabricanteGUI;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus Generoso
 * @version 1.0 30/10/2013
 */
public class InserirFabricanteGUI extends javax.swing.JFrame {

    private ListarFabricanteGUI janela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private int linhaSelecionada;

    public InserirFabricanteGUI(DefaultTableModel modelo, ListarFabricanteGUI janela) {

        this.janela = janela;
        this.modelo = modelo;
        initComponents();
        setLocationRelativeTo(null);

    }

    public InserirFabricanteGUI(DefaultTableModel modelo, int linhaSelecionada, int idFabricante, ListarFabricanteGUI janela) {

        this.janela = janela;
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        initComponents();
        setLocationRelativeTo(null);

        Fabricante listValue = new Fabricante();
        FabricanteController fc = new FabricanteController();

        listValue = fc.listarId(idFabricante);
        txCodFabricante.setText(String.valueOf(listValue.getCod()));
        txNmFantasia.setText(listValue.getNmFantasia());
        SimpleDateFormat formatDtCad = new SimpleDateFormat("dd/MM/yyyy");
        String dataCad = formatDtCad.format(listValue.getDtCadastro());
        txDtCadastro.setText(dataCad);
        txRazaoSocial.setText(listValue.getRazaoSocial());
        txCnpj.setText(listValue.getCnpj());
        txTelefone.setText(listValue.getTelefone());
        txEmail.setText(listValue.getEmail());
        txEndereco.setText(listValue.getEndereco());


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txNmFantasia = new javax.swing.JTextField();
        txCnpj = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txCodFabricante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txRazaoSocial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txTelefone = new javax.swing.JFormattedTextField();
        txDtCadastro = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fabricante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btSalvar.setBorderPainted(false);
        btSalvar.setContentAreaFilled(false);
        btSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nome Fantasia.:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("CNPJ.:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("E-mail.:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Endereço.:");

        jLabel6.setText("Cod.:");

        txCodFabricante.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Razão Social.:");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Dt Cadastro.:");

        try {
            txTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txDtCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCodFabricante))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRazaoSocial)
                                    .addComponent(txNmFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txDtCadastro))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txCnpj)
                            .addComponent(txEndereco)
                            .addComponent(txTelefone))))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCodFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNmFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txDtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(painelPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (Validadores.somenteNumeros(txCnpj.getText(), "CNPJ")
                && Validadores.validaCampoVazio(txCnpj.getText(), "CNPJ")
                && Validadores.validaCnpj(txCnpj.getText())
                && Validadores.validaCampoVazio(txDtCadastro.getText(), "Data Cadastro")
                && Validadores.validaCampoVazio(txEmail.getText(), "E-mail")
                && Validadores.validaCampoVazio(txEndereco.getText(), "Endereço")
                && Validadores.validaCampoVazio(txNmFantasia.getText(), "Nome Fantasia")
                && Validadores.validaCampoVazio(txRazaoSocial.getText(), "Razão Social")
                && Validadores.validaCampoVazio(txTelefone.getText(), "Telefone")
                && Validadores.validaEmail(txEmail.getText())) {
            Fabricante fab = new Fabricante();
            fab.setNmFantasia(txNmFantasia.getText());
            fab.setRazaoSocial(txRazaoSocial.getText());

            try {
                String data = txDtCadastro.getText();

                fab.setDtCadastro(new SimpleDateFormat("dd/mm/yyyy").parse(data));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data incorreta" + ex);
            }

            fab.setCnpj(txCnpj.getText());
            fab.setTelefone(txTelefone.getText());
            fab.setEmail(txEmail.getText());
            fab.setEndereco(txEndereco.getText());

            FabricanteController fc = new FabricanteController();
            if (!(txCodFabricante.getText().equals("") || txCodFabricante.getText() == null)) {
                fab.setCod(Integer.parseInt(txCodFabricante.getText()));

                fc.salvar(fab);
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{fab.getCod(), fab.getNmFantasia(), fab.getCnpj(), fab.getTelefone(), fab.getEmail()});

            } else {

                modelo.addRow(new Object[]{fc.salvar(fab), fab.getNmFantasia(), fab.getCnpj(), fab.getTelefone(), fab.getEmail()});

            }
            this.janela.repaint();
            this.dispose();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        txNmFantasia.setText("");
        txRazaoSocial.setText("");
        txDtCadastro.setText("");
        txCnpj.setText("");
        txTelefone.setText("");
        txEmail.setText("");
        txEndereco.setText("");
    }//GEN-LAST:event_btCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextField txCnpj;
    private javax.swing.JTextField txCodFabricante;
    private javax.swing.JFormattedTextField txDtCadastro;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEndereco;
    private javax.swing.JTextField txNmFantasia;
    private javax.swing.JTextField txRazaoSocial;
    private javax.swing.JFormattedTextField txTelefone;
    // End of variables declaration//GEN-END:variables
}
