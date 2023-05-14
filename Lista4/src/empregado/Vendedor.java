package empregado;

public class Vendedor extends Empregado {
	public float percentualComissao;
	public float salarioTotal;
	public Vendedor(String nome, float salario, double percentualComissao) {
		super(nome, salario);
	}
	public float CalcularSalario() {
		salarioTotal= salario +(salario*percentualComissao);
		return salarioTotal;
		
	}
	public String toString() {
		return "Vendedor [nome do empregado= "+ nome+ "salario sem comissão="+ salario+", percentualComissao=" + percentualComissao + ", salarioTotal=" + salarioTotal + "]";
	}

}
