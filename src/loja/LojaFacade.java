package loja;

import easyaccept.EasyAccept;
import excecoes.DuplicatedUsernameException;
import excecoes.FakeHighscoreException;
import excecoes.GameNotFoundException;
import excecoes.InvalidFieldValueException;
import excecoes.TipoUsuarioNotRecognizedException;
import excecoes.UserNotFoundException;

public class LojaFacade {
	private LojaController lojacontroller;
	
	public LojaFacade(){
		lojacontroller = new LojaController();
	}
	
	public static void main(String[] args) {
		args = new String[] { "loja.LojaFacade", "acceptance_tests/us1.txt", "acceptance_tests/us2.txt",  "acceptance_tests/us3.txt" };
		EasyAccept.main(args);

	}
	
	public boolean criaUsuario(String nome, String login, String tipoUsuario) throws InvalidFieldValueException, DuplicatedUsernameException, TipoUsuarioNotRecognizedException{
		return lojacontroller.criaUsuario(nome, login, tipoUsuario);
	}
	
	public boolean adicionaCredito(String login, double credito) throws InvalidFieldValueException, UserNotFoundException{
		return lojacontroller.adicionaCredito(login, credito);
	}
	
	public double confereCredito(String login) throws InvalidFieldValueException, UserNotFoundException{
		return lojacontroller.confereCredito(login);
	}
	
	public boolean vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) throws InvalidFieldValueException, UserNotFoundException {
		return lojacontroller.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}
	
	public void upgrade(String login) throws InvalidFieldValueException, UserNotFoundException {
		lojacontroller.upgrade(login);
	}
	
	public int getX2p(String login) throws InvalidFieldValueException, UserNotFoundException{
		return lojacontroller.getX2p(login);
	}
	
	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException, UserNotFoundException{
		lojacontroller.punir(login, nomeJogo, scoreObtido, zerou);
	}
	
	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException, UserNotFoundException{
		lojacontroller.recompensar(login, nomeJogo, scoreObtido, zerou);
	}
	
}
