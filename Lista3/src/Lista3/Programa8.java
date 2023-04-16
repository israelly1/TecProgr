package Lista3;

public class Programa8 {
	
	public static int funcaoK_esimoMaiorValor(int vetor[], int k) {
		int vetOrdenado[]= new int[vetor.length];
		vetOrdenado= funcaoOrdenaçao(vetor);
		
		return vetOrdenado[vetOrdenado.length-k];
	}
	
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
		int k=2;
		int vetor[]= new int[5];
		vetor[0]=1;
		vetor[1]=3;
		vetor[2]=4;
		vetor[3]=5;
		vetor[4]=20;
		
		System.out.println(funcaoK_esimoMaiorValor(vetor,k));

	}

}
