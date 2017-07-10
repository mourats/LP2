package lp2.lab04.p1;

import java.util.HashSet;
import java.util.Set;

import lp2.lab04.p1.enums.Previsao;
import lp2.lab04.p1.enums.Status;
import lp2.lab04.p1.util.Checks;

public class Cenario {

	private final String NL = System.lineSeparator();

	private String descricao;
	private Status estado;

	private Set<Aposta> apostas;

	public Cenario(String descricao) {
		
		Checks.verificaDescricaoNula(descricao);
		Checks.verificaDescricaoVazia(descricao);
		
		this.descricao = descricao;
		this.estado = Status.NAO_FINALIZADO;
		this.apostas = new HashSet<Aposta>();
	}

	@Override
	public String toString() {
		return this.descricao + " - " + this.estado.getStatus();
	}

	public void adicionarNovaAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		apostas.add(aposta);

	}

	public int valorTotalApostasCenario() {
		int valorTotal = 0;
		for (Aposta aposta : apostas) {
			valorTotal += aposta.getValor();
		}
		return valorTotal;
	}

	public int totalApostasCenario() {
		return apostas.size();
	}

	public String exibirApostasCenario() {

		String stringRetorno = "";
		for (Aposta aposta : apostas)
			stringRetorno += aposta.toString() + NL;

		return stringRetorno;
	}

	public void fecharApostaCenario(boolean ocorreu) {
		if (ocorreu)
			this.estado = Status.FINALIZADO_TRUE;
		else
			this.estado = Status.FINALIZADO_FALSE;

	}

	public int getValorTotalPerdedores() {
		int valorTotal = 0;
		boolean resultado;
		resultado = resultadoCenario();
		for (Aposta aposta : apostas) {
			if (aposta.getPrevisao().equals(Previsao.VAI_ACONTECER)) {
				if (!resultado)
					valorTotal += aposta.getValor();
			} else {
				if (resultado)
					valorTotal += aposta.getValor();
			}
		}
		return valorTotal;
	}

	private boolean resultadoCenario() {
		boolean resultado;
		if (this.estado.equals(Status.FINALIZADO_TRUE))
			resultado = true;
		else
			resultado = false;
		return resultado;
	}
}
