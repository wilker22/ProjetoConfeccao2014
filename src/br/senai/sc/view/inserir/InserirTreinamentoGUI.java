package br.senai.sc.view.inserir;

import br.senai.sc.controller.TreinamentoController;
import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.validador.Validadores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Interface responsavél por inserir treinamento com dados e métodos para
 * executar na classe principal
 *
 * @author Bruna Zakrzeski
 * @since 1.0 05/11/2013
 * @param treina
 * @return
 */
public class InserirTreinamentoGUI extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int linhaSelecionada;

    //Metodo que abre a pagina para fazer inserção de treinamento
    public InserirTreinamentoGUI(DefaultTableModel modelo) {
        this.modelo = modelo;
        initComponents();
    }

    //Metodo que faz editar os dados, com formularios preechidos com os dados
    public InserirTreinamentoGUI(DefaultTableModel modelo, int linhaSelecionada, int idTreinamento) {
        initComponents();

        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;

        TreinamentoController tc = new TreinamentoController();
        Treinamento treina = tc.listarTreinamentoById(idTreinamento);


        txCodigoTreinamento.setText(String.valueOf(treina.getId()));
        txNomeTreinamento.setText(treina.getNome());
        txCargaHorariaTreinamento.setText(String.valueOf(treina.getCargaHoraria()));
        txConteudoTreinamento.setText(treina.getConteudo());


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txCodigoTreinamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNomeTreinamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txCargaHorariaTreinamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btSalvarTreinamento = new javax.swing.JButton();
        btLimparTreinamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txConteudoTreinamento = new javax.swing.JTextArea();
        txMenssagemTreinamento1 = new javax.swing.JLabel();
        txMenssagemTreinamento4 = new javax.swing.JLabel();
        txMenssagemTreinamento5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserir Treinamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código Treinamento:  ");

        txCodigoTreinamento.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Treinamento:  ");

        txNomeTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeTreinamentoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Carga Horária:  ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Conteúdo:  ");

        btSalvarTreinamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btSalvarTreinamento.setToolTipText("Inserir Treinamento");
        btSalvarTreinamento.setBorderPainted(false);
        btSalvarTreinamento.setContentAreaFilled(false);
        btSalvarTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarTreinamentoActionPerformed(evt);
            }
        });

        btLimparTreinamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btLimparTreinamento.setToolTipText("Limpar Treinamento");
        btLimparTreinamento.setBorderPainted(false);
        btLimparTreinamento.setContentAreaFilled(false);
        btLimparTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparTreinamentoActionPerformed(evt);
            }
        });

        txConteudoTreinamento.setColumns(20);
        txConteudoTreinamento.setRows(5);
        jScrollPane1.setViewportView(txConteudoTreinamento);

        txMenssagemTreinamento1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento1.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento1.setText("*");

        txMenssagemTreinamento4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento4.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento4.setText("*");

        txMenssagemTreinamento5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento5.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento5.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMenssagemTreinamento4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMenssagemTreinamento5)))
                .addGap(13, 13, 13)
                .addComponent(txMenssagemTreinamento1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btSalvarTreinamento)
                        .addGap(73, 73, 73)
                        .addComponent(btLimparTreinamento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCodigoTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNomeTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCargaHorariaTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(366, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txCodigoTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomeTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txMenssagemTreinamento1))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txCargaHorariaTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMenssagemTreinamento4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txMenssagemTreinamento5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimparTreinamento)
                    .addComponent(btSalvarTreinamento))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarTreinamentoActionPerformed

     
         if(
                 
                Validadores.validaCampoVazio(txNomeTreinamento.getText(), "Nome Treinamento") &&
                 
                Validadores.validaCampoVazio(txCargaHorariaTreinamento.getText(), "Carga Horária Treinamento") &&
                Validadores.somenteNumeros(txCargaHorariaTreinamento.getText(), "Carga Horária Treinamento") &&
                 
                Validadores.validaCampoVazio(txConteudoTreinamento.getText(), "Conteúdo Treinamento")){


             

            Treinamento treina = new Treinamento();

            treina.setNome(txNomeTreinamento.getText());
            treina.setCargaHoraria((Integer.parseInt(txCargaHorariaTreinamento.getText())));
            treina.setConteudo(txConteudoTreinamento.getText());


            TreinamentoController tc = new TreinamentoController();
            if (!(txCodigoTreinamento.getText().equals("") | (txCodigoTreinamento.getText().equals("null")))) {

                treina.setId(Integer.parseInt(txCodigoTreinamento.getText()));

                tc.salvar(treina);
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{treina.getId(), treina.getNome(), treina.getCargaHoraria(), treina.getConteudo()});

                this.dispose();


            } else {
                Treinamento id = tc.salvar(treina);
                modelo.addRow(new Object[]{id, treina.getNome(), treina.getCargaHoraria(), treina.getConteudo()});

                this.dispose();
            }



         }
    }//GEN-LAST:event_btSalvarTreinamentoActionPerformed

    private void btLimparTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparTreinamentoActionPerformed
    }//GEN-LAST:event_btLimparTreinamentoActionPerformed

    private void txNomeTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeTreinamentoActionPerformed
    }//GEN-LAST:event_txNomeTreinamentoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimparTreinamento;
    private javax.swing.JButton btSalvarTreinamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txCargaHorariaTreinamento;
    private javax.swing.JTextField txCodigoTreinamento;
    private javax.swing.JTextArea txConteudoTreinamento;
    private javax.swing.JLabel txMenssagemTreinamento1;
    private javax.swing.JLabel txMenssagemTreinamento4;
    private javax.swing.JLabel txMenssagemTreinamento5;
    private javax.swing.JTextField txNomeTreinamento;
    // End of variables declaration//GEN-END:variables
}