package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Plano;

public class JanelaPrincipal extends JFrame{
	
	private PainelEntrada Painelentrada;
	private PainelPlano Painelplano;
	private PainelRobos Painelrobos;

	public JanelaPrincipal() {
		Painelplano= new PainelPlano();
		Painelentrada= new PainelEntrada(Painelplano.getPlano());
		Painelrobos= new PainelRobos(Painelplano.getPlano());
		
		this.setSize(800, 600); 
		
		 this.add(Painelplano, BorderLayout.CENTER);
		 Painelplano.setLayout(new GridLayout(6,6));
		 Painelplano.setVisible(true);
		 Painelrobos.setVisible(true);
		 this.add(Painelrobos, BorderLayout.EAST);
		 this.add(Painelentrada, BorderLayout.NORTH);
		
		 
		 this.setTitle("PROVA 2- Israelly");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
	}
}
