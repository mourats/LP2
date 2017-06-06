package lp2.lab02.agenda;

/**
 * Classe responsável pela criação de uma agenda com até 100 contatos.
 * 
 * Laboratório de Programação 2 - Lab 02
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public class Agenda {

	final String NL = System.lineSeparator();

	Contato[] contatos = new Contato[101];

	/**
	 * Cadastra um novo contato na agenda.
	 * 
	 * @param posicao
	 *            Posição escolhida para o contato na agenda.
	 * @param nome
	 *            Nome do contato.
	 * @param sobrenome
	 *            Sobrenome do contato.
	 * @param telefone
	 *            Telefone do contato.
	 */
	public void cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {

		Contato contato = new Contato(nome, sobrenome, telefone);
		contatos[posicao] = contato;
	}

	/**
	 * Exibe um contato escolhido pela posição dele na agenda.
	 * 
	 * @param posicao
	 *            Posição escolhida na solicitação.
	 * @return Retorna uma string com o contato escolhido.
	 */
	public String exibirContato(int posicao) {

		if (contatos[posicao] != null) {
			Contato contato = contatos[posicao];
			return "Nome do Contato: " + contato.nomeCompleto() + NL + "Telefone: " + contato.getTelefone() + NL;
		} else {
			return "CONTATO INEXISTENTE!" + NL;
		}
	}

	/**
	 * Lista os contatos existentes na agenda.
	 * 
	 * @return Retorna uma string com a lista de contatos. Caso não exista
	 *         contatos cadastados, retorna uma mensagem informando isso.
	 */
	public String listarContatos() {

		String saida = "";
		for (int index = 0; index < contatos.length; index++) {

			if (contatos[index] != null) {
				Contato contato = contatos[index];
				saida += index + " - " + contato.toString() + NL;
			}
		}
		if (saida.isEmpty())
			return "LISTA DE CONTATOS VAZIA" + NL;

		return saida;
	}
}
