package negocio;

import java.util.ArrayList;

public class ListaJogador {

	private ArrayList<Jogador> listaJogador;

	public ListaJogador() {
		this.listaJogador= new ArrayList<Jogador>();
	}
	
	public ArrayList<Jogador> getListaJogador() {
		return listaJogador;
	}

	public void setListaJogador(ArrayList<Jogador> listaJogador) {
		this.listaJogador = listaJogador;
	}

	
	public void addJogador(Jogador jogador) {
		listaJogador.add(jogador);
	}
	
	
	public String dadosJogador() {
		String dados= "";
		for (Jogador jogador : listaJogador) {
			dados+= jogador.getNome() + ";" + jogador.getPartidas() +";" + jogador.getPontuacaoTotal() + ";" +
			jogador.getPontuacaoAluno() + ";" + jogador.getPontuacaoBug() + ";" + jogador.getPontRei() + ";"+
			jogador.getPontPeao() + ";" + jogador.getPontCavalo() + "\n";
		}
		return dados;
	}
	
}
