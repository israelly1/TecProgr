package control;

import java.util.ArrayList;
import java.util.Random;

import control.Mensagem.Codigos;
import interfaces.InterfaceGrafica;
import interfaces.InterfaceRede;
import interfaces.JogoView;
import module.Persistencia;
import module.Rede;
import module.SaidaRede;
import module.gameDAO;
import view.Apresentacao;
import view.JFrameRelatorio;

public final class Jogo implements SaidaRede, JogoView {
	
	private final static String NOME_JOGO = "Adivinhação";
	
	private static Jogo instancia;
	
	private InterfaceGrafica interfaceGrafica;
	
	private InterfaceRede interfaceRede;
	
	private String dica;
	
	private ArrayList<Carta> listaCartas;
	
	private ArrayList<Jogador> listaJogadores;
	
	private Jogador jogadorInstancia;
	
	private int numeroJogadoresParaEsperar;
	
	private OrdemJogadores ordemJogadores;
	
	private Jogo() {
		listaCartas = new ArrayList<>();
		listaJogadores = new ArrayList<>();
		
		carregarCartas();
	}
	
	public static Jogo getInstance() {
		if (instancia == null) {
			instancia = new Jogo();
			return instancia;
		}
		
		return instancia;
	}
	
	public String getDiretorioCarta(String nomeCarta) {
		Carta carta = procurarCarta(nomeCarta);
		
		if (carta != null) {
			return carta.getDiretorio();
		}
		
		return "";
	}
	
	public void iniciar() {
		interfaceGrafica = Apresentacao.getInstancia();
		interfaceGrafica.iniciarTelaEntrada();
	}
	
	public void comecarJogo() {
		definirOrdemJogadores();
		
		interfaceRede.enviarMensagem(Mensagem.mensagemComecarJogo().toString());
		interfaceGrafica.iniciarTelaJogo(getNomeJogadores());
		
		iniciarRodada();
	}

	public void criarServer(String nomeJogador) {
		definirJogador(nomeJogador);
		jogadorInstancia.definirComoHost();
		
		interfaceRede = Rede.getInstancia();
		interfaceRede.setSaidaRede(this);
		interfaceRede.iniciarServer(nomeJogador);

		interfaceGrafica.entrarLobby(getNomeJogadores(), interfaceRede.getPorta(), true);
	}

	public void entrarServer(String nomeJogador, String ipPorta) {
		definirJogador(nomeJogador);
		jogadorInstancia.definirComoClient();
		
		interfaceRede = Rede.getInstancia();
		interfaceRede.setSaidaRede(this);
		
		int porta = -1;
		
		String[] args = ipPorta.split(":");
		if (args.length == 2) {
			String ip = args[0];
			String portaStr = args[1];
			
			try {
				porta = Integer.parseInt(portaStr);
				interfaceRede.conectar(nomeJogador, ip, porta);
				
				if (!interfaceRede.isConectado()) {
					interfaceGrafica.avisoTelaEntrada(
							"não foi possível conectar com ip: " + ip + ", e porta: " + porta);
					
					return;
				}
				
			} catch (NumberFormatException e) {
				interfaceGrafica.avisoTelaEntrada("IP invalido");
				return;
			}
			
		} else {
			interfaceGrafica.avisoTelaEntrada("IP invalido");
			return;
		}
		
		askHostListaJogadores();
		interfaceGrafica.entrarLobby(getNomeJogadores(), porta, false);
	}

