package lp2.p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LeiaCSV {

	public Set<Refeicao> lerArquivo() {

		Set<Refeicao> cardapio = null;
		String arquivoCSV = "src/lp2/p3/refeicoes.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			cardapio = new HashSet<Refeicao>();

			while ((linha = br.readLine()) != null) {

				String[] leitura = linha.split(csvDivisor);

				String nome = leitura[0];
				double preco = Double.parseDouble(leitura[1]);
				int serve = Integer.parseInt(leitura[2]);

				Refeicao refeicao = new Refeicao(nome, preco, serve);
				cardapio.add(refeicao);

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cardapio;
	}

	public void escreverArquivo(String refeicao) {

		String arquivoCSV = "src/lp2/p3/refeicoes.csv";
		BufferedWriter bw;

		try {
			FileWriter arq = new FileWriter(arquivoCSV);
			bw = new BufferedWriter(arq);
			bw.write(refeicao);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}