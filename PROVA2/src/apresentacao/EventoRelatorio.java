package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EventoRelatorio implements ActionListener {

	private JanelaRelatorio janelaRelatorio;
	
	public EventoRelatorio() {
	}

	public void actionPerformed(ActionEvent e) {
		janelaRelatorio = new JanelaRelatorio();
		janelaRelatorio.setVisible(true);
	}
}
