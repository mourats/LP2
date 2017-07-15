package lp2.lab04p1.entidades;

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

	public Seguro getSeguro() {
		return this.seguro;
	}

	public void alterarSeguro(double taxa) {
		this.seguro = new SeguroTaxa(taxa);
	}

	public void alterarSeguro(int valor) {
		this.seguro = new SeguroValor(valor);
	}

	public int getValorSegurado() {
		if(this.seguro.getClass() == SeguroTaxa.class)
			return (int) (super.getValor() * ((SeguroTaxa) this.seguro).getTaxa());

		if(this.seguro.getClass() == SeguroValor.class)
			return ((SeguroValor) this.seguro).getValor();
		return 0;
	}
}
