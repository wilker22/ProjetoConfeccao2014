/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.TipoMaquinaAssistencia;
import br.senai.sc.model.persistencia.dao.TipoMaquinaAssistenciaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Gabriel Arsênio
 * @version 1.0 01/10/2013
 */
public class TipoMaquinaAssistenciaDaoJDBC implements TipoMaquinaAssistenciaDAO {

    //Strings com os comandos SQL
    private static final String INSERT = "INSERT INTO tipo_maquina_assistencia VALUES "
            + "(null, ?)";
    private static final String UPDATE = "UPDATE tipo_maquina_assistencia set cod_tipo_maquina_assistencia"
            + " where cod_tipo_maquina_assistencia = ?";
    private static final String DELETE = "DELETE FROM tipo_maquina_assistencia "
            + "WHERE cod_categoria = ?";
    private static final String SELECT = "select * from tipo_maquina_assistencia";

    @Override
    public boolean insert(TipoMaquinaAssistencia tma) throws SQLException {
        //Cria uma nova conexão
        Connection con = null;
        try {
            //Abre a conexão 'con'
            con = ConnectionFactory.getConnection();
            //Recebe a String com o comando SQL, no caso, o comando INSERT
            PreparedStatement pstm = con.prepareStatement(INSERT);
            //Subustitui os pontos de interrogação do comando
            pstm.setInt(1, 1);
            
            //Executa o comando SQL
            pstm.execute();
            //Fecha a conexão
            ConnectionFactory.closeConnection(con, pstm);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
            //Fecha a conxão
            ConnectionFactory.closeConnection(con);
            return false;
        }
    }

    @Override
    public boolean update(TipoMaquinaAssistencia tma) throws SQLException {
        //Cria uma nova conexão
        Connection con = null;
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Prepara o comando SQL
            PreparedStatement pstm = con.prepareStatement(UPDATE);
            //Substitui os pontos de interrogação do comando
            pstm.setInt(1, tma.getCodTipoMaquina());
            pstm.setInt(2, tma.getAssistenciaTipoMaquina().getCod());
            //Executa o comando
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            //Fecha a conexão
            ConnectionFactory.closeConnection(con, pstm);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
            ConnectionFactory.closeConnection(con);
            return false;
        }
    }

    @Override
    public boolean delete(int cod) throws SQLException {
        //Cria uma nova conexão
        Connection con = null;
        try {
            //Abre a conexão
            con = ConnectionFactory.getConnection();
            //Executa o comando SQL
            PreparedStatement pstm = con.prepareStatement(DELETE);
            //Substitui os pontos de interrogação do comando            
            pstm.setInt(1, cod);
            //Executa o comando
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            //Fecha a conexão e o statement
            ConnectionFactory.closeConnection(con, pstm);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
            //Fecha a conexão
            ConnectionFactory.closeConnection(con);
            return false;
        }
    }

    @Override
    public List<TipoMaquinaAssistenciaDAO> listAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
