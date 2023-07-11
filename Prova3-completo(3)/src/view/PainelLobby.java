package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelLobby extends JPanel {
	
	private static final long serialVersionUID = 183640773495015267L;
	
	private ArrayList<JLabel> labelsJogadores;
	private boolean host;
	private int numeroJogadores;
	
	public PainelLobby() {
		this.setLayout(new BorderLayout());

		JPanel painelJogadores = new JPanel();
		JPanel panel2 = new JPanel();
		
		painelJogadores.setLayout(new GridLayout(4, 1));
		painelJogadores.setBackground(Color.orange);
		
		labelsJogadores = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			JLabel labelNomeJogador = new JLabel();
			painelJogadores.add(labelNomeJogador);
			labelsJogadores.add(labelNomeJogador);
		}
		
		host = false;
		numeroJogadores = 0;
		
		JButton botaoIniciar = new JButton("INICIAR JOGO");
	    botaoIniciar.addActionListener(new AcaoComecarJogo());
	    botaoIniciar.setBackground(Color.orange);
	    panel2.add(botaoIniciar);

	    this.add(painelJogadores, BorderLayout.CENTER);
	    this.add(panel2, BorderLayout.SOUTH);
	    
	}
	
	protected void setNomes(ArrayList<String> nomesJogadores) {
		numeroJogadores = nomesJogadores.size();
		if (numeroJogadores > 4) {
			numeroJogadores = 4;
		}
		
		for (int i = 0; i < labelsJogadores.size() && i < nomesJogadores.size(); i++) {
			if (i == 0) {
				labelsJogadores.get(i).setText(nomesJogadores.get(i) + " (host)");
			} else {
				labelsJogadores.get(i).setText(nomesJogadores.get(i));
			}
		}
		
	}

	protected void setHost(boolean host) {
		this.host = host;
	}
	
	private class AcaoComecarJogo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (host) {
				if (numeroJogadores < 2) { // TODO é para ser 3, mas enquanto testo, preciso que seja 2
					Apresentacao.getInstancia().getJanelaEntrada().aviso(
							"Número de jogadores insuficientes para jogar");
				} else {
					
					Apresentacao.getInstancia().comecarJogo();
					
				}
			} else {
				Apresentacao.getInstancia().getJanelaEntrada().aviso(
						"Apenas o Host pode começar o jogo!");
			}
		}
	}
	
}
