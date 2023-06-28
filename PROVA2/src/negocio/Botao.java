package negocio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import apresentacao.PainelEntrada;
import apresentacao.PainelPlano;

public class Botao {
	PainelPlano Painelplano;
	Plano plano;
	private ArrayList <Celula> listaCelula;

	public Botao(PainelPlano Painelplano, Plano plano) {
		this.Painelplano= Painelplano;
		this.plano= plano;
		int cont = 1;
		listaCelula= new ArrayList<Celula>();
		
		for (int i = 0; i < 6; i++) {
			  for (int j = 0; j < 6; j++) {
				 Celula celula = new Celula(cont, plano);
				 listaCelula.add(celula);
				 this.Painelplano.add(celula.getBotao());
				 cont++;
			}  
		}	
	}
	
	public ArrayList<Celula> getListaCelula() {
		return listaCelula;
	}
	public void setListaCelula(ArrayList<Celula> listaCelula) {
		this.listaCelula = listaCelula;
	}
}

