package lp2.lab04p1.fachada;

/**
 * Classe responsável por ser a classe fachada do projeto, realiazando a comunicando front-end com back-end.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

import lp2.lab04p1.controllers.Sistema;

public class Facade {

	private Sistema sistema;

	public void inicializa(int caixa, double taxa) {
		sistema = new Sistema(caixa, taxa);
	}

	public int getCaixa() {
		return sistema.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return sistema.cadastrarCenario(descricao);
	}

	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalApostas(cenario);
	}

	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}

}
