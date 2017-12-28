/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Admin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adoniran
 */
@Local
public interface AdminLocal {

    void criar(Admin admin);

    void editar(Admin admin);

    void remover(Admin admin);

    Admin find(Object id);
    
}
