package Lista3;

import java.util.Scanner;

public class Programa12 {
	
	public static boolean funcaoNumeroPrimo(int num) {
		int cont=0;
		for(int i=1; i<=num;i++) {
			if(num%i==0) {
				cont++;
			}
		}
		if(cont>2) {
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Digite um número: ");
		int num= sc.nextInt();

		
		System.out.println(funcaoNumeroPrimo(num));
	}

}
