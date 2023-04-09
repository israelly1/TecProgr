package Lista2;

import java.util.Scanner;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num;
		int soma=0;
		System.out.println("Digite um número: ");
		num= sc.nextInt();
		while(num>0){
		soma=soma+num;
		System.out.println("Digite um número: ");
		num= sc.nextInt();
		}
		System.out.println("Soma dos número positivos: "+soma);
	

}
}
