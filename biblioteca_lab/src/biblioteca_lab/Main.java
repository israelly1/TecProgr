package biblioteca_lab;

public class Main {

	public static void main(String[] args) {
		
		Livro livro1= new Livro("Biblia KJ",1662, "Deus", 200);
		Livro livro2= new Livro("O peregrino",1900, "John Buyan", 100);
		Livro livro3= new Livro("As crônicas de Nárnia",2003, "CS Lewis", 90);
		Revista revista1= new Revista("Meio ambiente", 2014, "Leonardo Calvalcante", 30);
		Revista revista2= new Revista("Moda", 2023, "Julia Pimentel", 24);
		Revista revista3= new Revista("Machine Learning", 2022, "Pedro Gurgel", 20);
		TCC tcc1= new TCC("TCC 1", 2023,"Julio Aguiar", 34);
		TCC tcc2= new TCC("TCC 2", 2023,"Fernanda Victor", 38);
		
		
		Biblioteca biblioteca= new Biblioteca();
		biblioteca.AdicionarLivro(livro1);
		biblioteca.AdicionarLivro(livro2);
		biblioteca.AdicionarLivro(livro3);
		
		biblioteca.AdicionarRevista(revista1);
		biblioteca.AdicionarRevista(revista2);
		biblioteca.AdicionarRevista(revista3);
		
		biblioteca.AdicionarTCC(tcc1);
		biblioteca.AdicionarTCC(tcc2);
		
		
		Aluno aluno= new Aluno(510147, "Maria", biblioteca);
		Professor professor= new Professor(54389, "João", biblioteca);
		Servidor servidor = new Servidor(78453, "Junior", biblioteca);
		
		aluno.FazerEmprestimo(livro2);
		professor.FazerEmprestimo(tcc2);
		servidor.FazerEmprestimo(revista2);
		
		biblioteca.Acervo();
	
		
		
		
	}

}
