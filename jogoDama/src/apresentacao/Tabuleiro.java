package apresentacao;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel{
	
	private Botao botao;
	private ImageIcon icon;

	public Tabuleiro() {
		this.setLayout(new GridLayout(8,8));
		montarTabuleiro();
	}
	
	public void montarTabuleiro() {
		boolean preta= true;
		boolean branca= false;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				JButton botao= new JButton();
				
				botao.addActionListener(new Botao(botao, this));
				
				if(preta==true) {
					botao.setBackground(Color.black);
					preta= false;
					branca= true;
					if(i==0 || i==1) {
						icon= new ImageIcon("bola-de-criquete.png");
						botao.setIcon(icon);
					}else {
						if(i==5 || i==6) {
							icon= new ImageIcon("bola (1).png");
							botao.setIcon(icon);
						}
					}
					this.add(botao);
				}else {
					botao.setBackground(Color.white);
					preta= true;
					branca= false;
					this.add(botao);
				}
			}
		}
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
