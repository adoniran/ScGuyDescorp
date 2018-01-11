/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.UsuarioLocal;
import Entidades.Projetos;
import Entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author adoniran
 */
@Named(value = "painelUser")
@SessionScoped
public class PainelUser implements Serializable {
    List<Projetos> participantes;
    
    @EJB
    UsuarioLocal bean;
    /**
     * Creates a new instance of PainelUser
     */
    public PainelUser() {
    }
    
    public List<Projetos> getParticipantes() {
        this.participantes=bean.findProjetosParticipantes(1);
        return participantes;
    }

    public void setParticipantes(List<Projetos> participantes) {
        this.participantes = participantes;
    }
    
}
