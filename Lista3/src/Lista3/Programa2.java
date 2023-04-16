package Lista3;

public class Programa2 {
	public static int[] funcaoMedia(int vetor1[], int vetor2[]) {
		int soma1= 0;
		int soma2=0;
		int media1=0;
		int media2=0;
		int medias[]= new int [2];
		for (int i = 0; i < vetor1.length; i++) {
			soma1=soma1+vetor1[i];
		}
			media1= soma1/vetor1.length;
		for (int i = 0; i < vetor2.length; i++) {
		   soma2=soma2+vetor2[i];
		}
			media2= soma2/vetor2.length;
		 medias[0]= media1;
		 medias[1]= media2;
		return  medias;
	}
	public static void main(String[] args) {
		int vetor1[]= new int[5];
		int vetor2[]= new int[5];
		int medias[]= new int[2];
		
		
		vetor1[0]=4;
		vetor1[1]=2;
		vetor1[2]=3;
		vetor1[3]=5;
		vetor1[4]=6;
		
		vetor2[0]=10;
		vetor2[1]=20;
		vetor2[2]=5;
		vetor2[3]=5;
		vetor2[4]=10;
		
		medias=funcaoMedia(vetor1, vetor2);
		for(int i=0;i< medias.length; i++) {
			System.out.println(medias[i]);
		}
	}

}
