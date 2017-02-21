package jogo;

import excecoes.FakeHighscoreException;
import excecoes.InvalidFieldValueException;

public class RPG extends Jogo {

	public RPG(String nome, double preco) throws InvalidFieldValueException  {
		super(nome, preco);
		setTipoJogo("RPG");
	}
	
	@Override
	public int registraJogada(int score, boolean zerou) throws InvalidFieldValueException, FakeHighscoreException {
		super.registraJogada(score, zerou);
		return 10;
	}
	
	public Jogo getClone() throws InvalidFieldValueException  {
		RPG clone = new RPG(getNome(), getPreco());
		clone.setEstilos(getEstilos());
		return clone;
	}
}
