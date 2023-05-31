package prova1;

public class Peão extends Robo{
	public Peão(int id, Plano plano) {
		super(id, plano);
		this.setNome("peao");
		this.setSimbolo("p");
	}

	public void avançar() {
		if(VerificarMovimento(posicaox, posicaoy+1)== false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaoy++;
			AtualizarPosicoes();
		}
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox , posicaoy -1) == false) {
			System.out.println("Movimento inválido para o robo " + this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaoy--;
			AtualizarPosicoes();
		}
	}
}

