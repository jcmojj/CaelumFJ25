package br.com.caelum.financas.modelo;

import java.util.Calendar;

public interface Atualizavel {
	
	public default void setData(Calendar data){
		
	}
}
