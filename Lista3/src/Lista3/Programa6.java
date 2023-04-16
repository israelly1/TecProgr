package Lista3;

public class Programa6 {
	public static int[] funcaoOrdenaçao(int vetor[]) {
		int aux=0;
		for (int i = 0; i < vetor.length-1; i++) {
			for (int j = 0; j <vetor.length-1-i; j++) {
				if(vetor[j]>vetor[j+1]) {
					aux= vetor[j];
					vetor[j]=vetor[j+1];
					vetor[j+1]= aux;
				}
			}
		}
		return vetor;
	}
	public static void main(String[] args) {
		int vetor[]= new int[5];
		
		vetor[0]=15;
		vetor[1]=10;
		vetor[2]=5;
		vetor[3]=25;
		vetor[4]=20;
		System.out.println("Vetor desordenado: ");
		for (int i = 0; i < vetor.length-1; i++) {
			System.out.println(vetor[i]);
		}
		vetor= funcaoOrdenaçao(vetor);
		System.out.println("\n");
		System.out.println("Vetor Ordenado: ");
		for (int i = 0; i < vetor.length-1; i++) {
			System.out.println(vetor[i]);
		}
		
	}

}
