package apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import negocio.Celula;
import negocio.Plano;

public class Evento_Verificar implements ActionListener {
	private Plano plano;

	public Evento_Verificar(Plano plano) {
		this.plano= plano;
	}

	public boolean verificarPlano() {
		if(plano.isPeao()== true && plano.isRei()== true && plano.isCavalo()==true) {
			return true;
		}
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		if(verificarPlano()) {
			for (Celula celula : plano.getListaCelula()) {
				if(celula.getIcon()!= null && celula.getBug() != null) {
					celula.getRobo().setPontuacao(-15);
					plano.setPontuacaoBug();
					celula.getBotao().setBackground(Color.RED);
					
				}else if(celula.getIcon()!= null && celula.getAluno()!= null) {
					celula.getRobo().setPontuacao(10);
					plano.setPontuacaoAluno();
					celula.getBotao().setBackground(Color.GREEN);
				}
			}
			plano.setVerificado(true);
			String msg= "Verificado!";
			plano.getPainelplano().mensagem(msg);
			plano.getPainelRobo().getPontRei().setText(Integer.toString(plano.getListaRobos().get(0).getPontuacao()));
			plano.getPainelRobo().getPontPeao().setText(Integer.toString(plano.getListaRobos().get(1).getPontuacao()));
			plano.getPainelRobo().getPontCavalo().setText(Integer.toString(plano.getListaRobos().get(2).getPontuacao()));
			plano.getPainelRobo().getPontAluno().setText(Integer.toString(plano.getPontuacaoAluno()));
			plano.getPainelRobo().getPontBug().setText(Integer.toString(plano.getPontuacaoBug()));
			
		}else {
			String msg= "Selecione todos os robôs para verificar!";
			plano.getPainelplano().mensagem(msg);
		}
	}
}