package br.senai.sc.view.list;

import br.senai.sc.controller.EntradaController;
import br.senai.sc.model.negocio.Entrada;
import br.senai.sc.view.inserir.InserirEntradaGUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nathan_bettiol
 * @version 1.0 09/10/2013
 */
public class ListarEntradaGUI extends javax.swing.JFrame { 

    private DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabela;

    public ListarEntradaGUI()  {
        initComponents();
        criaJTable();
       
        
        
        scrollAssistencia.setViewportView(tabela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        painelAssistencia = new javax.swing.JPanel();
        txBuscar = new javax.swing.JTextField();
        scrollAssistencia = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        btInserir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jButton1.setText("jButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelAssistencia.setBackground(new java.awt.Color(255, 255, 255));

        txBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Pesquisar:  ");

        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inserir.jpg"))); // NOI18N
        btInserir.setBorderPainted(false);
        btInserir.setContentAreaFilled(false);
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setToolTipText("");
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deletar.jpg"))); // NOI18N
        btDeletar.setToolTipText("");
        btDeletar.setBorderPainted(false);
        btDeletar.setContentAreaFilled(false);
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAssistenciaLayout = new javax.swing.GroupLayout(painelAssistencia);
        painelAssistencia.setLayout(painelAssistenciaLayout);
        painelAssistenciaLayout.setHorizontalGroup(
            painelAssistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAssistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAssistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollAssistencia)
                    .addGroup(painelAssistenciaLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 273, Short.MAX_VALUE))
                    .addGroup(painelAssistenciaLayout.createSequentialGroup()
                        .addComponent(btInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btDeletar)))
                .addContainerGap())
        );
        painelAssistenciaLayout.setVerticalGroup(
            painelAssistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAssistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAssistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelAssistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btInserir)
                    .addComponent(btEditar)
                    .addComponent(btDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollAssistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAssistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAssistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
 
        InserirEntradaGUI it = new InserirEntradaGUI();
        it.setLocationRelativeTo(null);
        it.setVisible(true);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       int linhaSelecionada = -1;

        linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int idEntrada = (int) tabela.getValueAt(linhaSelecionada, 0);

            InserirEntradaGUI icc = new InserirEntradaGUI(modelo);
            icc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma linha foi selecionada.");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
  Entrada en = new Entrada();
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >=0){
            int idEntrada = (int)
                    tabela.getValueAt(linhaSelecionada, 0);
            en.setCodigo(idEntrada);
            EntradaController ec = new EntradaController();
            if (ec.remove(en.getCodigo())){
                
                modelo.removeRow(linhaSelecionada);
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha");
    }       
      
        
      
    }//GEN-LAST:event_btDeletarActionPerformed
 
    private void txBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBuscarActionPerformed
        String nome = txBuscar.getText();
        modelo.setNumRows(0);
        EntradaController ccc = new EntradaController();
        for (Entrada cc : ccc.listarTodos()) {
            modelo.addRow(new Object[]{cc.getCodigo(), cc.getDtEmissao(), cc.getProduto().getCodProduto(), cc.getFuncionario().getCod(), cc.getNotaFiscal(), cc.getPreco(), cc.getQtProduto()});
    }//GEN-LAST:event_txBuscarActionPerformed
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel painelAssistencia;
    private javax.swing.JScrollPane scrollAssistencia;
    private javax.swing.JTextField txBuscar;
    // End of variables declaration//GEN-END:variables

    private void criaJTable()  {
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Data de Emissão");
        modelo.addColumn("Código produto");
        modelo.addColumn("Código funcionário");
        modelo.addColumn("Código nota fiscal");
        modelo.addColumn("Preço");
        modelo.addColumn("Quantidade");
        preencherJTable();
    }

    private void preencherJTable() {
        EntradaController ec = new EntradaController();
        for (Entrada e : ec.listarTodos()) {
            modelo.addRow(new Object[]{e.getCodigo(), e.getDtEmissao(), e.getProduto().getCodProduto(), e.getFuncionario().getCod(), e.getNotaFiscal(), e.getPreco(), e.getQtProduto()});
        }
    }
}
