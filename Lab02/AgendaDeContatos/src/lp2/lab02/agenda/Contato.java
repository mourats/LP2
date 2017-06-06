package lp2.lab02.agenda;

/**
 * Classe responsável pela representação de um molde contato.
 * 
 * Laboratório de Programação 2 - Lab 02
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Contato {

	private String nome;
	private String sobrenome;
	private String telefone;

	/**
	 * Construtor responsável para criação de um contato após a validação de seus
	 * dados.
	 * 
	 * @param nome
	 *            Nome do novo contato.
	 * @param sobrenome
	 *            Sobrenome do novo contato.
	 * @param telefone
	 *            Telefone do novo contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {

		Checks.verificaNomeNulo(nome);
		Checks.verificaSobrenomeNulo(sobrenome);
		Checks.verificaTelefoneNulo(telefone);

		Checks.verificaNomeVazio(nome);
		Checks.verificaSobrenomeVazio(sobrenome);
		Checks.verificaTelefoneVazio(telefone);

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * @return Retorna o telefone do contato.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @return Retorna o nome e sobrenome concatenado.
	 */
	public String nomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}

	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}

}
