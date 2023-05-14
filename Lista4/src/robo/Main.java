package robo;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a dimensão do plano: ");
		int dimensao= sc.nextInt();
		Plano plano = new Plano(dimensao);
		plano.SortearMoeda();
		Robo robo= new Robo(plano);
		robo.CaminhadaB();
		robo.MostrarPlano();
	}
}