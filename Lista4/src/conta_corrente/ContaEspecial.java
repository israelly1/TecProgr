package conta_corrente;

public class ContaEspecial extends ContaCorrente {
	protected double limiteEspecial;
	
	public ContaEspecial(int NumeroConta, int saldo, int limiteEspecial) {
		super(NumeroConta, saldo);
		this.limiteEspecial= limiteEspecial;
	}

	public void Sacar(int valorSaque) {
		if(valorSaque>saldo+limiteEspecial) {
			System.out.println("limite insuficiente");
		}else {
			saldo= saldo - valorSaque;
		}
		System.out.println(saldo);
	}

}
