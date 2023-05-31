package prova1;

public class Cavalo extends Robo{

	
	public Cavalo(int id, Plano plano) {
		super(id, plano);
		this.setNome("cavalo");
		this.setSimbolo("c");
		
	}

	public void avançar() {
		if(VerificarMovimento(posicaox-2, posicaoy-2)== false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox-=2;
			posicaoy-=2;
			AtualizarPosicoes();
		}
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox +2 , posicaoy +2) == false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox+=2;
			posicaoy+=2;
			AtualizarPosicoes();
		}
	}

}
