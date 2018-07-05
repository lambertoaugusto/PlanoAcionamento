
public class Militar {
	
	private String nomeDeGuerra;
	private String telefone;
	private String Pai_1;
	private String Pai_2;
	private String Pai_3;
	private String Filho_1;
	private String Filho_2;
	private String Filho_3;
	//private int posicao;
	//private int linha;
	//private int coluna;
	
	public Militar(){
		this.nomeDeGuerra = "";
		this.telefone = "";
	}
	
	public Militar(String n, String t){
		this.nomeDeGuerra = n;
		this.telefone = t;		
	}
	
	public String getNomeDeGuerra() {
		return nomeDeGuerra;
	}
	public void setNomeDeGuerra(String nomeDeGuerra) {
		this.nomeDeGuerra = nomeDeGuerra;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}*/

	public String getPai_1() {
		return Pai_1;
	}

	public void setPai_1(String pai_1) {
		Pai_1 = pai_1;
	}

	public String getPai_2() {
		return Pai_2;
	}

	public void setPai_2(String pai_2) {
		Pai_2 = pai_2;
	}

	public String getPai_3() {
		return Pai_3;
	}

	public void setPai_3(String pai_3) {
		Pai_3 = pai_3;
	}

	public String getFilho_1() {
		return Filho_1;
	}

	public void setFilho_1(String filho_1) {
		Filho_1 = filho_1;
	}

	public String getFilho_2() {
		return Filho_2;
	}

	public void setFilho_2(String filho_2) {
		Filho_2 = filho_2;
	}

	public String getFilho_3() {
		return Filho_3;
	}

	public void setFilho_3(String filho_3) {
		Filho_3 = filho_3;
	}

	/*public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}*/
	
}
