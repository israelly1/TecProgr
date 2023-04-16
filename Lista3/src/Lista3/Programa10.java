package Lista3;

public class Programa10 {

	public static boolean funcaoIgualdade(int vetor1[] ,int vetor2[]){
			int cont=0;
			for(int i=0; i<vetor1.length; i++) {
				for (int j = 0; j < vetor2.length; j++) {
					if(vetor1[i]!=vetor2[i]) {
						cont++;
					}
					
				}
			}
			if(cont==0) {
				return true;
			}else {
				return false;
			}
		}	
		

		public static void main(String[] args) {
			int vetor1[]= new int[5];
			int vetor2[]= new int[5];
			vetor1[0]= 1;
			vetor1[1]= 3;
			vetor1[2]= 4;
			vetor1[3]= 5;
			vetor1[4]= 20;
			
			vetor2[0]= 1;
			vetor2[1]= 2;
			vetor2[2]= 4;
			vetor2[3]= 7;
			vetor2[4]= 5;
			
			
			
			System.out.println(funcaoIgualdade(vetor1, vetor2));
			
	}

}
