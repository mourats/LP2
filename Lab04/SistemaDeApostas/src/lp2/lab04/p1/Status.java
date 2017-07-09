package lp2.lab04.p1;

public enum Status {

	NAO_FINALIZADO("Não finalizado"), FINALIZADO_TRUE("Finalizado (ocorreu)"), FINALIZADO_FALSE(
			"Finalizado (n ocorreu)");

	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
