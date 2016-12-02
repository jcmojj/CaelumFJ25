package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAutil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAutil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		manager.getTransaction().begin();
		Conta conta = dao.busca(2);
		manager.remove(conta);
		manager.getTransaction().commit();
		manager.close();
	}
}
