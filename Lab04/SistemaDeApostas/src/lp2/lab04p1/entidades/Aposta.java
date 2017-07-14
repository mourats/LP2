package lp2.lab04p1.entidades;

/**
 * Classe responsável moldar a representação de uma aposta utilizada nesse programa..
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import lp2.lab04p1.enums.Previsao;
import lp2.lab04p1.util.Checks;

public class Aposta {

	private String apostador;
	private Previsao previsao;
	private int valor;

	/**
	 * Construtor responsável por inicializar uma aposta, validando seus dados e
	 * identificando sua previsão.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public Aposta(String apostador, int valor, String previsao) {

		Checks.verificaApostadorVazio(apostador, "Erro no cadastro de aposta: ");
		Checks.verificaValorZero(valor, "Erro no cadastro de aposta: ");
		Checks.verificaPrevisaoVazia(previsao, "Erro no cadastro de aposta: ");

		this.apostador = apostador;
		this.valor = valor;
		identificaPrevisaoAposta(previsao);
	}

	/**
	 * Método responsável por identificar a previsão da aposta.
	 * 
	 * @param previsao
	 *            String da previsão que será avaliada.
	 */
	private void identificaPrevisaoAposta(String previsao) {
		if (previsao.equals("VAI ACONTECER"))
			this.previsao = Previsao.VAI_ACONTECER;
		else if (previsao.equals("N VAI ACONTECER"))
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		else
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
	}

	@Override
	public String toString() {
		double representacaoRealValor = ((double) this.valor) / 100;
		return this.apostador + " - R$" + representacaoRealValor + "0 - " + this.previsao.getPrevisao();
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
