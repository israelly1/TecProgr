package Lista3;

import java.util.Scanner;

public class Programa11 {
	
	public static int funcaoPotenciacao(int base, int exp) {
		int cont=0;
		int potencia=base;
		//int resultado=0;
		for(int i= 1; i <exp; i++) {
			potencia= potencia * base;
		}
		
		return potencia;
	}

	public static void main(String[] args) {
		int potencia;
		Scanner sc= new Scanner(System.in);
		System.out.println("Digite a base: ");
		int base= sc.nextInt();
		System.out.println("Digite o expoente: ");
		int exp= sc.nextInt();
		
		
		System.out.println(funcaoPotenciacao(base,exp));

	}

}
