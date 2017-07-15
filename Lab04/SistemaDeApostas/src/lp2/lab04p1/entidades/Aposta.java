package lp2.lab04p1.entidades;

/**
 * Classe responsável moldar a representação de uma aposta utilizada nesse programa.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import lp2.lab04p1.enums.Previsao;

public class Aposta {

	private String apostador;
	private Previsao previsao;
	private int valor;

	/**
	 * Construtor responsável por inicializar uma aposta sem seguro.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public Aposta(String apostador, int valor, Previsao previsao) {

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		double representacaoDoubleValor  =((double) this.valor) / 100;
		String representacaoStringValor = String.format("%.2f", representacaoDoubleValor);
		return this.apostador + " - R$ " + representacaoStringValor + " - " + this.previsao.getPrevisao();
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

}