	public void receberMensagem(String mensagemString) {
		System.out.println("mensagem recebida: " + mensagemString);
		
		Mensagem mensagem = Mensagem.decodificarMensagem(mensagemString);
		
		if (mensagem.getCodigo() == Codigos.APRESENTACAO) {
			String nome = mensagem.getArgumentos().get(0);
			adicionarJogador(nome);
			
			interfaceRede.enviarMensagem(Mensagem.mensagemAtualizarNomes(getNomeJogadores()).toString());
			interfaceGrafica.atualizarJogadoresLobby(getNomeJogadores());
			
		} else if (mensagem.getCodigo() == Codigos.UPDATE_NOMES) {
			updateJogadores(mensagem.getArgumentos());
			interfaceGrafica.atualizarJogadoresLobby(getNomeJogadores());
			
		} else if (mensagem.getCodigo() == Codigos.COMECAR_JOGO) {
			interfaceGrafica.iniciarTelaJogo(getNomeJogadores());
			
		} else if (mensagem.getCodigo() == Codigos.DICA) {
			String dica = mensagem.getArgumentos().get(0);
			interfaceGrafica.setDica(dica);
			
		} else if (mensagem.getCodigo() == Codigos.JOGADOR_DA_VEZ) {
			String nomeJogadorVez = mensagem.getArgumentos().get(0);
			
			if (jogadorInstancia.getNome().equals(nomeJogadorVez)) {
				jogadorInstancia.setVez(true);
				interfaceGrafica.definirESuaVez();
				
			} else {
				jogadorInstancia.setVez(false);
				interfaceGrafica.definirEsperarPelaDica(nomeJogadorVez);
			}
			
		} else if (mensagem.getCodigo() == Codigos.CARTAS) {
			String nomeJogador = mensagem.getArgumentos().get(0);
			if (jogadorInstancia.getNome().equals(nomeJogador)) {
				
				ArrayList<String> nomesCartas = new ArrayList<>();
				for (int i = 1; i < mensagem.getArgumentos().size(); i++) {
					nomesCartas.add(mensagem.getArgumentos().get(i));
				}
				
				interfaceGrafica.atualizarCartas(nomesCartas);
			}
			
		} else if (mensagem.getCodigo() == Codigos.CARTA_ESCOLHIDA_1) {
			if (jogadorInstancia.isVez()) {
				String nomeJogador = mensagem.getArgumentos().get(0);
				String nomeCarta = mensagem.getArgumentos().get(1);
				
				Jogador jogador = getJogador(nomeJogador);
				if (jogador != null) {
					Carta carta = getCarta(nomeCarta);
					if (carta != null) {
						jogador.setCartaEscolhida1(carta);
						numeroJogadoresParaEsperar--;
						if (numeroJogadoresParaEsperar <= 1) {
							comecarParte2Rodada();
						}
						
					} else {
						System.out.println("isso não é para acontecer");
					}
					
				} else {
					System.out.println("isso não é para acontecer");
				}
			}
			
		} else if (mensagem.getCodigo() == Codigos.CARTA_ESCOLHIDA_2) {
			if (jogadorInstancia.isVez()) {
				String nomeJogador = mensagem.getArgumentos().get(0);
				String nomeCarta = mensagem.getArgumentos().get(1);
				
				Jogador jogador = getJogador(nomeJogador);
				if (jogador != null) {
					Carta carta = getCarta(nomeCarta);
					if (carta != null) {
						jogador.setCartaEscolhida2(carta);
						numeroJogadoresParaEsperar--;
						if (numeroJogadoresParaEsperar <= 1) {
							fimParte2();
						}
						
					} else {
						System.out.println("isso não é para acontecer");
					}
					
				} else {
					System.out.println("isso não é para acontecer");
				}
			}
			
		} else if (mensagem.getCodigo() == Codigos.COMECAR_PARTE_2) {
			ArrayList<String> cartasEscolhidas = mensagem.getArgumentos();
			interfaceGrafica.atualizarCartas(cartasEscolhidas);
			interfaceGrafica.comecarParte2();
			
		} else if (mensagem.getCodigo() == Codigos.UPDATE_PONTOS) {
			ArrayList<String> nomesJogadores = new ArrayList<>();
			ArrayList<Integer> pontuacaoJogadores = new ArrayList<>();
			
			for (int i = 0; i < mensagem.getArgumentos().size(); i += 2) {
				String nomeJogador = mensagem.getArgumentos().get(i);
				nomesJogadores.add(nomeJogador);
				
				String pontosJogadorStr = mensagem.getArgumentos().get(i + 1);
				int pontosJogador; 
				try {
					pontosJogador = Integer.parseInt(pontosJogadorStr);
				} catch (NumberFormatException e) {
					pontosJogador = 0;
				}
				
				pontuacaoJogadores.add(pontosJogador);
			}
			
			updatePontos(nomesJogadores, pontuacaoJogadores);
			interfaceGrafica.atualizarPontuacao(nomesJogadores, pontuacaoJogadores);
			
		} else if (mensagem.getCodigo() == Codigos.TERMINAR_RODADA) {
			System.out.println("recebido mensagem para terminar a rodada");
			
			if (jogadorInstancia.isHost()) {
				System.out.println("sou o host");
				
				fimRodada();
			}
		}
	}

