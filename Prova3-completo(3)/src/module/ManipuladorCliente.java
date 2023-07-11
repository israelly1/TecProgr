package module;

import java.io.*;
import java.net.Socket;

public class ManipuladorCliente implements Runnable {
	
	//public static ArrayList<ManipuladorCliente2> listaClientes = new ArrayList<ManipuladorCliente2>();
	
	private Socket socket;
	private BufferedReader readerEntrada;
	private BufferedWriter writerSaida;
	private String nomeDoCliente;
	private Servidor servidor;
	
	protected ManipuladorCliente(Socket socket, Servidor servidor) {
		try {
			this.socket = socket;
			this.servidor = servidor;
		
			writerSaida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			readerEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			nomeDoCliente = readerEntrada.readLine();
			
			(servidor.getListaClientes()).add(this);
			
			servidor.imprimirServerLogs("< "+ nomeDoCliente + " > entrou no chat");
			
		} catch (IOException e) {
			closeConexao();
			e.printStackTrace();
		}
	}
	
	
	
	
	public void run() {
		
		String msgDoCliente;
		
		while(socket.isConnected()) {
			try {
				msgDoCliente = readerEntrada.readLine();
				broadcastMessagem(msgDoCliente);
				servidor.imprimirServerLogs("< "+nomeDoCliente+" enviou: '"+ msgDoCliente +"' >");
			} catch (IOException e) {
				closeConexao();
				break;
			}
		}
		
	}
	
	
	
	protected void broadcastMessagem(String msgParaEnviar) {
		for (ManipuladorCliente cliente : (servidor.getListaClientes())) {
			try {
				
				if(!cliente.getNomeDoCliente().equalsIgnoreCase(nomeDoCliente)) {
					cliente.enviarMensagem(msgParaEnviar);
				}
					
			}catch (IOException e) {
				closeConexao();
			}
		}
	}
	
	private void enviarMensagem(String msgParaEnviar) throws IOException {
		writerSaida.write(msgParaEnviar);
		writerSaida.newLine();
		writerSaida.flush();
	}
	
	
	
	protected void closeConexao() {
		removerCliente();
		
		try {
			if(this.writerSaida != null) 
				this.writerSaida.close();
			
			if(this.readerEntrada != null) 
				this.readerEntrada.close();
		
			if(this.socket != null) 
				this.socket.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	protected void removerCliente() {
		(servidor.getListaClientes()).remove(this);
		servidor.imprimirServerLogs("< "+ nomeDoCliente +" > saiu do chat!");
	}

	
	
	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
}


