/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Projetos;
import Entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface ProjetosLocal {

    void criar(Projetos projetos);

    void editar(Projetos projetos);

    void remover(Projetos projetos);

    Projetos find(Object id); 
    
    Projetos findByName(String name);
    
    List<Projetos> findBySimilarName(String name);
    
    List<Usuario> findParticipantes(Object idProjeto);
    
   
}
