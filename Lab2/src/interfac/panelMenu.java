package interfac;

import javax.swing.JPanel;

public class panelMenu extends JPanel  {
	
	Janela janela;
	public panelMenu(Janela janela) {
		this.janela= janela;
		criarBotoes();
	}
	
	public void criarBotoes(){
		
		Botao cadastrar = new Botao("CADASTRAR");
		cadastrar.addActionListener(new Cadastro(janela));
		this.add(cadastrar);
		Botao listar= new Botao("LISTAR");
		this.add(listar);
		Botao atualizar= new Botao("ATUALIZAR");
		atualizar.addActionListener(new Atualizar(janela));
		this.add(atualizar);
		Botao deletar= new Botao("DELETAR");
		deletar.addActionListener(new Deletar(janela));
		this.add(deletar);
	}
	
}
