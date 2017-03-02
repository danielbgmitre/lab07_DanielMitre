package usuario;

import jogo.Jogo;
import jogo.JogoCollection;
import excecoes.*;

public class Usuario {	
	
	private String username;
	private String nome;
	private double money;
	private int x2pPoints;
	private TipoUsuario tipo;
	private JogoCollection jogos;
	
	public Usuario(String username, String nome) throws InvalidFieldValueException{
		this(username, nome, null);
	}
	
	public Usuario(String username, String nome, TipoUsuario tipoUsuario) throws InvalidFieldValueException  {
		
		this.username = username;
		this.nome = nome;
		money = 0;
		
		if (tipoUsuario == null){
			this.tipo = new Noob();
		} else {
			this.tipo = tipoUsuario;
		}
		
		x2pPoints = this.tipo.getStartingPoints();
		
		jogos = new JogoCollection();
	}
	
	
	
	
	public String getUsername(){
		return username;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getTipoName(){
		return tipo.getTipo();
	}
	
	public int getX2p(){
		return x2pPoints;
	}
	
	public boolean upgrade() throws InvalidFieldValueException  {
		if ((tipo.getClass() == Noob.class) && x2pPoints >= 1000){
			Veterano upgraded = new Veterano();
			mudarTipo(upgraded);
			return true;
		}
		return false;
	}
	
	public void mudarTipo(TipoUsuario novoTipo){
		tipo = novoTipo;
	}
	
	public void addX2p(int x2p) throws InvalidFieldValueException  {
		if (x2p < 0){
			throw new InvalidFieldValueException();
		} else {
			this.x2pPoints += x2p;
		}
	}
	
	public void removeX2p(int x2p) throws InvalidFieldValueException  {
		if (x2p < 0){
			throw new InvalidFieldValueException();
		} else {
			this.x2pPoints -= x2p;
		}
	}
	
	public boolean podeComprar(Jogo jogo) throws InvalidFieldValueException {
		return tipo.podeComprar(money, jogo);
	}
	
	public double calculaPreco(Jogo jogo){
		return tipo.calculaPreco(jogo);
	}
	
	public boolean addMoney(double money) throws InvalidFieldValueException{
		if (money <= 0){
			throw new InvalidFieldValueException();
		} else {
			this.money += money;
			return true;
		}
	}
	
	public double getMoney(){
		return money;
	}
	
	public boolean compraJogo(Jogo jogo) throws InvalidFieldValueException  {
		if (tipo.podeComprar(money, jogo)){
			this.money -= (tipo.calculaPreco(jogo));
			//jogos.add(jogo.getClone());
			jogos.add(jogo);
			addX2p(tipo.pontosPorCompra(jogo));
			return true;
		} else {
			return false;
		}
	}

	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException  {
		if (nomeDoJogo == null || nomeDoJogo.trim().equals("")){
			throw new InvalidFieldValueException();
		}		
		Jogo jogo = jogos.get(nomeDoJogo);
		if (jogo == null){
			throw new GameNotFoundException();
		} 
		int points = jogo.registraJogada(score, zerou);
		
		addX2p(points);
	}
	
	public void recompensar(String nomeDoJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException{
		registraJogada(nomeDoJogo, scoreObtido, zerou);
		Jogo jogo = jogos.get(nomeDoJogo);
		
		addX2p(tipo.recompensar(jogo, scoreObtido, zerou));		
	}
	
	public void punir(String nomeDoJogo, int scoreObtido, boolean zerou) throws FakeHighscoreException, GameNotFoundException, InvalidFieldValueException{
		registraJogada(nomeDoJogo, scoreObtido, zerou);
		Jogo jogo = jogos.get(nomeDoJogo);
		
		removeX2p(tipo.punir(jogo, scoreObtido, zerou));		
	}
	

	public void listarJogos() {
		System.out.println("Lista de Jogos:");
		jogos.listarJogos();
	}
	
	
}
