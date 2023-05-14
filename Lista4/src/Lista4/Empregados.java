package Lista4;

public class Empregados {
	private String PrimeiroNome;
	private String Sobrenome;
	private double SalarioMensal;
	
	public Empregados(String PrimeiroNome, String Sobrenome, double SalarioMensal) {
		this.PrimeiroNome= PrimeiroNome;
		this.Sobrenome= Sobrenome;
		this.SalarioMensal= SalarioMensal;
	}
	public String getPrimeiroNome() {
		return PrimeiroNome;
	}
	public void setPrimeiroNome(String PrimeiroNome) {
		this.PrimeiroNome= PrimeiroNome;
	}
	public String Sobrenome() {
		return Sobrenome;
}
	public void setSobrenome(String Sobrenome) {
		this.Sobrenome= Sobrenome;
	}
	public double getSalarioMensal() {
		return SalarioMensal;
}
	public void setSalarioMensal(double SalarioMensal) {
		this.SalarioMensal= SalarioMensal;
	}
}
