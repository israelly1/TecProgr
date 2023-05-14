package robo;

public class Robo {
	
	private int quantCasasSul;
	private int quantCasasNorte;
	private int quantCasasSudeste;
	private int quantCasasNordeste;
	private int quantCasasLeste;
	private int quantCasasSudoeste;
	private int quantCasasNoroeste;
	private int quantCasasOeste;
	
	private Plano plano;
	
	private int x;
	private int y;
	int QuantCasasAndadas;
	int RoboNaoPassou;
	
	public Robo(Plano plano){
		this.x = (plano.getDimensao() -1)/2;
		this.y = x;
		this.plano= plano;
	}
	
	public void AndarLeste(){
		this.y++;
		quantCasasLeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarOeste(){
		this.y--;
		quantCasasOeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarNorte(){
		this.x--;
		quantCasasNorte++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarSul(){
		this.x++;
		quantCasasSul++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarNordeste() {
		this.y++;
		this.x--;
		quantCasasNordeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarNoroeste() {
		this.y--;
		this.x--;
		quantCasasNoroeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarSudoeste() {
		this.y--;
		this.x++;
		quantCasasSudoeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	public void AndarSudeste() {
		this.y++;
		this.x++;
		quantCasasSudeste++;
		EncontrarMoeda();
		OndeRoboPassou(x, y);
		QuantCasasAndadas();
	}
	
	public void EncontrarMoeda() {
		String[][] aux = new String[plano.getDimensao()][plano.getDimensao()];
		aux = plano.getPlano();
		for(int i=0; i<= plano.getDimensao()-1; i++) {
			for(int j=0; j<= plano.getDimensao()-1; j++) {
				if(aux[i][j].equals(" $ ")) {
					System.out.println("O robô encontrou uma moeda");
				}
			}
		}
	}
	
	public void OndeRoboPassou(int x, int y) {
		String[][] aux= new String[plano.getDimensao()][plano.getDimensao()];
		aux = plano.getPlano();
		aux[x][y]=" @ ";
		plano.setPlano(aux);
	}
	
	public int QuantCasasAndadas() {
		QuantCasasAndadas++;
		return QuantCasasAndadas;
	}
	
	public int OndeRoboNaoPassou() {
		String[][] aux= new String[plano.getDimensao()][plano.getDimensao()];
		aux = plano.getPlano();
		for(int i=0; i<= plano.getDimensao()-1; i++) {
			for(int j=0; j<= plano.getDimensao()-1; j++) {
				if(!aux[i][j].equals(" @ ")) {
					RoboNaoPassou++;
				}
			}
		}
		return RoboNaoPassou;
	}
	
	public void CaminhadaB() {
		this.x = 0;
		this.y = 0;
		OndeRoboPassou(x, y);
		for(int i=0; i<= plano.getDimensao()-2; i++ ) {
			AndarSudeste();
		}
		for(int i=0; i<= plano.getDimensao()-2; i++ ) {
			AndarNorte();
		}
		for(int i=0; i<= plano.getDimensao()-2; i++ ) {
			AndarSudoeste();
		}
		for(int i=0; i<= plano.getDimensao()-3; i++ ) {
			AndarNorte();
		}
	}
	public void CaminhadaC() { 
		int leste=1;
		while(leste < plano.getDimensao()) {
			for(int i=0; i< leste;i++) {
				AndarLeste();
			}
			for(int i=0; i< leste;i++) {
				AndarSul();
			}
			for(int i=0; i< leste+1;i++) {
				AndarOeste();
			}
			for(int i=0; i< leste+1;i++) {
				AndarNorte();
			}
			leste=leste+2;
		}
		for(int i=0; i< plano.getDimensao()-1; i++) {
			AndarLeste();
		}
	}
	
	public void MostrarPlano() {
		for(int i=0; i<= plano.getDimensao()-1; i++ ) {
			for(int j=0; j<= plano.getDimensao()-1; j++ ) {
				String[][] aux= new String[plano.getDimensao()][plano.getDimensao()];
				aux = plano.getPlano();
				System.out.printf("%s",aux[i][j]);
			}
			System.out.println("\n");
		}
	}
	
}
	
	
