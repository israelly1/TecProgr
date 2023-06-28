package apresentacao;

import javax.swing.JFrame;

public class JanelaRelatorio extends JFrame{

	private Painel_Relatorio PainelRelatorio;
	
	
	public JanelaRelatorio() {
		this.setSize(800,600);
		PainelRelatorio= new Painel_Relatorio();
		PainelRelatorio.setVisible(true);
		this.add(PainelRelatorio);
		this.setVisible(false);
	
	}
}
