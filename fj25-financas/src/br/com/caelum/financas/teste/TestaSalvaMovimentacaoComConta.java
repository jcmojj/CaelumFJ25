package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.EnumTipoMovimentacao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao daoConta = new ContaDao(manager);
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Diego");
		conta.setBanco("BANCO DO BRASIL");
		conta.setNumero("852-1");
		conta.setAgencia("333");
			
		Movimentacao mov = new Movimentacao();
		//mov.setData(Calendar.getInstance());
		mov.setDescricao("conta de luz - dezembro /2015");
		mov.setValor(new BigDecimal("223"));
		mov.setConta(conta);
		mov.setTipoMovimentacao(EnumTipoMovimentacao.SAIDA);
		
		manager.getTransaction().begin();
		daoConta.adiciona(conta);
		dao.adiciona(mov);		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println(mov.getConta().getTitular());
	}

}
