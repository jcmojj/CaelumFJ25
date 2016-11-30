package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.modelo.Conta;


@Stateless // transforma o DAO em um javaBean acessível pelo CDI
public class ContaDao {
	
	@PersistenceContext // o EJB.container tem que injetar a EntityManager para possibilitar conexão 
	private EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//@TransactionAttribute(TransactionAttributeType.MANDATORY) OBRIGA TER UMA TRANSACAO ja criada.. senao da erro
	public void adiciona(Conta conta) {
		this.manager.persist(conta);
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}

	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		this.manager.remove(contaParaRemover);
	}
	
	public void altera(Conta conta){
		this.manager.merge(conta);
	}

}




