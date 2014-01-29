package br.com.gamessoup.mb;

import br.com.gamessoup.dao.JpaUtil;
import br.com.gamessoup.dao.UsuarioDao;
import br.com.gamessoup.model.Usuario;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean(name = "Usuario")
@SessionScoped
public class UsuarioController {
	private String nome;
	private String senha;
	private Calendar data_de_nascimento;
	private String email;
	private String mensagem;
        private boolean autenticado = false;

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

	public Calendar getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(Calendar data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        public boolean isAutenticado(){
            return autenticado;
        }

			
     public String clique() {
        EntityManager em = JpaUtil.getEntityManager();
        UsuarioDao dao = new UsuarioDao (em);
        Usuario u = dao.login(nome,senha);
                 if (u!= null) {
		autenticado = true;
		} else {
		mensagem = "Login e/ou senha inválida";
					}
			return email;
	}
			public String cadastra(){
				return "PaginaDeCadastro";
			}
			public String cadastrado(){
                                    EntityManager em = JpaUtil.getEntityManager();
                                    Usuario u = new Usuario();
                                    u.setNome(nome);
                                    u.setSenha(senha);
                                    u.setEmail(email);
                                    UsuarioDao dao = new UsuarioDao (em);
                                    dao.insert(u);
            return "index";
                       
                        } 
}          
