package interfac;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cadastro implements ActionListener{
	private Janela janela;
	
	
	public Cadastro(Janela janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		janela.cadastro.setVisible(true);
		janela.atualizar.setVisible(false);
		janela.deletar.setVisible(false);
		
	}
	
}
