package Produto;

public class Produto {
	public String nome;
	public double preco, ValorPago;
	public int quantidade;
	
	public Produto(String nome, double preco, int quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public double ComprarProduto() {
		preco=preco*quantidade;
		if(preco<=100) {
			ValorPago= preco;
		}else {
			if(preco<=200) {
				ValorPago= preco*(0.9);
			}else {
				if(preco<=500) {
					ValorPago= preco*0.8;
				}else {
					ValorPago=preco*0.75;
				}
			}
		}
		return ValorPago;	
	}
}
