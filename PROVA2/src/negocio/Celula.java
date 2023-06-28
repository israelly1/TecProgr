package negocio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Celula implements ActionListener{
	
	private Elemento bug, aluno;
	private JButton botao;
	int id;
	private Plano plano;
	private ImageIcon icon;
	private Robos robo;
	
	public Celula(int id, Plano plano) {
		this.id= id;
		this.plano= plano;
		botao= new JButton();
		botao.setBackground(Color.WHITE);
		botao.setIcon(icon);
		botao.addActionListener(this);
	}

	public Elemento getBug() {
		return bug;
	}

	public void setBug(Elemento bug) {
		this.bug = bug;
	}

	public Elemento getAluno() {
		return aluno;
	}

	public void setAluno(Elemento aluno) {
		this.aluno = aluno;
	}

	public JButton getBotao() {
		return botao;
	}

	public void setBotao(JButton botao) {
		this.botao = botao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public Robos getRobo() {
		return robo;
	}

	public void setRobo(Robos robo) {
		this.robo = robo;
	}
	
	public void actionPerformed(ActionEvent e) {		
		try {
			this.robo = plano.getRobo();
			this.icon = plano.getRobo().getIcon();
			this.botao.setIcon(icon);
			plano.setRobo(null);

		} catch (Exception e1) {
			String msg= "Selecione os robôs e coloque no plano!";
			plano.getPainelplano().mensagem(msg);
		}
		
		
	}

	

}
