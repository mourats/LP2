package lp2.prova3.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import lp2.prova3.entidades.Segurado;
import lp2.prova3.entidades.Seguro;
import lp2.prova3.exceptions.SeguradoJaExisteException;
import lp2.prova3.exceptions.SeguradoNaoExisteException;

public class Agencia {

	private Map<Segurado, Seguro> segurados;

	public Agencia() {
		segurados = new HashMap<Segurado, Seguro>();
	}

	public void adicionaSeguroASegurado(String nome, String cpf, String telefone, int anoNascimento,
			String tipoSeguro) {

		verificaExistenciaSegurado(cpf);

		Segurado segurado = new Segurado(nome, cpf, telefone, anoNascimento);
		Seguro seguro = new Seguro(LocalDate.now().getYear(), tipoSeguro);

		segurados.put(segurado, seguro);

	}

	public void mudaTipoSeguro(String cpf, String novoSeguro) {

		Segurado segurado = identicaSegurado(cpf);

		Seguro seguro = segurados.get(segurado);

		seguro.setTipoDeSeguro(novoSeguro);
	}

	public void pagaMensalidadeSeguro(String cpf) {

		Segurado segurado = identicaSegurado(cpf);

		Seguro seguro = segurados.get(segurado);

		seguro.recebePagamento();

	}

	public double valorPagamentoMensalPorDoenca(String cpf) {

		Segurado segurado = identicaSegurado(cpf);

		Seguro seguro = segurados.get(segurado);

		return seguro.getValorPagamentoMensalPorDoenca();
	}

	public void salvaAgencia() {

		try {

			FileOutputStream fos = new FileOutputStream("arquivo.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			for (Segurado segurado : segurados.keySet()) {
				oos.writeObject(segurado);
				oos.writeObject(segurados.get(segurado));
			}
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Segurado identicaSegurado(String cpf) {

		for (Segurado segurado : segurados.keySet()) {
			if (segurado.getCPF().equals(cpf))
				return segurado;
		}
		throw new SeguradoNaoExisteException();
	}

	private void verificaExistenciaSegurado(String cpf) {

		for (Segurado segurado : segurados.keySet()) {
			if (segurado.getCPF().equals(cpf))
				throw new SeguradoJaExisteException();
		}
	}

}
