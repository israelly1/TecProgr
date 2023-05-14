package ingresso;

import java.util.ArrayList;

public class Evento {

	ArrayList<Ingresso> ListaIngresso = new ArrayList<Ingresso>();
	int IngressosVendidos=0;
	int ValorIngresso;
	public void VendaIngresso() {
		ListaIngresso.remove(0);
		IngressosVendidos++;
	}
	public void AdicionarIngresso(int quantIngresso, Ingresso ingresso) {
		for(int i=0; i< quantIngresso; i++) {
			ListaIngresso.add(ingresso);
		}
		ValorIngresso= ingresso.valor;
	}
	public int IngressosVendidos() {
		return IngressosVendidos*ValorIngresso;
	}
}
