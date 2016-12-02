package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAutil;

public class TestaMovimentacaoDao {
	public static void main(String[] args) {
		EntityManager manager = new JPAutil().getEntityManager();
		Dao<Conta> daoConta = new Dao<Conta>(manager,Conta.class);
		Conta conta = daoConta.busca(1);
		Dao<Movimentacao> daoMovimentacao = new Dao<Movimentacao>(manager,Movimentacao.class);
		Movimentacao mov = daoMovimentacao.busca(1); //com manage.find
		// busca id movimentacao 1 e coloca em mov2
		Movimentacao mov2 = daoMovimentacao.buscaBarata(1); //com manage.getReference
		// busca conta que contem mov2
		Conta conta2 = mov2.getConta();
		// cria movimentacao 3
		Movimentacao mov3 = new Movimentacao();
		// adiciona a conta 2 a movimentacao 3
		mov3.setConta(conta2);
		mov3.setValor(new BigDecimal("0.1"));
		mov3.setData(Calendar.getInstance());
		mov3.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov3.setDescricao("Gastando muito!");
		manager.getTransaction().begin();
		//Conta conta = manager.find(Conta.class,2); //op1
		//op2 manager.persist(new Conta(construtor tem que estar bem feito));//ou -bem pior
		//mov3.setConta(conta);
		manager.persist(mov3);
		manager.getTransaction().commit();
		manager.close();
	}
}
