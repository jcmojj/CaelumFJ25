package br.com.caelum.financas.modelo;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AtualizadorDeData {
	
	@PrePersist
	@PreUpdate
	public void preAltera(Object entidade){
		Atualizavel a = (Atualizavel)entidade;
		a.setData(Calendar.getInstance());
		
		System.out.println("atualizando data de hoje!!!");
	}

}
