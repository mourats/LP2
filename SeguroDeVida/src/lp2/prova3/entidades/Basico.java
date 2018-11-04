package lp2.prova3.entidades;

import lp2.prova3.interfaces.TipoSeguro;

public class Basico implements TipoSeguro {
	
	private String tipo = "Basico";
	
	@Override
	public String getTipo() {
		return this.tipo;
	}

	@Override
	public double valorAcumulado() {
		return valorMensalidade() * 0.87;
	}

	@Override
	public double pagamentoMensalPorDoenca(int idadeSeguro, double saldoAcumulado) {
		return Math.min(3500, valorMensalidade()*4 + idadeSeguro/100 * saldoAcumulado/2);
	}

	@Override
	public double valorMensalidade() {
		return 250.0;
	}

}
