/**
 * 
 */
package br.com.gamessoup.model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author nicolas
 *
 */
@Entity
public class Usuario {
@Id @GeneratedValue
private Long id;
private String nome;
private String senha;
@Temporal(TemporalType.DATE)
private Calendar dataNascimento;
private String email; 
 @OneToMany(mappedBy="usuario")
private List <Noticia> noticia;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Noticia> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticia = noticia;
    }

    
}
