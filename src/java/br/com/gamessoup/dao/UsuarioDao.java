/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gamessoup.dao;

import static br.com.gamessoup.model.Noticia_.usuario;
import br.com.gamessoup.model.Usuario;
import static br.com.gamessoup.model.Usuario_.email;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.eclipse.persistence.internal.helper.ClassConstants;

/**
 *
 * @author Nicolas
 */
public class UsuarioDao extends Dao<Usuario>{
private EntityManager em;

    public UsuarioDao( EntityManager em) {
        super(Usuario.class, em);
        this.em = em;
    }

    /**
     * 
     * @param usuario
     * @param senha
     * @return 
     */
    public Usuario login(String usuario,String senha){
        Query q= em.createQuery("Select u from Usuario as u where u.nome = :n1 and u.senha=:s1");
        q.setParameter("n1", usuario);
        q.setParameter("s1", senha);
        List<Usuario> res=q.getResultList();
        if(res.size() > 0){
        return res.get(0);
    }
        else{
        return null;
        }
    } 
    
}

