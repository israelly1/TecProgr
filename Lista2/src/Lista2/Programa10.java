package Lista2;

import java.util.Scanner;

public class Programa10 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Digite um número: ");
		int num= sc.nextInt();
		
		for (int i = 0; i <= num-1; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.printf("%d ",j);
			}
			System.out.printf("\n");
		}
		

	}

}
