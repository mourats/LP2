package lp2.lab04.p1;

import lp2.lab04.p1.enums.Previsao;
import lp2.lab04.p1.util.Checks;

public class Aposta {

	private String apostador;
	private Previsao previsao; 
	private int valor;

	public Aposta(String apostador, int valor, String previsao) {
		
		Checks.verificaApostadorNulo(apostador);
		Checks.verificaApostadorVazio(apostador);
		Checks.verificaValorZero(valor);
		Checks.verificaPrevisaoNula(previsao);
		Checks.verificaPrevisaoVazia(previsao);
		
		this.apostador = apostador;
		this.valor = valor;
		identificaPrevisaoAposta(previsao);
	}


	private void identificaPrevisaoAposta(String previsao) {
		if (previsao.equals("VAI ACONTECER"))
			this.previsao = Previsao.VAI_ACONTECER;
		else if (previsao.equals("N VAI ACONTECER"))
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		else
			throw new IllegalArgumentException("PREVISÃO INDISPONÍVEL!");
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
