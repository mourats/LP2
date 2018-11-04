package lp2.prova3.entidades;

import lp2.prova3.interfaces.TipoSeguro;

public class Pleno implements TipoSeguro {
	
	private String tipo = "Pleno";
	
	@Override
	public String getTipo() {
		return this.tipo;
	}

	@Override
	public double valorMensalidade() {
		return 400.0;
	}

	@Override
	public double valorAcumulado() {
		return valorMensalidade() * 0.87;
	}

	@Override
	public double pagamentoMensalPorDoenca(int idadeSeguro, double saldoAcumulado) {
		
		return Math.min(5000, valorMensalidade()*5 + idadeSeguro/100 * saldoAcumulado/2);
	}

}
