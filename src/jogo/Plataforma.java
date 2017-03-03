package jogo;

import excecoes.*;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws InvalidFieldValueException {
		super(nome, preco);
	}

	@Override
	public String getTipoJogo(){
		return "Luta";
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
			increaseTimesFinished();
			return 20;
			
		}
		return 0;
	}
}
