package apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Plano;
import negocio.Robos;

 public class PainelRobos extends JPanel{
	private JPanel panel1= new JPanel();
	private JPanel panel3= new JPanel();
	private JPanel panel4= new JPanel();
	private JPanel panel5= new JPanel();
	private JLabel pontRei, pontPeao, pontCavalo, pontAluno, pontBug;
	private Plano plano;
	 
	private JButton verificar= new JButton("VERIFICAR");
	private JButton proximaRodada= new JButton("PRÓXIMA RODADA");
	private JButton sairJogo= new JButton("SAIR DO JOGO");
	
	public PainelRobos(Plano plano) {
		this.plano=plano;
		this.plano.setPainelRobo(this);
		Robos rei= new Robos("coroa.png", "Rei", plano);
		Robos peao= new Robos("peao.png", "Peao", plano);
		Robos cavalo= new Robos("cavalo.png", "Cavalo", plano);
		this.plano.getListaRobos().add(rei);
		this.plano.getListaRobos().add(peao);
		this.plano.getListaRobos().add(cavalo);
		
		this.setLayout(new GridLayout(5,2));
		panel1.add(rei.getBotao());
		panel1.add(peao.getBotao());
		panel1.add(cavalo.getBotao());
		panel1.setBackground(Color.WHITE);

		ImageIcon iconRei= new ImageIcon("coroa.png");
		ImageIcon iconPeao= new ImageIcon("peao.png");
		ImageIcon iconCavalo= new ImageIcon("cavalo.png");
		JLabel rei_ = new JLabel(iconRei);
		JLabel peao_ = new JLabel(iconPeao);
		JLabel cavalo_ = new JLabel(iconCavalo);
		pontRei= new JLabel(Integer.toString(plano.getListaRobos().get(0).getPontuacao()));
		pontPeao= new JLabel(Integer.toString(plano.getListaRobos().get(1).getPontuacao()));
		pontCavalo= new JLabel(Integer.toString(plano.getListaRobos().get(2).getPontuacao()));

		panel3.add(rei_);
		panel3.add(pontRei);
		panel3.add(peao_);
		panel3.add(pontPeao);
		panel3.add(cavalo_);
		panel3.add(pontCavalo);
		panel3.setBackground(Color.WHITE);
		
		panel3.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
		
		verificar.setBackground(Color.CYAN);
		verificar.addActionListener(new Evento_Verificar(plano));
		
		proximaRodada.setBackground(Color.CYAN);
		proximaRodada.addActionListener(new Evento_ProximaRodada(plano));
		
		sairJogo.setBackground(Color.CYAN);
		sairJogo.addActionListener(new EventoSair());

		panel4.setLayout(new GridLayout(5,2));
		panel4.add(verificar);
		panel4.add(proximaRodada);
		panel4.add(sairJogo);
		
		panel5.setLayout(new GridLayout(1,5));
		JLabel total= new JLabel("TOTAL:");
		panel5.add(total);
		ImageIcon iconAluno= new ImageIcon("alunos.png");
		JLabel aluno = new JLabel(iconAluno);
		panel5.add(aluno);
		pontAluno= new JLabel(Integer.toString(plano.getPontuacaoAluno()));
		panel5.add(pontAluno);
		ImageIcon iconBug= new ImageIcon("erro.png");
		JLabel bug = new JLabel(iconBug);
		pontBug= new JLabel(Integer.toString(plano.getPontuacaoBug()));
		panel5.add(bug);
		panel5.add(pontBug);
		panel5.setBackground(Color.WHITE);
		
		this.add(panel1);
		this.add(panel5);
		this.add(panel3);
		this.add(panel4);
		
		this.setVisible(true);
	}

	public JLabel getPontRei() {
		return pontRei;
	}

	public void setPontRei(JLabel pontRei) {
		this.pontRei = pontRei;
	}

	public JLabel getPontPeao() {
		return pontPeao;
	}

	public void setPontPeao(JLabel pontPeao) {
		this.pontPeao = pontPeao;
	}

	public JLabel getPontCavalo() {
		return pontCavalo;
	}

	public void setPontCavalo(JLabel pontCavalo) {
		this.pontCavalo = pontCavalo;
	}

	public JLabel getPontAluno() {
		return pontAluno;
	}

	public void setPontAluno(JLabel pontAluno) {
		this.pontAluno = pontAluno;
	}

	public JLabel getPontBug() {
		return pontBug;
	}

	public void setPontBug(JLabel pontBug) {
		this.pontBug = pontBug;
	}
	
}
