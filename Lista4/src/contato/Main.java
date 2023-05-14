package contato;

public class Main {

	public static void main(String[] args) {
		Contato contato1=  new Contato();
		contato1.Contato1(145);
		Contato contato2= new Contato();
		contato2= contato1.ClonarContato(1500, "Maria", "maria@hotmail.com", 2469784, "Esse contato é de Maria");
		
		System.out.println(contato2.email);
		
		Agenda agenda= new Agenda("Agenda semanal", "Essa agenda é para sua organização semanal");
		agenda.AdicionarContato(contato2);
		System.out.println(agenda.lista.get(0).nome);
		
		
	}


}
