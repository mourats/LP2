package lp2.simulado1;

public class Time {

	Jogador[] jogadores = new Jogador[11];

	private String nomeTime;

	public Time(String nome) {
		this.nomeTime = nome;
	}

	public String getNomeTime() {
		return this.nomeTime;
	}

	public boolean adicionaJogador(String nome, String cpf, double salario) {

		Jogador jogador = new Jogador(nome, cpf, salario);
		boolean guard = false;

		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i] == null) {
				jogadores[i] = jogador;
				guard = true;
				break;
			}
		}
		return guard;
	}

	public String listaJogador(String cpf) {

		for (int i = 0; i < jogadores.length; i++) {
			if(jogadores[i] != null){
				Jogador jogador = jogadores[i];
				if (jogador.getCpf() == cpf) {
					return jogador.toString();
				}
			}
		}
		return "Jogador não encontrado!";
	}

	public double calculaValor() {
		double valorTotal = 0.0;
		int contJogadores = 0;

		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i] != null) {
				Jogador jogador = jogadores[i];
				valorTotal += jogador.getSalario();
				contJogadores++;
			}
		}
		double mediaAritmetica = valorTotal / contJogadores;
		return mediaAritmetica;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		Time ref = (Time) obj;

		double valorTime = this.calculaValor();
		double valorTimeRef = ref.calculaValor();

		if (valorTime != valorTimeRef) {
			return false;
		}

		if (this.getNomeTime() != ref.getNomeTime()) {
			return false;
		}

		return true;

	}
}
