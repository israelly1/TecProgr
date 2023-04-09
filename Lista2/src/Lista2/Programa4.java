package Lista2;

import java.util.Scanner;

public class Programa4 {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int num;
	int i=1;
	int res;
	System.out.println("Digite um número: ");
	num= sc.nextInt();
	
	while(i<=10) {
		res=num*i;
		i++;
		System.out.println(res);
	}
	}

}
