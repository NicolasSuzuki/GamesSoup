package br.com.gamessoup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamesSoupUP");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(EntityManager em) {
		em.close();
	}
}
