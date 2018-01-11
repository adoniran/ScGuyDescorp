/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import Acesso.Grupo;
import EJB.UsuarioLocal;
import Entidades.Conta;
import Entidades.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 *
 * @author adoniran
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean {
    private Usuario usuario= new Usuario();
    String cel1,cel2;
    private Conta conta=new Conta();
    String login,senha;
//    private Endereco endereco=new Endereco();
    
    @EJB
    UsuarioLocal bean;
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario u) {
        this.usuario = u;
    }

    public String getCel1() {
        return cel1;
    }

    public void setCel1(String cel1) {
        this.cel1 = cel1;
    }

    public String getCel2() {
        return cel2;
    }

    public void setCel2(String cel2) {
        this.cel2 = cel2;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void loginUser(){
        addMessage("Bem vindo:"+login);
    }
    public void buttonAction(ActionEvent actionEvent) {
        salvarUsuario();
        addMessage("Usuario cadastrado com sucesso");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void salvarUsuario(){
//        Grupo g = new Grupo();
//        g.setNome(Grupo.USUARIO);
//        usuario.adicionarGrupo(g);
        usuario.addTelefone(cel1);
        usuario.addTelefone(cel2);
        bean.criar(this.usuario);          
    }
    
}
