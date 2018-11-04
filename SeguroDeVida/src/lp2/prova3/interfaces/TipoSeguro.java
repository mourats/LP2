package lp2.prova3.interfaces;

public interface TipoSeguro {
	
	public String getTipo();
	
	public double valorMensalidade();

	public double valorAcumulado();
	
	public double pagamentoMensalPorDoenca(int idadeSeguro, double saldoAcumulado);
}