	public String getNomeJogo() {
		return NOME_JOGO;
	}
	
	public void receberDicaECarta(String dica, String nomeCarta) {
		if (jogadorInstancia.isVez()) {
			Carta cartaEscolhida = getCarta(nomeCarta);
			jogadorInstancia.setCartaEscolhida1(cartaEscolhida);
			
			this.dica = dica;
			interfaceRede.enviarMensagem(Mensagem.mensagemDica(dica).toString());
			
			numeroJogadoresParaEsperar = listaJogadores.size();
			
		} else {
			System.out.println("isso não deveria acontecer");
		}
	}

	public void receberCartaParte1(String nomeCarta) {
		if (!jogadorInstancia.isVez()) {
			Carta cartaEscolhida = getCarta(nomeCarta);
			jogadorInstancia.setCartaEscolhida1(cartaEscolhida);
			
			String nomeJogador = jogadorInstancia.getNome();
			interfaceRede.enviarMensagem(Mensagem.mensagemCartaEscolhidaPart1(nomeJogador, nomeCarta).toString());
			
		} else {
			System.out.println("isso não deveria acontecer");
		}
	}

	public void receberCartaParte2(String nomeCarta) {
		if (!jogadorInstancia.isVez()) {
			Carta cartaEscolhida = getCarta(nomeCarta);
			jogadorInstancia.setCartaEscolhida2(cartaEscolhida);
			
			String nomeJogador = jogadorInstancia.getNome();
			interfaceRede.enviarMensagem(Mensagem.mensagemCartaEscolhidaPart2(nomeJogador, nomeCarta).toString());
		} else {
			System.out.println("isso não deveria acontecer");
		}
		
	}

	private void iniciarRodada() {
		embaralharCartas();
		distribuirCartas();
		
		String nomeJogadorVez = ordemJogadores.getJogadorVez().getNome();
		
		interfaceRede.enviarMensagem(Mensagem.mensagemJogadorDaVez(nomeJogadorVez).toString());
		
		if (jogadorInstancia.getNome().equals(nomeJogadorVez)) {
			jogadorInstancia.setVez(true);
			interfaceGrafica.definirESuaVez();
		} else {
			jogadorInstancia.setVez(false);
			interfaceGrafica.definirEsperarPelaDica(nomeJogadorVez);
		}
	}
	
	private void fimParte2() {
		contarPontos();
		
		interfaceRede.enviarMensagem(Mensagem.mensagemAtualizarPontuacao(getNomeJogadores(), getPontuacaoJogadores()).toString());
		interfaceGrafica.atualizarPontuacao(getNomeJogadores(), getPontuacaoJogadores());
		
		interfaceRede.enviarMensagem(Mensagem.mensagemTerminarRodada().toString());
		if (jogadorInstancia.isHost()) {
			fimRodada();
		}
	}
	
	private void fimRodada() {
		System.out.println("terminando a rodada");
		
		ordemJogadores.passarVez();
		
		salvarDadosBancoDeDados();
		
		for (Jogador jogador : listaJogadores) {
			jogador.resetarInformacoes();
		}
		
		interfaceGrafica.resetarTelaPrincipal();
		
		iniciarRodada();
	}
	
	private void contarPontos() {
		
		if (todosJogadoresAcertaramACartaDoJogdaorDaVez() || todosJogadoresErraramACartaDoJogdaorDaVez()) {
			for (Jogador jogador : listaJogadores) {
				if (!jogador.isVez()) {
					jogador.adicionarPontos(2);
				}
			}
		} else {
			getJogadorVez().adicionarPontos(2);
		}
		
		for (Jogador jogador : listaJogadores) {
			if (!jogador.isVez()) {
				String nomeCartaEscolhida = jogador.getCartaEscolhida1().getNome();
				
				for (Jogador outroJogador : listaJogadores) {
					if (!outroJogador.isVez() && outroJogador != jogador) {
						
						String nomeCartaEscolhidaOutroJogador = outroJogador.getCartaEscolhida2().getNome();
						if (nomeCartaEscolhidaOutroJogador.equals(nomeCartaEscolhida)) {
							
							jogador.adicionarPontos(1);
						}
					}
				}
			}
		}
		
	}
	
