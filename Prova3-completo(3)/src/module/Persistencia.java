package module;

import java.util.ArrayList;

public class Persistencia {
	
	private static Persistencia instancia;
	
	private Persistencia() {
		;
	}
	
	public static Persistencia getInstance() {
		if (instancia == null) {
			instancia = new Persistencia();
		}
		return instancia;
	}
	
	public ArrayList<String> getNomeCartas() {
		ArrayList<String> nomeImagens = new ArrayList<>();
		
		for (String nome : NomeImagens.getInstancia().getNomeImagens()) {
			nomeImagens.add(nome);
		}
		
		return nomeImagens;
	}
	
	public void salvarNovaLinha(String dica, 
			String nomeJogadorVez, String nomeCartaJogadorVez, int pontuacaoJogadorVez,
			String nomeJogador2, String nomeCartaJogador2, int pontuacaoJogador2,
			String nomeJogador3, String nomeCartaJogador3, int pontuacaoJogador3,
			String nomeJogador4, String nomeCartaJogador4, int pontuacaoJogador4) {
		
		gameDAO.getInstancia().salvar(dica, 
				nomeJogadorVez, nomeCartaJogadorVez, pontuacaoJogadorVez, 
				nomeJogador2, nomeCartaJogador2, pontuacaoJogador2, 
				nomeJogador3, nomeCartaJogador3, pontuacaoJogador3, 
				nomeJogador4, nomeCartaJogador4, pontuacaoJogador4);
	}
	
	public ArrayList<ArrayList<String>> getDados() {
		ArrayList<ArrayList<String>> matrizDados = new ArrayList<>();
		
		String[][] matrizArray = gameDAO.getInstancia().getMatrizDeDados();
		
		for (int i = 0; i < matrizArray.length; i++) {
			matrizDados.add(new ArrayList<>());
			for (int j = 0; j < matrizArray[i].length; j++) {
				matrizDados.get(i).add(matrizArray[i][j]);
			}
		}
		
		return matrizDados;
	}

}
