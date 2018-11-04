package lp2.prova3.exceptions;

public class SeguradoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Segurado nao existe";
	}

	
}
