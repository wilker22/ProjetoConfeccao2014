package br.senai.sc.model.persistencia.dao;
import br.senai.sc.model.negocio.NotaFiscal;
import java.util.List;

public interface NotaFiscalDAO {

   public int insert(NotaFiscal e);
    /*
     * Método responsável pela inserção da nota fiscal na base de dados
     * @author Elivelton Sipriano
     * @versin 1.0 09/09/2013
     */

 public int update(NotaFiscal e);
    /*
     * Método responsável pela atualização de uma nota fiscal na base de dados
     * @author Elivelton Sipriano
     * @versin 1.0 09/09/2013
     */

 public boolean delete(int codNumero);
    /*
     * Método responsável pela remoção de uma nota fiscal da base de dados 
     * @author Elivelton Sipriano
     * @versin 1.0 09/09/2013
     */

  public List<NotaFiscal> listAll();
    /*
     * Método responsável pela listagem de todos as notas fiscais cadastradas na base de dados 
     * @author Elivelton Sipriano
     * @versin 1.0 09/09/2013
     */

 public  NotaFiscal listById(int codNumero);

//     * Método reponsável por buscar uma nota fiscal na base de dados através de um id
//     * @author Elivelton Sipriano
//     * @versin 1.0 09/09/2013
 List<NotaFiscal> listPesquisa(String texto);
}
     
     