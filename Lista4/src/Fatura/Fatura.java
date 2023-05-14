package Fatura;

public class Fatura {
	
	public String descricao;
	public int quantidade, numero;
	private double PrecoUnitario, PrecoTotal,ValorFatura;
	
	public Fatura(int numero, String descricao, int quantidade, double precoUnitario) {
		super();
		if(quantidade<0)
			quantidade=0;
		if(precoUnitario<0)
			precoUnitario=0;
		
		this.numero = numero;
		this.descricao = descricao;
		this.quantidade = quantidade;
		PrecoUnitario = precoUnitario;
		PrecoTotal = PrecoUnitario*quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPrecoUnitario() {
		return PrecoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		PrecoUnitario = precoUnitario;
	}

	public double getPrecoTotal() {
		return PrecoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		PrecoTotal = precoTotal;
	}

	public void Desconto(double Desconto) {
		PrecoUnitario= PrecoUnitario*(1-Desconto/100);
	}
	
	public double ValorFatura() {
		this.ValorFatura= quantidade*PrecoUnitario;
		return ValorFatura;
	}
}
