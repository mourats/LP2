package lp2.p3;

public class Refeicao {

	private String nome;
	
	private double preco;
	
	private int serve;
	
	
	public Refeicao(String nome, double preco, int serve){
		this.nome = nome;
		this.preco = preco;
		this.serve = serve;
	}
	
	@Override
	public String toString() {
		return "Refeicao [nome=" + nome + ", preco=" + preco + ", serve=" + serve + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getServe() {
		return serve;
	}

	public void setServe(int serve) {
		this.serve = serve;
	}


}
