/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Arquivos;
import Entidades.Projetos;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;


/**
 *
 * @author adoniran
 */
@Stateless
public class ArquivosBean extends Crud<Arquivos> implements ArquivosLocal {

       public ArquivosBean() {
        super(Arquivos.class);
    }

    @Override
    public Arquivos findByName(String name) {
//        TypedQuery<Arquivos> que= getGerente().createQuery("Select a from Arquivos a where a.nome= :name ",Arquivos.class);
        TypedQuery<Arquivos> que= getGerente().createQuery("Select a from Arquivos a where a.nome like :name",Arquivos.class);
        que.setParameter("name", name);
        Arquivos retorno = que.getSingleResult();
        return retorno;
    }

    
    
}
