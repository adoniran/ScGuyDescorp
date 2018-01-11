/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.Projetos;
import Entidades.Usuario;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import javax.persistence.TypedQuery;

/**
 *
 * @author adoniran
 */
@Stateless(name = "ejb/UsuarioBean")
public class UsuarioBean extends Crud<Usuario> implements UsuarioLocal {

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public List<Projetos> findProjetosParticipantes(long idUsuario) {
        Usuario user;
        user = getGerente().find(Usuario.class, idUsuario);
        return user.getProj();
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

    @Override
    public Usuario findUserById(String name) {
        TypedQuery<Usuario> query = getGerente().createQuery("SELECT p from Usuario p where p.login =:nome", Usuario.class);
        query.setParameter("nome", name);
        Usuario p = query.getSingleResult();
        return p;
    }
}
