package negocio;

import java.io.LineNumberInputStream;
import java.util.ArrayList;

public class ListaClientes {
	
	private ArrayList<Cliente> listaClientes;
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ListaClientes() {
		this.listaClientes= new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	public void setListaCliente(ArrayList<Cliente> lista) {
		listaClientes= lista;
	}
	
	public int numeroCliente() {
		return listaClientes.size();
	}
	
	public String dadosCliente() {
		String dados= "";
		for (Cliente cliente : listaClientes) {
			dados+= cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getMatricula() + ";" + cliente.getVertente()+ "\n";
		}
		return dados;
	}
	

}
