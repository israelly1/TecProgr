package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JanelaEntrada extends JFrame {
	
	private static final long serialVersionUID = 1108111219751195246L;
	
	private PainelInicial painelInicial;
	private PainelLobby painelLobby;

	public JanelaEntrada(String titulo) {
		painelInicial = new PainelInicial(titulo);
		painelInicial.setVisible(true);
		painelLobby = new PainelLobby();
		painelLobby.setVisible(false);
//		
//		painelInicial.setJanela(this);
//		painelInicial.setVisible(true);
//		painelInicial.getPainelIntermediario().setVisible(false);
		
		setLayout(new BorderLayout());
		add(painelInicial);
		
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	protected void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg);	
	}
	
	protected PainelInicial getPainelInicial() {
		return painelInicial;
	}
	
	protected PainelLobby getPainelLobby() {
		return painelLobby;
	}

	protected void mudarParaLobby(ArrayList<String> nomeJogadores, boolean host) {
		painelInicial.setVisible(false);
		painelLobby.setVisible(true);
		
		painelLobby.setNomes(nomeJogadores);
		painelLobby.setHost(host);
		
		add(painelLobby);
	}
	
}