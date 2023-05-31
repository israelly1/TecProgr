package prova1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
	private Jogador jogador;
	private int numeroAlunos;
	private int numeroBugs;
	private Plano plano;
	private int AlunosResgatados;
	private int BugsOcorridos;
	private int AlunosRestantes;
	private ArrayList<Robo> ListaRobo;
	
	public ArrayList<Robo> getListaRobo() {
		return ListaRobo;
	}

	public void setListaRobo(ArrayList<Robo> listaRobo) {
		ListaRobo = listaRobo;
	}

	public Jogo(Plano plano) {
		super();
		this.numeroAlunos = 0;
		this.numeroBugs = 0;
		this.plano = plano;
		this.AlunosResgatados=0;
		this.BugsOcorridos=0;
		this.AlunosRestantes= 0;
		this.ListaRobo= new ArrayList <Robo>();
		this.jogador = new Jogador(null);
		Andador andador= new Andador(1, plano);
		Peão peao= new Peão(2, plano);
		Torre torre = new Torre(3, plano);
		Bispo bispo= new Bispo(4, plano);
		Cavalo cavalo= new Cavalo(5, plano);
		Rei king = new Rei(6, plano);
		Rainha queen= new Rainha(7, plano);
		ListaRobo.add(andador);
		ListaRobo.add(peao);
		ListaRobo.add(torre);
		ListaRobo.add(bispo);
		ListaRobo.add(cavalo);
		ListaRobo.add(king);
		ListaRobo.add(queen);
		
	}
	
	public boolean VerificarCelulaVazia(int x, int y) {
		for (Celula celula : plano.getListaCelulas()) {
			if(celula.getPosicaoX() == x && celula.getPosicaoY() == y) {
				if(celula.isCelulaVazia()) {
					return true;
				}
			}
		}
		return false;
	}

	public void GerarAlunosBugs(){
		Random random= new Random();
		for(int i=0; i<numeroAlunos; i++) {
			int x,y;
			do {
				x= random.nextInt(0, plano.getTamanoX());
				y= random.nextInt(0, plano.getTamanhoY());
			}while(VerificarCelulaVazia(x,y) == false);
			Aluno aluno= new Aluno(i+1, x, y, plano);
			plano.retornarCelula(x, y).setAluno(aluno);
			plano.retornarCelula(x, y).setCelulaAluno(true);
			plano.retornarCelula(x, y).setCelulaVazia(false);
		}
		
		for(int i=0; i<numeroBugs; i++) {
			int x,y;
			do {
				x= random.nextInt(0, plano.getTamanoX());
				y= random.nextInt(0, plano.getTamanhoY());
			}while(VerificarCelulaVazia(x,y)== false);
			Bug bug = new Bug(i+1, x, y, plano);
			plano.retornarCelula(x, y).setBug(bug);
			plano.retornarCelula(x,y).setCelulaBug(true);
			plano.retornarCelula(x, y).setCelulaVazia(false);
		}
	}
	
	public void ImprimirPlanoPontuacao() {
		plano.ImprimirPlano();
		System.out.println("\nPONTUAÇÕES:");
		
		AlunosResgatados = 0;
		BugsOcorridos = 0;
		for (Robo robo : ListaRobo) {
			System.out.println(robo.getNome()+":" +robo.getPontuacao());
			AlunosResgatados= robo.getAlunosResgatados() + AlunosResgatados;
			BugsOcorridos= robo.getBugsOcorridos() + BugsOcorridos;
			AlunosRestantes= numeroAlunos - AlunosResgatados;
		}
		System.out.println("\nAlunos resgatados: " + AlunosResgatados + "\nBugs ocorridos: "+ BugsOcorridos);
		System.out.println("Alunos Restantes: " +AlunosRestantes);
		System.out.println("\n");
	}
	
	
	public void Start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome do jogador: ");
		String nomeJogador= sc.nextLine();
		jogador.setNome(nomeJogador);
		
		System.out.println("Digite o número de Alunos: ");
		this.numeroAlunos = sc.nextInt();
		System.out.println("Digite o número de Bugs: ");
		this.numeroBugs = sc.nextInt();
		GerarAlunosBugs();
		
		AlunosRestantes= numeroAlunos;
		int rodadas=1;
		String movimento="";
		String continuarJogo= "S";
		sc.nextLine();
		System.out.println("Estado inicial do jogo: ");
		ImprimirPlanoPontuacao();
		while(AlunosRestantes > 0 && continuarJogo.equals("S")) {
			System.out.println("-------------------------------------------------------------- RODADA: "+ rodadas);
			for (Robo robo : ListaRobo) {
				System.out.println("(A) Avançar ou (R) Retroceder para " + robo.getNome());
				movimento= sc.nextLine();
				if(movimento.equals("A")) {
					robo.avançar();
				}else if(movimento.equals("R")) {
					robo.retroceder();
				}
			}
			ImprimirPlanoPontuacao();
			System.out.println(jogador.getNome() +", Deseja continuar? (S/N):  ");
			continuarJogo= sc.nextLine();
			System.out.println("-------------------------------------------------------------- ");
			rodadas++;
		}
		System.out.println("\nFIM DE JOGO");
		
		System.out.println("\n\nRelatório da Partida");
		for (Robo robo : ListaRobo) {
			robo.ImprimirReletorio();
		}
	}
	
}

