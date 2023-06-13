package interfac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import negocio.Cliente;


public class Janela extends JFrame{
	JPanel panelvazio;
	JLabel texto;
	JTextField nome;
	Cliente cliente;
	panelMenu menu;
	panelCadastro cadastro;
	panelAtualizar atualizar;
	panelDeletar deletar;
	
	public Janela() {
		menu = new panelMenu(this);
		this.setSize(700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panelvazio= new JPanel();
	//	this.cliente= new Cliente();
		
		
		menu= new panelMenu(this);
		cadastro= new panelCadastro();
		atualizar= new panelAtualizar();
		deletar= new panelDeletar();
		
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);
	
		cadastro.setVisible(false);
		atualizar.setVisible(false);
		deletar.setVisible(false);
		JPanel panelvazio = new JPanel();
		panelvazio.add(cadastro);
		panelvazio.add(atualizar);
		panelvazio.add(deletar);
		

		this.add(panelvazio, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

}
