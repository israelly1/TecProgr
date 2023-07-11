package control;

/**
 * Representa um jogador
 * 
 * @author Samuel
 */
public final class Jogador {
	
	/**
	 * Nome do jogador
	 */
	private String nome;
	
	/**
	 * Se o jogador for o host ou cliente do jogo
	 * 
	 * <p> {@code true} siginifica ser host
	 * {@code false} significa ser cliente </p>
	 */
	private boolean host;
	
	/**
	 * A quantidade de pontos do jogador
	 */
	private int pontuacao;
	
	private boolean isVez;
	
	private Carta cartaEscolhida1;
	private Carta cartaEscolhida2;
	
	/**
	 * Cria um novo Jogador
	 * 
	 * @param nome nome do jogador
	 * 
	 * @see Jogador#nome
	 */
	public Jogador(String nome) {
		this.nome = nome;
		host = false;
		pontuacao = 0;
		isVez = false;
		resetarCartas();
	}
	
	public void resetarInformacoes() {
		isVez = false;
		resetarCartas();
	}
	
	/**
	 * Retorna o nome do jogador
	 * 
	 * @return nome do jogador
	 * 
	 * @see Jogador#nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Diz se o jogador é o host do jogo
	 * 
	 * @return {@code true} se o jogador é o host, e {@code false} se for cliente
	 * 
	 * @see Jogador#host 
	 */
	public boolean isHost() {
		return host;
	}
	
	/**
	 * Retorna a pontuação do jogador
	 * 
	 * @return a pontuação do jogador
	 * 
	 * @see Jogador#pontuacao
	 */
	public int getPontuacao() {
		return pontuacao;
	}
	
	/**
	 * Define do jogador como host
	 * 
	 * @see Jogador#host
	 */
	public void definirComoHost() {
		host = true;
	}
	
	/**
	 * Define do jogador como cliente
	 * 
	 * @see Jogador#host
	 */
	public void definirComoClient() {
		host = false;
	}
	
	/**
	 * Define a pontuação do jogador
	 * 
	 * @param pontuacao a nova pontuação do jogador
	 * 
	 * @see Jogador#pontuacao
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	/**
	 * Adiciona pontos para o jogador
	 * 
	 * @param pontos número de pontos a serem adicionados ao jogador
	 * 
	 * @see Jogador#pontuacao
	 */
	public void adicionarPontos(int pontos) {
		pontuacao += pontos;
	}
	
	public void setVez(boolean isVez) {
		this.isVez = isVez;
	}
	
	public boolean isVez() {
		return isVez;
	}
	
	public void resetarCartas() {
		cartaEscolhida1 = null;
		cartaEscolhida2 = null;
	}
	
	public void setCartaEscolhida1(Carta cartaEscolhida1) {
		this.cartaEscolhida1 = cartaEscolhida1;
	}
	
	public void setCartaEscolhida2(Carta cartaEscolhida2) {
		this.cartaEscolhida2 = cartaEscolhida2;
	}
	
	public Carta getCartaEscolhida1() {
		return cartaEscolhida1;
	}
	
	public Carta getCartaEscolhida2() {
		return cartaEscolhida2;
	}

}
