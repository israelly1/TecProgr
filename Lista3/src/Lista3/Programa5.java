package Lista3;

public class Programa5 {
	
	public static int[] funcaoCopia(int vetor[]) {
		int vetor_aux[]= new int[vetor.length];
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor_aux.length; j++) {
				vetor_aux[i]= vetor[i];	
			}
			
		}
		return vetor_aux;
	}

	public static void main(String[] args) {
		
		int vetor[]= new int[5];
		int vetor_aux[];
		
		vetor[0]=10;
		vetor[1]=20;
		vetor[2]=30;
		vetor[3]=40;
		vetor[4]=50;
		
		vetor_aux= funcaoCopia(vetor);
		for (int j = 0; j < vetor_aux.length; j++) {
			System.out.println(vetor_aux[j]);
		}

	}

}
