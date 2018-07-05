
public class ListaMilitar {
	private Militar[] militares;
	private int proximo = 0;
	
	public ListaMilitar(int tamanho){
		this.militares = new Militar[tamanho];
	}

	public Militar[] getMilitares() {
		return militares;
	}

	public void setMilitares(Militar[] militares) {
		this.militares = militares;
	}

	public int getProximo() {
		return proximo;
	}

	public void setProximo(int proximo) {
		this.proximo = proximo;
	}
	
	
}
