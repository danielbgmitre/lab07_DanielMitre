package usuario;

import jogo.*;
import excecoes.*;

public class Veterano extends TipoUsuario {	
	
	public Veterano() throws InvalidFieldValueException  {
		super();
		setStartingPoints(1000);
		setTipo("Jogador Veterano");
	}
	
	@Override
	public double calculaDesconto(Jogo jogo) {
		return jogo.getPreco()*0.20;
	}
	
	@Override
	public int pontosPorCompra(Jogo jogo) {
		return (int) jogo.getPreco() * 15; 
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int points = 0;
		if (jogo.hasJogabilidade(Jogabilidade.ONLINE)){
			points += 10;
		}
		if (jogo.hasJogabilidade(Jogabilidade.COOPERATIVO)){
			points += 20;
		}
		return points;
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int points = 0;
		if (jogo.hasJogabilidade(Jogabilidade.COMPETITIVO)){
			points += 20;
		}
		if (jogo.hasJogabilidade(Jogabilidade.OFFLINE)){
			points += 20;
		}
		return points;
	}
}
