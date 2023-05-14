package empregado;

public class Gerente extends Empregado {
	public String departamento;
	public Gerente(String nome, float salario, String departamento) {
		super(nome, salario);
		this.departamento= departamento;
	}
	public String toString() {
		return "Gerente [nome=" + nome + ", salario=" + salario + ", departamento="+ departamento+"]";
	}
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
