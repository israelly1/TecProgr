package interfac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.ListaClientes;
import persistencia.Escrever;
import persistencia.LerDados;

public class panelAtualizar extends JPanel {
	
	JTextField caixamatricula, caixaVertente;
	
public panelAtualizar() {
		criarAtualizar();
	
	}

	public  void criarAtualizar() {
		JLabel matricula  = new JLabel("Matricula");
		caixamatricula= new JTextField(6);
		
		JLabel vertente  = new JLabel("Vertente");
		caixaVertente= new JTextField(6);
		
		Botao botaoatualizar= new Botao("ATUALIZAR");
		botaoatualizar.addActionListener(new atualizar());
		
		this.add(matricula);
		this.add(caixamatricula);
		this.add(vertente);
		this.add(caixaVertente);
		this.add(botaoatualizar);
		
	}
	
	public class atualizar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String matricula= caixamatricula.getText();
			String vertente= caixaVertente.getText();
			
			LerDados ler = new LerDados();
			ler.lerDados("dados/Dados.txt");
			
			ListaClientes lista = new ListaClientes();
			lista.setListaCliente(ler.lista);
			
			for (Cliente cliente1 : lista.getListaClientes()) {
				if(cliente1.getMatricula() == Integer.parseInt(matricula)) {
					cliente1.setVertente(vertente);
				}
			}

			Escrever escrever= new Escrever();
			escrever.escerverDados("dados/Dados.txt", lista.dadosCliente() );

			caixamatricula.setText("");
			caixaVertente.setText("");
			
		}
		
	}
}
	
