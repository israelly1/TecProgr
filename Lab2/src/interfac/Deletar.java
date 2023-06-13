package interfac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Deletar implements ActionListener {

	private Janela janela;
	
	public Deletar(Janela janela) {
	this.janela = janela;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		janela.cadastro.setVisible(false);
		janela.atualizar.setVisible(false);
		janela.deletar.setVisible(true);
		
	}
}
