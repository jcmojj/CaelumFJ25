package br.com.caelum.financas.modelo;

import java.math.BigDecimal;

public class ValorPorMesEAno {
	private BigDecimal valor;
	private Integer mes;
	private Integer ano;
	private String anomes;

	public ValorPorMesEAno(BigDecimal valor, Integer mes, Integer ano,
			String anomes) {
		this.ano = ano;
		this.mes = mes;
		this.valor = valor;
		this.anomes = anomes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getMes() {
		return mes;
	}

	public Integer getAno() {
		return ano;
	}

	public String getAnomes() {
		return anomes;
	}
	
}
