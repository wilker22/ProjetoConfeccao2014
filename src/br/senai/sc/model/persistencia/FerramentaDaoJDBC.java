package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.negocio.Ferramenta;
import br.senai.sc.model.persistencia.ConnectionFactory;
import br.senai.sc.model.persistencia.dao.FerramentaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FerramentaDaoJDBC implements FerramentaDAO {

    private static final String INSERT = "INSERT INTO ferramenta(cod_ferramenta, nm_ferramenta, descricao, cod_fabricante, status) values (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE ferramenta SET cod_ferramenta = ?, nm_ferramenta = ?, descricao = ?, cod_fabricante = ?, dt_cadastro = ?, status = ? WHERE cod_produto = ?";
    private static final String DELETE = "DELETE FROM ferramenta WHERE cod_ferramenta = ?";
    private static final String LIST = "SELECT fr.cod_ferramenta, fr.nm_ferramenta, fr.descricao, fr.dt_cadastro, fr.status, fr.cod_fabricante, fa.nmfantasia, fa.cnpj, fa.telefone, fa.email, fa.endereco FROM ferramenta fr LEFT JOIN fabricante fa on  fr.cod_fabricante = fa.cod_fabricante ";
    private static final String LISTBYID = "SELECT fr.cod_ferramenta, fr.nm_ferramenta, fr.descricao, fr.dt_cadastro, fr.status, fr.cod_fabricante, fa.nmfantasia, fa.cnpj, fa.telefone, fa.email, fa.endereco FROM ferramenta fr LEFT JOIN fabricante fa on  fr.cod_fabricante = fa.cod_fabricante  WHERE cod_ferramenta = ?";
    private static final String LISTPESQUISA = "SELECT fr.cod_ferramenta, fr.nm_ferramenta, fr.descricao, fr.dt_cadastro, fr.status, fr.cod_fabricante, fa.nmfantasia, fa.cnpj, fa.telefone, fa.email, fa.endereco FROM ferramenta fr LEFT JOIN fabricante fa on  fr.cod_fabricante = fa.cod_fabricante  WHERE cod_ferramenta LIKE ? OR nome LIKE ?";
    
    /**
     * Método responsável pela inserção de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param f
     * @return 
     */
    public int insert(Ferramenta f) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, f.getCodFerramenta());
            pstm.setString(2, f.getNome());
            pstm.setString(3, f.getDescricao());
            pstm.setInt(4, f.getNmFabricante().getCod());
            pstm.setString(5, f.getStatus());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = (rs.getInt(1));
                }
            }
            ConnectionFactory.closeConnection(conn, pstm);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            return retorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                //Fecha a conxão
                ConnectionFactory.closeConnection(conn);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex1.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método responsável pela atualização de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param f
     * @return 
     */
    public int update(Ferramenta f) {
        int retorno = -1;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setInt(1, f.getCodFerramenta());
            pstm.setString(2, f.getNome());
            pstm.setString(3, f.getDescricao());
            pstm.setInt(4, f.getNmFabricante().getCod());
            pstm.setDate(5, (Date) f.getDtCadastro());
            pstm.setString(6, f.getStatus());
            pstm.execute();
            retorno = f.getCodFerramenta();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar " + ex.getMessage());
        } finally {
            try {
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método responsável pela remoção de uma ferramenta
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param codFerramenta
     * @return 
     */
    public boolean delete(int codFerramenta) {
        boolean retorno = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, codFerramenta);
            pstm.execute();
            retorno = true;
            System.out.println(retorno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
        } finally {
            try {
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return retorno;
    }

    /**
     * Método responsável pela listagem de ferramentas com o código enviado pelo parametro
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @return 
     */
    @Override
    public List<Ferramenta> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ferramenta> ferramentas = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Ferramenta f = new Ferramenta();
                
                Fabricante fa = new Fabricante();
                fa.setCod(rs.getInt("cod_fabricante"));
                fa.setCnpj(rs.getString("cnpj"));
                fa.setNmFantasia(rs.getString("nmfantasia"));
                fa.setEmail(rs.getString("email"));
                fa.setTelefone(rs.getString("telefone"));
                fa.setEndereco(rs.getString("endereco"));;
                
                f.setCodFerramenta(rs.getInt("cod_ferramenta"));
                f.setNome(rs.getString("nm_ferramenta"));
                f.setDescricao(rs.getString("descricao"));
                f.setNmFabricante(fa);
                f.setDtCadastro(rs.getDate("dt_cadastro"));
                f.setStatus(rs.getString("status"));
                ferramentas.add(f);
                
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return ferramentas;
    }

    /**
     * Método responsável pela listagem de ferramentas pelo id
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param codFerramenta
     * @return 
     */
    public Ferramenta listById(int codFerramenta) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Ferramenta f = new Ferramenta();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, codFerramenta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                            
                Fabricante fa = new Fabricante();
                fa.setCod(rs.getInt("cod_fabricante"));
                fa.setCnpj(rs.getString("cnpj"));
                fa.setNmFantasia(rs.getString("nmfantasia"));
                fa.setEmail(rs.getString("email"));
                fa.setTelefone(rs.getString("telefone"));
                fa.setEndereco(rs.getString("endereco"));
                
                f.setCodFerramenta(rs.getInt("cod_ferramenta"));
                f.setNome(rs.getString("nm_ferramenta"));
                f.setDescricao(rs.getString("descricao"));
                f.setNmFabricante(fa);
                f.setDtCadastro(rs.getDate("dt_cadastro"));
                f.setStatus(rs.getString("status"));
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return f;
    }

    /**
     * Método responsável pela listagem de ferramentas, com filtragem, mostrando apenas correspondentes que tiverem ao menos parte do digitado
     * @author Ariane Souza da Silva
     * @version 1.0 05/11/2013
     * @param texto
     * @return 
     */
    public List<Ferramenta> listPesquisa(String texto) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ferramenta> ferramentas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTPESQUISA);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Ferramenta f = new Ferramenta();
                
                Fabricante fa = new Fabricante();
                fa.setCod(rs.getInt("cod_fabricante"));
                fa.setCnpj(rs.getString("cnpj"));
                fa.setNmFantasia(rs.getString("nmfantasia"));
                fa.setEmail(rs.getString("email"));
                fa.setTelefone(rs.getString("telefone"));
                fa.setEndereco(rs.getString("endereco"));
                
                f.setCodFerramenta(rs.getInt("cod_ferramenta"));
                f.setNome(rs.getString("nm_ferramenta"));
                f.setDescricao(rs.getString("descricao"));
                f.setNmFabricante(fa);
                f.setDtCadastro(rs.getDate("dt_cadastro"));
                f.setStatus(rs.getString("status"));
                ferramentas.add(f);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return ferramentas;
    }
}
