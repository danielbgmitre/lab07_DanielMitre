package excecoes;

public class DuplicatedUsernameException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DuplicatedUsernameException(){
		super("Valor invalido para o campo");
	}
}
