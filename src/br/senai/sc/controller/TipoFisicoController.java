/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.controller;

import br.senai.sc.model.negocio.TipoFisico;
import br.senai.sc.model.persistencia.TipoFisicoDaoJPA;
import br.senai.sc.model.persistencia.dao.TipoFisicoDAO;
import java.util.List;

/**
 * @author Gustavo L. Alves
 * @version 1.0 05/11/2013
 */
public class TipoFisicoController {

   public TipoFisico salvar(TipoFisico tp) {
       TipoFisicoDAO dao = new TipoFisicoDaoJPA();
       return dao.save(tp);
   }
   
   public boolean excluir(int codigo){
       TipoFisicoDAO dao = new TipoFisicoDaoJPA();
       return dao.remove(TipoFisico.class, codigo);
               
   }
   
   public List<TipoFisico> listarTipoFisico(){
       TipoFisicoDAO dao = new TipoFisicoDaoJPA();
       return dao.getAll(TipoFisico.class);
   }
   
   public TipoFisico listarTipoFisicoById(int codigo){
       TipoFisicoDAO dao = new TipoFisicoDaoJPA();
       return dao.getById(TipoFisico.class, codigo);
       
   }
   
   public List<TipoFisico> pesquisarNome(String nome){
       TipoFisicoDAO dao = new TipoFisicoDaoJPA();
       return dao.pesquisaNome(nome);
   }
}