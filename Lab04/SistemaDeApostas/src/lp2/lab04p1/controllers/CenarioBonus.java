package lp2.lab04p1.controllers;

import lp2.lab04p1.util.Checks;

/**
 * Classe responsável por moldar a representação de um cenário bônus e controlar
 * as apostas destinadas a esse tipo de cenário.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class CenarioBonus extends Cenario {

	private int bonus;

	/**
	 * Construtor responsável por inicializar um cenário bonus validando antes
	 * seu bonus.
	 * 
	 * @param descricao
	 *            Descrição do novo cenário.
	 * @param bonus
	 *            Bonus do novo cenário.
	 */
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);

		String msgErro = "Erro no cadastro de cenario: ";
		Checks.verificaBonusInvalido(bonus, msgErro);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		double representacaoDoubleBonus = ((double) this.bonus) / 100;
		String representacaoStringBonus = String.format("%.2f", representacaoDoubleBonus);
		return super.toString() + " - R$ " + representacaoStringBonus;
	}

	/**
	 * Método responsável por sobrescrever o valor total arrecadado dos
	 * perdedores modificado de um cenário adicionando seu bonus.
	 */
	@Override
	public int getValorTotalArrecadadoPerdedoresModificado() {
		int valorTotalPerdedores = super.getValorTotalArrecadadoPerdedoresPadrao();
		valorTotalPerdedores += this.bonus;
		return valorTotalPerdedores;
	}

}
