package biblioteca_lab;

public class Servidor extends Cliente {
	
	public Servidor(int matricula, String nome, Biblioteca biblioteca) {
		super(matricula, nome, biblioteca);
	}
	public int VerificarDias() {
		return 15;
	}
	public void FazerEmprestimo(Publicacoes publicacao) {
		if(ListaPublicacoes.size() == 7) {
			System.out.println("Você ja completou 7 alugueis");
		}else {
			ListaPublicacoes.add(publicacao);
			tps+=15;
			if(tps%50==0) {
				doacoes++;
			}
		
		
		}

	}

}

