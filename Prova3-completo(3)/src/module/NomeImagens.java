package module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class NomeImagens {
	
	private static NomeImagens instancia;
	
	private String[] nomeImagens;
	
	public static NomeImagens getInstancia() {
		if(instancia == null) {
			instancia = new NomeImagens();
		}
		
		return instancia;
	}
	
	private NomeImagens() {
		this.popularNomeImagens();
	}
	
	public int getQtdDeCartas() {
		return nomeImagens.length;
	}
	
	public String[] getNomeImagens() {
		return nomeImagens;
	}
	
	public String getNomeImagem(int index) {
		return nomeImagens[index];
	}
	
	
	private void popularNomeImagens() {
		ArrayList<String> arrayStringTemp = new ArrayList<String>();
		
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("img/nomesCartas.txt"));
			
			while (leitor.ready())
				arrayStringTemp.add(leitor.readLine());
			
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de Nomes Das Imagens não encontrado");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		nomeImagens = new String[arrayStringTemp.size()];
		
		for(int i=0; i<nomeImagens.length; i++) {
			nomeImagens[i] = arrayStringTemp.get(i);
		}
		
	}
	
	
}
