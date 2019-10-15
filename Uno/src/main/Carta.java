package main;

/***
 * 
 * @author Roberta Coelho
 *
 */
public class Carta {

	private int cor;
	private int tipo_ou_num;
	
	public Carta (int _cor, int _tipo ){
		cor = _cor;
		tipo_ou_num = _tipo;
	}
	
	public void setCor(int _cor) {
		this.cor = cor;
	}
	
	public int getCor() {
		return cor;
	}
	
	public void setTipo_ou_Num(int _tipo) {
		this.tipo_ou_num = tipo_ou_num;
	}
	
	public int getTipo_ou_Num() {
		return tipo_ou_num;
	}
	
}
