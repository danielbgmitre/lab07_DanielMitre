package excecoes;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(){
		super("Usuario nao encontrado no sistema");
	}

}
