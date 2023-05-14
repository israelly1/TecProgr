package empregado;

public class Main {

	public static void main(String[] args) {
		Empregado empregado= new Empregado("Maria", 1500);
		Gerente gerente= new Gerente("Jose", 2000, "projetos");
		Vendedor vendedor= new Vendedor("Luiza", 2000, 0.20);
	}

}
