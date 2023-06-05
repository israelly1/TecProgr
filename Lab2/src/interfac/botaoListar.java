package interfac;

import javax.swing.JButton;

public class botaoListar {
	
	public JButton criarbotaoListar(String nome) {
		JButton botao= new JButton(nome);
		botao.setText(nome);
		return botao;
		
	}

}
