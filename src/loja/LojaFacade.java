package loja;

import easyaccept.EasyAccept;

public class LojaFacade {
	private LojaController lojacontroller;
	
	public LojaFacade(){
		lojacontroller = new LojaController();
	}
	
	
	public static void main(String[] args) {
		args = new String[] { "loja.LojaFacade", "acceptance_tests/us1.txt", "acceptance_tests/us2.txt",  "acceptance_tests/us3.txt" };
		EasyAccept.main(args);

	}	
}
