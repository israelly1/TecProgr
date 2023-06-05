package negocio;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cliente {
	private String nome;
	
public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//	public Cliente(String nome) {
//		this.nome= nome;
//	}
	public String entradaDados(String msg) {
		String nome = JOptionPane.showInputDialog(msg);
		return nome;
	}

}
