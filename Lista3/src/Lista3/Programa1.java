package Lista3;

public class Programa1 {
	public static int funcaoSomatorio(int soma,int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			soma=soma+vetor[i];
		}
		return soma;
	}
	public static void main(String[] args) {
		int vetor[]= new int[5];
		int soma=0;
		
		vetor[0]=10;
		vetor[1]=20;
		vetor[2]=30;
		vetor[3]=50;
		vetor[4]=60;
		
		soma= funcaoSomatorio(soma, vetor);
		System.out.println(soma);
	}

}
