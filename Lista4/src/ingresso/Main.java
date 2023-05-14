package ingresso;

public class Main {

	public static void main(String[] args) {
		Ingresso ingresso= new Ingresso(100);
		IngressoVip ingressoVip= new IngressoVip(150);
		Evento evento = new Evento();
		
		evento.AdicionarIngresso(5, ingresso);
		evento.VendaIngresso();
		evento.VendaIngresso();
		
		
		System.out.println(evento.IngressosVendidos());
	

	}

}
