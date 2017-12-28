/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.MensagemUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface MensagemUserLocal {

    void criar(MensagemUser mensagemUser);

    void editar(MensagemUser mensagemUser);

    void remover(MensagemUser mensagemUser);

   
    
}
