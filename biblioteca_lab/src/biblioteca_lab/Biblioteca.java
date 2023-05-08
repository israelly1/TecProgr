package biblioteca_lab;

import java.util.ArrayList;

public class Biblioteca {

	public ArrayList<Livro>ListaLivros= new ArrayList<Livro>();
	public ArrayList<Revista>ListaRevista= new ArrayList<Revista>();
	public ArrayList<TCC>ListaTCC= new ArrayList<TCC>();
	public ArrayList<Cliente>ListaClientes= new ArrayList<Cliente>();
	
	public void Acervo() {
		System.out.println("Livros:");
		for(int i=0;i<ListaLivros.size();i++) {
			System.out.println(i+"-"+ListaLivros.get(i).getTitulo()+"\n"+ ListaLivros.get(i).getAnoPublicacao()+ "\n"+ListaLivros.get(i).getAutor()+"\n"+ListaLivros.get(i).getQuantidadeDisponivel());
		}
		System.out.println("Revistas:");
		for(int i=0;i<ListaRevista.size();i++) {
			System.out.println(i+"-"+ListaRevista.get(i).getTitulo()+"\n"+ ListaRevista.get(i).getAnoPublicacao()+ "\n"+ListaRevista.get(i).getAutor()+"\n"+ListaRevista.get(i).getQuantidadeDisponivel());
		}
		System.out.println("TCC:");
		for(int i=0;i<ListaTCC.size();i++) {
			System.out.println(i+"-"+ListaTCC.get(i).getTitulo()+"\n"+ ListaTCC.get(i).getAnoPublicacao()+ "\n"+ListaTCC.get(i).getAutor()+"\n"+ListaTCC.get(i).getQuantidadeDisponivel());
		}
	}
	
	public void AdicionarLivro(Livro livro) {
		ListaLivros.add(livro);
	}
	public void AdicionarRevista(Revista revista) {
		ListaRevista.add(revista);
	}
	public void AdicionarTCC(TCC TCC) {
		ListaTCC.add(TCC);
	}
	
	
}
