package biblioteca_lab;

public class Aluno extends Cliente{
	public Aluno(int matricula, String nome, Biblioteca biblioteca) {
		super(matricula, nome, biblioteca);
	}
	public int VerificarDias() {
		return 10;
	}
	public void FazerEmprestimo(Publicacoes publicacoes) {
		if(ListaPublicacoes.size() == 5) {
			System.out.println("Você ja completou 5 alugueis");
		}else {
			ListaPublicacoes.add(publicacoes);
			if(publicacoes instanceof Livro) {
				tps = tps + 9;
				if(tps%50==0) {
					doacoes++;
				}
			}else {
				if(publicacoes instanceof Revista) {
					tps = (float) (tps + 9.9);
					if(tps%50==0) {
						doacoes++;
					}
				}else {
					tps = tps + 5;
					if(tps%50==0) {
						doacoes++;
					}
				}
			}
		}
		
	}

	

	
}
