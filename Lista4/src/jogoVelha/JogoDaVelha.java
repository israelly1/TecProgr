package jogoVelha;

import java.util.Scanner;

public class JogoDaVelha {
	Scanner sc = new Scanner(System.in);

	private String grade[][] = new String[3][3];
	private String jogador1;
	private String jogador2;
	
	public JogoDaVelha() {
		for(int i = 0; i <= 2 ; i++) {
			for(int j = 0; j <= 2; j++) {
				grade[i][j]= "";
			}
		}
	}
	
	public void ExibirGrade() {
		for(int i = 0; i <= 2 ; i++) {
			for(int j = 0; j <= 2; j++) {
				System.out.printf("%s    ",grade[i][j]);
			}
			System.out.println("\n");
		}
	}

	public void Play(String jogador1, String jogador2) {
		this.jogador1= jogador1;
		this.jogador2= jogador2;
		int jogador=1;
		boolean existeVencedor= false;
		boolean deuEmpate = false;
		int rodadas=0;
		while(existeVencedor == false && deuEmpate == false) {
			System.out.println("Jogador "+ jogador);
			System.out.println("Digite as coordenadas: ");
			int x = sc.nextInt();
			int y= sc.nextInt();
			while(!grade[x][y].equals("")) {
				System.out.println("Digite novamente as coordenadas: ");
				x = sc.nextInt();
				y = sc.nextInt();
			}
			
			grade[x][y]= "Jogador "+ jogador;
			rodadas++;
			
			existeVencedor= VerificarGanhador();
			if(rodadas==9 && existeVencedor==false) {
				deuEmpate = true;
			}
			
			if(existeVencedor==false) {
				if(jogador==1) {
					jogador= 2;
				}else {
					jogador=1;
				}
			}
			ExibirGrade();
	}
		System.out.println("Fim de jogo!" );
		if(deuEmpate == true) {
			System.out.println("Deu velha!");
		}else {
			if(jogador==1) {
				System.out.println(jogador1 +" "+"venceu!");
			}else {
				System.out.println(jogador2 +" "+"venceu!");
			}
		}
	}
	
	public boolean VerificarGanhador() {
		for(int i=0 ; i <=2 ; i++) {
			if(!grade[i][0].equals("") && grade[i][0].equals(grade[i][1])&& grade[i][2].equals(grade[i][0])) {
				return true;
			}
			if(!grade[0][i].equals("") && grade[0][i].equals(grade[1][i]) && grade[2][i].equals(grade[0][i])  ) {
				return true;
			}
		}
		
		if(!grade[0][0].equals("") && grade[0][0].equals(grade[1][1]) && grade[0][0].equals(grade[2][2])  ) {
			return true;
		}
		if(!grade[0][2].equals("") && grade[0][2].equals(grade[1][1]) && grade[0][2].equals(grade[2][0]) ) {
			return true;
		}
			return false;
	}
		
	
}
