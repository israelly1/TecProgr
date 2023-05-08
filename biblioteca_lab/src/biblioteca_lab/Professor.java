package biblioteca_lab;

public class Professor extends Cliente {
	

	public Professor(int matricula, String nome, Biblioteca biblioteca) {
		super(matricula, nome, biblioteca);
	
	}
	public int VerificarDias() {
		return 20;
	}
	public void FazerEmprestimo(Publicacoes publicacao) {
		if(ListaPublicacoes.size() == 10) {
			System.out.println("Você ja completou 10 alugueis");
		}else {
			ListaPublicacoes.add(publicacao);
			tps+=25;
			if(tps%50==0) {
				doacoes++;
			}
		
		
		}
		
	}

	}

	

