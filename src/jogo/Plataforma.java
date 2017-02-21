package jogo;

import excecoes.*;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws InvalidFieldValueException {
		super(nome, preco);
		setTipoJogo("Plataforma");
	}

	@Override
	public int registraJogada(int score, boolean zerou) throws InvalidFieldValueException, FakeHighscoreException{
		if (score < 0){
			throw new InvalidFieldValueException();
		}
		
		increaseTimesPlayed();
		
		if (score > getHighestScore()){
			setHighestScore(score);
		}
		
		if (zerou == true){
			increaseTimesFinised();
			return 20;
			
		}
		return 0;
	}

	@Override
	public Jogo getClone() throws InvalidFieldValueException {
		Plataforma clone = new Plataforma(getNome(), getPreco());
		clone.setEstilos(getEstilos());
		return clone;
	}
}
