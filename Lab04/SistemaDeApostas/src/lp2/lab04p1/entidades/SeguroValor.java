package lp2.lab04p1.entidades;

public class SeguroValor extends Seguro {

	private int valor;

	/**
	 * Construtor responsável por inicializar um Seguro do tipo Valor.
	 * 
	 * @param tipo
	 *            Tipo do seguro.
	 * @param valor
	 *            Valor do seguro.
	 */
	public SeguroValor(String tipo, int valor) {
		super(tipo);
		this.valor = valor;
	}

	@Override
	public String toString() {
		double representacaoDoubleValor = ((double) this.valor) / 100;
		String representacaoStringValor = String.format("%.2f", representacaoDoubleValor);

		return super.toString() + " - R$ " + representacaoStringValor;
	}

	@Override
	public int retornaSeguro(int aposta) {
		return valor;
	}
}
