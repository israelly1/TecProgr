package apresentacao;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Painel_Relatorio extends JPanel{

	public Painel_Relatorio() {
		DefaultTableModel tabela = new DefaultTableModel();
        tabela.addColumn("NOME");
        tabela.addColumn("PONTUAÇÃO TOTAL");
        tabela.addColumn("PONTUAÇÃO ALUNO");
        tabela.addColumn("PONTUAÇÃO BUG");
        tabela.addColumn("REI");
        tabela.addColumn("PEÃO");
        tabela.addColumn("CAVALO");
        
        try {
			FileReader arquivo = new FileReader("dados/Dados.txt");
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				String[] dados = leitura.readLine().split(";");
				tabela.addRow(dados);
			}

		} catch (Exception e) {
		}
        JTable relatorio = new JTable(tabela);
        relatorio.setVisible(true);
        this.add(relatorio);
	}
}
