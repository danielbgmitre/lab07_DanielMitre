package excecoes;

public class InvalidFieldValueException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidFieldValueException(){
		super("Valor invalido para o campo");
	}
}
