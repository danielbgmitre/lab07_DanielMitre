package usuario;

import jogo.Jogabilidade;
import jogo.Jogo;
import excecoes.InvalidFieldValueException;

public class Noob extends TipoUsuario {
	
	public Noob() throws InvalidFieldValueException  {
		super();
		setStartingPoints(0);
		setTipo("Jogador Noob");
	}
	
	@Override
	public double calculaDesconto(Jogo jogo){
		return jogo.getPreco()*0.10;
	}

	@Override
	public int pontosPorCompra(Jogo jogo) {
		return (int) jogo.getPreco() * 10; 
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int points = 0;
		if (jogo.hasJogabilidade(Jogabilidade.OFFLINE)){
			points += 30;
		}
		if (jogo.hasJogabilidade(Jogabilidade.MULTIPLAYER)){
			points += 10;
		}
		return points;
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int points = 0;
		if (jogo.hasJogabilidade(Jogabilidade.ONLINE)){
			points += 10;
		}
		if (jogo.hasJogabilidade(Jogabilidade.COMPETITIVO)){
			points += 20;
		}
		if (jogo.hasJogabilidade(Jogabilidade.COOPERATIVO)){
			points += 50;
		}
		return points;
	}


}
