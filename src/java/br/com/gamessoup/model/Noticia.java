package br.com.gamessoup.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Noticia {
    @Id @GeneratedValue
private Long id;
    @Temporal(TemporalType.TIMESTAMP)
private Calendar dataPostagem;
private String noticia;
private String titulo;
@ManyToOne
private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Calendar dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
