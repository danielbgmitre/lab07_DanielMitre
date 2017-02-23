package usuario;

import java.util.HashMap;

import excecoes.*;

public class UsuarioCollection {
	private HashMap<String, Usuario> usuarios;
	
	public UsuarioCollection(){
		usuarios = new HashMap<String, Usuario>();
	}
	
	public boolean hasUsuario(Usuario user) throws InvalidFieldValueException{
		if (user == null){
			throw new InvalidFieldValueException();
		}
		return hasUsuario(user.getUsername());
	}
	
	public Usuario get(String username) throws InvalidFieldValueException, UserNotFoundException{
		if (hasUsuario(username)){
			return usuarios.get(username);
		} else {
			throw new UserNotFoundException();
		}
	}
	
	public boolean hasUsuario(String username) throws InvalidFieldValueException{
		if (username == null || username.trim().equals("")){
			throw new InvalidFieldValueException();
		}
		return usuarios.containsKey(username);
	}
	
	public boolean add(Usuario user) throws InvalidFieldValueException{
		if (hasUsuario(user)){
			return false;
		} else {
			usuarios.put(user.getUsername(), user);
			return true;
		}
	}
	
	public boolean remove(Usuario user) throws InvalidFieldValueException{
		if (hasUsuario(user)){
			usuarios.remove(user.getUsername());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean remove(String username) throws InvalidFieldValueException{
		if (hasUsuario(username)){
			usuarios.remove(username);
			return true;
		} else {
			return false;
		}
	}

	public void listarUsuarios() {
		boolean primeiro = true;
		for (Usuario u : usuarios.values()){
			if (!primeiro){
				System.out.println("--------------------------------------------");
			}
			primeiro = false;
			System.out.println(u.getTipoName() + ": " + u.getUsername());
			System.out.println(u.getNome() + " - " + u.getX2p());
			u.listarJogos();
		}
	}
}
