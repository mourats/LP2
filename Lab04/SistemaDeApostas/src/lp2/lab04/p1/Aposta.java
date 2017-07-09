package lp2.lab04.p1;

public class Aposta {

	private String apostador;
	private Previsao previsao; 
	private int valor;

	public Aposta(String apostador, int valor, String previsao) {
		this.apostador = apostador;
		this.valor = valor;
		
		if (previsao.equals("VAI ACONTECER"))
			this.previsao = Previsao.VAI_ACONTECER;
		else
			this.previsao = Previsao.NAO_VAI_ACONTECER;
	}

	public String getApostador() {
		return this.apostador;
	}

	public Previsao getPrevisao() {
		return previsao;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostador == null) ? 0 : apostador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta ref = (Aposta) obj;

		if (ref.getApostador() == this.apostador)
			return true;

		return false;
	}

}
