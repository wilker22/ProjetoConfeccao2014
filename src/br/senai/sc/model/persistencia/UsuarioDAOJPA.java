package br.senai.sc.model.persistencia;

import br.senai.sc.model.negocio.Usuario;
import br.senai.sc.model.persistencia.dao.UsuarioDAO;
import java.util.List;


/**
 *
 * @author mateus_aguiar    
 */
public class UsuarioDAOJPA extends DAOJPA<Usuario, Integer> implements UsuarioDAO {

    @Override
    public List<Usuario> listPesquisa(String texto) {
        return getEntityManager().createQuery("select u from Usuario u where u.nome like '%" + texto + "%'").getResultList();
    }


}
