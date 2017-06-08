package lp2.simulado1;

public class Jogador {

	private String nome;

	private String cpf;

	private double salario;

	public Jogador(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		Jogador ref = (Jogador) obj;
		if (this.cpf == null) {
			if (ref.cpf != null)
				return false;
		} else if (!this.cpf.equals(ref.cpf))
			return false;
		
		return true;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.salario;
	}

}
