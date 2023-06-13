package interfac;
import java.awt.event.ActionEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfac.panelAtualizar.atualizar;
import negocio.Cliente;
import negocio.ListaClientes;
import persistencia.Escrever;
import persistencia.LerDados;

public class panelDeletar extends JPanel{
	JTextField caixamatricula;
	
	public panelDeletar() {
		criarDeletar();
	}
	
	public void criarDeletar() {
		JLabel matricula  = new JLabel("Matricula");
		caixamatricula= new JTextField(6);
		
		Botao botaodeletar= new Botao("DELETAR");
		botaodeletar.addActionListener(new deletar());
		
		this.add(matricula);
		this.add(caixamatricula);
		this.add(botaodeletar);
	}
	
	private class deletar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String matricula= caixamatricula.getText();
			
			LerDados ler = new LerDados();
			ler.lerDados("dados/Dados.txt");
			
			ListaClientes lista = new ListaClientes();
			lista.setListaCliente(ler.lista);
			
			int cont=0;
			int index=0;
			for (Cliente cliente1 : lista.getListaClientes()) {
				if(cliente1.getMatricula() == Integer.parseInt(matricula)) {
					index= cont;	
				}
				cont++;
			}
			lista.getListaClientes().remove(index);

			Escrever escrever= new Escrever();
			escrever.escerverDados("dados/Dados.txt", lista.dadosCliente() );

			caixamatricula.setText("");
		}
		
	}
}
