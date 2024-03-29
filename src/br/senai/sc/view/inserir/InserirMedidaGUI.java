package br.senai.sc.view.inserir;
import br.senai.sc.controller.MedidaController;
import br.senai.sc.controller.UsuarioController;
import br.senai.sc.model.negocio.Medida;
import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.validador.Validadores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */


public class InserirMedidaGUI extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private int linhaSelecionada;


    public InserirMedidaGUI(DefaultTableModel modelo) {
        initComponents();
        setLocationRelativeTo(null);
        this.modelo = modelo;
        carregarCombo();
    }

    
    
    
    /**
     * Construtor responsável por carregar valores nos campo quando acionado
     * botão editar;
     *
     * @param modelo
     * @param linhaSelecionada
     * @param idMedida
     */
    
    public InserirMedidaGUI(DefaultTableModel modelo, int linhaSelecionada, int idMedida) {
        initComponents();
        this.modelo = modelo;
        this.linhaSelecionada = linhaSelecionada;
        setLocationRelativeTo(null);

        MedidaController mc = new MedidaController();
        Medida m = mc.listarMedidaById(idMedida);

        txId.setText(String.valueOf(m.getCodigo()));
        txAltura.setText(String.valueOf(m.getAltura()));
        txMdBusto.setText(String.valueOf(m.getMdBusto()));
        txMdCintura.setText(String.valueOf(m.getMdCintura()));
        txMdOmbros.setText(String.valueOf(m.getMdOmbros()));
        txMdQuadril.setText(String.valueOf(m.getMdQuadril()));
        carregarCombo();

    }


    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txMdBusto = new javax.swing.JTextField();
        txMdCintura = new javax.swing.JTextField();
        txMdQuadril = new javax.swing.JTextField();
        txMdOmbros = new javax.swing.JTextField();
        txAltura = new javax.swing.JTextField();
        cbNome = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 18), java.awt.Color.black)); // NOI18N

        jLabel1.setText("Id.:  ");

        txId.setEditable(false);

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
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome.:");

        jLabel9.setText("Medida Busto.:");

        jLabel10.setText("Medida Cintura.: ");

        jLabel11.setText("Medida Quadril.: ");

        jLabel12.setText("Medida Ombros.: ");

        jLabel13.setText("Altura.:");

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txAltura)
                            .addComponent(txMdOmbros)
                            .addComponent(txMdQuadril)
                            .addComponent(txMdCintura)
                            .addComponent(txMdBusto)
                            .addComponent(txId)
                            .addComponent(cbNome, 0, 138, Short.MAX_VALUE))
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFundoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)))
                .addComponent(btLimpar)
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txMdBusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txMdCintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txMdQuadril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txMdOmbros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (Validadores.validaCampoVazio(txMdBusto.getText(), "BUSTO")
                && Validadores.validaCampoVazio(txMdCintura.getText(), "CINTURA")
                && Validadores.validaCampoVazio(txMdQuadril.getText(), "QUADRIL")
                && Validadores.validaCampoVazio(txMdOmbros.getText(), "OMBROS")
                && Validadores.validaCampoVazio(txAltura.getText(), "ALTURA")
                && Validadores.validaDouble(txMdBusto.getText(), "BUSTO")
                && Validadores.validaDouble(txMdCintura.getText(), "CINTURA")
                && Validadores.validaDouble(txMdQuadril.getText(), "QUADRIL")
                && Validadores.validaDouble(txMdOmbros.getText(), "OMBROS")
                && Validadores.validaDouble(txAltura.getText(), "ALTURA")) {


            Medida m = new Medida();

            m.setUsuario((Usuario) cbNome.getSelectedItem());
            m.setAltura(Double.parseDouble(txAltura.getText()));
            m.setMdCintura(Double.parseDouble(txMdCintura.getText()));
            m.setMdBusto(Double.parseDouble(txMdBusto.getText()));
            m.setMdOmbros(Double.parseDouble(txMdOmbros.getText()));
            m.setMdQuadril(Double.parseDouble(txMdQuadril.getText()));

            MedidaController mc = new MedidaController();
            Medida med = mc.salvar(m);
            
        if(med != null){
        modelo.addRow(new Object[] {m.getCodigo(), m.getAltura(), m.getMdCintura(), m.getMdBusto(),
        m.getMdOmbros(), m.getMdQuadril()});
        dispose();
        }

       }
    }//GEN-LAST:event_btSalvarActionPerformed

    
    
    
    
    
    
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txAltura.setText("");
        txMdCintura.setText("");
        txMdBusto.setText("");
        txMdOmbros.setText("");
        txMdQuadril.setText("");

        
        
        
    }//GEN-LAST:event_btLimparActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JTextField txAltura;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txMdBusto;
    private javax.swing.JTextField txMdCintura;
    private javax.swing.JTextField txMdOmbros;
    private javax.swing.JTextField txMdQuadril;
    // End of variables declaration//GEN-END:variables

    
    
    
    /**
     * Método responsável por carregar dados da tabela usuario.
     *
     * @author Gustavo L. Alves
     * @since 1.0 05/11/2013
     */
    private void carregarCombo() {

        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbNome.getModel();
        comboModel.removeAllElements();
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioController uc = new UsuarioController();
        usuarios = uc.listAll();

        for (int linha = 0; linha < usuarios.size(); linha++) {
            Usuario u = usuarios.get(linha);
            comboModel.addElement(u);
        }
    }

}