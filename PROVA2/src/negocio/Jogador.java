package negocio;

public class Jogador {
	
	private Plano plano;
	private String nome;
	private int partidas, pontuacaoTotal, pontuacaoAluno, pontuacaoBug, pontRei, pontPeao, pontCavalo;
	
	public Jogador(String nome, int partidas, int pontuacaoTotal, int pontuacaoAluno,
		int pontuacaoBug, int pontRei, int pontPeao, int pontCavalo) {
		this.nome= nome;
		this.partidas= partidas;
		this.pontuacaoTotal= pontuacaoTotal;
		this.pontuacaoAluno= pontuacaoAluno;
		this.pontuacaoBug= pontuacaoBug;
		this.pontRei= pontRei;
		this.pontPeao= pontPeao;
		this.pontCavalo= pontCavalo;
		this.pontuacaoTotal= pontRei + pontPeao + pontCavalo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public int getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(int pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public int getPontuacaoAluno() {
		return pontuacaoAluno;
	}

	public int getPontuacaoBug() {
		return pontuacaoBug;
	}

	public int getPartidas() {
		return partidas;
	}

	public int getPontRei() {
		return pontRei;
	}

	public int getPontPeao() {
		return pontPeao;
	}

	public int getPontCavalo() {
		return pontCavalo;
	}

}
