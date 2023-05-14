package contato;

public class Contato {
	
	public int codigo;
	public String nome;
	protected String email;
	public int telefone;
	public String observacao;

	public void Contato1(int codigo) {
		if(codigo>=1000 && codigo<9999) {
			this.codigo=codigo;
		}else {
			System.out.println("Código inválido");
		}
	}
	public void Contato2(int codigo, String nome) {
		if(codigo>=1000 && codigo<9999) {
			this.codigo=codigo;
		}else {
			System.out.println("Código inválido");
		}
		this.nome=nome;
	}
	public void Contato3(int codigo, String nome, String email) {
		if(codigo>=1000 && codigo<9999) {
			this.codigo=codigo;
		}else {
			System.out.println("Código inválido");
		}
		this.nome=nome;
		this.email=email;
	}
	public void Contato4(int telefone, String observacao) {
		String t = Integer.toString(telefone);
		if(t.length()==7) {
			this.telefone=telefone;
		}else {
			System.out.println("Número de telefone inválido");
		}
		this.observacao= observacao;
	}
	
	public void ImprimirDados() {
		System.out.println(codigo+"\n"+ nome+"\n"+ email+"\n"+telefone+"\n"+observacao );
	}
	
	public Contato ClonarContato(int codigo, String nome, String email, int telefone, String obseravacao) {
		 Contato contato2= new Contato();
		 contato2.Contato3(codigo, nome, email);
		 contato2.Contato4(telefone, obseravacao);
		 
		 return contato2;
	}
}

