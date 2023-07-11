package control;

import java.util.ArrayList;

public class Rodada {
	
	/**
	 * Dica enviada pelo jogador da vez
	 */
	private String dica;
	
	/**
	 * nome dos jogadores 
	 * 
	 * <p>primeiro nome é o jogador da vez</p>
	 */
	private ArrayList<String> nomeJogadores;
	
	/**
	 * nome das cartas escolhidas pelos jogadores
	 * 
	 * <p>a Xº carta corresponde ao Xº jogador</p>
	 */
	private ArrayList<String> nomeCartasEscolhidas;
	
	/**
	 * pontuação de cada jogador
	 * 
	 * <p>a Xº pontuação corresponde ao Xº jogador</p>
	 */
	private ArrayList<Integer> pontuacaoJogadores;
	
	public String getDica() {
		return dica;
	}
	
	public ArrayList<String> getNomeJogadores() {
		return nomeJogadores;
	}
	
	public ArrayList<String> getNomeCartasEscolhidas() {
		return nomeCartasEscolhidas;
	}
	
	public ArrayList<Integer> getPontuacaoJogadores() {
		return pontuacaoJogadores;
	}

}
