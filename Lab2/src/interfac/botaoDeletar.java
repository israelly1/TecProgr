package interfac;

import javax.swing.JButton;

public class botaoDeletar extends JButton {

	public JButton criarbotaoDeletar(String nome) {
		JButton botao= new JButton();
		botao.setText(nome);
		return botao;
	}
}
