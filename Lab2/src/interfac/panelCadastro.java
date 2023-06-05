package interfac;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelCadastro extends JPanel {
	JTextField nome, cpf, matricula, vertente;
	botaoCadastro botao;
	
	public panelCadastro() {
		super();
		this.nome= new JTextField(10);
		this.cpf= new JTextField(10);
		this.matricula= new JTextField(10);
		this.vertente= new JTextField(10);
		this.botao= new botaoCadastro();
	}
	
	public JPanel criarCadastro(){
		JPanel cadastro= new JPanel();
		cadastro.setVisible(true);
		cadastro.setLayout(new GridBagLayout());
		GridBagConstraints gride= new GridBagConstraints();
		gride.gridx= 0;
		gride.gridy=0;
		cadastro.add(new JLabel("USUÁRIO"),gride);
		this.nome= new JTextField(10);
		gride.gridx=1;
		gride.gridy=0;
		cadastro.add(nome,gride);
		gride.gridx=0;
		gride.gridy=1;
		cadastro.add(new JLabel("CPF"),gride);
		gride.gridx=1;
		gride.gridy=1;
		cadastro.add(cpf,gride);
		gride.gridx=0;
		gride.gridy=2;
		cadastro.add(new JLabel("MATRÍCULA"),gride);
		gride.gridx=1;
		gride.gridy=2;
		cadastro.add(matricula,gride);
		gride.gridx=0;
		gride.gridy=3;
		cadastro.add(new JLabel("VERTENTE"),gride);
		gride.gridx=1;
		gride.gridy=3;
		cadastro.add(vertente,gride);
		gride.gridx=1;
		gride.gridy=4;
		cadastro.add(botao.criarbotaoCadastro("CADASTRAR"),gride);
		
		return cadastro;
		
	}

	
}
