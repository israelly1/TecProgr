package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSair implements ActionListener {
	
	public EventoSair() {
		
	}

	public void actionPerformed(ActionEvent e) {
		 System.exit(0);
	}
}
