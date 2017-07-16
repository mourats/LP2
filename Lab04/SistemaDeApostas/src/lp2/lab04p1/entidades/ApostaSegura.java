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

	public ApostaSegura(String apostador, int valor, Previsao previsao, int valorSeguro) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroValor(valorSeguro);

	}

	public ApostaSegura(String apostador, int valor, Previsao previsao, double taxaSegura) {
		super(apostador, valor, previsao);
		seguro = new SeguroTaxa(taxaSegura);
	}

	@Override
	public String toString() {
		return super.toString() + this.seguro.toString();
	}

	public void alterarSeguro(double taxa) {
		this.seguro = new SeguroTaxa(taxa);
	}

	public void alterarSeguro(int valor) {
		this.seguro = new SeguroValor(valor);
	}

	public int getValorSegurado() {
		if (this.seguro.getTipo().equals("TAXA"))
			return (int) (super.getValor() * ((SeguroTaxa) this.seguro).getTaxa());

		if (this.seguro.getTipo().equals("VALOR"))
			return ((SeguroValor) this.seguro).getValor();
		return 0;
	}
}
