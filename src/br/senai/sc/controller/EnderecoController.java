/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;


import br.senai.sc.model.negocio.Endereco;
import br.senai.sc.model.persistencia.EnderecoDAOJDBC;
import br.senai.sc.model.persistencia.dao.EnderecoDAON;
import java.util.List;

    /**
    *
    * @author gustavo_cm
    * @version 1.0 06/11/2013
    */
    public class EnderecoController {
   
    /**
    * Responsável pela ligação do método dos
    * registros com interface gráfica.
    * @author gustavo_cm
    * @version 1.0 06/11/2013
    * @param Endereço
    */
    public List<Endereco> listAll(){
        EnderecoDAON dao = new EnderecoDAOJDBC();
        return dao.listAll();
    }
    /**
     * Responsável pela ligação do método
     * inserção com a interface gráfica.
     * @author gustavo_cm
     * @version 1.0 06/11/2013
     * @param Endereço
     */
    public int inserir (Endereco e){
        EnderecoDAON dao = new EnderecoDAOJDBC();
        return dao.insert(e);
    }
    /**
     * Responsável pela ligação do método 
     * com a interface grafica.
     * @author gustavo_cm
     * @version 1.0 06/11/2013
     * @param Endereço
     * @return
     */
    public Endereco listbyId(int id){
        EnderecoDAON dao = new EnderecoDAOJDBC();
        return dao.listById(id);
        
    }
    /**
     *Responsável pela ligação do método
     *com a interface gráfica.
     * @author gustavo_cm
     * @version 1.0 06/11/2013
     * @param Endereço
     */
    public int update(Endereco e){
       EnderecoDAON dao = new EnderecoDAOJDBC();
       return dao.update(e);
        
    }
    /**
     * Responsável pela ligação do método
     * remover com a interface gráfica.
     * @author gustavo_cm
     * @version 1.0 06/11/2013
     * @param Endereço
     */
    public boolean remove(int id){
        EnderecoDAON dao = new EnderecoDAOJDBC();
        return dao.remove(id);
    }
    /**
     *Responsável pela ligação do método
     * com a interface gráfica
     * @author gustavo_cm
     * @version 1.0 06/11/2013
     * @param Endereço
     */
     public List<Endereco> pesquisar(String text){
         EnderecoDAON dao = new EnderecoDAOJDBC();
         return dao.pesquisar(text);
     } 
}