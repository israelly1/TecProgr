package interfac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class panelMenu extends JPanel implements ActionListener {
	private panelCadastro cadastro;
	private botaoCadastro botaoCadastro;
	
	public panelMenu(Janela janela) {
		botaoCadastro = new botaoCadastro();
		cadastro = botaoCadastro.getPanel();
		
		
	}
	
	public JPanel criarMenu(){
		
		JPanel menu = new JPanel();
		menu.setVisible(true);
		
		botaoCadastro bc= new botaoCadastro();
		menu.add(bc.criarbotaoCadastro("CADASTRAR"));
		botaoListar bl = new botaoListar();
		menu.add(bl.criarbotaoListar("LISTAR"));
		botaoDeletar bd = new botaoDeletar();
		botaoAtualizar ba = new botaoAtualizar();
		menu.add(ba.criarbotaoAtualizar("ATUALIZAR"));
		menu.add(bd.criarbotaoDeletar("DELETAR"));
		
		return menu;
	}
	
	public JButton criarBotao(Color c, String nome) {
		JButton b= new JButton(nome);
		b.setPreferredSize(new Dimension(70,40));
		b.addActionListener((ActionListener) this);
		b.setBackground(c);
		return b;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public panelCadastro getPanel() {
		return cadastro;
	}
	
}
