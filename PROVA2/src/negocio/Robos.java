package negocio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Robos extends JButton implements ActionListener{

	private ImageIcon icon;
	private JButton botao;
	private Plano plano;
	private int pontuacao;
	private String nome;
	
	public Robos(String caminho ,String nome, Plano plano) {
		this.plano= plano;
		this.nome= nome;
		this.pontuacao= 0;
		botao= new JButton(nome);
		icon= new ImageIcon(caminho);
		botao.setIcon(icon);
		botao.setBackground(Color.WHITE);
		botao.addActionListener(this);	
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}
	
	public JButton getBotao() {
		return botao;
	}

	public void setBotao(JButton botao) {
		this.botao = botao;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean verificarRobos(String nome) {
		for (Celula celula : plano.getListaCelula()) {
			if(celula.getRobo()!=null && celula.getRobo().getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public void setbooleanRobo(String nome) {
		if(this.nome.equals("Peao")) {
			plano.setPeao(true);
		}else if (this.nome.equals("Rei")){
			plano.setRei(true);
		}else if(this.nome.equals("Cavalo")) {
			plano.setCavalo(true);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(verificarRobos(this.nome)== false) {
			plano.setRobo(this);
			setbooleanRobo(this.nome);
		}else {
			String msg= "Esse robô já existe no plano!";
			plano.getPainelplano().mensagem(msg);
		}	
	}
}
