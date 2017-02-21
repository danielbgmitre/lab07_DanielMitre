package excecoes;

public class FakeHighscoreException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FakeHighscoreException(){
		super("Recorde falso");
	}
}
