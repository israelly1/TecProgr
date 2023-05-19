package negocio;

import java.util.Random;

import apresentacao.*;

public class Jogo {
	
	private Jogador jogador;
	private Tela tela;
	private Terminal terminal;
	private int numeroEscolhido;
	private boolean jogando;

	public Jogo() {
		tela = new Tela();
		terminal = new Terminal();
		jogador = new Jogador();
		jogando = true;
	}
	
	public void SortearNumero() {
		Random random= new Random();
		numeroEscolhido= random.nextInt(0,20);
	}

	public void inciarJogoTerminal() {
		jogador.setNome(terminal.entradaNome());
		terminal.mesagem("Seja bem vindo: " + jogador.getNome());
	}

	public void inciarJogoGUI() {
		jogador.setNome(tela.entradaDados("Qual � o seu nome?"));
		tela.mesagem("Seja bem vindo: " + jogador.getNome());
		jogadas();
	}

	public int solicitarNumero() {
		String numero = tela.entradaDados("Informe um numero:");
		return Integer.parseInt(numero);
	}

	public void jogadas() {
		do {
			verificarAcerto();
		} while (jogando);

		fimDoJogo();
	}

	private void fimDoJogo() {

		String numeros = "";
		for (Integer numero : jogador.getListaNumeros()) {
			numeros += " - " + numero;
		}
		tela.mesagem("Numeros apostados: " + numeros);

	}

	public boolean verificarMenor(int numero) {
		if (numero < numeroEscolhido)
			return true;

		return false;
	}

	public void verificarAcerto() {
		int numero = solicitarNumero();
		jogador.addNumero(numero);
		if (numero == numeroEscolhido) {
			tela.mesagem("Parabens voce acertou! numero de tentativas: " + jogador.getNumeroTentativa());
			jogando = false;
		} else {
			tela.mesagem("Voce errou!  numero de tentativas: "  + jogador.getNumeroTentativa());
			jogador.setNumeroTentativa();

			if (verificarMenor(numero)) {
				tela.mesagem("tente um numero maior");
			} else {
				tela.mesagem("Tente numero menor");
			}
		}
	}

	// public void verificarAcerto() {
	// do {
	// if (solicitarNumero() == numeroEscolhido) {
	// jogador.setNumeroTentativa();
	// tela.mesagem("Parabens voce acertou! numero de tentativas: " +
	// jogador.getNumeroTentativa());
	// return;
	// } else {
	// tela.mesagem("Deu ruim, voce errou");
	// jogador.setNumeroTentativa();
	// }
	// } while (true);
	// }
}
