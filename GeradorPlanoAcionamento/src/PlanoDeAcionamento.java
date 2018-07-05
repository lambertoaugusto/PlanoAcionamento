import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;


public class PlanoDeAcionamento {
	private Militar[] militares;
	
	public PlanoDeAcionamento(Militar[] mil){
		this.militares = mil;
	}

	public Militar[] getMilitares() {
		return militares;
	}

	public void setMilitares(Militar[] militares) {
		this.militares = militares;
	}
	
	public void gerarPlano(){		
		//inserindo os primeiros filhos e primeiros pais
		for(int j = 0; j < militares.length; j++){
			militares[j].setFilho_1(militares[(j+1)%(militares.length)].getNomeDeGuerra());
			militares[(j+1)%(militares.length)].setPai_1(militares[j].getNomeDeGuerra());
		}
		//inserindo os segundos filhos e segundos pais
		for(int j = 0; j < militares.length; j++){
			militares[j].setFilho_2(militares[(j+2)%(militares.length)].getNomeDeGuerra());
			militares[(j+2)%(militares.length)].setPai_2(militares[j].getNomeDeGuerra());
		}
		//inserindo os segundos filhos e segundos pais
		for(int j = 0; j < militares.length; j++){
			militares[j].setFilho_3(militares[(j+3)%(militares.length)].getNomeDeGuerra());
			militares[(j+3)%(militares.length)].setPai_3(militares[j].getNomeDeGuerra());
		}
	}	
}
