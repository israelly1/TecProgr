package ingresso;

public class Ingresso {

	protected int valor;
	
	public Ingresso(int valor) {
		this.valor=valor;
	}
	
	public String toString(){
		return Integer.toString(valor);
	}
	
}
