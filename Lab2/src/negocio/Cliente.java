package negocio;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cliente {
	private String nome;
	private String cpf;
	private int matricula;
	private String vertente;
	
	
	public Cliente(String nome, String cpf, int matricula, String vertente) {
		this.nome= nome;
		this.cpf= cpf;
		this.matricula= matricula;
		this.vertente= vertente;
	}
	
public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getVertente() {
		return vertente;
	}

	public void setVertente(String vertente) {
		this.vertente = vertente;
	}

	public String entradaDados(String msg) {
		String nome = JOptionPane.showInputDialog(msg);
		return nome;
		
	}

}
