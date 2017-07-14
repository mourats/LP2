package lp2.lab04p1.enums;

/**
 * Enum responsável por encapsular a representção da previsão de uma aposta.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

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
