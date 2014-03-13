package br.senai.sc.view.list;

import br.senai.sc.controller.EnderecoController;
import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.view.inserir.InserirEndereco;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo_cm
 * @version 1.0 06/11/2013
 */
public class ListaEnderecoGUI extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modelo =
            new DefaultTableModel();

    /**
     * Creates new form ListaPessoa
     */
    public ListaEnderecoGUI() {
        initComponents();
        criaJanela();
        scroll.setViewportView(tabela);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelFundo = new javax.swing.JPanel();
        lbPesquisa = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btInserir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        lbPesquisa.setText("Pesquisa: ");

        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
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

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editar.jpg"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
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

        javax.swing.GroupLayout PainelFundoLayout = new javax.swing.GroupLayout(PainelFundo);
        PainelFundo.setLayout(PainelFundoLayout);
        PainelFundoLayout.setHorizontalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addComponent(lbPesquisa)
                        .addGap(31, 31, 31)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addGroup(PainelFundoLayout.createSequentialGroup()
                        .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        PainelFundoLayout.setVerticalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesquisa)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btEditar)
                    .addComponent(btInserir))
                .addGap(27, 27, 27)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada > 0) {

            int codigoEndereco = (int) tabela.getValueAt(linhaSelecionada, 0);

            int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o endereço? ");
            if (resp == 0) {
                EnderecoController ec = new EnderecoController();
                if (ec.remove(codigoEndereco)) {

                    modelo.removeRow(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Endereço removido com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. ");
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        InserirEndereco ie = new InserirEndereco(modelo);
        ie.setLocationRelativeTo(null);
        ie.setVisible(true);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada > 0) {

            int codigoEndereco = (int) tabela.getValueAt(linhaSelecionada, 0);

            InserirEndereco ie = new InserirEndereco(modelo, linhaSelecionada, codigoEndereco);
            ie.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada. ");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        String text = tfPesquisa.getText();
        
        EnderecoController ec = new EnderecoController();
       
        modelo.setNumRows(0);
        
        for (Endereco p : ec.pesquisar(text)) {
            modelo.addRow(new Object[]{p.getCodigo(), p.getRua(), p.getBairro(), p.getCidade(),
                p.getCep(), p.getComplemento(), p.getNumero()});
    }//GEN-LAST:event_tfPesquisaActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel lbPesquisa;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

/**
* Responsável por cria a tabela
* que gera a lista de dados do Banco de Dados.
* @author gustavo_cm
* @version 1.0 06/11/2013
*/
    private void criaJanela() {
        tabela = new JTable(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Rua");
        modelo.addColumn("Bairro");
        modelo.addColumn("Cidade");
        modelo.addColumn("Cep");
        modelo.addColumn("Complemento");
        modelo.addColumn("Numero");
        preencherJTable();


    }
    
/**
* Responsável pelo prenchimento da tabela com os dados.
* @author gustavo_cm
* @version 1.0 06/11/2013
*/
    private void preencherJTable() {
        EnderecoController pc = new EnderecoController();

        for (Endereco p : pc.listAll()) {
            modelo.addRow(new Object[]{p.getCodigo(), p.getRua(), p.getBairro(), p.getCidade(),
                p.getCep(), p.getComplemento(), p.getNumero()});

        }
    }
}