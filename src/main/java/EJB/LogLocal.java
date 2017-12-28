/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Log;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface LogLocal {

    void criar(Log log);

    void editar(Log log);

    void remover(Log log);

    Log find(Object id);

    List<Log> findAll(Object idAdmin);

    
    
}
