package jogo;

import excecoes.*;

public class Luta extends Jogo {

	public Luta(String nome, double preco) throws InvalidFieldValueException  {
		super(nome, preco);
		setTipoJogo("Luta");
	}
	
	@Override
	public int registraJogada(int score, boolean zerou) throws InvalidFieldValueException, FakeHighscoreException{
		if (score < 0){
			throw new InvalidFieldValueException();
		}
		int bonusX2P = 0;
		increaseTimesPlayed();
		
		if (score > getHighestScore()){
			setHighestScore(score);
			bonusX2P = Math.floorDiv(score, 1000);
		}
		
		if (zerou){
			increaseTimesFinised();
		}
		
		return bonusX2P;
	}

	public Jogo getClone() throws InvalidFieldValueException {
		Luta clone = new Luta(getNome(), getPreco());
		clone.setEstilos(getEstilos());
		return clone;
	}
}
