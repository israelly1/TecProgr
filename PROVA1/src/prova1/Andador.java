package prova1;

public class Andador extends Robo{
	public Andador(int id, Plano plano) {
		super(id, plano);
		this.setNome("andador");
		this.setSimbolo("a");
	}

	public void retroceder() {
		if(VerificarMovimento(posicaox + 1, posicaoy) == false) {
			System.out.println("Movimento inválido para o robo "+ this.getNome());
		}
		
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox++;
			AtualizarPosicoes();
		}
	}
	public void avançar() {
		if(VerificarMovimento(posicaox -1, posicaoy) == false) {
			System.out.println("Movimento inválido para o robo "+ this.getNome());
		}
		else {
			plano.retornarCelula(posicaox, posicaoy).RemoverRobo(this);
			posicaox--;
			AtualizarPosicoes();
		}
	}

}
