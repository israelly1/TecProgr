package apresentacao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.Botao;
import negocio.Plano;

public class PainelPlano extends JPanel{
	private Plano plano;

	public PainelPlano (){
		plano = new Plano(this); 

	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public void mensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);	
	}
}
