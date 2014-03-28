package br.senai.sc.view.list;
import br.senai.sc.view.inserir.InserirMedidaGUI;
import br.senai.sc.controller.MedidaController;
import br.senai.sc.model.negocio.Medida;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo_lourenco
 */


public class ListarMedidaGUI extends javax.swing.JFrame {
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();


    
    public ListarMedidaGUI() {
        initComponents();
        criaJTable();
        scrollMedida.setViewportView(tabela);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txPesquisa = new javax.swing.JTextField();
        scrollMedida = new javax.swing.JScrollPane();
        btRemover = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Pesquisar.: ");

        txPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaActionPerformed(evt);
            }
        });

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btRemover.setBorderPainted(false);
        btRemover.setContentAreaFilled(false);
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserir.setBorderPainted(false);
        btInserir.setContentAreaFilled(false);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMedida, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 163, Short.MAX_VALUE))
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(btInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover)))
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btEditar)
                    .addComponent(btInserir))
                .addGap(18, 18, 18)
                .addComponent(scrollMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(painelFundo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed

        InserirMedidaGUI im = new InserirMedidaGUI(modelo);
        im.setLocationRelativeTo(null);
        im.setVisible(true);
        
    }//GEN-LAST:event_btInserirActionPerformed

    
    
    
    
    
    
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
//        int linhaSelecionada = -1;
//        linhaSelecionada = tabela.getSelectedRow();
//        if (linhaSelecionada >= 0) {
//            int idMedida = (int) tabela.getValueAt(linhaSelecionada, 0);
//            MedidaController mc = new MedidaController();
//            InserirMedidaGUI img = new InserirMedidaGUI(modelo, linhaSelecionada, idMedida);
//            img.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
//        }

    }//GEN-LAST:event_btEditarActionPerformed

    
    
    
    
    
    
    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();

        
        if (linhaSelecionada >= 0) {
            int id = (int) tabela.getValueAt(linhaSelecionada, 0);
            
            MedidaController mc = new MedidaController();
            if(mc.excluir(id)); {
                  modelo.removeRow(linhaSelecionada);
        }
            
            
        }
//            try {
//                int idMedida = (int) tabela.getValueAt(linhaSelecionada, 0);
//
//                MedidaController mc = new MedidaController();
//                if (mc.delete(idMedida)) {
//                    modelo.removeRow(linhaSelecionada);
//                }
//            } catch (Exception ex) {
//                System.out.println("Erro ao deletar Medida." + ex.getMessage());
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada.");
//        }
    }//GEN-LAST:event_btRemoverActionPerformed

    
    
    
    
    
    
    private void txPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaActionPerformed

        MedidaController mc = new MedidaController();
        modelo.setNumRows(0);
        
        for (Medida m : mc.pesquisarNome(txPesquisa.getText())) {
                modelo.addRow(new Object[]{m.getCodigo(), m.getAltura(), m.getMdBusto(), m.getMdCintura(),
                m.getMdCintura(), m.getMdOmbros(), m.getMdQuadril()});
    
        }
        
    
  
       
        
        
        
        
        //        String texto = txPesquisa.getText();
//        modelo.setNumRows(0);
//        MedidaController mc = new MedidaController();
//        for (Medida m : mc.pesquisar(texto)) {
//    //        modelo.addRow(new Object[]{m.getCodigo(), m.getUsuario(), m.getAltura(), m.getMdBusto(), m.getMdCintura(), m.getMdOmbros(), m.getMdQuadril()});
//        }

        
        
        
        
        
    }//GEN-LAST:event_txPesquisaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JScrollPane scrollMedida;
    private javax.swing.JTextField txPesquisa;
    // End of variables declaration//GEN-END:variables

    /**
     * Método responsável por criar tabela.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     */
    
    
    
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Altura");
        modelo.addColumn("Busto");
        modelo.addColumn("Cintura");
        modelo.addColumn("Ombros");
        modelo.addColumn("Quadril");
        
        preencherJTable();
    }

    
    
    
    
    
    /**
     * Método reponsável por preencher tabela.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     */
    
    private void preencherJTable() {
        
        MedidaController mc = new MedidaController();
        for (Medida m : mc.listarMedida()){
            modelo.addRow(new Object[]{m.getCodigo(), m.getUsuario(), m.getAltura(), m.getMdBusto(), m.getMdCintura(),
            m.getMdOmbros(), m.getMdQuadril()});
       
       }
        
        
    }
}
