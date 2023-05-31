package prova1;

public class Bispo extends Robo {

	
	public Bispo(int id, Plano plano) {
		super(id, plano);
		this.setNome("bispo");
		this.setSimbolo("b");
		
	}

	public void avançar() {
		if(VerificarMovimento(posicaox-2, posicaoy+2)== false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox-=2;
			posicaoy+=2;
			AtualizarPosicoes();
		}
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox +2 , posicaoy -2) == false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox+=2;
			posicaoy-=2;
			AtualizarPosicoes();
		}
	}

}
