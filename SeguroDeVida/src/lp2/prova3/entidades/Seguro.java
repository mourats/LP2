package lp2.prova3.entidades;

import java.time.LocalDate;

import lp2.prova3.interfaces.TipoSeguro;

public class Seguro {

	private int ano;
	private double saldo;
	private TipoSeguro tipo;

	public Seguro(int ano, String tipo) {
		this.ano = ano;
		this.saldo = 0.0;
		this.tipo = identificaTipoSeguro(tipo);
	}

	public void recebePagamento() {
		this.saldo = tipo.valorMensalidade();
	}

	public double getValorPagamentoMensalPorDoenca() {
		
		double valorPagamento = tipo.pagamentoMensalPorDoenca(LocalDate.now().getYear() - this.ano, this.saldo);
		this.saldo -= valorPagamento;
		return valorPagamento;
	}

	public void setTipoDeSeguro(String tipo) {
		this.tipo = identificaTipoSeguro(tipo);
	}

	private TipoSeguro identificaTipoSeguro(String tipoSeguro) {

		TipoSeguro seguro = null;

		if (tipoSeguro.equals("Basico"))
			seguro = new Basico();
		if (tipoSeguro.equals("Pleno"))
			seguro = new Pleno();

		return seguro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguro other = (Seguro) obj;

		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public String getTipo() {
		return this.tipo.getTipo();
	}

}
