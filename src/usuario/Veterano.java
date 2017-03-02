package usuario;

import jogo.*;
import excecoes.*;

public class Veterano implements TipoUsuario {	
	
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

	@Override
	public String getTipo() {
		return "Jogador Veterano";
	}

	@Override
	public int getStartingPoints() {
		return 1000;
	}

	@Override
	public boolean podeComprar(double money, Jogo jogo) throws InvalidFieldValueException{
		if (money < 0 || jogo == null){
			throw new InvalidFieldValueException();
		}
		if (money >= calculaPreco(jogo)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double calculaPreco(Jogo jogo) {
		return jogo.getPreco() - this.calculaDesconto(jogo);
	}
}
