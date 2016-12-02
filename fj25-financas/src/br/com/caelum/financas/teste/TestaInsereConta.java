package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;


import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;


public class TestaInsereConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long inicio = System.currentTimeMillis();
		
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		//EntityManager manager = factory.createEntityManager();
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Amaral Ramos");
		conta.setBanco("CEF");
		conta.setNumero("552211-9");
		conta.setAgencia("0001");
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		//manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso!");
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em : "+ (fim - inicio)+ "ms");

	}

}
