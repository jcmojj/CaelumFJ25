package br.com.caelum.financas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

// dao sem usar esse clase se chamarao DaoAntiga

@Named
@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Produces @RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}
	
}
