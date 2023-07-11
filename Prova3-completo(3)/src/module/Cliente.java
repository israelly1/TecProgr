package module;

import java.io.*;
import java.net.Socket;

public class Cliente {
			
	private Socket socket;
	private BufferedReader readerEntrada;
	private BufferedWriter writerSaida;
	private String apelido;
	
	public Cliente(String ip, int porta, String apelidoCliente){
		try {
			
			this.socket = new Socket(ip, porta);
			this.apelido = apelidoCliente;
		
			writerSaida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			readerEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			enviarMensagem(apelido);
			
			new Thread(new EscutarMensagems()).start();
			
		}catch (IOException e) {
			closeConexao();
		}
	}
	
	
	
	protected void enviarMensagem(String mensagem) {
		try {
			
			writerSaida.write(mensagem);
			writerSaida.newLine();
			writerSaida.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
			closeConexao();
		}
	}
	
	protected boolean isConectado() {
		if (socket != null) {
			return socket.isConnected() && !socket.isClosed();
		}
		
		return false;
	}

	private void closeConexao() {
		try {
			
			if(readerEntrada != null) 
				readerEntrada.close();
			
			if(writerSaida != null) 
				writerSaida.close();
		
			if(socket != null) 
				socket.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class EscutarMensagems implements Runnable {
		public void run() {
			
			while(isConectado()) {
				
				try {
					
					if(readerEntrada.ready())
						(Rede.getInstancia()).mensagemRecebidaDaRede(readerEntrada.readLine());
						
				} catch (IOException e) {
					e.printStackTrace();
					closeConexao();
				}
				
			}
		}
	}
}
