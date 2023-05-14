package Fatura;

public class Main {

	public static void main(String[] args) {
		Fatura fatura= new Fatura(12, "projetor", 2, 700);
		
		fatura.ValorFatura();
		
		System.out.println(fatura.ValorFatura());
		fatura.Desconto(10);
		System.out.println(fatura.ValorFatura());
	}

}
