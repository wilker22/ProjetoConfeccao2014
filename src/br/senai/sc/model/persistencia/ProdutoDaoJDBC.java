package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.CategoriaColecao;
import br.senai.sc.model.negocio.CategoriaProduto;
import br.senai.sc.model.negocio.Colecao;
import br.senai.sc.model.negocio.Fabricante;
import br.senai.sc.model.negocio.Funcionario;
import br.senai.sc.model.negocio.Produto;
import br.senai.sc.model.persistencia.dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDaoJDBC implements ProdutoDAO {

    private final String INSERT = "INSERT INTO produtos (cod_categoria, cod_colecao, cod_fabricante, modelo, nome, preco, tamanho, cor, qt_produtos)VALUES(?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE produtos SET cod_categoria = ?, cod_colecao = ?, cod_fabricante = ?, modelo = ?, nome = ?, preco = ?, tamanho = ?, cor = ?, qt_produtos = ? WHERE cod_produto = ?";
    private final String DELETE = "DELETE FROM produtos WHERE cod_produto = ?";
    private final String LIST = "SELECT p.cod_produto, p.nome, p.modelo, p.preco, p.cor, p.tamanho, p.qt_produtos, "
            + "cp.cod_categoria, cp.nome AS categoria, cp.descricao, "
            + "f.cod_fabricante, f.nmfantasia, f.cnpj, f.razao_social, f.dt_cadastro AS dt_cadastro_fabricante, f.telefone, f.email, f.endereco, "
            + "c.cod_colecao, c.estacao, c.ano, c.pub_alvo, c.cod_funcionario, c.categoria_colecao_cod_categoria, "
            + "cc.cod_categoria AS cod_categoria_colecao, cc.nm_categoria_colecao, cc.descricao AS descricao_categoria_colecao, "
            + "fn.cod_funcionario, fn.login, fn.ctps, fn.cargo, fn.salario, fn.dt_admissao, fn.dt_recisao, fn.nome AS funcionario, fn.cpf, fn.rg, fn.dt_nascimento, fn.telefone, fn.endereco AS end_funcionario, fn.dt_cadastro AS dt_cadastro_funcionario "
            + "FROM produtos p "
            + "LEFT JOIN categoria_produto cp ON (cp.cod_categoria = p.cod_categoria) "
            + "LEFT JOIN colecao c ON (c.cod_colecao = p.cod_colecao) "
            + "LEFT JOIN categoria_colecao cc ON (c.categoria_colecao_cod_categoria = cc.cod_categoria) "
            + "LEFT JOIN funcionario fn ON (c.cod_funcionario = fn.cod_funcionario) "
            + "LEFT JOIN fabricante f ON (f.cod_fabricante = p.cod_categoria)";
    private final String LISTBYID = "SELECT p.cod_produto, p.nome, p.modelo, p.preco, p.cor, p.tamanho, p.qt_produtos, "
            + "cp.cod_categoria, cp.nome AS categoria, cp.descricao, "
            + "f.cod_fabricante, f.nmfantasia, f.cnpj, f.razao_social, f.dt_cadastro AS dt_cadastro_fabricante, f.telefone, f.email, f.endereco, "
            + "c.cod_colecao, c.estacao, c.ano, c.pub_alvo, c.cod_funcionario, c.categoria_colecao_cod_categoria, "
            + "cc.cod_categoria AS cod_categoria_colecao, cc.nm_categoria_colecao, cc.descricao AS descricao_categoria_colecao, "
            + "fn.cod_funcionario, fn.login, fn.ctps, fn.cargo, fn.salario, fn.dt_admissao, fn.dt_recisao, fn.nome AS funcionario, fn.cpf, fn.rg, fn.dt_nascimento, fn.telefone, fn.endereco AS end_funcionario, fn.dt_cadastro AS dt_cadastro_funcionario "
            + "FROM produtos p "
            + "LEFT JOIN categoria_produto cp ON (cp.cod_categoria = p.cod_categoria) "
            + "LEFT JOIN colecao c ON (c.cod_colecao = p.cod_categoria) "
            + "LEFT JOIN categoria_colecao cc ON (c.categoria_colecao_cod_categoria = cc.cod_categoria) "
            + "LEFT JOIN funcionario fn ON (c.cod_funcionario = fn.cod_funcionario) "
            + "LEFT JOIN fabricante f ON (f.cod_fabricante = p.cod_categoria) "
            + "WHERE p.cod_produto = ?";
    private final String SEARCH = "SELECT p.cod_produto, p.nome, p.modelo, p.preco, p.cor, p.tamanho, p.qt_produtos, "
            + "cp.cod_categoria, cp.nome AS categoria, cp.descricao, "
            + "f.cod_fabricante, f.nmfantasia, f.cnpj, f.razao_social, f.dt_cadastro AS dt_cadastro_fabricante, f.telefone, f.email, f.endereco, "
            + "c.cod_colecao, c.estacao, c.ano, c.pub_alvo, c.cod_funcionario, c.categoria_colecao_cod_categoria, "
            + "cc.cod_categoria AS cod_categoria_colecao, cc.nm_categoria_colecao, cc.descricao AS descricao_categoria_colecao, "
            + "fn.cod_funcionario, fn.login, fn.ctps, fn.cargo, fn.salario, fn.dt_admissao, fn.dt_recisao, fn.nome AS funcionario, fn.cpf, fn.rg, fn.dt_nascimento, fn.telefone, fn.endereco AS end_funcionario, fn.dt_cadastro AS dt_cadastro_funcionario "
            + "FROM produtos p "
            + "LEFT JOIN categoria_produto cp ON (cp.cod_categoria = p.cod_categoria) "
            + "LEFT JOIN colecao c ON (c.cod_colecao = p.cod_categoria) "
            + "LEFT JOIN categoria_colecao cc ON (c.categoria_colecao_cod_categoria = cc.cod_categoria) "
            + "LEFT JOIN funcionario fn ON (c.cod_funcionario = fn.cod_funcionario) "
            + "LEFT JOIN fabricante f ON (f.cod_fabricante = p.cod_categoria) "
            + "WHERE p.cod_produto LIKE ? OR p.nome LIKE ? OR p.modelo LIKE ? OR p.preco LIKE ? OR "
            + "p.cor LIKE ? OR p.tamanho LIKE ? OR p.qt_produtos LIKE ? OR cp.nome LIKE ? OR f.nmfantasia LIKE ? OR c.estacao LIKE ?";

    /**
     * Método responsável pela inserção de dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param p
     * @return
     */
    @Override
    public boolean insert(Produto p) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, p.getCategoria().getCodCategoriaProduto());
            pstm.setInt(2, p.getColecao().getCodColecao());
            pstm.setInt(3, p.getFabricante().getCod());
            pstm.setString(4, p.getModelo());
            pstm.setString(5, p.getNome());
            pstm.setDouble(6, p.getPreco());
            pstm.setString(7, p.getTamanho());
            pstm.setString(8, p.getCor());
            pstm.setInt(9, p.getQtProdutos());
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setCodProduto(rs.getInt(1));
                }
            }
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação " + e.getMessage());
            return false;
        }
    }

    /**
     * Método responsável pela atualização de dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param p
     * @return
     */
    @Override
    public boolean update(Produto p) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setInt(1, p.getCategoria().getCodCategoriaProduto());
            pstm.setInt(2, p.getColecao().getCodColecao());
            pstm.setInt(3, p.getFabricante().getCod());
            pstm.setString(4, p.getModelo());
            pstm.setString(5, p.getNome());
            pstm.setDouble(6, p.getPreco());
            pstm.setString(7, p.getTamanho());
            pstm.setString(8, p.getCor());
            pstm.setInt(9, p.getQtProdutos());
            pstm.setInt(10, p.getCodProduto());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação");
            return false;
        }
    }

    /**
     * Método responsável pela exclusão de dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codProduto
     * @return
     */
    @Override
    public boolean delete(int codProduto) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codProduto);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Transação efetuada com sucesso");
            ConnectionFactory.closeConnection(conn, pstm);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação" + e.getMessage());
            return false;
        }
    }

    /**
     * Método responsável por listar todos os dados da tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @return
     */
    @Override
    public List<Produto> listAll() {
        Connection conn;
        List<Produto> produtos = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();

                CategoriaProduto cp = new CategoriaProduto();
                cp.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                cp.setNomeCategoriaProduto(rs.getString("categoria"));
                cp.setDescricaoCategoriaProduto(rs.getString("descricao"));

                CategoriaColecao cc = new CategoriaColecao();
                cc.setCodCategoriaColecao(rs.getInt("cod_categoria_colecao"));
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                cc.setDescricaoCategoriaColecao(rs.getString("descricao_categoria_colecao"));

                Funcionario fn = new Funcionario();
                fn.setCod(rs.getInt("cod_categoria_colecao"));
                fn.setLogin(rs.getString("login"));
                fn.setEmail(rs.getString("email"));
                fn.setCtps(rs.getString("ctps"));
                fn.setCargo(rs.getString("cargo"));
                fn.setSalario(rs.getDouble("salario"));
                fn.setDtAdmissao(rs.getDate("dt_admissao"));
                fn.setDtRecisao(rs.getDate("dt_recisao"));
                fn.setNome(rs.getString("funcionario"));
                fn.setCpf(rs.getString("cpf"));
                fn.setRg(rs.getString("rg"));
                fn.setDtNascimento(rs.getDate("dt_nascimento"));
                fn.setTelefone(rs.getString("telefone"));
                fn.setEndereco(rs.getString("end_funcionario"));
                fn.setDtCadastro(rs.getDate("dt_cadastro_funcionario"));

                Fabricante f = new Fabricante();
                f.setCod(rs.getInt("cod_fabricante"));
                f.setNmFantasia(rs.getString("nmfantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));

                Colecao c = new Colecao();
                c.setCodColecao(rs.getInt("cod_colecao"));
                c.setEstacaoColecao(rs.getString("estacao"));
                c.setAnoColecao(rs.getInt("ano"));
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                c.setFunResponsavelColecao(fn);
                c.setCategoriaColecao(cc);

                p.setCodProduto(rs.getInt("cod_produto"));
                p.setCategoria(cp);
                p.setColecao(c);
                p.setFabricante(f);
                p.setNome(rs.getString("nome"));
                p.setModelo(rs.getString("modelo"));
                p.setPreco(rs.getDouble("preco"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                p.setQtProdutos(rs.getInt("qt_produtos"));

                produtos.add(p);

            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação");
        }
        return produtos;
    }

    /**
     * Método responsável por listar por ID os dados da tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param codProduto
     * @return
     */
    @Override
    public Produto listById(int codProduto) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, codProduto);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();

                CategoriaProduto cp = new CategoriaProduto();
                cp.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                cp.setNomeCategoriaProduto(rs.getString("categoria"));
                cp.setDescricaoCategoriaProduto(rs.getString("descricao"));

                CategoriaColecao cc = new CategoriaColecao();
                cc.setCodCategoriaColecao(rs.getInt("cod_categoria_colecao"));
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                cc.setDescricaoCategoriaColecao(rs.getString("descricao_categoria_colecao"));

                Funcionario fn = new Funcionario();
                fn.setCod(rs.getInt("cod_categoria_colecao"));
                fn.setLogin(rs.getString("login"));
                fn.setEmail(rs.getString("email"));
                fn.setCtps(rs.getString("ctps"));
                fn.setCargo(rs.getString("cargo"));
                fn.setSalario(rs.getDouble("salario"));
                fn.setDtAdmissao(rs.getDate("dt_admissao"));
                fn.setDtRecisao(rs.getDate("dt_recisao"));
                fn.setNome(rs.getString("funcionario"));
                fn.setCpf(rs.getString("cpf"));
                fn.setRg(rs.getString("rg"));
                fn.setDtNascimento(rs.getDate("dt_nascimento"));
                fn.setTelefone(rs.getString("telefone"));
                fn.setEndereco(rs.getString("end_funcionario"));
                fn.setDtCadastro(rs.getDate("dt_cadastro_funcionario"));

                Fabricante f = new Fabricante();
                f.setCod(rs.getInt("cod_fabricante"));
                f.setNmFantasia(rs.getString("nmfantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));

                Colecao c = new Colecao();
                c.setCodColecao(rs.getInt("cod_colecao"));
                c.setEstacaoColecao(rs.getString("estacao"));
                c.setAnoColecao(rs.getInt("ano"));
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                c.setFunResponsavelColecao(fn);
                c.setCategoriaColecao(cc);

                p.setCodProduto(rs.getInt("cod_produto"));
                p.setCategoria(cp);
                p.setColecao(c);
                p.setFabricante(f);
                p.setNome(rs.getString("nome"));
                p.setModelo(rs.getString("modelo"));
                p.setPreco(rs.getDouble("preco"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                p.setQtProdutos(rs.getInt("qt_produtos"));

                return p;
            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação");
        }
        return null;
    }

    /**
     * Método responsável por pesquisar dados na tabela produtos
     *
     * @author Gustavo Motta Agustinho
     * @version 1.0 05/11/2013
     * @param texto
     * @return
     */
    @Override
    public List<Produto> search(String texto) {

        Connection conn;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(SEARCH);
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            pstm.setString(4, "%" + texto + "%");
            pstm.setString(5, "%" + texto + "%");
            pstm.setString(6, "%" + texto + "%");
            pstm.setString(7, "%" + texto + "%");
            pstm.setString(8, "%" + texto + "%");
            pstm.setString(9, "%" + texto + "%");
            pstm.setString(10, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();

                CategoriaProduto cp = new CategoriaProduto();
                cp.setCodCategoriaProduto(rs.getInt("cod_categoria"));
                cp.setNomeCategoriaProduto(rs.getString("categoria"));
                cp.setDescricaoCategoriaProduto(rs.getString("descricao"));

                CategoriaColecao cc = new CategoriaColecao();
                cc.setCodCategoriaColecao(rs.getInt("cod_categoria_colecao"));
                cc.setNomeCategoriaColecao(rs.getString("nm_categoria_colecao"));
                cc.setDescricaoCategoriaColecao(rs.getString("descricao_categoria_colecao"));

                Funcionario fn = new Funcionario();
                fn.setCod(rs.getInt("cod_categoria_colecao"));
                fn.setLogin(rs.getString("login"));
                fn.setEmail(rs.getString("email"));
                fn.setCtps(rs.getString("ctps"));
                fn.setCargo(rs.getString("cargo"));
                fn.setSalario(rs.getDouble("salario"));
                fn.setDtAdmissao(rs.getDate("dt_admissao"));
                fn.setDtRecisao(rs.getDate("dt_recisao"));
                fn.setNome(rs.getString("funcionario"));
                fn.setCpf(rs.getString("cpf"));
                fn.setRg(rs.getString("rg"));
                fn.setDtNascimento(rs.getDate("dt_nascimento"));
                fn.setTelefone(rs.getString("telefone"));
                fn.setEndereco(rs.getString("end_funcionario"));
                fn.setDtCadastro(rs.getDate("dt_cadastro_funcionario"));

                Fabricante f = new Fabricante();
                f.setCod(rs.getInt("cod_fabricante"));
                f.setNmFantasia(rs.getString("nmfantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getString("endereco"));

                Colecao c = new Colecao();
                c.setCodColecao(rs.getInt("cod_colecao"));
                c.setEstacaoColecao(rs.getString("estacao"));
                c.setAnoColecao(rs.getInt("ano"));
                c.setPubAlvoColecao(rs.getString("pub_alvo"));
                c.setFunResponsavelColecao(fn);
                c.setCategoriaColecao(cc);

                p.setCodProduto(rs.getInt("cod_produto"));
                p.setCategoria(cp);
                p.setColecao(c);
                p.setFabricante(f);
                p.setNome(rs.getString("nome"));
                p.setModelo(rs.getString("modelo"));
                p.setPreco(rs.getDouble("preco"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                p.setQtProdutos(rs.getInt("qt_produtos"));

                produtos.add(p);

            }
            ConnectionFactory.closeConnection(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transação.");
        }
        return produtos;
    }
}
