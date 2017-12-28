/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import EJB.ProjetosLocal;
import EJB.UsuarioLocal;
import Entidades.Projetos;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aluno
 */
public class EJBTeste {
    private static EJBContainer container;
    
    public EJBTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();
        assertNotNull(container);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void helloEJBTeste() throws NamingException {
        UsuarioLocal usuarioLocal = (UsuarioLocal) container.getContext().lookup("java:global/classes/ejb/UsuarioBean!EJB.UsuarioLocal");
        assertNotNull(usuarioLocal);
    }
    
    @Test
    public void ProjetoPorNome() throws NamingException{
        String name="Dracoin";
        ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
        assertNotNull(projetoLocal);
        Projetos p=projetoLocal.findByName(name);
        assertNotNull(p);
        assertEquals(p.getNome(), name);
    }
}
