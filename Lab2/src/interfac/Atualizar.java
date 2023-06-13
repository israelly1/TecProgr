package interfac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Atualizar implements ActionListener {
	Janela janela;
	public Atualizar(Janela janela) {
		this.janela= janela;
	}

	public void actionPerformed(ActionEvent e) {
		janela.cadastro.setVisible(false);
		janela.atualizar.setVisible(true);
		janela.deletar.setVisible(false);
		
	}
}
