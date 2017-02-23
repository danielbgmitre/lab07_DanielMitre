package loja;

import jogo.*;
import usuario.*;
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
	
	public boolean vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) throws InvalidFieldValueException, UserNotFoundException{
		Jogo jogo = criaJogo(jogoNome, preco, estiloJogo, jogabilidades);
		Usuario user = usuarios.get(loginUser);
		
		return user.compraJogo(jogo);
		
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
}
