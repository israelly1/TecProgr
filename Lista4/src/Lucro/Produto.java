package Lucro;

public class Produto {
	
	private String nome;
	private double precoCusto;
	private double precoVenda;
	private double margemLucro;
	private double despesas;
	private int lucro;
	
	public Produto(String nome, double precoCusto, double precoVenda, double margemLucro, double despesas) {
		super();
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.margemLucro = margemLucro;
		this.despesas = despesas;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoVenda() {
		return this.precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public double getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	public double getDespesas() {
		return this.despesas;
	}
	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}
	
	public int CalculoMargemLucro() {
		lucro= (int) (precoVenda - (precoCusto +despesas)/precoVenda)*100;
		return lucro;
	}
	
	
}
