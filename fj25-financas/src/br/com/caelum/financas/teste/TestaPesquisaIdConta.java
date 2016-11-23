package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAutil;

public class TestaPesquisaIdConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAutil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		Conta encontrada = dao.busca(4);
		System.out.println(encontrada.getTitular());
		manager.close();
	}

}
