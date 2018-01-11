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
public interface UsuarioLocal {

    void criar(Usuario usuario);

    void editar(Usuario usuario);

    void remover(Usuario usuario);  
    
    List<Projetos> findProjetosParticipantes(long idUsuario);

    public Usuario findUserById(String name);
}
