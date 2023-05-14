package empregado;

public class Empregado {
	public String nome;
	protected float salario;
	
	public Empregado(String nome, float salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String toString() {
		return "Empregado [nome=" + nome + ", salario=" + salario + "]";
	}
	
}
