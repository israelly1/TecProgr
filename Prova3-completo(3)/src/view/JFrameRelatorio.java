package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class JFrameRelatorio extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modeloJTable;
	private JTable jt;
	
	public JFrameRelatorio(String[][] matrizDeDados) {
		
	
		this.setSize(1300,550);
		this.setResizable(false);
		this.setTitle("Relatorio das Rodadas");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.ORANGE);
		
		Font fontePadrao = new Font("SansSerif", Font.BOLD, 14);
		
		modeloJTable = new DefaultTableModel();
		
	 	modeloJTable.addColumn("ID");
	 	modeloJTable.addColumn("Dica");
	 	
	 	modeloJTable.addColumn("Jogador Da Vez");
	 	modeloJTable.addColumn("Carta Da Vez");
	 	modeloJTable.addColumn("Pontos Jog. Da Vez");
	 	
	 	modeloJTable.addColumn("Segundo Jogador");
	 	modeloJTable.addColumn("Carta Jog. 2");
	 	modeloJTable.addColumn("Pontos Jog. 2");
	 	
	 	modeloJTable.addColumn("Terceiro Jogador");
	 	modeloJTable.addColumn("Carta Jog. 3");
	 	modeloJTable.addColumn("Pontos Jog. 3");
	 	
	 	modeloJTable.addColumn("Quarto Jogador");
	 	modeloJTable.addColumn("Carta Jog. 4");
	 	modeloJTable.addColumn("Pontos Jog. 4");
	 	
	 	//cada posicao de matrizDeDados representa todos os dados salvos de uma rodada
	 	for (String rodada[] : matrizDeDados) {
			modeloJTable.addRow(rodada);
		}
	 	
		jt = new JTable(modeloJTable);
		
		jt.setBackground(Color.ORANGE.darker());
		jt.setFont(fontePadrao);
		
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBackground(Color.ORANGE);
		this.add(jsp);
		
		
		this.setVisible(true);
	}
	
}
