package view;

public class Jogadores {
	private String nome;
	private int pontuacao=10;
	private boolean isHost;
	
	public Jogadores(String nome) {
		this.nome= nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}
}
