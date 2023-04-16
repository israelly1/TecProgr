package Lista3;

public class Programa7 {
	
	public static boolean funcaoCrescente(int vetor[]) {
		int cont=0;
		for(int i = 0; i < vetor.length-2; i++) {
			if(vetor[i+1]<vetor[i]) {
				cont++;
			}
		}
		if(cont==0) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		int vetor[]= new int[5];
		vetor[0]=1;
		vetor[1]=3;
		vetor[2]=4;
		vetor[3]=5;
		vetor[4]=20;
		
		
		
		System.out.println(funcaoCrescente(vetor));
		
	}

}
