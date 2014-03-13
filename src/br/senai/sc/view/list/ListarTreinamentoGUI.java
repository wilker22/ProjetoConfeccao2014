package br.senai.sc.view.list;

import br.senai.sc.controller.TreinamentoController;
import br.senai.sc.model.negocio.Treinamento;
import br.senai.sc.view.inserir.InserirTreinamentoGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

    /**
     * Interface responsavél por listar treinamento
     * com dados e metodos para executar na classe principal
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param treina
     * @return 
     */

public class ListarTreinamentoGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarTreinamentoGUI() {
        initComponents();

        criaJTable();
        scroll.setViewportView(tabela);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisaTreinamento = new javax.swing.JTextField();
        btInserirTreinamento = new javax.swing.JButton();
        btEditarTreinamento = new javax.swing.JButton();
        btRemoverTreinamento = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setMaximumSize(new java.awt.Dimension(800, 600));
        painelFundo.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pesquisar:  ");

        txPesquisaTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaTreinamentoActionPerformed(evt);
            }
        });

        btInserirTreinamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserirTreinamento.setToolTipText("");
        btInserirTreinamento.setBorderPainted(false);
        btInserirTreinamento.setContentAreaFilled(false);
        btInserirTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirTreinamentoActionPerformed(evt);
            }
        });

        btEditarTreinamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditarTreinamento.setToolTipText("");
        btEditarTreinamento.setBorderPainted(false);
        btEditarTreinamento.setContentAreaFilled(false);
        btEditarTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarTreinamentoActionPerformed(evt);
            }
        });

        btRemoverTreinamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btRemoverTreinamento.setToolTipText("");
        btRemoverTreinamento.setBorderPainted(false);
        btRemoverTreinamento.setContentAreaFilled(false);
        btRemoverTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverTreinamentoActionPerformed(evt);
            }
        });

        scroll.setMaximumSize(new java.awt.Dimension(800, 600));
        scroll.setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txPesquisaTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btInserirTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditarTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btRemoverTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisaTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btRemoverTreinamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditarTreinamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btInserirTreinamento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(painelFundo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirTreinamentoActionPerformed
                
        InserirTreinamentoGUI ivg = new InserirTreinamentoGUI(modelo);
        
        
        ivg.setVisible(true);
        ivg.setLocationRelativeTo(null);
        ivg.setSize(800, 600);
        
    }//GEN-LAST:event_btInserirTreinamentoActionPerformed

    private void btRemoverTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverTreinamentoActionPerformed
        
        int linhaSelecionada = tabela.getSelectedRow();
        
        if(linhaSelecionada >= 0){
            int idTreinamento = (int) tabela.getValueAt(linhaSelecionada, 0);
            
            TreinamentoController tc = new TreinamentoController();
             tc.delete(idTreinamento);
             
             modelo.removeRow(linhaSelecionada);
             
        
        }
        
    }//GEN-LAST:event_btRemoverTreinamentoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       
        //Metodo para limpar os dados repetidos
        modelo.setNumRows(0);
        //Metodo para atualizar a lista quando for acrescentado outro item
        preencherJTable(); 
        
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btEditarTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarTreinamentoActionPerformed
        
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        
       

        if (linhaSelecionada >= 0) {
            int idTreinamento = (int) tabela.getValueAt(linhaSelecionada, 0);

            TreinamentoController tc = new TreinamentoController();
            
            InserirTreinamentoGUI itg = new InserirTreinamentoGUI(modelo, linhaSelecionada, idTreinamento);
            itg.setVisible(true);
            this.dispose();
            

            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha! ");
  
        }
 
    }//GEN-LAST:event_btEditarTreinamentoActionPerformed

    private void txPesquisaTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaTreinamentoActionPerformed
        
        TreinamentoController tc = new TreinamentoController();       
        modelo.setNumRows(0);
        
        for (Treinamento treina: tc.pesquisar(txPesquisaTreinamento.getText())){
            modelo.addRow(new Object[] {treina.getId(), treina.getNome(), treina.getCargaHoraria(), treina.getConteudo()});
        }
    }//GEN-LAST:event_txPesquisaTreinamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditarTreinamento;
    private javax.swing.JButton btInserirTreinamento;
    private javax.swing.JButton btRemoverTreinamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txPesquisaTreinamento;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {

        tabela = new JTable(modelo);
        
        
        modelo.addColumn("Id Treinamento");
        modelo.addColumn("Nome do Treinamento");
        modelo.addColumn("Carga Horária");
        modelo.addColumn("Conteúdo");
        
        preencherJTable();
        

    }

    private void preencherJTable() {

        TreinamentoController pc = new TreinamentoController();
        for (Treinamento treina : pc.ListAll()) {
            modelo.addRow(new Object[]{treina.getId(), treina.getNome(), treina.getCargaHoraria(), treina.getConteudo()});
       
            
            
        }
    }
}