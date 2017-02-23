package jogo;

import excecoes.InvalidFieldValueException;

public class JogoFactory {
	public static final String RPG = "rpg";
	public static final String LUTA = "luta";
	public static final String PLATAFORMA = "plataforma";
	
	public static final String OFFLINE = "offline";
	public static final String ONLINE = "online";
	public static final String MULTIPLAYER = "plataforma";
	public static final String COOPERATIVO = "cooperativo";
	public static final String COMPETITIVO = "competitivo";
	
	
	public static Jogo criaJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo) throws InvalidFieldValueException{
		Jogo jogo;
		
		if (estiloJogo.toLowerCase().equals(RPG)){
			jogo = criaRPG(jogoNome, preco);
		
		} else if (estiloJogo.toLowerCase().equals(LUTA)){
			jogo = criaLuta(jogoNome, preco);
		
		} else if (estiloJogo.toLowerCase().equals(PLATAFORMA)){
			jogo = criaPlataforma(jogoNome, preco);
		
		} else {
			jogo = criaJogo(jogoNome, preco);
		}
		
		if (estiloJogo != null){
			for(String s : estiloJogo.split(" ")){
				addEstilo(jogo, s);
			}
		}
		
		return jogo;
	}
	
	private static Jogo criaJogo(String jogoNome, double preco) throws InvalidFieldValueException {
		return new Jogo(jogoNome, preco);
	}

	private static Jogo criaPlataforma(String jogoNome, double preco) throws InvalidFieldValueException {
		return new Plataforma(jogoNome, preco);
	}

	private static Luta criaLuta(String jogoNome, double preco) throws InvalidFieldValueException {
		return new Luta(jogoNome, preco);
	}

	private static RPG criaRPG(String jogoNome, double preco) throws InvalidFieldValueException {
		return new RPG(jogoNome, preco);
	}
	
	private static void addEstilo(Jogo jogo, String estilo){
		if (estilo.toLowerCase().equals(COMPETITIVO)){
			jogo.addEstilo(Jogabilidade.COMPETITIVO);
			
		} else if (estilo.toLowerCase().equals(COOPERATIVO)){
			jogo.addEstilo(Jogabilidade.COOPERATIVO);
			
		} else if (estilo.toLowerCase().equals(MULTIPLAYER)){
			jogo.addEstilo(Jogabilidade.MULTIPLAYER);
			
		} else if (estilo.toLowerCase().equals(OFFLINE)){
			jogo.addEstilo(Jogabilidade.OFFLINE);
			
		} else if (estilo.toLowerCase().equals(ONLINE)){
			jogo.addEstilo(Jogabilidade.ONLINE);
		}
	}
}
