package apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.Celula;
import negocio.Plano;

public class Evento_ProximaRodada implements ActionListener {
	
	private Plano plano;
	
	public Evento_ProximaRodada(Plano plano) {
		this.plano=plano;
	}
	
	public void limparPlano() {
		for (Celula celula : plano.getListaCelula()) {
			celula.setRobo(null);
			celula.setIcon(null);
			celula.getBotao().setIcon(null);
			celula.getBotao().setBackground(Color.WHITE);
		}
		plano.setRobo(null);
		plano.setCavalo(false);
		plano.setPeao(false);
		plano.setRei(false);
		plano.setVerificado(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		plano.setPartidas();
		if(plano.isVerificado()) {
			limparPlano();
		}else {
			String msg= "Clique no botão (verificar) primeiro!";
			plano.getPainelplano().mensagem(msg);
		}
	}
}
