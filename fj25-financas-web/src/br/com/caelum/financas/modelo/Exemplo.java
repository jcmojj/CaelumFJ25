package br.com.caelum.financas.modelo;

public enum Exemplo {
	RACA1("Cachorro", "Pastor alemão"), 
	RACA2("Cachorro", "Pastor belga"),
	RACA3("Gato", "alguma");

	private String tipo;
	private String raca;

	private Exemplo(String tipo, String raca) {
		this.tipo = tipo;
		this.raca = raca;
	}

	public String getTipo() {
		return tipo;
	}

	public String getRaca() {
		return raca;
	}

}
