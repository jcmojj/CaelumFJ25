package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaExtDao extends Dao<Conta> {
	public ContaExtDao(EntityManager manager){
		super(manager,Conta.class);
	}

public List<String> agencias() {
	return this.manager.createQuery("select c.agencia from Conta c", String.class)
			.getResultList();
	}	

}
