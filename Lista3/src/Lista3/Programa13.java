package Lista3;

import java.util.*;

public class Programa13 {
	
	public static int[] funcaoOcorrencias(int vetor1[] ,int vetor2[])
	{
		int cont = 0;
		
		
		for(int i=0; i <= vetor1.length - 1; i++) 
		{
			for (int j = 0; j <=  vetor2.length-1; j++) 
			{
				if(vetor1[i]==vetor2[j]) 
				{
					cont++;
				}

			}
		}
			
		int vetor3[] = new int[cont];
		int cont2 = 0;
		
		for(int i=0; i< vetor1.length;i++) 
		{
			for (int j = 0; j < vetor2.length; j++) 
			{
				if(vetor1[i]==vetor2[j]) 
				{
					vetor3[cont2] = vetor2[j];
					cont2++;
				}

			}
		}
		
		
		
		return vetor3;
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Insira o número de elementos do 1° vetor: ");
		
		int n = entrada.nextInt();
		int vetor1[] = new int[n];
		
		System.out.println("Insira o número de elementos do 2° vetor:");
		int n2 = entrada.nextInt();
		
		int vetor2[] = new int[n2];
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Digite o " + (i+1) + "° elemento: ");
			vetor1[i] = entrada.nextInt();
		}
		for(int i = 0; i < n2; i++)
		{
			System.out.print("Digite o " + (i+1) + "° elemento: ");
			vetor2[i] = entrada.nextInt();
		}
		
		int vetor3[] = funcaoOcorrencias(vetor1, vetor2);
		
		for(int i = 0; i < vetor3.length; i++)
		{
			System.out.print(" " + vetor3[i]);
		}
		
	}

}
