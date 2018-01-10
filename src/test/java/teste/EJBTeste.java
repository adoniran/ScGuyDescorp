/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import EJB.AdminLocal;
import EJB.ProjetosLocal;
import EJB.UsuarioLocal;
import Entidades.Area;
import Entidades.Arquivos;
import Entidades.Conta;
import Entidades.Necessidade;
import Entidades.Projetos;
import Entidades.Situacao;
import Entidades.Usuario;
import javax.ejb.EJBException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.validation.ConstraintViolationException;
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
        
//      DbUnitUtil.inserirDados();

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
    public void funcionaUser() throws NamingException {
        UsuarioLocal usuarioLocal = (UsuarioLocal) container.getContext().lookup("java:global/classes/ejb/UsuarioBean!EJB.UsuarioLocal");
        assertNotNull(usuarioLocal);
    }
    
//    @Test
//    public void ProjetoPorNome() throws NamingException{
//        String name="Dracoin";
//        ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
//        assertNotNull(projetoLocal);
//        Projetos p=projetoLocal.findByName(name);
//        assertNotNull(p);
//        assertEquals(p.getNome(), name);
//    }
    @Test
    public void funcionaProj ()throws NamingException{
    ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
        assertNotNull(projetoLocal);
    }
    @Test
    public void funcionaAdmin ()throws NamingException{
    AdminLocal adminLocal=(AdminLocal) container.getContext().lookup("java:global/classes/AdminBean!EJB.AdminLocal");
        assertNotNull(adminLocal);
    }
    @Test
    public void findProj ()throws NamingException{
    ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
    Long num= new Long(1);
    Projetos proj = projetoLocal.find(num);
        assertNotNull(projetoLocal);
        assertNotNull(proj);
    }
    @Test
    public void AtualizaProj ()throws NamingException{
    ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
        Projetos projeto = new Projetos();
        projeto.setNome("Oldname");
        projeto.setArea(Area.TI);
        projeto.setDescricao("teste teste teste");
        projeto.setNecessidade(Necessidade.NENHUMA);
        projeto.setMotivacaoNecessidade("nehuma");
        projeto.setSituacao(Situacao.PARADO);
        projetoLocal.criar(projeto);
        assertNotNull(projeto.getId());
        Projetos atualizado=projetoLocal.findByName("Oldname");
        atualizado.setNome("Atualizado");
        atualizado.setDescricao("Atualizado");
        projetoLocal.editar(atualizado);
        Projetos teste=projetoLocal.findByName("Atualizado");
        assertNotNull(teste);
        assertEquals(teste.getNome(), "Atualizado");
    }
    @Test
    public void CriarInvalidoProj ()throws NamingException{
    ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
        try {
        Projetos projeto = new Projetos();
        projeto.setNome("Gggggggggggggggggggrrrrrrrrrrrraaaaaaaaaaaaannnnnnnnnnnnnnnddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        projeto.setArea(Area.TI);
        projeto.setDescricao("teste teste teste");
        projeto.setNecessidade(Necessidade.NENHUMA);
        projeto.setMotivacaoNecessidade("nehuma");
        projetoLocal.criar(projeto);
        assertTrue(false);
            
        } catch (EJBException ex) {
            assertTrue(ex.getCause() instanceof ConstraintViolationException);
        }
        
    }
    @Test
    public void SalvaProj ()throws NamingException{
        ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
        Projetos projeto = new Projetos();
        projeto.setNome("Estrela");
        projeto.setArea(Area.TI);
        projeto.setDescricao("Estrela da morte");
        projeto.setNecessidade(Necessidade.FINANCEIRO);
        projeto.setMotivacaoNecessidade("materiais");
        
        projeto.setSituacao(Situacao.PARADO);
        Arquivos arq = new Arquivos();
        arq.setNome("requisitos");
        arq.setTipo("pdf");
        arq.setURL("bit.ly/arquivo");
        projetoLocal.criar(projeto);
        projeto.addArquivo(arq);    
        assertNotNull(projeto.getId());
    }
    @Test
    public void ColocaEachaProj ()throws NamingException{
    ProjetosLocal projetoLocal = (ProjetosLocal) container.getContext().lookup("java:global/classes/ProjetosBean!EJB.ProjetosLocal");
       Projetos projeto = new Projetos();
       String name="Powerpuffgirls";
        projeto.setNome(name);
        projeto.setArea(Area.CIENCIA);
        projeto.setDescricao("criação de defensoras para a cidade assolada de townsville");
        projeto.setNecessidade(Necessidade.FINANCEIRO);
        projeto.setMotivacaoNecessidade("dinheiro necessario para compra de elemento X");
        
        projeto.setSituacao(Situacao.DESENVOLVENDO);
        Arquivos arq = new Arquivos();
        arq.setNome("Receita");
        arq.setTipo("pdf");
        arq.setURL("bit.ly/arquivo");projeto.addArquivo(arq);
        projetoLocal.criar(projeto);
            
        assertNotNull(projeto.getId());
        assertNotNull(arq.getId());
      
        
        Projetos teste=projetoLocal.findByName(name);
        assertNotNull(teste);
    }
    @Test
    public void SalvaUser ()throws NamingException{
   UsuarioLocal usuarioLocal = (UsuarioLocal) container.getContext().lookup("java:global/classes/ejb/UsuarioBean!EJB.UsuarioLocal");
   Usuario user = new Usuario();
        Conta conta = new Conta();
        
        //valido
        user.setEmail("User@teste.com");
        user.setNome("Userteste");
        user.setLogin("Userteste00");
        user.setSenha("User.teste00");
//      
        conta.setAgencia("12341");
        conta.setNumero("000567844");
        conta.setTipo("CONTA CORRENTE");
        user.setConta(conta);
        
        usuarioLocal.criar(user);
   
        assertNotNull(user.getId());
    }
    @Test
    public void testeMsg(){
    
    
    }
}
