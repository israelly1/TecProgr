package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Jogo;

public class PainelInicial extends JPanel {
	
	private static final long serialVersionUID = 2924967633417483192L;
	
	private JTextField caixaNome;
	
	public PainelInicial(String titulo) {
		this.setLayout(new BorderLayout());
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(Color.orange);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setBackground(Color.orange);
		
		JLabel NomeJogo = new JLabel(titulo);
		NomeJogo.setHorizontalAlignment(JLabel.CENTER);
		Font font = NomeJogo.getFont();
		Font novaFonte = font.deriveFont(font.getSize() + 20.0f);
		NomeJogo.setFont(novaFonte);
		
		JLabel nomeEquipe = new JLabel("Por Cize, Israelly e Samuel");
		
		panel1.add(NomeJogo);
		panel1.add(nomeEquipe);
	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(10,2));
		panel2.setBackground(Color.orange);
		JLabel nomeJogador= new JLabel("Nome:");
		caixaNome = new JTextField(10);
		
		JButton botaoCriar = new JButton("Criar server");
		botaoCriar.addActionListener(new AcaoCriarServer());
		JButton botaoEntrar= new JButton("Entrar server");
		botaoEntrar.addActionListener(new AcaoEntrarServer());
		JButton botaoRelatorio= new JButton("Mostrar Relatorio");
		botaoRelatorio.addActionListener(new AcaoMostrarRelatorio());
		panel2.add(nomeJogador);
		panel2.add(caixaNome);
		panel2.add(botaoCriar);
		panel2.add(botaoEntrar);
		panel2.add(botaoRelatorio);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
	}
	
	public JTextField getCaixaNome() {
		return caixaNome;
	}

	public void setCaixaNome(JTextField caixaNome) {
		this.caixaNome = caixaNome;
	}
	
	private boolean verificarCaixaTexto() {
		if (caixaNome.getText().isBlank()) {
			Apresentacao.getInstancia().getJanelaEntrada().aviso("Nome não pode ser vazio");
			return false;
		}
		
		return true;
	}
	
	private String getNomeJogador() {
		return caixaNome.getText();
	}
	
	private class AcaoCriarServer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (verificarCaixaTexto()) {
				Apresentacao.getInstancia().criarServer(getNomeJogador());
			}
		}
	}
	
	private class AcaoEntrarServer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (verificarCaixaTexto()) {
				String ipPorta = JOptionPane.showInputDialog("IP:");
				if (ipPorta != null) {
					Apresentacao.getInstancia().entrarServer(getNomeJogador(), ipPorta);
				}
			}
		}
	}
	
	private class AcaoMostrarRelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				Jogo.getInstance().instanciarRelatorio();
			}
		}
	
}