	private boolean todosJogadoresAcertaramACartaDoJogdaorDaVez() {
		String nomeCartaEscolhidaJogadorVez = getNomeCartaEscolhidaJogadorVez();
		
		for (Jogador jogador : listaJogadores) {
			if (!jogador.isVez()) {
				String cartaEscolhida = jogador.getCartaEscolhida2().getNome();
				
				if (!cartaEscolhida.equals(nomeCartaEscolhidaJogadorVez)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean todosJogadoresErraramACartaDoJogdaorDaVez() {
		String nomeCartaEscolhidaJogadorVez = getNomeCartaEscolhidaJogadorVez();
		
		for (Jogador jogador : listaJogadores) {
			if (!jogador.isVez()) {
				String cartaEscolhida = jogador.getCartaEscolhida2().getNome();
				
				if (cartaEscolhida.equals(nomeCartaEscolhidaJogadorVez)) {
					return false;
				}
			}
		}
		
		return true;	
	}
	
	private Jogador getJogadorVez() {
		for (Jogador jogador : listaJogadores) {
			if (jogador.isVez()) {
				return jogador;
			}
		}
		
		return null;
	}
	
	private String getNomeCartaEscolhidaJogadorVez() {
		for (Jogador jogador : listaJogadores) {
			if (jogador.isVez()) {
				return jogador.getCartaEscolhida1().getNome();
			}
		}
		
		return null;
	}

	private void comecarParte2Rodada() {
		numeroJogadoresParaEsperar = listaJogadores.size();
		
		ArrayList<String> cartasEscolhidas = getCartasEscolhidasNomes();
		
		interfaceRede.enviarMensagem(Mensagem.mensagemComecarParte2(cartasEscolhidas).toString());
	}
	
	private void distribuirCartas() {
		int indexCarta = 0;
		
		for (int i = 0; i < listaJogadores.size(); i++) {
			ArrayList<String> cartasJogador = new ArrayList<>();
			
			for (int j = 0; j < 6; j++) {
				cartasJogador.add(listaCartas.get(indexCarta).getNome());
				indexCarta++;
			}
			
			String nomeJogador = listaJogadores.get(i).getNome();
			
			if (nomeJogador.equals(jogadorInstancia.getNome())) {
				interfaceGrafica.atualizarCartas(cartasJogador);
				
			} else {
				interfaceRede.enviarMensagem(Mensagem.mensagemCartas(nomeJogador, cartasJogador).toString());
			}
		}
	}
	
	private void updateJogadores(ArrayList<String> nomesJogadores) {
		System.out.println("antes de atualizar nome dos jogadores: " + getNomeJogadores());
		
		if (jogadorInstancia.isHost()) {
			if (nomesJogadores.get(0).equals(jogadorInstancia.getNome())) {
				
				resetarListaJogadores();
				adicionarJogador(jogadorInstancia);
				
				for (int i = 1; i < nomesJogadores.size(); i++) {
					adicionarJogador(nomesJogadores.get(i));
				}
				
			} else {
				System.out.println(
						"Erro, nome do primeiro jogador da lista: " 
								+ nomesJogadores.get(0) + " é diferente do nome do jogador da instância: " 
								+ jogadorInstancia.getNome() + " que é o host!"	
								);
			}
			
		} else {
			if (!nomesJogadores.get(0).equals(jogadorInstancia.getNome())) {
				
				resetarListaJogadores();
				adicionarHost(nomesJogadores.get(0));
				
				boolean nomeJogadorInstanciaEncontrado = false;
				
				for (int i = 1; i < nomesJogadores.size(); i++) {
					if (nomesJogadores.get(i).equals(jogadorInstancia.getNome())) {
						nomeJogadorInstanciaEncontrado = true;
						adicionarJogador(jogadorInstancia);
					} else {
						adicionarJogador(nomesJogadores.get(i));
					}
				}
				
				if (!nomeJogadorInstanciaEncontrado) {
					System.out.println("o nome do jogador da instância: " + jogadorInstancia.getNome() 
						+ "não foi encontrado na lista de nomes: ");
					for (int i = 0; i < nomesJogadores.size(); i++) {
						System.out.print(nomesJogadores.get(i) + " ");
					}
				}
				
			} else {
				System.out.println(
						"Erro, nome do primeiro jogador da lista: " 
								+ nomesJogadores.get(0) + " é igual do nome do jogador da instância: " 
								+ jogadorInstancia.getNome() + " que não é o host!"	
								);
			}
			
		}
		
		System.out.println("depois de atualizar nome dos jogadores: " + getNomeJogadores());
		
	}

	private void carregarCartas() {
		for(String nomeCarta : Persistencia.getInstance().getNomeCartas()) {
			listaCartas.add(new Carta(nomeCarta));
		}
	}
	
	private void definirJogador(String nome) {
		jogadorInstancia = new Jogador(nome);
		adicionarJogador(jogadorInstancia);
	}

//	private void atualizarPontos(String nome, int pontuacao) {
//		Jogador jogador = getJogador(nome);
//		
//		if (jogador != null) {
//			jogador.setPontuacao(pontuacao);
//		}
//	}
	
	private Jogador getJogador(String nomeJogador) {
		for (Jogador jogador : listaJogadores) {
			if (jogador.getNome().equals(nomeJogador)) {
				return jogador;
			}
		}
		
		return null;
	}
	
	private ArrayList<Integer> getPontuacaoJogadores() {
		ArrayList<Integer> pontosOrdemCorreta = new ArrayList<>();
		
		for (String nomeJogador : getNomeJogadores()) {
			Jogador jogador = getJogador(nomeJogador);
			pontosOrdemCorreta.add(jogador.getPontuacao());
		}
		
		return pontosOrdemCorreta;
	}
	
	private ArrayList<String> getNomeJogadores() {
		ArrayList<String> nomesClientes = new ArrayList<>();
		String nomeHost = "null";
		
		for (Jogador jogador : listaJogadores) {
			if (jogador.isHost()) {
				nomeHost = jogador.getNome();
			} else {
				nomesClientes.add(jogador.getNome());
			}
		}
		
		ArrayList<String> nomesJogdaoresOrdemCorreta = new ArrayList<>();
		nomesJogdaoresOrdemCorreta.add(nomeHost);
		nomesJogdaoresOrdemCorreta.addAll(nomesClientes);
		
		return nomesJogdaoresOrdemCorreta;
	}
	
	private void resetarListaJogadores() {
		listaJogadores = new ArrayList<>();
	}
	
	private void adicionarJogador(Jogador jogador) {
		listaJogadores.add(jogador);
	}
	
	private void adicionarJogador(String nome) {
		listaJogadores.add(new Jogador(nome));
	}
	
	private void adicionarHost(String nome) {
		Jogador jogador = new Jogador(nome);
		jogador.definirComoHost();
		listaJogadores.add(jogador);
	}
	
	private void definirOrdemJogadores() {
		ordemJogadores = new OrdemJogadores(listaJogadores);
	}
	
//	private Jogador getJogador(String nome) {
//		for (Jogador jogador : listaJogadores) {
//			if (jogador.getNome().equals(nome)) {
//				return jogador;
//			}
//		}
//		
//		return null;
//	}
	
	private void embaralharCartas() {
		ArrayList<Carta> listaTemporariaCartas = new ArrayList<>();
		
		Random geradorAleatorio = new Random();
		
		while (listaCartas.size() > 0) {
			int indexAleatorio = geradorAleatorio.nextInt(0, listaCartas.size());
			listaTemporariaCartas.add(listaCartas.get(indexAleatorio));
			listaCartas.remove(indexAleatorio);
		}
		
		listaCartas = listaTemporariaCartas;
	}
	
	private Carta procurarCarta(String nomeCarta) {
		for (Carta carta : listaCartas) {
			if (carta.getNome().equals(nomeCarta)) {
				return carta;
			}
		}
		
		return null;
	}
	
	private void updatePontos(ArrayList<String> nomesJogadores, ArrayList<Integer> pontuacaoJoadores) {
		for (int i = 0; i < nomesJogadores.size(); i++) {
			String nomeJogador = nomesJogadores.get(i);
			Jogador jogador = getJogador(nomeJogador);
			
			jogador.setPontuacao(pontuacaoJoadores.get(i));
		}
	}
	
	private Carta getCarta(String nome) {
		for (Carta carta : listaCartas) {
			if (carta.getNome().equals(nome)) {
				return carta;
			}
		}
		
		return null;
	}
	
	private ArrayList<String> getCartasEscolhidasNomes() {
		ArrayList<String> nomesCartasEscolhidasEmOrdem = new ArrayList<>();
		ArrayList<String> nomesCartasEscolhidasEmbaralhado = new ArrayList<>();
		
		for (Jogador jogador : listaJogadores) {
			String nomeCartaEscolhida = jogador.getCartaEscolhida1().getNome();
			nomesCartasEscolhidasEmOrdem.add(nomeCartaEscolhida);
		}
		
		Random gerador = new Random();
		
		while (nomesCartasEscolhidasEmOrdem.size() > 0) {
			int indexAleatorio = gerador.nextInt(0, nomesCartasEscolhidasEmOrdem.size());
			nomesCartasEscolhidasEmbaralhado.add(nomesCartasEscolhidasEmOrdem.get(indexAleatorio));
			nomesCartasEscolhidasEmOrdem.remove(indexAleatorio);
		}
		
		return nomesCartasEscolhidasEmbaralhado;
	}
	
	private void askHostListaJogadores() {
		interfaceRede.enviarMensagem(Mensagem.mensagemApresentacao(jogadorInstancia.getNome()).toString());
	}
	
	private void salvarDadosBancoDeDados() {
		
		Jogador jogadorVez = getJogadorVez();
		String nomeJogadorVez = jogadorVez.getNome();
		String cartaEscolhidaJogadorVez = jogadorVez.getCartaEscolhida1().getNome();
		int pontuacaoJogadorVez = jogadorVez.getPontuacao();
		
		Jogador jogador2 = getJogador(getNomeJogadores().get(1));
		String nomeJogador2;
		String cartaEscolhidaJogador2;
		int pontuacaoJogador2;
		if (jogador2 != null) {
			nomeJogador2 = jogador2.getNome();
			cartaEscolhidaJogador2 = jogador2.getCartaEscolhida1().getNome();
			pontuacaoJogador2 = jogador2.getPontuacao();
		} else {
			nomeJogador2 = "null";
			cartaEscolhidaJogador2 = "null";
			pontuacaoJogador2 = -1;
		}
		
		Jogador jogador3 = getJogador(getNomeJogadores().get(2));
		String nomeJogador3;
		String cartaEscolhidaJogador3;
		int pontuacaoJogador3;
		if (jogador3 != null) {
			nomeJogador3 = jogador3.getNome();
			cartaEscolhidaJogador3 = jogador3.getCartaEscolhida1().getNome();
			pontuacaoJogador3 = jogador3.getPontuacao();
		} else {
			nomeJogador3 = "null";
			cartaEscolhidaJogador3 = "null";
			pontuacaoJogador3 = -1;
		}
		
		Jogador jogador4 = getJogador(getNomeJogadores().get(3));
		String nomeJogador4;
		String cartaEscolhidaJogador4;
		int pontuacaoJogador4;
		if (jogador4 != null) {
			nomeJogador4 = jogador4.getNome();
			cartaEscolhidaJogador4 = jogador4.getCartaEscolhida1().getNome();
			pontuacaoJogador4 = jogador4.getPontuacao();
		} else {
			nomeJogador4 = "null";
			cartaEscolhidaJogador4 = "null";
			pontuacaoJogador4 = -1;
		}
		
		Persistencia.getInstance().salvarNovaLinha(dica, 
				nomeJogadorVez, cartaEscolhidaJogadorVez, pontuacaoJogadorVez, 
				nomeJogador2, cartaEscolhidaJogador2, pontuacaoJogador2, 
				nomeJogador3, cartaEscolhidaJogador3, pontuacaoJogador3, 
				nomeJogador4, cartaEscolhidaJogador4, pontuacaoJogador4);
		}

	public void instanciarRelatorio() {
		new JFrameRelatorio(gameDAO.getInstancia().getMatrizDeDados());
	}

}
