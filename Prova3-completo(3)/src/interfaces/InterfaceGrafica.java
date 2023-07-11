package interfaces;

import java.util.ArrayList;

public interface InterfaceGrafica {
	
	/**
	 * Deve iniciar a tela com os botões de criar server e entrar server
	 */
	public void iniciarTelaEntrada();
	
	public void avisoTelaEntrada(String mensagem);
	
	/**
	 * Deve mudar para o painel de lobby e colocar o nomes dos jogadores no lobby
	 * 
	 * @param nomesJogadores nomes dos jogadores (1º é o host)
	 * @param porta a porta do servidor que deve ser apresentado no título da janela
	 */
	public void entrarLobby(ArrayList<String> nomesJogadores, int porta, boolean host);
	
	/**
	 * Deve atualizar a janela de lobby para novos nomes de jogadores
	 * 
	 * <p> chamado quando um jogador entrar ou sair no lobby </p>
	 * 
	 * @param nomesJogadores
	 */
	public void atualizarJogadoresLobby(ArrayList<String> nomesJogadores);
	
	/**
	 * Deve inicar a tela de jogo com os nomes dos jogadores
	 * 
	 * <p> todos os jogadores iniciam com pontuação 0 </p>
	 */
	public void iniciarTelaJogo(ArrayList<String> nomesJogadores);
	
	/**
	 * Deve atualizar a pontuação dos jogadores
	 * 
	 * <p>{@code pontuacoes.get(i)} é a pontuação do jogador {@code nomesJogadores.get(i)}</p>
	 * 
	 * @param nomesJogadores
	 * @param pontuacao
	 */
	public void atualizarPontuacao(ArrayList<String> nomesJogadores, ArrayList<Integer> pontuacoes);
	
	/**
	 * Deve colocar a dica na caixa de dica
	 * 
	 * <p>se dica for vazia então é a vez do jogador, caso contrário então não é a vez daquele jogador</p>
	 * 
	 * @param dica a dica para ser escrita
	 */
	public void setDica(String dica);
	
	/**
	 * Deve mudar o título da tela jogar
	 * 
	 * @param texto texto para colocar no título
	 */
	public void setTituloTelaPrincipal(String texto);
	
	public void definirESuaVez();
	
	public void definirEsperarPelaDica(String nomeJogadorVez);
	
	public void comecarParte2();
	
	/**
	 * Deve atualizar as cartas da tela jogo
	 * 
	 * @param nomesCartas
	 */
	public void atualizarCartas(ArrayList<String> nomesCartas);
	
	public void resetarTelaPrincipal();

}
