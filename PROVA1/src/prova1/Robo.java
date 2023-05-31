package prova1;

import java.util.ArrayList;

public abstract class Robo implements IRobo {
	private String nome;
	private int AlunosResgatados;
	private int BugsOcorridos;
	private ArrayList<Celula> ListaCelulasRobo = new ArrayList<Celula>();
	public int id;
	public int posicaox;
	public int posicaoy;
	public Plano plano;
	private int pontuacao;
	private String simbolo;

	public Robo(int id, Plano plano) {
		this.id = id;
		this.pontuacao=0;
		this.posicaox= ((plano.getTamanoX()+1)/2);
		this.posicaoy= posicaox;
		this.plano = plano;
		this.AlunosResgatados=0;
		this.BugsOcorridos=0;
		AtualizarPosicoes();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = this.pontuacao+ pontuacao;
	}

	public int getAlunosResgatados() {
		return AlunosResgatados;
	}

	public void setAlunosResgatados() {
		AlunosResgatados++;
	}

	public int getBugsOcorridos() {
		return BugsOcorridos;
	}

	public void setBugsOcorridos() {
		BugsOcorridos++;
	}

	public boolean VerificarMovimento(int x, int y) {
		if(x > plano.getTamanoX() || y > plano.getTamanhoY() || x<1 || y<1) {
			return false;
		}
		return true;	
	}
	
	public void AtualizarPosicoes() {
		plano.retornarCelula(posicaox, posicaoy).setRoboCelula(this);
		plano.retornarCelula(posicaox, posicaoy).setCelulaVazia(false);
		plano.retornarCelula(posicaox, posicaoy).setCelulaRobo(true);
		plano.retornarCelula(posicaox, posicaoy).VerificaElemento(this);
		ListaCelulasRobo.add(plano.retornarCelula(posicaox, posicaoy));
	}
	
	public void ImprimirReletorio() {
		System.out.println("\nRobo " + nome);
		System.out.println("Celulas visitadas:");
		for (Celula celula : ListaCelulasRobo) {
			System.out.println("    X: " + celula.getPosicaoX() + ", Y: " + celula.getPosicaoY());
		}
		System.out.println("Alunos Resgatados: " + AlunosResgatados);
		System.out.println("Bugs Ocorridos: " + BugsOcorridos);
	}
}
