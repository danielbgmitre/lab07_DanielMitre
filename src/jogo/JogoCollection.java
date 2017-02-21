package jogo;

import java.util.HashMap;

public class JogoCollection {
	private HashMap<String, Jogo> jogos;
	
	public JogoCollection(){
		jogos = new HashMap<String, Jogo>();
	}
	
	public boolean hasJogo(Jogo jogo){
		return jogos.containsValue(jogo);
	}
	
	public Jogo get(String name){
		if (hasJogo(name)){
			return jogos.get(name);
		} else {
			return null;
		}
	}
	
	public boolean hasJogo(String name){
		return jogos.containsKey(name);
	}
	
	public boolean add(Jogo jogo){
		if (hasJogo(jogo)){
			return false;
		} else {
			jogos.put(jogo.getNome(), jogo);
			return true;
		}
	}
	
	public boolean remove(Jogo jogo){
		if (hasJogo(jogo)){
			jogos.remove(jogo.getNome());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean remove(String name){
		if (hasJogo(name)){
			jogos.remove(name);
			return true;
		} else {
			return false;
		}
	}
	
	public void listarJogos(){
		double total = 0;
		for (Jogo j : jogos.values()){
			System.out.println("+ " + j.getNome() + " - " + j.getTipoJogo());
			System.out.println("===> Jogou " + j.getTimesPlayed() + " vez(es)");
			System.out.println("===> Zerou " + j.getTimesFinished() + " vez(es)");
			System.out.println("===> Maior Score: " + j.getHighestScore());
			total += j.getPreco();
		}
		System.out.printf("Total de preço dos jogos: R$: %.2f\n", total);
	}
}
