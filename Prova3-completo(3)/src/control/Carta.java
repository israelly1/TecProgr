package control;

/**
 * Representa as cartas do jogo
 * 
 * @author Samuel
 */
public class Carta {
	
	/**
	 * nome da carta
	 */
	private String nome;
	
	/**
	 * Cria uma carta com um nome e id especificado
	 * 
	 * @param id id da carta
	 * @param nome nome da carta
	 * 
	 * @see Carta#id
	 * @see Carta#nome
	 */
	public Carta(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o nome da carta
	 * 
	 * @return o nome da carta
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o caminho do arquivo de imagem da carta
	 * 
	 * @return o caminho do arquivo de imagem da carta
	 */
	public String getDiretorio() {
		if (nome.endsWith(".jpg")) {
			return "img/" + nome;
		}
		
		return "img/" + nome + ".jpg";
	}

}
