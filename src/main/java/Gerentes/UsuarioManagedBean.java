/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.UsuarioLocal;
import Entidades.Conta;
import Entidades.Endereco;
import Entidades.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;


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
    private Endereco endereco=new Endereco();
    
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
   
    public void salvarUsuario(){
//        conta.setAgencia("12345");
//        conta.setNumero("448576655");
//        conta.setTipo("POUPANÇA");
//        conta.setDonoConta(usuario);
//    usuario.setEndereco(endereco);
    usuario.addTelefone(cel1);
   usuario.addTelefone(cel2);
      bean.criar(this.usuario);    
    }
    
}
