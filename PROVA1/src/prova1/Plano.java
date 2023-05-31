package prova1;

import java.util.ArrayList;

public class Plano {
	private int tamanhoX;
	private int tamanhoY;
	private ArrayList<Celula> listaCelulas;
	
	public Plano(int tamanhoX) {
		this.tamanhoX= tamanhoX;
		this.tamanhoY= tamanhoX;
		listaCelulas = new ArrayList<Celula>();

		int contador = 1;
		for (int i = 1; i <= tamanhoX; i++) {
			for (int j = 1; j <= tamanhoY; j++) {
				Celula celula = new Celula(contador, i, j);
				listaCelulas.add(celula);
				contador++;
			}
		}
	}
	
	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}
	
	public void setListaCelulas(ArrayList<Celula> listaCelulas) {
		this.listaCelulas = listaCelulas;
	}

	
	public int getTamanoX() {
		return tamanhoX;
	}

	public void setTamanhoX(int tamanoX) {
		this.tamanhoX = tamanoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}

	public Celula retornarCelula(int x, int y) {
		for (Celula celula : listaCelulas) {
			if(celula.getPosicaoX()== x && celula.getPosicaoY()== y) {
				return celula;
			}
		}
		return null;
	}
	
	public void setCelula(Celula celula) {
		 listaCelulas.set(0, celula);
	}

	public void ImprimirPlano() {
		int contador = 0;
		for (int i = 1; i <= tamanhoX; i++) {
			for (int j = 1; j <= tamanhoY; j++) {
				System.out.printf(" ");
				if(listaCelulas.get(contador).isCelulaVazia()) {
					System.out.printf("x");
				}
				if(listaCelulas.get(contador).isCelulaAluno()) {
					System.out.printf("A");
				}
				if(listaCelulas.get(contador).isCelulaBug()) {
					System.out.printf("B");
				}
				if(listaCelulas.get(contador).isCelulaRobo()) {
					for (Robo robo : listaCelulas.get(contador).getListaRobo()) {
						System.out.printf(robo.getSimbolo());
					}
				}
				System.out.printf(" ");
				contador++;
			}
			System.out.printf("\n");
		}
		
	}
}
