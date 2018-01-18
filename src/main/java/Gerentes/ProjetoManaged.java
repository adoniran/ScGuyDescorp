/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.ProjetosLocal;
import Entidades.Area;
import Entidades.Necessidade;
import Entidades.Projetos;
import Entidades.Situacao;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author adoniran
 */
@Named(value = "projetoManaged")
@RequestScoped
public class ProjetoManaged {

    private String nome;
    private Projetos projeto = new Projetos();
    private String nec;
    private String area;
    private List<Projetos> p;
    /**
     * Creates a new instance of ProjetoManaged
     */
    @EJB
    ProjetosLocal bean;

    public ProjetoManaged() {
    }

    public Projetos getProjeto() {
        return projeto;
    }

    public void setProjeto(Projetos projeto) {
        this.projeto = projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Projetos> getP() {
        return p;
    }

    public void setP(List<Projetos> p) {
        this.p = p;
    }

    public String getNec() {
        return nec;
    }

    public void setNec(String nec) {
        this.nec = nec;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private void are(String area) {
        switch (area) {
            case "TI":
                this.projeto.setArea(Area.TI);
                break;

            case "COMUNICACAO":
                this.projeto.setArea(Area.COMUNICACAO);
                break;

            case "STARTUP":
                this.projeto.setArea(Area.STARTUP);
                break;
            case "HARDWARE":
                this.projeto.setArea(Area.HARDWARE);
                break;

            default:
                this.projeto.setArea(Area.CIENCIA);
                break;

        }

    }

    private void nece(String nec) {
        switch (nec) {
            case "Intelectual":
                this.projeto.setNecessidade(Necessidade.INTELECTUAL);
                break;

            case "Humano":
                this.projeto.setNecessidade(Necessidade.HUMANO);
                break;

            case "Financeiro":
                this.projeto.setNecessidade(Necessidade.FINANCEIRO);
                break;

            default:
                this.projeto.setNecessidade(Necessidade.NENHUMA);
                break;

        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void procura() {
        List<Projetos> proj;
        proj = bean.findBySimilarName(nome);
        this.p = proj;
    }

    public void salvarProj() {
        nece(this.nec);
        are(this.area);
        projeto.setSituacao(Situacao.DESENVOLVENDO);
        bean.criar(projeto);
        addMessage("Projeto cadastrado com sucesso");
    }

}
