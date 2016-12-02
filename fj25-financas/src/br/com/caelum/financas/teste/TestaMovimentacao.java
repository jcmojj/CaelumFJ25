package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager  = new JPAUtil().getEntityManager();
		
		Movimentacao mov = new Movimentacao();
		mov.setData(Calendar.getInstance());
		mov.setDescricao("teste");
		mov.setValor(new BigDecimal("0.1"));
		Conta conta = new Conta();
		mov.setConta(conta);
		
		manager.getTransaction().begin();
		manager.persist(mov);
		manager.getTransaction().commit();
		manager.close();

	}

}
