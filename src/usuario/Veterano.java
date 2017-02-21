package usuario;

import jogo.Jogo;
import excecoes.InvalidFieldValueException;

public class Veterano extends TipoUsuario {	
	public Veterano() throws InvalidFieldValueException  {
		super();
		setStartingPoints(1000);
		setTipo("Veterano");
	}
	
	@Override
	public double calculaDesconto(Jogo jogo) {
		return jogo.getPreco()*0.20;
	}
	
	@Override
	public int pontosPorCompra(Jogo jogo) {
		return (int) jogo.getPreco() * 15; 
	}
}
