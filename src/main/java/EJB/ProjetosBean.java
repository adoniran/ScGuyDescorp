/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Projetos;
import javax.ejb.Stateless;


/**
 *
 * @author adoniran
 */
@Stateless
public class ProjetosBean extends Crud<Projetos> implements ProjetosLocal {

   

    public ProjetosBean() {
        super(Projetos.class);
    }

    @Override
    public Projetos find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projetos findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
