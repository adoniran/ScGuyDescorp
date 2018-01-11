/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Projetos;
import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;


/**
 *
 * @author adoniran
 */
@Stateless(name="ProjetosBean")
public class ProjetosBean extends Crud<Projetos> implements ProjetosLocal {

   

    public ProjetosBean() {
        super(Projetos.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Projetos find(Object id) {
       Projetos proj;
       proj=getGerente().find(Projetos.class, id);
       return proj;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)    
    public Projetos findByName(String name) {
        TypedQuery<Projetos> query =getGerente().createQuery("SELECT p from Projetos p where p.nome =:nome",Projetos.class);
        query.setParameter("nome", name);
        Projetos p = query.getSingleResult();        
        return p;
       
    }

    @Override
    public List<Usuario> findParticipantes(Object idProjeto) {
       Projetos proj;
       proj=getGerente().find(Projetos.class, idProjeto);
       return proj.getParticipantes();
    }

    
}
