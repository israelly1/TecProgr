package prova1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a dimensão do plano: \n X: ");
		int X= sc.nextInt();
		Plano plano = new Plano(X);
		Jogo jogo= new Jogo(plano);
		jogo.Start();
		
	}
}
