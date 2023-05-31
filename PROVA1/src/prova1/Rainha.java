package prova1;

public class Rainha extends Robo {

	
	public Rainha(int id, Plano plano) {
		super(id, plano);
		this.setNome("queen");
		this.setSimbolo("q");
	}

	public void avançar() {
		if(VerificarMovimento(posicaox-4, posicaoy+4)== false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox-=4;
			posicaoy+=4;
			AtualizarPosicoes();
		}
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox +4 , posicaoy -4) == false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox+=4;
			posicaoy-=4;
			AtualizarPosicoes();
		}
	}

}
