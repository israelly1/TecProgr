package contato;

import java.util.ArrayList;



public class Agenda {
	
	public ArrayList<Contato> lista= new ArrayList<Contato>();
	public String NomeAgenda;
	public String descricao;
	
	public Agenda(String nomeAgenda, String descricao) {
		this.NomeAgenda= nomeAgenda;
		this.descricao= descricao;
	}
	public void AdicionarContato(Contato contato) {
		lista.add(contato);
	}
}
