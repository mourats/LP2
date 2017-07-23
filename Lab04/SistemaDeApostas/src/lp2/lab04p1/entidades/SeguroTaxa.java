package lp2.lab04p1.entidades;

/**
 * Classe responsável por moldar a representação de Seguro por taxa para esse
 * Sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class SeguroTaxa extends Seguro {

	private double taxa;

	/**
	 * Construtor responsável por inicializar um Seguro do tipo Taxa.
	 * 
	 * @param tipo
	 *            Tipo do seguro.
	 * 
	 * @param taxa
	 *            Taxa do seguro.
	 */
	public SeguroTaxa(String tipo, double taxa) {
		super(tipo);
		this.taxa = taxa;

	}

	@Override
	public String toString() {
		int representacaoInteiraTaxa = (int) (taxa * 100);
		return super.toString() + " - " + representacaoInteiraTaxa + "%";
	}

	@Override
	public int retornaSeguro(int aposta) {
		return (int) (aposta * this.taxa);
	}
}
