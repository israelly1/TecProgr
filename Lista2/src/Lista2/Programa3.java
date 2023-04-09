package Lista2;

import java.util.Scanner;

public class Programa3 {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int num_correto= 20;
	int num_usuario;
	System.out.println("Adivinhe um número entre 1 e 100: ");
	num_usuario= sc.nextInt();
	
	if(num_usuario!=num_correto) {
		System.out.println("Adivinhe um número entre 1 e 100: "+num_usuario);
		num_usuario= sc.nextInt();
	}else {
		System.out.println("Parabéns! número correto");
	}
}
}
	


