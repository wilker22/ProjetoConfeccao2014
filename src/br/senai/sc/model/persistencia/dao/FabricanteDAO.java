package br.senai.sc.model.persistencia.dao;
import br.senai.sc.model.negocio.Fabricante;
import java.util.List;

public interface FabricanteDAO {
    
    /**
     * Método responsável pela inserção do Fabricante
     * @author Mateus Generoso
     * @since 1.0 16/09/2013
     * @param fab
     * @return 
     */

    int insert(Fabricante fab);
    
    /**
     * Método responsável pela alteração do Fabricante
     * @author Mateus Generoso
     * @version 1.0 16/09/2013
     * @param fab
     * @return
     */
    int update(Fabricante fab);
   
    /**
     * Método responsável pela deleção do Fabricante com base no cod recebido por parametro
     * @author Mateus Generoso
     * @since 1.0 16/09/2013
     * @param fab
     * @return
     */
    boolean delete(Fabricante fab);
     
    /**
     * Método responsável pela listagem de todos os Fabricantes
     * @author Mateus Generoso
     * @since 1.0 16/09/2013
     * @return
     */
    List<Fabricante> listAll();
    
    /**
     * Método responsável pela listagem do Fabricante com base no cod recebido por parametro
     * @author Mateus Generoso
     * @since 1.0 16/09/2013
     * @param codFabricante
     * @return
     */
    Fabricante listById(int codFabricante);
    
    /**
     * Método responsável pela pesquisa do Fabricante com base nos dados recebidos
     * @author Mateus Generoso
     * @since 1.0 30/10/2013
     * @param texto
     * @return
     */    
    List<Fabricante> ListPesquisar(String texto);
}
