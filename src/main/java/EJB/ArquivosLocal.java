/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Arquivos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface ArquivosLocal {

    void criar(Arquivos arquivos);

    void editar(Arquivos arquivos);

    void remover(Arquivos arquivos);

    Arquivos findByName(String name);
    
}
