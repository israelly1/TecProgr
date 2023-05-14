package Lista4;

public class Main {

	public static void main(String[] args) {
		Empregados empregado1= new Empregados("Maria", "Albuquerque", 2500);
		Empregados empregado2= new Empregados("João", "Farias", 3500);
		
		System.out.println(empregado1.getPrimeiroNome());
		empregado1.setPrimeiroNome("Julia");
		System.out.println(empregado1.getPrimeiroNome());
		
		System.out.println("Salário: " + empregado1.getSalarioMensal());
		System.out.println("Salário: " + empregado2.getSalarioMensal());
		
		empregado1.setSalarioMensal(1.1*empregado1.getSalarioMensal());
		empregado2.setSalarioMensal(1.1*empregado2.getSalarioMensal());
		
		System.out.println("Salário: " + empregado1.getSalarioMensal());
		System.out.println("Salário: " + empregado2.getSalarioMensal());

	}

}
