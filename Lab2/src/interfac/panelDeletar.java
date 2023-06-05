package interfac;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelDeletar extends JPanel{
	JTextField matricula;
	botaoDeletar botao;
	
	public panelDeletar() {
		this.matricula= new JTextField(10);
		this.botao= new botaoDeletar();
		
	}
	
	public JPanel deletar() {
		JPanel deletar= new JPanel();
		deletar.add(new JLabel("MATRÍCULA"));
		deletar.add(matricula);
		deletar.add(botao.criarbotaoDeletar("DELETAR"));
		return deletar; 
		
		
}
}
