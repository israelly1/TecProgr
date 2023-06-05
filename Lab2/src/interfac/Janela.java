package interfac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import negocio.Cliente;


public class Janela extends JFrame implements ActionListener{
	JPanel panelvazio;
	JLabel texto;
	JTextField nome;
	Cliente cliente;
	panelMenu menu;
	panelCadastro cadastro;
	
	public Janela() {
		menu = new panelMenu(this);
		this.setSize(700, 700);
		this.setTitle(getTitle());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panelvazio= new JPanel();
		this.cliente= new Cliente();
		panelMenu menu= new panelMenu(this);
		panelCadastro cadastro= new panelCadastro();
		panelAtualizar atualizar= new panelAtualizar();
		panelListar listar= new panelListar();
		panelDeletar deletar= new panelDeletar();
	//	cadastro = menu.getPanel();
		this.setLayout(new BorderLayout());
		this.add(menu.criarMenu(), BorderLayout.NORTH);
		this.add(cadastro.criarCadastro(), BorderLayout.CENTER);
//		this.add(atualizar.criarAtualizar(), BorderLayout.CENTER);
//		this.add(deletar.deletar(), BorderLayout.CENTER);
//		this.add(panelvazio, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	

//		panel1.add(criarBotao(Color.DARK_GRAY, "salvar"), gride);
//		
//		return panel1;
//		
//	}
	
	public JButton criarBotao(Color c, String nome) {
		JButton b= new JButton(nome);
		b.setPreferredSize(new Dimension(70,40));
		b.addActionListener(this);
		b.setBackground(c);
		return b;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		cliente.setNome(nome.getText());
		
	}
	public panelCadastro getCadastro()
	{
		return this.cadastro;
	}

}
