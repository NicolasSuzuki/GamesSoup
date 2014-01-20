package br.com.gamessoup.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {
	
	private static final long serialVersionUID = 2091671855346127476L;
	private EntityManager em;
	private final Class<T> classe;

	public Dao(Class<T> classe, EntityManager em) {
		this.em = em;
		this.classe = classe;
	}

	public void insert(T t) {
		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public void remove(T t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
	}

	public void update(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public List<T> listAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}
	
	public T loadById(Long id) {
		T instancia = em.find(classe, id);
		return instancia;
	}
	
	public int countAll() {
		long result = (Long) em.createQuery("select count(n) from " + classe.getName() + " n").getSingleResult();
		return (int) result;
	}

	public List<T> listAllByPage(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		return lista;
	}
}
