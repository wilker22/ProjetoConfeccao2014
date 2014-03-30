package br.senai.sc.view.inserir;

import br.senai.sc.controller.VagasController;
import br.senai.sc.model.negocio.Vagas;
import br.senai.sc.validador.Validadores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    /**
     * Interface responsavél por inserir vagas
     * com dados e metodos para executar na classe principal
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */


public class InserirVagasGUI extends javax.swing.JFrame {
    
    private DefaultTableModel modelo;
    private int linhaSelecionada;
    

    public InserirVagasGUI(DefaultTableModel modelo) {
        initComponents();
    }

    
    public InserirVagasGUI(DefaultTableModel modelo, int linhaSelecionada, int codVaga){
        initComponents();
        
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        
        
        VagasController vc = new VagasController();
        Vagas vag = vc.listById(codVaga);
        
        
        txCodigoVaga.setText(String.valueOf(vag.getCodigo()));
        txNomeVaga.setText(vag.getNome());
        txQuantidadeVaga.setText(String.valueOf(vag.getQtVaga())); 
        txRequisitoVaga.setText(vag.getPreRequisito());
        txFuncaoVaga.setText(vag.getFuncao());
        txFaixaVaga.setText(String.valueOf(vag.getfaixaSalarial()));

    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txCodigoVaga = new javax.swing.JTextField();
        txNomeVaga = new javax.swing.JTextField();
        txQuantidadeVaga = new javax.swing.JTextField();
        txFuncaoVaga = new javax.swing.JTextField();
        txFaixaVaga = new javax.swing.JTextField();
        btSalvarVaga = new javax.swing.JButton();
        btLimparVaga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txRequisitoVaga = new javax.swing.JTextArea();
        txMenssagemTreinamento4 = new javax.swing.JLabel();
        txMenssagemTreinamento7 = new javax.swing.JLabel();
        txMenssagemTreinamento8 = new javax.swing.JLabel();
        txMenssagemTreinamento9 = new javax.swing.JLabel();
        txMenssagemTreinamento10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserir Vagas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(0, 0, 0))); // NOI18N
        painelFundo.setMaximumSize(new java.awt.Dimension(800, 600));
        painelFundo.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código Vaga:  ");
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 600));
        painelFundo.add(jLabel1);
        jLabel1.setBounds(20, 50, 90, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Vaga:  ");
        jLabel2.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel2.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel2.setPreferredSize(new java.awt.Dimension(800, 600));
        painelFundo.add(jLabel2);
        jLabel2.setBounds(20, 100, 80, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Quantidade Vaga:  ");
        painelFundo.add(jLabel3);
        jLabel3.setBounds(20, 150, 110, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Pré - Requisitos:  ");
        jLabel4.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel4.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel4.setPreferredSize(new java.awt.Dimension(800, 600));
        painelFundo.add(jLabel4);
        jLabel4.setBounds(20, 210, 110, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Função:  ");
        jLabel5.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel5.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel5.setPreferredSize(new java.awt.Dimension(800, 600));
        painelFundo.add(jLabel5);
        jLabel5.setBounds(20, 370, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Faixa Salarial:  ");
        jLabel6.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel6.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel6.setPreferredSize(new java.awt.Dimension(800, 600));
        painelFundo.add(jLabel6);
        jLabel6.setBounds(20, 430, 100, 20);

        txCodigoVaga.setEditable(false);
        painelFundo.add(txCodigoVaga);
        txCodigoVaga.setBounds(180, 50, 60, 20);
        painelFundo.add(txNomeVaga);
        txNomeVaga.setBounds(180, 100, 310, 20);
        painelFundo.add(txQuantidadeVaga);
        txQuantidadeVaga.setBounds(180, 150, 120, 20);
        painelFundo.add(txFuncaoVaga);
        txFuncaoVaga.setBounds(180, 370, 310, 20);
        painelFundo.add(txFaixaVaga);
        txFaixaVaga.setBounds(180, 430, 120, 20);

        btSalvarVaga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btSalvarVaga.setToolTipText("");
        btSalvarVaga.setBorderPainted(false);
        btSalvarVaga.setContentAreaFilled(false);
        btSalvarVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarVagaActionPerformed(evt);
            }
        });
        painelFundo.add(btSalvarVaga);
        btSalvarVaga.setBounds(470, 500, 100, 50);

        btLimparVaga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/limpar.jpg"))); // NOI18N
        btLimparVaga.setToolTipText("");
        btLimparVaga.setBorderPainted(false);
        btLimparVaga.setContentAreaFilled(false);
        btLimparVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparVagaActionPerformed(evt);
            }
        });
        painelFundo.add(btLimparVaga);
        btLimparVaga.setBounds(630, 500, 90, 50);

        txRequisitoVaga.setColumns(20);
        txRequisitoVaga.setRows(5);
        jScrollPane1.setViewportView(txRequisitoVaga);

        painelFundo.add(jScrollPane1);
        jScrollPane1.setBounds(180, 210, 210, 100);

        txMenssagemTreinamento4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento4.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento4.setText("*");
        painelFundo.add(txMenssagemTreinamento4);
        txMenssagemTreinamento4.setBounds(100, 100, 7, 14);

        txMenssagemTreinamento7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento7.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento7.setText("*");
        painelFundo.add(txMenssagemTreinamento7);
        txMenssagemTreinamento7.setBounds(120, 430, 7, 14);

        txMenssagemTreinamento8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento8.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento8.setText("*");
        painelFundo.add(txMenssagemTreinamento8);
        txMenssagemTreinamento8.setBounds(130, 150, 7, 14);

        txMenssagemTreinamento9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento9.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento9.setText("*");
        painelFundo.add(txMenssagemTreinamento9);
        txMenssagemTreinamento9.setBounds(130, 210, 10, 14);

        txMenssagemTreinamento10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txMenssagemTreinamento10.setForeground(new java.awt.Color(255, 0, 0));
        txMenssagemTreinamento10.setText("*");
        painelFundo.add(txMenssagemTreinamento10);
        txMenssagemTreinamento10.setBounds(90, 370, 10, 20);

        getContentPane().add(painelFundo);
        painelFundo.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarVagaActionPerformed


         if(
                 
                Validadores.validaCampoVazio(txNomeVaga.getText(), "Nome Vaga") &&
                 
                Validadores.validaCampoVazio(txQuantidadeVaga.getText(), "Quantidade Vaga") &&
                Validadores.somenteNumeros(txQuantidadeVaga.getText(), "Quantidade Vaga") &&
                 
                Validadores.validaCampoVazio(txRequisitoVaga.getText(), "Pré - Requisito Vaga") &&
         
                Validadores.validaCampoVazio(txFuncaoVaga.getText(), "Função Vaga") &&
                 
                Validadores.validaCampoVazio(txFaixaVaga.getText(), "Faixa Salarial Vaga")  &&
                 Validadores.somenteNumeros(txFaixaVaga.getText(), "Faixa Salarial Vaga")){
        
            
            
            
            
        Vagas vag = new Vagas();

        vag.setNome(txNomeVaga.getText());
        vag.setQtVaga(Integer.parseInt(txQuantidadeVaga.getText()));
        vag.setPreRequisito((txRequisitoVaga.getText()));
        vag.setFuncao(txFuncaoVaga.getText());
        vag.setfaixaSalaria(Double.parseDouble(txFaixaVaga.getText()));

        VagasController vc = new VagasController();
        
        if (!(txCodigoVaga.getText().equals("") |  (txCodigoVaga.getText().equals(null)))){
            
            vag.setCodigo(Integer.parseInt(txCodigoVaga.getText()));
            vc.inserir(vag);
            
            modelo.removeRow(linhaSelecionada);
            modelo.addRow(new Object [] {vag.getCodigo(), vag.getNome(), vag.getQtVaga(),
                vag.getPreRequisito(), vag.getFuncao(), vag.getfaixaSalarial()});
            this.dispose();

        }else{

            vc.inserir(vag);
            this.dispose();
            
        }
        }
    }//GEN-LAST:event_btSalvarVagaActionPerformed

    private void btLimparVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparVagaActionPerformed

    }//GEN-LAST:event_btLimparVagaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimparVaga;
    private javax.swing.JButton btSalvarVaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JTextField txCodigoVaga;
    private javax.swing.JTextField txFaixaVaga;
    private javax.swing.JTextField txFuncaoVaga;
    private javax.swing.JLabel txMenssagemTreinamento10;
    private javax.swing.JLabel txMenssagemTreinamento4;
    private javax.swing.JLabel txMenssagemTreinamento7;
    private javax.swing.JLabel txMenssagemTreinamento8;
    private javax.swing.JLabel txMenssagemTreinamento9;
    private javax.swing.JTextField txNomeVaga;
    private javax.swing.JTextField txQuantidadeVaga;
    private javax.swing.JTextArea txRequisitoVaga;
    // End of variables declaration//GEN-END:variables
}
