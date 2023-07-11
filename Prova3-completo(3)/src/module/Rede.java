package module;

import interfaces.InterfaceRede;

public class Rede implements InterfaceRede {
	
	private static Rede instancia;
	
	private SaidaRede saidaRede;
	
	private Servidor servidor;
	private Cliente cliente;
	
	private Rede() {
	}
	
	public static Rede getInstancia() {
		if (instancia == null) {
			instancia = new Rede();
		}
		return instancia;
	}
	
	/**
	 * Método que sera executado apos o cliente receber uma mensagem da rede
	 * 
	 * @param mensagem recebida do servidor
	 */
	protected void mensagemRecebidaDaRede(String msgDaRede) {
		if (saidaRede != null) {
			saidaRede.receberMensagem(msgDaRede);
		}
	}
	
	public void setSaidaRede(SaidaRede saidaRede) {
		this.saidaRede = saidaRede;
	}
	
	/**
	 * Deve mandar uma mensagem para os computadores conectados na rede
	 * 
	 * @param mensagem a string a ser enviada
	 */
	public void enviarMensagem(String msgParaRede) {
		cliente.enviarMensagem(msgParaRede);
	}
	
	/**
	 * Deve criar um cliente e conecta-lo com um host de um ip informado
	 * 
	 * @param ip ip do servidor host 
	 * @param nome  nome do cliente
	 */
	public void conectar(String nome, String ip, int porta) {
		cliente = new Cliente(ip, porta, nome);
	}
	
	/**
	 * Deve iniciar um server para que outros computadores posssam conectar
	 */
	public void iniciarServer(String nome) {
		servidor = new Servidor();
		
		cliente = new Cliente("127.0.0.1", getPorta(), nome);
	}
	
	/**
	 * Retorna a porta do servidor
	 * 
	 * @return a porta do servidor ou cliente
	 */
	public int getPorta() {
		return servidor.getPorta();
	}

	public boolean isConectado() {
		return cliente.isConectado();
	}
	
}
