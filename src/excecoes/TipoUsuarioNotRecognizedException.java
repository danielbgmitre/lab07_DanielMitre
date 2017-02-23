package excecoes;

public class TipoUsuarioNotRecognizedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public TipoUsuarioNotRecognizedException(){
		super("Tipo de usuario requisitado nao foi reconhecido pelo sistema");
	}
}
