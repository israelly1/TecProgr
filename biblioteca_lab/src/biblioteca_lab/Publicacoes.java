package biblioteca_lab;

public class Publicacoes {
	
	private String titulo;
	private int AnoPublicacao;
	private String autor;
	private int QuantidadeDisponivel;
	
	public Publicacoes(String titulo, int anoPublicacao, String autor, int quantidadeDisponivel) {
		super();
		this.titulo = titulo;
		AnoPublicacao = anoPublicacao;
		this.autor = autor;
		QuantidadeDisponivel = quantidadeDisponivel;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnoPublicacao() {
		return AnoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		AnoPublicacao = anoPublicacao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getQuantidadeDisponivel() {
		return QuantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		QuantidadeDisponivel = quantidadeDisponivel;
	}
	
	

}
