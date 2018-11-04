package lp2.prova3.entidades;
import java.time.LocalDate;

public class Segurado {
	
	private String nome;
	private String CPF;
	private String telefone;
	private int anoNascimento;

	public Segurado(String nome, String cPF, String telefone, int anoNascimento) {
		if (nome == null || nome.trim().equals("") || cPF == null
				|| cPF.trim().equals("") || telefone == null
				|| telefone.trim().equals(""))
			throw new IllegalArgumentException(
					"Todo segurado deve ter um nome, CPF e telefone validos.");
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
		this.anoNascimento = anoNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segurado other = (Segurado) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		return true;
	}

	public int getIdadeDoSegurado() {
		return LocalDate.now().getYear() - anoNascimento;
	}

	@Override
	public String toString() {
		return "Segurado [nome=" + nome + ", CPF=" + CPF + ", telefone="
				+ telefone + ", anoNascimento=" + anoNascimento + "]";
	}

}
