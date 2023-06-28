package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.Jogador;
import negocio.Plano;
import negocio.Jogador;

public class LerDados {
	
	 private ArrayList<Jogador> lista;
	 
	 public LerDados() {
	    lista= new ArrayList<Jogador>();
	}

	public void lerDados(String diretorio) {
		try {
			FileReader arquivo = new FileReader(diretorio);
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				lista.add(separarDadosDoCliente(leitura.readLine()));
			}

		} catch (Exception e) {
		}
	}

	private Jogador separarDadosDoCliente(String linha) {
		String dados[] = linha.split(";");
		Jogador jogador = new Jogador(dados[0], Integer. parseInt(dados[1]), Integer. parseInt(dados[2]), Integer. parseInt(dados[3]), Integer. parseInt(dados[4]), Integer. parseInt(dados[5]),
				Integer. parseInt(dados[6]), Integer. parseInt(dados[7]));
		return jogador;
	}

	public ArrayList<Jogador> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Jogador> lista) {
		this.lista = lista;
	}
	
	
	
}
