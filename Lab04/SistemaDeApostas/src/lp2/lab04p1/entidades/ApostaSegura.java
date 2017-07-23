package lp2.lab04p1.entidades;

/**
 * Classe responsável por representar uma aposta segura.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import lp2.lab04p1.enums.Previsao;

public class ApostaSegura extends Aposta {

	private Seguro seguro;

	/**
	 * Construtor responsável por inicializar uma aposta segura com o seguro por
	 * valor.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param valorSeguro
	 *            Valor assegurado do valor da aposta.
	 */
	public ApostaSegura(String apostador, int valor, Previsao previsao, int valorSeguro) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroValor("VALOR", valorSeguro);

	}

	/**
	 * Construtor responsável por inicializar uma aposta segura com o seguro por
	 * taxa.
	 * 
	 * @param apostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param taxaSegura
	 *            Taxa assegurada do valor da aposta.
	 */
	public ApostaSegura(String apostador, int valor, Previsao previsao, double taxaSegura) {
		super(apostador, valor, previsao);
		seguro = new SeguroTaxa("TAXA", taxaSegura);
	}

	@Override
	public String toString() {
		return super.toString() + this.seguro.toString();
	}

	/**
	 * Método responsável por alterar o seguro para taxa.
	 * 
	 * @param taxa
	 *            Taxa do novo seguro.
	 */
	public void alterarSeguro(double taxa) {
		this.seguro = new SeguroTaxa("TAXA", taxa);
	}

	/**
	 * Método responsável por alterar o seguro para valor.
	 * 
	 * @param valor
	 *            Valor do novo seguro.
	 */
	public void alterarSeguro(int valor) {
		this.seguro = new SeguroValor("VALOR", valor);
	}

	/**
	 * Método responsável por retornar o valor assegurado desta aposta, seja ele
	 * por taxa ou por valor.
	 * 
	 * @return Retorna um int com esse valor.
	 */
	public int getValorSegurado() {
		return seguro.retornaSeguro(this.getValor());
	}
}
