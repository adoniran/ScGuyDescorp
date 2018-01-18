/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.UsuarioLocal;
import Entidades.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author adoniran
 */
@ManagedBean(name = "login")
@RequestScoped
public class Login implements Serializable {

    private static Logger log = Logger.getLogger(Login.class.getName());

    private Usuario usuario;
    @NotBlank
    private String login;
    @NotBlank
    private String senha;
    /**
     * Creates a new instance of LoginBean
     */

    @EJB
    UsuarioLocal bean;

    public Login() {
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String loginUser() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(login, senha);
            request.setAttribute("login", login);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", null));
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

            return "loginUser";
        }
//		Principal principal = request.getUserPrincipal();
//		this.usuario = bean.findUserById(principal.getName());
//		log.info("Authentication done for user: " + principal.getName());
//		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		Map<String, Object> sessionMap = externalContext.getSessionMap();
//		sessionMap.put("Usuario", usuario);
        if (request.isUserInRole("Usuario")) {
            addMessage("Seja bem vindo:" + login);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ScienceGuy/usuario/usuario.xhtml");
            return "usuario";
        } else {
            return "loginUser";
        }
    }

    public String logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            this.usuario = null;
            request.logout();
            // clear the session
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
        }
        context.getExternalContext().redirect("/ScienceGuy/publico/index.xhtml");
        return "/publico/index?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
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

}
