package lp2.lab04.p1;

public class Main {

	public static void main(String[] args) {
	
		Facade f = new Facade();
		f.inicializa(10000, 0.5);
		
		System.out.println(f.getCaixa());
		System.out.println(f.cadastrarCenario("TA SAINDO DA JAULA O MONSTRO"));
		System.out.println(f.exibirCenario(0));
		System.out.println(f.cadastrarCenario("TA SAINDO DA JAULA O PATO"));
		System.out.println(f.exibirCenarios());

		f.cadastrarAposta(0, "BAMBAM", 100, "VAI ACONTECER");
		f.cadastrarAposta(0, "BAMbi", 10, "N VAI ACONTECER");
		
		System.out.println(f.valorTotalDeApostas(0));
		System.out.println(f.valorTotalDeApostas(1));
		
		f.cadastrarAposta(1, "thi", 50, "VAI ACONTECER");
		f.cadastrarAposta(1, "biel", 30, "N VAI ACONTECER");
		
		System.out.println(f.valorTotalDeApostas(1));
		
		System.out.println(f.totalDeApostas(0));
		System.out.println(f.totalDeApostas(1));
		
		f.cadastrarAposta(1, "biel", 30, "N VAI ACONTECER");
		System.out.println(f.totalDeApostas(1));
		
		System.out.println(f.exibeApostas(0));
		System.out.println(f.exibeApostas(1));
		
		System.out.println(f.valorTotalDeApostas(0));
		System.out.println(f.valorTotalDeApostas(1));
		
		f.fecharAposta(0, true);
	
		
		System.out.println(f.getCaixaCenario(0));
		System.out.println(f.getCaixa());
		System.out.println(f.getTotalRateioCenario(0));
		
		f.fecharAposta(1, true);
		System.out.println(f.getCaixaCenario(1));
		System.out.println(f.getCaixa());
		System.out.println(f.getTotalRateioCenario(1));
		
	}

}
