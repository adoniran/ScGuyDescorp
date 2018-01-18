/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Admin;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adoniran
 */
@DeclareRoles({"Administrador"})
@Stateless(name="AdminBean")
public class AdminBean extends Crud<Admin> implements AdminLocal {

    public AdminBean() {
        super(Admin.class);
    }

    @Override
    public Admin find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
