package Lista3;

import java.util.Scanner;

public class Programa14 {
	public static int[] funcaoRemocao(int vetor1[], int num) {
		int cont=0;
		for(int i=0; i<= vetor1.length-1;i++) {
			if(num!=vetor1[i]) {
				cont++;
			}
		}
		int vetor2[]= new int[cont];
		int j=0;
		for(int i=0; i<= vetor1.length-1;i++) {
			if(num!=vetor1[i]) {
				vetor2[j]= vetor1[i];
				j++;
			}
		}
		return vetor2;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Insira o número de elementos do 1° vetor: ");
		
		int n = entrada.nextInt();
		int vetor1[] = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Digite o " + (i+1) + "° elemento: ");
			vetor1[i] = entrada.nextInt();
		}
		
		System.out.println("Digite o número para remoção: ");
		int num= entrada.nextInt();
		
		int vetor2[]= funcaoRemocao(vetor1, num);
		
		for(int i=0; i<= vetor2.length - 1;i++) {
			System.out.print(vetor2[i]+ " ");
		}
		
		

	}

}
