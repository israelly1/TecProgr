package prova1;

import java.util.ArrayList;

public class Celula {
	private int posicaoX;
	private int posicaoY;
	private int id;
	private ArrayList<Robo> ListaRobo;
	private Aluno aluno;
	private Bug bug;
	private boolean CelulaVazia;
	private boolean celulaBug;
	private boolean celulaRobo;
	private boolean celulaAluno;

	public Celula(int id, int x , int y) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		ListaRobo = new ArrayList<Robo>();
		this.CelulaVazia= true;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Robo> getListaRobo() {
		return ListaRobo;
	}

	public void setListaRobo(ArrayList<Robo> listaRobo) {
		ListaRobo = listaRobo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Bug getBug() {
		return bug;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		setCelulaAluno(true);
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public void setCelulaVazia(boolean celulaVazia) {
		CelulaVazia = celulaVazia;
	}

	public boolean isCelulaBug() {
		return celulaBug;
	}

	public void setCelulaBug(boolean celulaBug) {
		this.celulaBug = celulaBug;
	}

	public boolean isCelulaRobo() {
		return celulaRobo;
	}

	public void setCelulaRobo(boolean celulaRobo) {
		this.celulaRobo = celulaRobo;
	}

	public boolean isCelulaAluno() {
		return celulaAluno;
	}
	public void setCelulaAluno(boolean celulaAluno) {
		this.celulaAluno = celulaAluno;
	}
	
	public boolean isCelulaVazia() {
		if(ListaRobo.size()==0 && aluno==null && bug==null) {
			return true;
		}
		return false;
	}

	public void VerificaElemento(Robo robo) {
		if(isCelulaAluno()){
			robo.setPontuacao(10);
			robo.setAlunosResgatados();
			setAluno(null);
			celulaAluno= false;
		}
		else {
			if(isCelulaBug()) {
				robo.setPontuacao(-15);
				robo.setBugsOcorridos();
			}
		}
	}

	public void setRoboCelula(Robo robo) {
		ListaRobo.add(robo);
	}
	
	public void RemoverRobo(Robo robo) {
		ListaRobo.remove(robo);
	}
}
