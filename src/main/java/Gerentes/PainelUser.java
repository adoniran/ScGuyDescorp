/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.ProjetosLocal;
import EJB.UsuarioLocal;
import Entidades.Area;
import Entidades.Necessidade;
import Entidades.Projetos;
import Entidades.Situacao;
import Entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;

/**
 *
 * @author adoniran
 */
@DeclareRoles({"Usuario"})
@Named(value = "painelUser")
@SessionScoped
public class PainelUser implements Serializable {
    List<Projetos> participantes= new ArrayList<>();
    
    @EJB
    ProjetosLocal bean;
    @EJB
    UsuarioLocal bean2;
    /**
     * Creates a new instance of PainelUser
     */
    public PainelUser() {
    }
    
    public List<Projetos> getParticipantes() {
//        this.participantes=bean2.findProjetosParticipantes(1);
        Projetos projeto = new Projetos();
        projeto.setNome("Estrela");
        projeto.setArea(Area.TI);
        projeto.setDescricao("Estrela da morte");
        projeto.setNecessidade(Necessidade.FINANCEIRO);
        projeto.setMotivacaoNecessidade("materiais");        
        projeto.setSituacao(Situacao.PARADO);
        participantes.add(projeto);
        return participantes;
    }

    public void setParticipantes(List<Projetos> participantes) {
        this.participantes = participantes;
    }
    
}
