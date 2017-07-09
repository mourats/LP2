package lp2.lab04.p1;

import java.util.HashMap;
import java.util.Map;

public class Sistema {

	private final String NL = System.lineSeparator();

	private double taxa;
	private int caixa;
	private Map<Integer, Cenario> cenarios;
	private int idCenario;

	public Sistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new HashMap<Integer, Cenario>();
		idCenario = 0;
	}

	public int getCaixa() {
		return caixa;
	}

	public void cadastrarCenario(String descricao) {

		Cenario cenario = new Cenario(descricao);
		cenarios.put(idCenario, cenario);
		idCenario++;
	}

	public String exibirCenario(int cenario) {
		return cenarios.get(cenario).toString();
	}

	public String exibirCenarios() {
		
		String stringRetorno = "";
		for (Cenario cenario : cenarios.values())
			stringRetorno += cenario.toString() + NL;

		return stringRetorno;
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		Cenario refCenario = cenarios.get(cenario);
		refCenario.adicionarNovaAposta(apostador, valor, previsao);
		
	}

	public int valorTotalApostas(int cenario) {
		Cenario refCenario = cenarios.get(cenario);
		return refCenario.valorTotalApostasCenario();
	}

	public int totalDeApostas(int cenario) {
		Cenario refCenario = cenarios.get(cenario);
		return refCenario.totalApostasCenario();
	}

	public String exibeApostas(int cenario) {
		Cenario refCenario = cenarios.get(cenario);
		return refCenario.exibirApostasCenario();
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		Cenario refCenario = cenarios.get(cenario);
		refCenario.fecharApostaCenario(ocorreu);
		this.caixa += getCaixaCenario(cenario);
		
	}

	public int getCaixaCenario(int cenario) {
		Cenario refCenario = cenarios.get(cenario);
		return (int) (refCenario.getValorTotalPerdedores() * this.taxa);
	
	}

	public int getTotalRateioCenario(int cenario) {
		Cenario refCenario = cenarios.get(cenario);
		int valor = (int) (refCenario.getValorTotalPerdedores() - (refCenario.getValorTotalPerdedores() * this.taxa));
		return valor; 
	}

}
