package br.senai.sc.view.inserir;

import br.senai.sc.controller.CurriculoController;
import br.senai.sc.model.negocio.Curriculo;
import br.senai.sc.validador.Validadores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class InserirCurriculoGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    public InserirCurriculoGUI(DefaultTableModel modelo) {
        initComponents();
        this.modelo = modelo;
        // carregarCombo();
    }

    public InserirCurriculoGUI(DefaultTableModel modelo, int linhaSelecionada, int idCurriculo) {


        initComponents();
        this.modelo = modelo;
        CurriculoController cc = new CurriculoController();
        Curriculo c = cc.listarCurriculoById(idCurriculo);

        txCodigo.setText(String.valueOf(c.getCodigo()));
        txNome.setText(c.getNome());
        txLogin.setText(c.getLogin());
        txSenha.setText(c.getSenha());
        txCpf.setText(c.getCpf());
        txTelefone.setText(c.getTelefone());
        txEmail.setText(c.getEmail());
        txRg.setText(c.getRg());
        txCtps.setText(c.getCtps());
        txCargo.setText(c.getCargo());
        txStatus.setText(c.getStatus());
        txSalario.setText(c.getSalario());
        txDataNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento()));
        txDataRecisao.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getDataAdmissao()));
        txDataRecisao.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getDataRecisao()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        txSenha = new javax.swing.JTextField();
        txNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txLogin = new javax.swing.JTextField();
        txRg = new javax.swing.JTextField();
        txCargo = new javax.swing.JTextField();
        txSalario = new javax.swing.JTextField();
        txStatus = new javax.swing.JTextField();
        txCtps = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txExperienciaProfissional = new javax.swing.JTextArea();
        txDataNascimento = new javax.swing.JFormattedTextField();
        txDataRecisao = new javax.swing.JFormattedTextField();
        txDataAdmissao = new javax.swing.JFormattedTextField();
        txCpf = new javax.swing.JFormattedTextField();
        txTelefone = new javax.swing.JFormattedTextField();
        txEmail = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curriculos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel1.setText("codigo.:   ");

        jLabel2.setText("Senha.:  ");

        jLabel3.setText("Nome.:  ");

        txCodigo.setEditable(false);
        txCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCodigoActionPerformed(evt);
            }
        });

        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSenhaActionPerformed(evt);
            }
        });

        txNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeActionPerformed(evt);
            }
        });

        btSalvar.setBackground(new java.awt.Color(0, 51, 51));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btSalvar.setBorderPainted(false);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(0, 51, 51));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel4.setText("Login.:  ");

        jLabel5.setText("Cpf.:  ");

        jLabel6.setText("E-mail.:  ");

        jLabel7.setText("Telefone.:  ");

        jLabel9.setText("Ctps.:  ");

        jLabel10.setText("Cargo.:  ");

        jLabel11.setText("Rg.:  ");

        jLabel12.setText("Salario.:  ");

        jLabel13.setText("Data Adimissão.:  ");

        jLabel14.setText("Data Nascimento.:  ");

        jLabel15.setText("Data Recisão.:  ");

        jLabel16.setText("Status.:  ");

        jLabel17.setText("Experiencia Profissional.:  ");

        txLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txLoginActionPerformed(evt);
            }
        });

        txRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRgActionPerformed(evt);
            }
        });

        txCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCargoActionPerformed(evt);
            }
        });

        txSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSalarioActionPerformed(evt);
            }
        });

        txStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txStatusActionPerformed(evt);
            }
        });

        txCtps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCtpsActionPerformed(evt);
            }
        });

        txExperienciaProfissional.setColumns(20);
        txExperienciaProfissional.setRows(5);
        jScrollPane1.setViewportView(txExperienciaProfissional);

        try {
            txDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txDataRecisao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(7, 7, 7)
                                        .addComponent(txNome))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txLogin)
                                            .addComponent(txCodigo)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txCpf))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txEmail))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(12, 12, 12)
                                        .addComponent(txCtps))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(3, 3, 3)
                                        .addComponent(txStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txDataAdmissao))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txDataRecisao)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txSalario))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txCargo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txRg))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txDataNascimento))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txTelefone))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txDataRecisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCodigoActionPerformed

    private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSenhaActionPerformed

    private void txNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (Validadores.validaCampoVazio(txLogin.getText(), "LOGIN")
                && Validadores.validaCampoVazio(txSenha.getText(), "SENHA")
                && Validadores.validaCampoVazio(txNome.getText(), "NOME")
                && Validadores.validaCampoVazio(txDataNascimento.getText(), "DATA NACIMENTO")
                && Validadores.validaData(txDataNascimento.getText(), "DATA NACIMENTO")
                && Validadores.validaCampoVazio(txCpf.getText(), "CPF")
                && Validadores.validaCampoVazio(txTelefone.getText(), "TELEFONE")
                && Validadores.validaCampoVazio(txEmail.getText(), "EMAIL")
                && Validadores.validaEmail(txEmail.getText())
                && Validadores.validaCampoVazio(txRg.getText(), "RG")
                && Validadores.somenteNumeros(txRg.getText(), "RG")
                && Validadores.validaCampoVazio(txCtps.getText(), "CTPS")
                && Validadores.validaCnpj(txCtps.getText())
                && Validadores.validaCampoVazio(txCargo.getText(), "CARGO")
                && Validadores.somenteLetras(txCargo.getText(), "CARGO")
                && Validadores.validaCampoVazio(txStatus.getText(), "STATUS")
                && Validadores.validaCampoVazio(txSalario.getText(), "SALARIO")
                && Validadores.validaDouble(txSalario.getText(), "SALARIO")
                && Validadores.validaCampoVazio(txDataAdmissao.getText(), "DATA ADIMISSÃO")
                && Validadores.validaData(txDataAdmissao.getText(), "DATA ADIMISSÃO")
                && Validadores.validaCampoVazio(txDataRecisao.getText(), "DATA RECISÃO")
                && Validadores.validaData(txDataRecisao.getText(), "DATA RECISÃO")
                && Validadores.validaCampoVazio(txExperienciaProfissional.getText(), "EXPERIENCIA PROFISSIONAL")) {
            Curriculo f = new Curriculo();
            f.setNome(txNome.getText());
            CurriculoController fc = new CurriculoController();

            f.setLogin(txLogin.getText());
            f.setSenha(txSenha.getText());
            f.setNome(txNome.getText());
            f.setCpf(txCpf.getText());
            f.setEmail(txEmail.getText());
            f.setTelefone(txTelefone.getText());
            f.setCtps(txCtps.getText());
            f.setCargo(txCargo.getText());
            f.setRg(txRg.getText());
            f.setSalario(txSalario.getText());
            f.setStatus(txStatus.getText());
            try {
                f.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(txDataNascimento.getText()));
            } catch (Exception ex) {
                System.out.println("Erro na conversão de datas" + ex.getMessage());
            }
            try {
                f.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse(txDataRecisao.getText()));
            } catch (Exception ex) {
                System.out.println("Erro na conversão de datas" + ex.getMessage());
            }
            try {
                f.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(txDataNascimento.getText()));
            } catch (Exception ex) {
                System.out.println("Erro na conversão de datas" + ex.getMessage());
            }
            try {
                f.setDataRecisao(new SimpleDateFormat("dd/MM/yyyy").parse(txDataRecisao.getText()));
            } catch (Exception ex) {
                System.out.println("Erro na conversão de datas" + ex.getMessage());
            }
            f.setStatus(txStatus.getText());
            f.setExperienciaprofissional(txExperienciaProfissional.getText());

            if (!(txCodigo.getText().equals("") || (txCodigo.getText().equals(null)))) {
                f.setCodigo(Integer.parseInt(txCodigo.getText()));

                fc.salvar(f);
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{f.getCodigo(), f.getNome(), f.getStatus()});
                this.dispose();
            } else {
                int id = fc.salvar(f).getCodigo();
                modelo.addRow(new Object[]{id, f.getNome(), f.getStatus()});
                this.dispose();

            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void txLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txLoginActionPerformed

    private void txRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRgActionPerformed

    private void txCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCargoActionPerformed

    private void txSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSalarioActionPerformed

    private void txStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txStatusActionPerformed

    private void txCtpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCtpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCtpsActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLimparActionPerformed

    private void txEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailActionPerformed
    }//GEN-LAST:event_txEmailActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txCargo;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JFormattedTextField txCpf;
    private javax.swing.JTextField txCtps;
    private javax.swing.JFormattedTextField txDataAdmissao;
    private javax.swing.JFormattedTextField txDataNascimento;
    private javax.swing.JFormattedTextField txDataRecisao;
    private javax.swing.JFormattedTextField txEmail;
    private javax.swing.JTextArea txExperienciaProfissional;
    private javax.swing.JTextField txLogin;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txRg;
    private javax.swing.JTextField txSalario;
    private javax.swing.JTextField txSenha;
    private javax.swing.JTextField txStatus;
    private javax.swing.JFormattedTextField txTelefone;
    // End of variables declaration//GEN-END:variables
}
