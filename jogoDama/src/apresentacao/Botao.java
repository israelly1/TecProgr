package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao implements ActionListener{
	
	private ImageIcon icon;
	private Tabuleiro tabuleiro;
	private JButton botao;
	
	public Botao(JButton botao, Tabuleiro tabuleiro) {
		this.botao= botao;
		this.tabuleiro= tabuleiro;
	}
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.botao.getIcon()!= null) {
		//	tabuleiro.setIcon(this.botao.getIcon());
			this.botao.setIcon(null);
		}else if(tabuleiro.getIcon()!= null) {
			this.botao.setIcon(tabuleiro.getIcon());
		}
		
	}
	
}
