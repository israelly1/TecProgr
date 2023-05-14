package ingresso;

public class IngressoVip extends Ingresso {

	public IngressoVip(int valor) {
		super(valor);
	}

	private int ValorAdicional;
	
	public String toString() {
		valor= valor+ValorAdicional;
		return Integer.toString(valor);
	}
}
