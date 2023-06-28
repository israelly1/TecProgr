package negocio;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import apresentacao.PainelPlano;
import apresentacao.PainelRobos;

public class Plano {
	private int numeroAlunos, numeroBugs;
	private ArrayList <Celula> listaCelula;
	private Botao botao;
	private Robos robo;
	private PainelPlano Painelplano;
	private PainelRobos PainelRobo;
	private boolean isPeao, isRei, isCavalo, isVerificado;
	private ArrayList<Robos>listaRobos;
	private int pontuacaoAluno, pontuacaoBug, partidas, pontuacaoTotal;
	
	public Plano(PainelPlano Painelplano) {
		listaRobos= new ArrayList<Robos>();
		this.Painelplano= Painelplano;
		botao = new Botao(Painelplano, this);
		listaCelula= botao.getListaCelula();
		numeroAlunos= 10;
		numeroBugs= 10;
		pontuacaoAluno=0;
		pontuacaoBug=0;
		partidas=1;
		GerarAlunosBugs();
	}
	
	public boolean isPeao() {
		return isPeao;
	}

	public void setPeao(boolean isPeao) {
		this.isPeao = isPeao;
	}

	public boolean isRei() {
		return isRei;
	}

	public void setRei(boolean isRei) {
		this.isRei = isRei;
	}

	public boolean isCavalo() {
		return isCavalo;
	}

	public void setCavalo(boolean isCavalo) {
		this.isCavalo = isCavalo;
	}

	public boolean isVerificado() {
		return isVerificado;
	}

	public void setVerificado(boolean isVerificado) {
		this.isVerificado = isVerificado;
	}

	public PainelPlano getPainelplano() {
		return Painelplano;
	}

	public void setPainelplano(PainelPlano painelplano) {
		Painelplano = painelplano;
	}
	
	public Robos getRobo() {
		return robo;
	}

	public void setRobo(Robos robo) {
		this.robo = robo;
	}

	public int getPontuacaoAluno() {
		return pontuacaoAluno;
	}

	public void setPontuacaoAluno() {
		this.pontuacaoAluno ++;
	}

	public int getPontuacaoBug() {
		return pontuacaoBug;
	}

	public void setPontuacaoBug() {
		this.pontuacaoBug ++;
	}

	public int getPartidas() {
		return partidas;
	}

	public void setPartidas() {
		this.partidas++;
	}

	public int getPontuacaoTotal() {
		pontuacaoTotal= listaRobos.get(0).getPontuacao() + listaRobos.get(1).getPontuacao() + listaRobos.get(2).getPontuacao();
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(int pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public ArrayList<Celula> getListaCelula() {
		return listaCelula;
	}

	public ArrayList<Robos> getListaRobos() {
		return listaRobos;
	}

	public void setListaRobos(ArrayList<Robos> listaRobos) {
		this.listaRobos = listaRobos;
	}

	public void setListaCelula(ArrayList<Celula> listaCelula) {
		this.listaCelula = listaCelula;
	}
	
	public Celula retornarCelula(int id) {
		for (Celula celula : listaCelula) {
			if(celula.getId() == id) {
				return celula;
			}
		}
		return null;
		
	}
	
	public PainelRobos getPainelRobo() {
		return PainelRobo;
	}

	public void setPainelRobo(PainelRobos painelRobo) {
		PainelRobo = painelRobo;
	}

	public boolean VerificarCelulaVazia(int id) {
		if(retornarCelula(id).getAluno()== null && retornarCelula(id).getBug()== null) {
			return true;
		}
		return false;
	}
	
	public void GerarAlunosBugs(){
		Random random= new Random();
		for(int i=0; i<numeroAlunos; i++) {
			int id=0;
			do {
				id= random.nextInt(1, 36);
			}while(VerificarCelulaVazia(id) == false);
			Aluno aluno= new Aluno(id);
			retornarCelula(id).setAluno(aluno);
		}
		
		for(int i=0; i<numeroBugs; i++) {
			int id;
			do {
				id= random.nextInt(0, 36);
			}while(VerificarCelulaVazia(id)== false);
			Bug bug = new Bug(id);
			retornarCelula(id).setBug(bug);
		}
	}
}
