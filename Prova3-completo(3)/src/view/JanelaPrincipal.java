package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = -7233345486380187015L;
	
	private JTextField caixaDica;
	private JButton botaoSelecionar;
	private JPanel panel1, panelLateral, panelPlacar;
	private PainelMesa painelMesa;
	private boolean isJogadorVez;
	private ArrayList<JLabel> labelsJogadores;
	private boolean esperar;
	private boolean parte2;
	
//	private PainelInicial painelEntrada;

	public JanelaPrincipal() {
		esperar = true;
		parte2 = false;
		
		this.setSize(new Dimension(600,600));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setTitle(this.title);
		this.setLayout(new BorderLayout());
		
		panel1= new JPanel();
		panelLateral= new JPanel();
		painelMesa= new PainelMesa();
		panelPlacar= new JPanel();
		
		isJogadorVez = false;
		caixaDica= new JTextField(40);
		caixaDica.setEnabled(false);
		botaoSelecionar= new JButton("SELECIONAR");
		botaoSelecionar.setPreferredSize(new Dimension(150,30));
		botaoSelecionar.addActionListener(new AcaoSelecionar());
		
		panel1.setBackground(Color.orange);
		panel1.add(caixaDica);
		
		panelLateral.setLayout(new BorderLayout());
		panelLateral.setBackground(Color.orange);
		
		panelLateral.add(panelPlacar, BorderLayout.CENTER);
		panelLateral.add(botaoSelecionar, BorderLayout.SOUTH);
		
		panelPlacar.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		
		panelPlacar.setLayout(new BoxLayout(panelPlacar,  BoxLayout.Y_AXIS));
		
		labelsJogadores = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			JLabel labelnome = new JLabel();
			labelsJogadores.add(labelnome);
			panelPlacar.add(labelnome);
		}
		
		panelPlacar.setBackground(Color.orange);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(painelMesa, BorderLayout.CENTER);
		this.add(panelLateral, BorderLayout.EAST);
		this.setVisible(false);
	}
	
	public void resetarTudo() {
		caixaDica.setText("");
		caixaDica.setEnabled(false);
		esperar = true;
		isJogadorVez = false;
		setTitle("");
		
		painelMesa.resetarCartas();
	}
	
	public void setJogadorVez(boolean isJogadorVez) {
		this.isJogadorVez = isJogadorVez;
		caixaDica.setEnabled(isJogadorVez);
	}
	
	public void setParte2(boolean parte2) {
		this.parte2 = parte2;
	}
	
	public void setEsperar(boolean esperar) {
		this.esperar = esperar;
	}
	
	protected void atualizarJogadores(ArrayList<String> nomesJogadores) {
		
		for (int i = 0; i < labelsJogadores.size() && i < nomesJogadores.size(); i++) {
			labelsJogadores.get(i).setText(nomesJogadores.get(i) + " - 0");
		}
		
	}
	
	protected void atualizarJogadores(
			ArrayList<String> nomesJogadores, ArrayList<Integer> pontosJogadores) {
		
		if (nomesJogadores.size() == pontosJogadores.size()) {
			for (int i = 0; i < labelsJogadores.size() && i < nomesJogadores.size(); i++) {
				labelsJogadores.get(i).setText(nomesJogadores.get(i) + " - " + pontosJogadores.get(i));
			}
		}
		
	}
	
	public boolean isJogadorVez() {
		return isJogadorVez;
	}
	
	public JTextField getCaixaDica() {
		return caixaDica;
	}
	
	public void caixaDicaSetEnable(boolean enable) {
		caixaDica.setEnabled(enable);
	}
	
	public void setCaixaDica(String texto) {
		caixaDica.setText(texto);
	}
	
	public PainelMesa getPainelMesa() {
		return painelMesa;
	}
	
	public boolean isCartaSelecionada() {
		return painelMesa.isCartaSelecionada();
	}
	
	public String getCartaSelecionada() {
		return painelMesa.getCartaEscolhida().getNome();
	}

	public void setPainelMesa(PainelMesa painelMesa) {
		this.painelMesa = painelMesa;
	}

	public void setPainelEntrada(PainelInicial painelEntrada) {
//		this.painelEntrada = painelEntrada;
	}
	
	public void PercorrerJogadores() {
//		for (Jogadores jogadores : painelEntrada.getPainelIntermediario().getListaJogadores()) {
//			String nome= jogadores.getNome() + "    " +  Integer.toString(jogadores.getPontuacao());
//			JLabel jogador = new JLabel(nome);
//			panelPlacar.add(jogador);
//		}
	}
	
	public void aviso(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);		
	}

	private class AcaoSelecionar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!esperar) {
				if (isJogadorVez) {
					if (!caixaDica.getText().isBlank()) {
						if (isCartaSelecionada()) {
							String dica = caixaDica.getText();
							String carta = getCartaSelecionada();
							
							Apresentacao.getInstancia().mandarCartaEDica(carta, dica);
						} else {
							aviso("Selecione uma carta");
						}
					} else {
						aviso("Escreva uma dica");
					}
				} else {
					if (isCartaSelecionada()) {
						String carta = getCartaSelecionada();
						if (parte2) {
							Apresentacao.getInstancia().mandarCartaPart2(carta);
						} else {
							Apresentacao.getInstancia().mandarCartaPart1(carta);
						}
						
					} else {
						aviso("Selecione uma carta");
					}
				}
			} else {
				aviso("Espere os outros jogadores");
			}
			
		}
	}
}
	