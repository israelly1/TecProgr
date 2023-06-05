package interfac;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelAtualizar extends JPanel {
	JTextField matricula, vertente;
	botaoAtualizar botao;
	
	
public panelAtualizar() {
		super();
		this.matricula = new JTextField(10);
		this.vertente = new JTextField(12);
		this.botao= new botaoAtualizar();
	
	}



public JPanel criarAtualizar() {
	JPanel atualizar= new JPanel();
	atualizar.add(new JLabel("MATRÍCULA"));
	atualizar.add(matricula); 
	atualizar.add(new JLabel("VERTENTE"));
	atualizar.add(vertente); 
	atualizar.add(botao.criarbotaoAtualizar("ATUALIZAR"));
	
	
	return atualizar;
		
	}
}
	
