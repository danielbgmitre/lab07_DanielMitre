package usuario;

import jogo.Jogo;
import excecoes.*;

public abstract class TipoUsuario {
	private String nomeTipo = "Default";
	private int startingPoints = 0;
	
	public String getTipo(){
		return nomeTipo;
	}
	
	public void setTipo(String tipo) throws InvalidFieldValueException{
		if (tipo.trim().equals("") || tipo == null){
			throw new InvalidFieldValueException();
		} else {
			nomeTipo = tipo;
		}
	}
	
	/**
	 * edita os pontos iniciais (que sao usados pelo usuario ao realizar mudanca de tipo)
	 * @param x2p quantidade de pontos iniciais
	 * @throws InvalidFieldValueException quando tentar colocar uma quantidade negativa de pontos (nao faz sentido pontos negativos nesse projeto)
	 */
	public void setStartingPoints(int x2p) throws InvalidFieldValueException{
		if (x2p < 0){
			throw new InvalidFieldValueException();
		} else {
			startingPoints = x2p;
		}
	}
	
	public int getStartingPoints(){
		return startingPoints;
	}
	
	/**
	 * Usuario desse tipo pode comprar o jogo com o dinheiro atual?
	 * @param money dinheiro atual
	 * @param jogo jogo a ser comprado
	 * @return pode comprar?
	 * @throws InvalidFieldValueException ao adicionar jogo null ou dinheiro negativo
	 */
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
	
	public double calculaDesconto(Jogo jogo){
		return 0;
	}
	
	public double calculaPreco(Jogo jogo){
		return jogo.getPreco() - calculaDesconto(jogo);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public abstract int pontosPorCompra(Jogo jogo);
	
}
