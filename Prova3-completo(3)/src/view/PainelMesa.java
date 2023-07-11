package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PainelMesa extends JPanel {
	
	private static final long serialVersionUID = 1267615664633400709L;
	
	private ArrayList<Carta> listaCartas;

	public PainelMesa() {
		this.setLayout(new GridLayout(2,3));
		listaCartas = new ArrayList<Carta>();
		
		for (int i = 0; i < 6; i++) {
			Carta carta = new Carta();
			listaCartas.add(carta);
			add(carta.getBotao());
		}
	}

	public void desselecionarCartas() {
		for (Carta carta : listaCartas) {
			carta.desselecionar();
		}
	}

	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}

	public void setListaCartas(ArrayList<String> nomesCartas) {
		int numeroCartas;
		
		if (nomesCartas != null) {
			numeroCartas = nomesCartas.size();
		} else {
			numeroCartas = 0;
		}
		
		for (int i = 0; i < listaCartas.size(); i++) {
			if (i < numeroCartas) {
				listaCartas.get(i).mudarNome(nomesCartas.get(i));
			} else {
				listaCartas.get(i).mudarNome("");
			}
		}
	}

	public boolean isCartaSelecionada() {
		for (Carta carta : listaCartas) {
			if (carta.isSelecionado()) {
				return true;
			}
		}
		return false;
	}

	public Carta getCartaEscolhida() {
		for (Carta carta : listaCartas) {
			if (carta.isSelecionado()) {
				return carta;
			}
		}
		
		return null;
	}

	public void resetarCartas() {
		for (int i = 0; i < listaCartas.size(); i++) {
			listaCartas.get(i).mudarNome("");
		}
		
	}
}