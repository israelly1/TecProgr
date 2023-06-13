package interfac;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.ListaClientes;
import persistencia.Escrever;
import persistencia.LerDados;

public class panelCadastro extends JPanel {
	
	JTextField caixaNome, caixaCPF, caixamatricula, caixaVertente ;
	
	
	public panelCadastro() {
		criarCadastro();
	}
	
	public void criarCadastro(){
			JLabel nome  = new JLabel("Nome");
			caixaNome= new JTextField(6);
			
			JLabel cpf  = new JLabel("CPF");
			caixaCPF= new JTextField(6);
			
			JLabel matricula  = new JLabel("Matricula");
			caixamatricula= new JTextField(6);
			
			JLabel vertente  = new JLabel("Vertente");
			caixaVertente= new JTextField(6);
			
			Botao botaocadastrar= new Botao("CADASTRAR");
			botaocadastrar.addActionListener(new dados() );
			
			this.setLayout(new GridLayout(5,2));
			
			this.add(nome);
			this.add(caixaNome);
			this.add(cpf);
			this.add(caixaCPF);
			this.add(matricula);
			this.add(caixamatricula);
			this.add(vertente);
			this.add(caixaVertente);
			this.add(botaocadastrar);	
			
	}
	
	private class dados implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String nome= caixaNome.getText();
			String cpf= caixaCPF.getText();
			String matricula= caixamatricula.getText();
			String vertente= caixaVertente.getText();
			
			Cliente cliente= new Cliente(nome, cpf, Integer.parseInt(matricula), vertente);
			
			LerDados ler = new LerDados();
			ler.lerDados("dados/Dados.txt");
			
			ListaClientes lista = new ListaClientes();
			lista.setListaCliente(ler.lista);
			lista.addCliente(cliente);

			Escrever escrever= new Escrever();
			escrever.escerverDados("dados/Dados.txt", lista.dadosCliente() );

			caixaNome.setText("");
			caixaCPF.setText("");
			caixamatricula.setText("");
			caixaVertente.setText("");
			
		}
		
	}
}
