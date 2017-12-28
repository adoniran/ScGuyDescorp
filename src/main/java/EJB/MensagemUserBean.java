/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.MensagemUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adoniran
 */
@Stateless
public class MensagemUserBean extends Crud<MensagemUser> implements MensagemUserLocal {

    public MensagemUserBean() {
        super(MensagemUser.class);
    }
    
}
