package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta {
	
	private final static Color COR_SELECIONADO = new Color(0xff0000);
	private final static Color COR_DESSELECIONADO = new Color(0xffffff);
	
	private String nome;
	private JButton botao;
	
	private boolean selecionado;
	
	private boolean selecionavel;

	public Carta() {
		nome = "null";
		selecionavel = false;
		
		botao= new JButton();
		botao.setSize(new Dimension(20,40));
		botao.setBackground(COR_DESSELECIONADO);
		botao.addActionListener(new AcaoSelecionarCarta());
		
		selecionado= false;
	}
	
	public void mudarNome(String nome) {
		this.nome = nome;
		desselecionar();
		
		String diretorio = Apresentacao.getInstancia().getDiretorioCarta(nome);
		
		if (!diretorio.isBlank()) {
			ImageIcon icone = new ImageIcon(diretorio);
			icone = new ImageIcon(icone.getImage().getScaledInstance(100, 200, Image.SCALE_SMOOTH));
			botao.setIcon(icone);
			selecionavel = true;
		} else {
			botao.setIcon(null);
			selecionavel = false;
		}
		
	}

	public String getNome() {
		return nome;
	}

	public JButton getBotao() {
		return botao;
	}

	public boolean isSelecionado() {
		return selecionado;
	}
	
	public void selecionar() {
		selecionado = true;
		botao.setBackground(COR_SELECIONADO);
	}
	
	public void desselecionar() {
		selecionado = false;
		botao.setBackground(COR_DESSELECIONADO);
	}
	
	private class AcaoSelecionarCarta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (selecionavel) {
				Apresentacao.getInstancia().getPainelMesa().desselecionarCartas();
				selecionar();
			} 
		}
	}
}