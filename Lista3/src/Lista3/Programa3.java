package Lista3;

public class Programa3 {
	
	public static int funcaoMediaPonderada(int vetorNotas[],int vetorPeso[]) {
		//int media_pond[]= new int[2];
		int media_pond=0;
		int soma_media=0;
		int soma_peso=0;
		int media_pond_tot=0;
		for(int i = 0; i < vetorNotas.length; i++) {
			for(int j = 0; j < vetorPeso.length; j++) {
				media_pond= vetorNotas[i] * vetorPeso[j];
				soma_media= soma_media+ media_pond;
				soma_peso= soma_peso+ vetorPeso[i];
			}	
			
		}
		media_pond_tot= soma_media/soma_peso;
		 return media_pond_tot;
	}

	public static void main(String[] args) {
		int vetorNotas[]= new int[3];
		vetorNotas[0]= 8;
		vetorNotas[1]= 7;
		vetorNotas[2]= 10;
		
		int vetorPeso[]= new int[3];
		vetorPeso[0]= 2;
		vetorPeso[1]= 2;
		vetorPeso[2]= 1;
		
		//int media_pond[]= new int[2];
		int media_pond_tot;
		
		media_pond_tot =funcaoMediaPonderada(vetorNotas, vetorPeso);
	
			System.out.println("Média total: "+media_pond_tot);
		

	}
}
