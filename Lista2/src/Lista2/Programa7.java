package Lista2;

import java.util.Scanner;

public class Programa7 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num;
		int cont=0;
		System.out.println("Digite um número: ");
		num= sc.nextInt();
		while (cont!=2) {
			cont=0;
			for(int i=1;i<=num;i++) {
				if(num%i==0) {
					cont=cont+1;
				}	
			}
			if(cont>2) {
				num=num-1;
			}
		
		}
		System.out.println(num);
	}
}

