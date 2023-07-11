package control;

import java.util.ArrayList;

/**
 * Usado para se para codificar mensagens em strings para enviar por rede,
 * além de também poder ser usado para decodificar strings em mensagens
 * 
 * @author Samuel
 */
public class Mensagem {
	
	private Codigos codigo;
	private ArrayList<String> argumentos;
	
	private Mensagem(Codigos codigo, ArrayList<String> argumentos) {
		this.argumentos = argumentos;
		this.codigo = codigo;
	}
	
	protected static Mensagem decodificarMensagem(String mensagem) {
		String[] args = mensagem.split(";");
		
		int codigoNumero;
		try {
			codigoNumero = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			codigoNumero = 0;
		}
		
		Codigos codigo;
		
		if (codigoNumero == Codigos.APRESENTACAO.getCodigoNumero()) {
			codigo = Codigos.APRESENTACAO;
		} else if (codigoNumero == Codigos.UPDATE_NOMES.getCodigoNumero()) {
			codigo = Codigos.UPDATE_NOMES;
		} else if (codigoNumero == Codigos.COMECAR_JOGO.getCodigoNumero()) {
			codigo = Codigos.COMECAR_JOGO; 
		} else if (codigoNumero == Codigos.DICA.getCodigoNumero()) {
			codigo = Codigos.DICA; 
		} else if (codigoNumero == Codigos.JOGADOR_DA_VEZ.getCodigoNumero()) {
			codigo = Codigos.JOGADOR_DA_VEZ; 
		} else if (codigoNumero == Codigos.CARTAS.getCodigoNumero()) {
			codigo = Codigos.CARTAS; 
		} else if (codigoNumero == Codigos.CARTA_ESCOLHIDA_1.getCodigoNumero()) {
			codigo = Codigos.CARTA_ESCOLHIDA_1; 
		} else if (codigoNumero == Codigos.CARTA_ESCOLHIDA_2.getCodigoNumero()) {
			codigo = Codigos.CARTA_ESCOLHIDA_2; 
		} else if (codigoNumero == Codigos.COMECAR_PARTE_2.getCodigoNumero()) {
			codigo = Codigos.COMECAR_PARTE_2; 
		} else if (codigoNumero == Codigos.UPDATE_PONTOS.getCodigoNumero()) {
			codigo = Codigos.UPDATE_PONTOS; 
		} else if (codigoNumero == Codigos.TERMINAR_RODADA.getCodigoNumero()) {
			codigo = Codigos.TERMINAR_RODADA; 
		} else {
			codigo = Codigos.DESCONHECIDO;
		}
		
		ArrayList<String> argumentos = new ArrayList<>();
 		
		for (int i = 1; i < args.length; i++) {
			argumentos.add(args[i]);
		}
		
		return new Mensagem(codigo, argumentos);
	}
	
	protected static Mensagem mensagemApresentacao(String nome) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(nome);
		return new Mensagem(Codigos.APRESENTACAO, argumentos);
	}
	
	protected static Mensagem mensagemAtualizarNomes(ArrayList<String> nomes) {
		return new Mensagem(Codigos.UPDATE_NOMES, nomes);
	}
	
	protected static Mensagem mensagemComecarJogo() {
		return new Mensagem(Codigos.COMECAR_JOGO, null);
	}
	
	protected static Mensagem mensagemDica(String dica) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(dica);
		return new Mensagem(Codigos.DICA, argumentos);
	}
	
	protected static Mensagem mensagemJogadorDaVez(String nomeJogadorDaVez) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(nomeJogadorDaVez);
		return new Mensagem(Codigos.JOGADOR_DA_VEZ, argumentos);
	}
	
	protected static Mensagem mensagemCartas(String nomeJogador, ArrayList<String> nomesCartas) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(nomeJogador);
		argumentos.addAll(nomesCartas);
		return new Mensagem(Codigos.CARTAS, argumentos);
	}
	
	protected static Mensagem mensagemCartaEscolhidaPart1(String nomeJogador, String nomeCarta) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(nomeJogador);
		argumentos.add(nomeCarta);
		return new Mensagem(Codigos.CARTA_ESCOLHIDA_1, argumentos);
	}
	
	protected static Mensagem mensagemComecarParte2(ArrayList<String> cartasEscolhidas) {
		return new Mensagem(Codigos.COMECAR_PARTE_2, cartasEscolhidas);
	}
	
	protected static Mensagem mensagemCartaEscolhidaPart2(String nomeJogador, String nomeCarta) {
		ArrayList<String> argumentos = new ArrayList<>();
		argumentos.add(nomeJogador);
		argumentos.add(nomeCarta);
		return new Mensagem(Codigos.CARTA_ESCOLHIDA_2, argumentos);
	}
	
	protected static Mensagem mensagemAtualizarPontuacao(ArrayList<String> nomesJogadores, ArrayList<Integer> pontuacoes) {
		ArrayList<String> argumentos = new ArrayList<>();
		for (int i = 0; i < nomesJogadores.size(); i++) {
			argumentos.add(nomesJogadores.get(i));
			
			if (i < pontuacoes.size()) {
				argumentos.add(pontuacoes.get(i).toString());
			} else {
				argumentos.add("0");
			}
		}
		
		return new Mensagem(Codigos.UPDATE_PONTOS, argumentos);
	}
	
	protected static Mensagem mensagemTerminarRodada() {
		return new Mensagem(Codigos.TERMINAR_RODADA, null);
	}

	protected Codigos getCodigo() {
		return codigo;
	}
	
	protected ArrayList<String> getArgumentos() {
		return argumentos;
	}
	
	public String toString() {
		String mensagemString = "";
		mensagemString += codigo.getCodigoNumero();
		
		if (argumentos != null) {
			for (String argumento : argumentos) {
				mensagemString += ";" + argumento;
			}
		}
		
		return mensagemString;
	}
	
	protected enum Codigos {
		DESCONHECIDO(0),
		APRESENTACAO(1),
		UPDATE_NOMES(2),
		COMECAR_JOGO(3),
		DICA(4),
		JOGADOR_DA_VEZ(5),
		CARTAS(6),
		CARTA_ESCOLHIDA_1(7),
		CARTA_ESCOLHIDA_2(8),
		COMECAR_PARTE_2(9),
		UPDATE_PONTOS(10),
		TERMINAR_RODADA(11);
		
		private int codigoNumero;
		
		private Codigos(int codigoNumero) {
			this.codigoNumero = codigoNumero;
		}
		
		public int getCodigoNumero() {
			return codigoNumero;
		}
		
	}

}
