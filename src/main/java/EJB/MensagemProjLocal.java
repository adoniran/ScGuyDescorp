/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.MensagemProj;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface MensagemProjLocal {

    void criar(MensagemProj mensagemProj);

    void editar(MensagemProj mensagemProj);

    void remover(MensagemProj mensagemProj);

    
}
