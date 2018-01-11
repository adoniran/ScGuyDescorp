/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acesso;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author adoniran
 */
@Entity
@Table(name = "tb_grupo")
@NamedQueries({
@NamedQuery(name = Grupo.GRUPO_POR_NOME, query = "SELECT g FROM Grupo g WHERE g.nome = ?1")})
public class Grupo implements Serializable{
     public static final String GRUPO_POR_NOME = "GrupoPorNome";
    public static final String USUARIO = "usuario";
public static final String ADMINISTRADOR = "admin";
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
protected Long id;

@NotBlank
    @Size(max = 45)
    @Column(name = "NOME")
private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
