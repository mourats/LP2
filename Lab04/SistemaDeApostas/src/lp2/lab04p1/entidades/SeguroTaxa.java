package lp2.lab04p1.entidades;

/**
 * Classe responsável por moldar a representação de Seguro por taxa para esse Sistema.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class SeguroTaxa extends Seguro{

	private double taxa;
	
	public SeguroTaxa(double taxa){
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

}
