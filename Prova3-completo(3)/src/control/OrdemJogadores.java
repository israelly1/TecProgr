package control;

import java.util.ArrayList;
import java.util.Random;

public class OrdemJogadores {
	
	private ArrayList<Jogador> listaJogadores;
	
	private ArrayList<Integer> indexJogadores;
	
	private int indexJogadorVez;
	
	public OrdemJogadores(ArrayList<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
		indexJogadores = new ArrayList<>();
		
		Random gerador = new Random();
		ArrayList<Integer> indexesOrdenados = new ArrayList<>();
		
		for (int i = 0; i < listaJogadores.size(); i++) {
			indexesOrdenados.add(i);
		}
		
		while (indexesOrdenados.size() > 0) {
			int indexAleatorio = gerador.nextInt(0, indexesOrdenados.size());
			indexJogadores.add(indexesOrdenados.get(indexAleatorio));
			indexesOrdenados.remove(indexAleatorio);
		}
		
		indexJogadorVez = 0;
		
	}
	
	public void passarVez() {
		indexJogadorVez++;
		
		if (indexJogadorVez >= indexJogadores.size()) {
			indexJogadorVez = 0;
		}
	}
	
	public Jogador getJogadorVez() {
		return listaJogadores.get(indexJogadores.get(indexJogadorVez));
	}

}
