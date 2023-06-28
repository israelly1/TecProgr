package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Jogador;
import negocio.ListaJogador;
import negocio.Plano;
import persistencia.Escrever;
import persistencia.LerDados;


public class PainelEntrada extends JPanel{
	
	private JTextField caixaNome;
	private JLabel nome, pontuacao, quantidadePartidas;
	private JButton start, relatorioJogo;
	private Plano plano;
	private JanelaRelatorio janelaRelatorio;

	public PainelEntrada(Plano plano) {
		this.plano= plano;
		janelaRelatorio= new JanelaRelatorio();
		start = new JButton("JOGAR");
		relatorioJogo= new JButton("RELATÓRIO DO JOGO");
		JLabel jogador= new JLabel("JOGADOR");
		caixaNome= new JTextField(10);
		this.add(jogador);
		this.add(caixaNome); 
		this.add(start);
		this.add(relatorioJogo);
		
		
		start.addActionListener(new dados());
		relatorioJogo.addActionListener(new EventoRelatorio());
	}

	private class dados implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String nome= caixaNome.getText();
			
			Jogador jogador = new Jogador(nome, plano.getPartidas(), plano.getPontuacaoTotal(),
			plano.getPontuacaoAluno(), plano.getPontuacaoBug(), plano.getListaRobos().get(0).getPontuacao(), 
			plano.getListaRobos().get(1).getPontuacao(),  plano.getListaRobos().get(2).getPontuacao());
					
			LerDados ler = new LerDados();
			ler.lerDados("dados/Dados.txt");
			
			ListaJogador lista = new ListaJogador();
			lista.setListaJogador(ler.getLista());
			lista.addJogador(jogador);

			Escrever escrever= new Escrever();
			escrever.escerverDados("dados/Dados.txt", lista.dadosJogador() );
			caixaNome.setText("");
		}
	
	}
}
