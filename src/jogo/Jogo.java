package jogo;
import java.util.HashSet;

import excecoes.*;


public class Jogo {	
	private String tipoJogo = "Tipo padrao de jogo";
	private String nome;
	private double preco;
	
	private HashSet<Jogabilidade> estilos;
	
	private int highestScore;
	private int timesPlayed;
	private int timesFinished;
	
	/**
	 * Construtor da classe jogo
	 * @param nome nome do jogo
	 * @param preco preco base do jogo
	 * @throws InvalidFieldValueException ao inserir um nome invalido ou preco negativo
	 */
	public Jogo(String nome, double preco) throws InvalidFieldValueException {
		if (nome == null || nome.trim().equals("") || preco < 0){
			throw new InvalidFieldValueException();
		}
		
		estilos = new HashSet<Jogabilidade>();
		
		this.nome = nome;
		this.preco = preco;
		
		highestScore = timesPlayed = timesFinished = 0;
	}
	
	public String getTipoJogo(){
		return tipoJogo;
	}
	
	/**
	 * Muda o nome do tipo do jogo, nao afeta o funcionamento (usado ao listar os jogos)
	 * @param s nome do tipo do jogo
	 * @throws InvalidFieldValueException quando insere um nome invalido
	 */
	public void setTipoJogo(String s) throws InvalidFieldValueException {
		if (s == null || s.trim().equals("")){
			throw new InvalidFieldValueException();
		}
		tipoJogo = s;
	}
	
	/**
	 * cria um objeto clonado a partir de si (deve ser sobrescrito nas subclasses)
	 * @return clone de si proprio
	 * @throws InvalidFieldValueException ao tentar copiar um objeto com nome ou preco invalido
	 */
	public Jogo getClone() throws InvalidFieldValueException {
		Jogo clone = new Jogo(nome, preco);
		clone.setEstilos(getEstilos());
		return clone;
	}
	
	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	/**
	 * define o novo preco
	 * @param preco novo preco
	 * @throws InvalidFieldValueException ao tentar alterar para um preco negativo
	 */
	private void setPreco(double preco) throws InvalidFieldValueException {
		if (preco < 0){
			throw new InvalidFieldValueException();
		}
		this.preco = preco;
	}
	
	
	public void addEstilo(Jogabilidade estilo){
		estilos.add(estilo);
	}
	
	/**
	 * retorna todos os estilos (utilizado ao criar um clone)
	 * @return objeto com os estilos
	 */
	public HashSet<Jogabilidade> getEstilos(){
		HashSet<Jogabilidade> copiaEstilos = new HashSet<Jogabilidade>();
		for (Jogabilidade e : estilos) {
			copiaEstilos.add(e);
		}
		return copiaEstilos;
	}

	
	/**
	 * define os novos estilos (utilizado ao criar um clone)
	 * @param estilos hashset recebido pelo getEstilos()
	 */
	public void setEstilos(HashSet<Jogabilidade> estilos){
		this.estilos = estilos;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int score) throws FakeHighscoreException {
		if (score > this.highestScore) {
			this.highestScore = score;
		} else {
			throw new FakeHighscoreException();
		}
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}

	public void increaseTimesPlayed(){
		timesPlayed++;
	}

	public int getTimesFinished() {
		return timesFinished;
	}
	
	public void increaseTimesFinised(){
		timesFinished++;
	}

	public int registraJogada(int pontos, boolean zerou) throws InvalidFieldValueException, FakeHighscoreException {
		if (pontos < 0){
			throw new InvalidFieldValueException();
		}
		
		increaseTimesPlayed();
		
		if (pontos > highestScore){
			setHighestScore(pontos);
		}
		if (zerou){
			increaseTimesFinised();
		}
		
		return 0; //x2p
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		
		if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	 
}
