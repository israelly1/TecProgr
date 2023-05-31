package prova1;

public class Torre extends Robo {

	
	public Torre(int id, Plano plano) {
		super(id, plano);
		this.setNome("torre");
		this.setSimbolo("t");
	}


	public void avançar() {
		if(VerificarMovimento(posicaox -2, posicaoy) == false) {
			System.out.println("Movimento inválido para o robo "+ this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox-=2;
			AtualizarPosicoes();
		}
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox + 2, posicaoy) == false) {
			System.out.println("Movimento inválido para o robo "+ this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox+=2;
			AtualizarPosicoes();
		}
	}

}
