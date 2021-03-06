package br.com.caelum.financas.testeDao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAutil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAutil().getEntityManager();
		Dao<Conta> dao = new Dao<Conta>(manager, Conta.class);
		manager.getTransaction().begin();
		Conta conta = dao.busca(3);
		conta.setTitular("Joao");
		manager.getTransaction().commit();
		manager.close();
	}
}