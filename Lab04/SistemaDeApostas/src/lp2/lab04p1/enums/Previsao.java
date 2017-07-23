package lp2.lab04p1.enums;

/**
 * Enum responsável por encapsular a representção da previsão de uma aposta.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public enum Previsao {

	VAI_ACONTECER("VAI ACONTECER"), NAO_VAI_ACONTECER("N VAI ACONTECER");

	private final String previsao;

	private Previsao(String previsao) {
		this.previsao = previsao;
	}

	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Método responsável por identificar a previsão da aposta.
	 * 
	 * @param previsao
	 *            String da previsão que será avaliada.
	 * 
	 * @param msgErro
	 *            Mensagem de erro referente ao método que está chamando esse
	 *            método.
	 * 
	 * @return Retornar uma Previsão indentificada.
	 */
	public static Previsao identificaPrevisao(String previsao, String msgErro) throws IllegalArgumentException {
		if (previsao.equals("VAI ACONTECER"))
			return VAI_ACONTECER;
		else if (previsao.equals("N VAI ACONTECER"))
			return NAO_VAI_ACONTECER;
		else
			throw new IllegalArgumentException(msgErro + "Previsao invalida");
	}

}
