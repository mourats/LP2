package lp2.lab04p1.fachada;

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> testes = new ArrayList<>();
		testes.add("acceptance_test" + File.separator + "us1_test.txt");
		testes.add("acceptance_test" + File.separator + "us2_test.txt");
		testes.add("acceptance_test" + File.separator + "us3_test.txt");
		testes.add("acceptance_test" + File.separator + "us4_test.txt");
		EasyAccept.executeEasyAcceptTests("lp2.lab04p1.fachada.Facade", testes);
}
	
}