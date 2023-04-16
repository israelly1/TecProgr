package Lista3;

public class Programa4 {
	
	public static int funcaoContagem(int vetor1[], int vetor2[],int cont) {
		cont=0;
		for (int i = 0; i < vetor1.length; i++) {
			if(4==vetor1[i]) {
				cont=cont+1;
			}
		}
		for (int i = 0; i < vetor2.length; i++) {
			if(4==vetor2[i]){
				cont=cont+1;
		}
	}
		return cont;
	}

	public static void main(String[] args) {
		int vetor1[]= new int[5];
		int vetor2[]= new int[5];
		int cont;

		vetor1[0]=4;
		vetor1[1]=2;
		vetor1[2]=4;
		vetor1[3]=4;
		vetor1[4]=5;
		
		vetor2[0]=10;
		vetor2[1]=4;
		vetor2[2]=4;
		vetor2[3]=5;
		vetor2[4]=2;
		
		
		cont= funcaoContagem(vetor1, vetor2, 0);
		System.out.println("4-> "+cont);
	}

}
