package usuario;

import jogo.Jogo;
import excecoes.*;

public interface TipoUsuario {	
	public String getTipo();
	
	/**
	 * edita os pontos iniciais (que sao usados pelo usuario ao realizar mudanca de tipo)
	 * @param x2p quantidade de pontos iniciais
	 * @throws InvalidFieldValueException quando tentar colocar uma quantidade negativa de pontos (nao faz sentido pontos negativos nesse projeto)
	 */
	
	public int getStartingPoints();
	
	/**
	 * Usuario desse tipo pode comprar o jogo com o dinheiro atual?
	 * @param money dinheiro atual
	 * @param jogo jogo a ser comprado
	 * @return pode comprar?
	 * @throws InvalidFieldValueException ao adicionar jogo null ou dinheiro negativo
	 */
	public boolean podeComprar(double money, Jogo jogo) throws InvalidFieldValueException;
	
	public double calculaDesconto(Jogo jogo);
	
	public double calculaPreco(Jogo jogo);

	public int pontosPorCompra(Jogo jogo);

	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou);

	public int punir(Jogo jogo, int scoreObtido, boolean zerou);
	
}
