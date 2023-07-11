package interfaces;

import module.SaidaRede;

public interface InterfaceRede {
	
	public void iniciarServer(String nome);
	
	public void conectar(String nome, String ip, int porta);
	
	public void setSaidaRede(SaidaRede saidaRede);
	
	public void enviarMensagem(String mensagem);
	
	public boolean isConectado();
	
	public int getPorta();

}
