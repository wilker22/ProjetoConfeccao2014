package br.senai.sc.view.list;

import br.senai.sc.controller.VagasController;
import br.senai.sc.model.negocio.Vagas;
import br.senai.sc.view.inserir.InserirVagasGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

    /**
     * Interface responsavél por listar vagas
     * com dados e metodos para executar na classe principal
     * @author Bruna Zakrzeski
     * @since 1.0  05/11/2013
     * @param vag
     * @return 
     */

public class ListarVagasGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarVagasGUI() {
        initComponents();

        criaJTable();
        scroll.setViewportView(tabela);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisaVagas = new javax.swing.JTextField();
        btInserirVagas = new javax.swing.JButton();
        btEditarVagas = new javax.swing.JButton();
        btRemoverVagas = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(null);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pesquisar:  ");

        txPesquisaVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaVagasActionPerformed(evt);
            }
        });

        btInserirVagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserirVagas.setToolTipText("");
        btInserirVagas.setBorderPainted(false);
        btInserirVagas.setContentAreaFilled(false);
        btInserirVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirVagasActionPerformed(evt);
            }
        });

        btEditarVagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditarVagas.setToolTipText("");
        btEditarVagas.setBorderPainted(false);
        btEditarVagas.setContentAreaFilled(false);
        btEditarVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarVagasActionPerformed(evt);
            }
        });

        btRemoverVagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btRemoverVagas.setToolTipText("");
        btRemoverVagas.setBorderPainted(false);
        btRemoverVagas.setContentAreaFilled(false);
        btRemoverVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverVagasActionPerformed(evt);
            }
        });

        scroll.setMaximumSize(new java.awt.Dimension(800, 600));
        scroll.setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txPesquisaVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(btInserirVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditarVagas)
                        .addGap(42, 42, 42)
                        .addComponent(btRemoverVagas)
                        .addGap(92, 92, 92))
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))))
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisaVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEditarVagas)
                            .addComponent(btRemoverVagas)))
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btInserirVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        getContentPane().add(painelFundo);
        painelFundo.setBounds(0, 0, 800, 697);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirVagasActionPerformed
                
        InserirVagasGUI ivg = new InserirVagasGUI(modelo);
        
        ivg.setVisible(true);
        ivg.setLocationRelativeTo(null);
        ivg.setSize(800, 600);
        
        
    }//GEN-LAST:event_btInserirVagasActionPerformed

    
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
         
        modelo.setNumRows(0);
        //Metodo para atualizar a lista quando for acrescentado outro item
        preencherJTable(); 
        
        
        
        
        
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btRemoverVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverVagasActionPerformed
        
        int linhaSelecionada = tabela.getSelectedRow();
        
        if(linhaSelecionada >= 0){
            int codVaga = (int) tabela.getValueAt(linhaSelecionada, 0);
            
            VagasController vc = new VagasController();
             vc.delete(codVaga);
             
             modelo.removeRow(linhaSelecionada);
             
             
             
        }      
    }//GEN-LAST:event_btRemoverVagasActionPerformed

    private void btEditarVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarVagasActionPerformed
        
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        
        if (linhaSelecionada >= 0) {
            int codVaga = (int) tabela.getValueAt(linhaSelecionada, 0);

            VagasController tc = new VagasController();
            
            InserirVagasGUI ivg = new InserirVagasGUI(modelo, linhaSelecionada, codVaga);
            ivg.setVisible(true);
            this.dispose();

            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha! ");

        }
    }//GEN-LAST:event_btEditarVagasActionPerformed

    
    private void txPesquisaVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaVagasActionPerformed
        
        VagasController vc = new VagasController();       
        modelo.setNumRows(0);
        
        for (Vagas vag: vc.pesquisar(txPesquisaVagas.getText())){
            modelo.addRow(new Object[] {vag.getCodigo(), vag.getNome(), vag.getQtVaga(), vag.getPreRequisito(), vag.getFuncao(), vag.getfaixaSalarial()});
        }
    }//GEN-LAST:event_txPesquisaVagasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditarVagas;
    private javax.swing.JButton btInserirVagas;
    private javax.swing.JButton btRemoverVagas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txPesquisaVagas;
    // End of variables declaration//GEN-END:variables

    private void criaJTable() {

        tabela = new JTable(modelo);

        modelo.addColumn("Código Vagas");
        modelo.addColumn("Nome Vagas");
        modelo.addColumn("Quantidade Vagas");
        modelo.addColumn("Pré - Requisítos");
        modelo.addColumn("Função");
        modelo.addColumn("Faixa Salarial");
        
        preencherJTable();

    }

    private void preencherJTable() {

        VagasController pc = new VagasController();
        
        for (Vagas vag : pc.ListAll()) {
            modelo.addRow(new Object[]{vag.getCodigo(), vag.getNome(), vag.getQtVaga(), vag.getPreRequisito(), vag.getFuncao(), vag.getfaixaSalarial()});
       
        }
    }
}