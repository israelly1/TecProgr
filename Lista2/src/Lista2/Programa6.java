package Lista2;

public class Programa6 {

	public static void main(String[] args) {
		
		double A[][] = { {1,1,4}, {1,1,1}, {1,1,1} };
		int cont=0;
		
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
			
				if(A[i][j]!=A[j][i]) {
					cont=cont+1;
				}
			}
 
		}
		if(cont!=0) {
			System.out.println("Não é simétrica");
		}else {
			System.out.println("É simétrica");
		}
	}
}
