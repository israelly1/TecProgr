package biblioteca_lab;

import java.util.ArrayList;

public abstract class Cliente implements IEmprestimo {
	private int matricula;
	private String nome;
	public float tps;
	public Biblioteca biblioteca;
	public int doacoes=0;
	public ArrayList<Publicacoes> ListaPublicacoes = new ArrayList<Publicacoes>();
	
	public Cliente(int matricula, String nome, Biblioteca biblioteca) {
		this.matricula= matricula;
		this.nome= nome;
		this.biblioteca= biblioteca;
		float tps= 0;
		biblioteca.ListaClientes.add(this);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
