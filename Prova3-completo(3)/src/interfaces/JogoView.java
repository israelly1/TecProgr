package interfaces;

public interface JogoView {
	
	public String getDiretorioCarta(String nomeCarta);
	
	public void criarServer(String nomeJogador);
	
	public void entrarServer(String nomeJogador, String ipPorta);

	public String getNomeJogo();
	
	public void comecarJogo();
	
	public void receberDicaECarta(String dica, String nomeCarta);
	
	public void receberCartaParte1(String nomeCarta);
	
	public void receberCartaParte2(String nomeCarta);

}
