package usuario;

import jogo.Jogo;
import excecoes.InvalidFieldValueException;

public class Noob extends TipoUsuario {
	
	public Noob() throws InvalidFieldValueException  {
		super();
		setStartingPoints(0);
		setTipo("Noob");
	}
	
	@Override
	public double calculaDesconto(Jogo jogo){
		return jogo.getPreco()*0.10;
	}

	@Override
	public int pontosPorCompra(Jogo jogo) {
		return (int) jogo.getPreco() * 10; 
	}
	
}
