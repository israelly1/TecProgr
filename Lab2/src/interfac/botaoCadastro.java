package interfac;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class botaoCadastro implements ActionListener{
	panelCadastro painelcadastro;
	panelCadastro cadastro; 
	
	public JButton criarbotaoCadastro(String nome) {
		JButton botao= new JButton();
		botao.setText(nome);
		this.painelcadastro= cadastro;
		
		return botao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("entrou");
		
	}
	public panelCadastro getPanel(){
		return this.painelcadastro;
	}
}
