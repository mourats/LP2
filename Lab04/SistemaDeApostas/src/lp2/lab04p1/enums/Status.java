package lp2.lab04p1.enums;

/**
 * Enum responsável por encapsular a representação de um estado de um cenário.
 * 
 * Laboratório de Programação 2 - Lab 04 Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 */

public enum Status {

	NAO_FINALIZADO("Nao finalizado"), FINALIZADO_TRUE("Finalizado (ocorreu)"), FINALIZADO_FALSE(
			"Finalizado (n ocorreu)");

	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
