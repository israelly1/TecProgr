package robo;

import java.util.Random;

public class Plano{
	private int dimensao;
	private String plano[][];
	Random random = new Random();
	
	public Plano(int dimensao){
		this.dimensao = dimensao;
		this.plano = new String[dimensao][dimensao];
		for(int i=0; i<= dimensao-1; i++ ) {
			for(int j=0; j<= dimensao-1; j++ ) {
				plano[i][j]=" X ";
			}
		}
	}
	
	public int getDimensao() {
		return dimensao;
	}
	public void setDimensao(int dimensao) {
		this.dimensao = dimensao;
	}
	public String[][] getPlano() {
		return plano;
	}
	public void setPlano(String[][] plano) {
		this.plano = plano;
	}
	
	public void SortearMoeda() {
		int NumeroAleatorioX = random.nextInt(0, dimensao);
		int NumeroAleatorioY = random.nextInt(0, dimensao);
		plano[NumeroAleatorioX][NumeroAleatorioY]= " $ ";
	}
}
