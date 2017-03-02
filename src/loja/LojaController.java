package loja;

import jogo.*;
import usuario.*;
import easyaccept.EasyAccept;
import excecoes.*;

public class LojaController {
	private UsuarioCollection usuarios;
	
	public LojaController(){
		usuarios = new UsuarioCollection();
	}
	
	public boolean criaUsuario(String nome, String login, String tipoUsuario) throws InvalidFieldValueException, DuplicatedUsernameException, TipoUsuarioNotRecognizedException{
		Usuario user = UsuarioFactory.criaUsuario(login, nome, tipoUsuario);
		return addUsuario(user);
	}
	
	public boolean addUsuario(Usuario user) throws DuplicatedUsernameException, InvalidFieldValueException {
		if (usuarios.hasUsuario(user)){
			throw new DuplicatedUsernameException();
		} else {
			usuarios.add(user);
			return true;
		}
	}
	
	public void fazUpgrade(String username) throws InvalidFieldValueException, UserNotFoundException{
		fazUpgrade(usuarios.get(username));
	}
	
	public void fazUpgrade(Usuario user) throws InvalidFieldValueException, UserNotFoundException {
		if (usuarios.hasUsuario(user)){
			user.upgrade();
		} else {
			throw new UserNotFoundException();
		}
	}
	
	public boolean adicionaCredito(String login, double credito) throws InvalidFieldValueException, UserNotFoundException {
		if (usuarios.hasUsuario(login)){
			return usuarios.get(login).addMoney(credito);
		} else {
			throw new UserNotFoundException();
		}
		
	}
	
	public double confereCredito(String login) throws InvalidFieldValueException, UserNotFoundException{
		return usuarios.get(login).getMoney();
	}
	
	public int getX2p(String login) throws InvalidFieldValueException, UserNotFoundException{
		return usuarios.get(login).getX2p();
	}
	
	public boolean vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) throws InvalidFieldValueException, UserNotFoundException{
		Jogo jogo = criaJogo(jogoNome, preco, estiloJogo, jogabilidades);
		Usuario user = usuarios.get(loginUser);
		
		return user.compraJogo(jogo);
		
	}
	
	public boolean upgrade(String login) throws InvalidFieldValueException, UserNotFoundException{
		return usuarios.get(login).upgrade();
	}
	
	public Jogo criaJogo(String jogoNome, double preco, String estiloJogo, String jogabilidades) throws InvalidFieldValueException{
		return JogoFactory.criaJogo(jogoNome, preco, jogabilidades, estiloJogo);
	}

	/*public boolean vendeJogo(String login, Jogo jogo) throws InvalidFieldValueException, UserNotFoundException {
		if (usuarios.hasUsuario(login)){
			return usuarios.get(login).compraJogo(jogo);
		} else {
			throw new UserNotFoundException();
		}
	}*/
	
	public void listarUsuarios(){
		System.out.println("=== Central P2-CG ===\n");
		usuarios.listarUsuarios();
	}
	
	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException, UserNotFoundException{
		usuarios.get(login).punir(nomeJogo, scoreObtido, zerou);
	}
	
	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException, UserNotFoundException{
		usuarios.get(login).recompensar(nomeJogo, scoreObtido, zerou);
	}
}
