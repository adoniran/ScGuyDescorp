/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Usuario;
import java.util.Iterator;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @author adoniran
 */
@Stateless
public class UsuarioBean extends Crud<Usuario> implements UsuarioLocal {

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public void criar(Usuario usuario) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<Usuario>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<Usuario> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

//         JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            }
        } else {
            getGerente().persist(usuario);

        }
    }
}
