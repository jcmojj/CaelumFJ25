package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class Dao<T> {
	private Class<T> clazz;
	protected EntityManager manager;

	public Dao(EntityManager manager, Class<T> clazz) {
		this.manager = manager;
		this.clazz = clazz;
	}

	public T busca(Integer id){
		return this.manager.find(clazz,id);
	}
	
	public T buscaBarata(Integer id){
		return this.manager.getReference(clazz,id);
	}

	public List<T> lista() {
		return this.manager.createQuery("select c from "+clazz.getSimpleName() +" c", clazz)
				.getResultList();
	}
	public void adiciona(T item){
		manager.persist(item);
	}
	public void remove(T item){
		manager.remove(item);
	}
	

}