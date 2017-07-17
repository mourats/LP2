package lp2.lab04p1.entidades;

public class SeguroValor extends Seguro {

	private int valor;

	/**
	 * Construtor responsável por inicializar um Seguro do tipo Valor.
	 * 
	 * @param valor
	 *            Valor do seguro.
	 */
	public SeguroValor(int valor) {
		this.valor = valor;
		super.setTipo("VALOR");
	}

	@Override
	public String toString() {
		double representacaoDoubleValor = ((double) this.valor) / 100;
		String representacaoStringValor = String.format("%.2f", representacaoDoubleValor);

		return super.toString() + " - R$ " + representacaoStringValor;
	}

	public int getValor() {
		return valor;
	}
}
