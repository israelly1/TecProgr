package view;

import java.util.ArrayList;

import control.Jogo;
import interfaces.InterfaceGrafica;
import interfaces.JogoView;

public class Apresentacao implements InterfaceGrafica {
	
	private static Apresentacao instancia;
	
	private JogoView camadaControle;
	
	private JanelaPrincipal janelaPrincipal;
	private JanelaEntrada janelaEntrada;
	
	private Apresentacao() {
		camadaControle = Jogo.getInstance();
		janelaEntrada = new JanelaEntrada(camadaControle.getNomeJogo());
		janelaPrincipal = new JanelaPrincipal();
	}
	
	protected String getDiretorioCarta(String nomeCarta) {
		return camadaControle.getDiretorioCarta(nomeCarta);
	}
	
	protected PainelMesa getPainelMesa() {
		return janelaPrincipal.getPainelMesa();
	}
	
	protected void criarServer(String nomeJogador) {
		camadaControle.criarServer(nomeJogador);
	}
	
	protected void entrarServer(String nomeJogador, String ipPorta) {
		camadaControle.entrarServer(nomeJogador, ipPorta);
	}
	
	protected String getNomeJogo() {
		return camadaControle.getNomeJogo();
	}
	
	protected JanelaEntrada getJanelaEntrada() {
		return janelaEntrada;
	}
	
	protected void comecarJogo() {
		camadaControle.comecarJogo();
	}
	
	protected void mandarCartaPart1(String nomeCarta) {
		camadaControle.receberCartaParte1(nomeCarta);
		
		janelaPrincipal.setEsperar(true);
		janelaPrincipal.setTitle("espere os outros jogadores escolherem as cartas");
	}
	
	protected void mandarCartaPart2(String nomeCarta) {
		camadaControle.receberCartaParte2(nomeCarta);
		
		janelaPrincipal.setEsperar(true);
		janelaPrincipal.setTitle("espere os outros jogadores escolherem as cartas");
		
	}

	protected void mandarCartaEDica(String nomeCarta, String dica) {
		camadaControle.receberDicaECarta(dica, nomeCarta);
		
		janelaPrincipal.setEsperar(true);
		janelaPrincipal.setTitle("espere os outros jogadores escolherem as cartas");
		janelaPrincipal.setCaixaDica(dica);
		janelaPrincipal.caixaDicaSetEnable(false);
	}

	public static Apresentacao getInstancia() {
		if (instancia == null) {
			instancia = new Apresentacao();
		}
		return instancia;
	}
	
	/*
	public Apresentacao() {
		this.janelaEntrada= new JanelaEntrada();
		iniciarTelaEntrada();
	}
	*/

	public void iniciarTelaEntrada() {
		janelaEntrada.setVisible(true);
		janelaPrincipal.setVisible(false);
	}
	
	public void iniciarTelaJogo(ArrayList<String> nomesJogadores) {
		janelaEntrada.setVisible(false);
		janelaPrincipal.setVisible(true);
		
		janelaPrincipal.atualizarJogadores(nomesJogadores);
	}

	/*
	public void entrarLobby(ArrayList<Jogadores>listaJogadores, int porta) {
		janela.getPainelEntrada().setPorta(porta);
		janela.getPainelEntrada().getPainelIntermediario().setListaJogadores(listaJogadores);
	}
	*/
	
	public void atualizarPontuacao(ArrayList<String> nomesJogadores, ArrayList<Integer> pontuacoes) {
		janelaPrincipal.atualizarJogadores(nomesJogadores, pontuacoes);
	}
	
	public void setDica(String dica) {
		janelaPrincipal.setCaixaDica(dica);
		janelaPrincipal.caixaDicaSetEnable(false);
		janelaPrincipal.setEsperar(false);
		janelaPrincipal.setTitle("Escolha uma carta");
	}
	
	public void setTituloTelaPrincipal(String title) {
		janelaPrincipal.setTitle(title);
	}
	
	public void atualizarCartas(ArrayList<String> nomesCartas) {
		janelaPrincipal.getPainelMesa().setListaCartas(nomesCartas);
	}

	public void entrarLobby(ArrayList<String> nomesJogadores, int porta, boolean host) {
		janelaEntrada.mudarParaLobby(nomesJogadores, host);
		janelaEntrada.setTitle("porta: " + porta);
	}

	public void atualizarJogadoresLobby(ArrayList<String> nomesJogadores) {
		janelaEntrada.getPainelLobby().setNomes(nomesJogadores);
	}

	public void avisoTelaEntrada(String mensagem) {
		janelaEntrada.aviso(mensagem);
	}

	public void definirESuaVez() {
		janelaPrincipal.setTitle("É sua vez!");
		janelaPrincipal.setEsperar(false);
		janelaPrincipal.setJogadorVez(true);
		janelaPrincipal.setParte2(false);
	}

	public void definirEsperarPelaDica(String nomeJogadorVez) {
		janelaPrincipal.setTitle("Espere, é a vez de " + nomeJogadorVez);
		janelaPrincipal.setEsperar(true);
		janelaPrincipal.setJogadorVez(false);
		janelaPrincipal.setParte2(false);
	}

	public void comecarParte2() {
		janelaPrincipal.setTitle("Escolha uma das cartas escolhidas pelos outros jogadores");
		janelaPrincipal.setEsperar(false);
		janelaPrincipal.setParte2(true);
	}

	public void resetarTelaPrincipal() {
		janelaPrincipal.getPainelMesa().setListaCartas(null);
		janelaPrincipal.setCaixaDica("");
		janelaPrincipal.caixaDicaSetEnable(false);
		janelaPrincipal.setEsperar(true);
		janelaPrincipal.setTitle("");
		janelaPrincipal.setParte2(false);
		
	}
	
//	public void avisoTelaPrincipal(String mensagem) {
//		janelaPrincipal.aviso(mensagem);
//	}
	
}