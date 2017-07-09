package lp2.lab04.p1;

public enum Previsao {
	
	VAI_ACONTECER("VAI ACONTECER"), NAO_VAI_ACONTECER("N VAI ACONTECER");
	
	private final String previsao;

	private Previsao(String previsao) {
		this.previsao = previsao;
	}

	public String getPrevisao() {
		return this.previsao;
	}

}
