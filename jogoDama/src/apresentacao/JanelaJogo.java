package apresentacao;

import javax.swing.JFrame;

public class JanelaJogo extends JFrame{

	private Tabuleiro tabuleiro;
	
	public JanelaJogo() {
		tabuleiro = new Tabuleiro();
		this.add(tabuleiro);
		this.setTitle("Jogo de Damas");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
