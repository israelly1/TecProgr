package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventoSelecionar implements ActionListener {
	private JanelaPrincipal janelaJogadas;
	
	public EventoSelecionar(JanelaPrincipal janelaJogadas) {
		this.janelaJogadas= janelaJogadas;
	}

	public void actionPerformed(ActionEvent e) {
		String dica = janelaJogadas.getCaixaDica().getText();
		
		if (janelaJogadas.isJogadorVez()) {
			if (!dica.isBlank() && janelaJogadas.isCartaSelecionada()) {
				// enviar carta para o controle
			} else if(!janelaJogadas.isCartaSelecionada() && !dica.isBlank() ){
				String msg= "Selecione uma carta";
				JOptionPane.showMessageDialog(null, msg);	
			}else if(janelaJogadas.isCartaSelecionada() && dica.isBlank()) {
				String msg= "Escreva uma dica";
				JOptionPane.showMessageDialog(null, msg);
			}else {
				String msg= "Escolha uma carta e escreva uma dica";
				JOptionPane.showMessageDialog(null, msg);
			}
			
		} else {
			if (janelaJogadas.isCartaSelecionada() && !dica.isBlank()) {
				// enviar carta para o controle
			}
			else if (janelaJogadas.isCartaSelecionada() && dica.isBlank()){
				String msg= "Aguarde a dica";
				JOptionPane.showMessageDialog(null, msg);
			}else {
				String msg= "Aguarde a dica e selecione uma carta";
				JOptionPane.showMessageDialog(null, msg);
			}
		}
	}
}