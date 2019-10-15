package main;
import java.util.ArrayList;


public class Partida {
	
	int codigoPartida;
	private ArrayList<Carta> cartasNaMesa;
	public int getCodigoPartida() {
		return codigoPartida;
	}
	public void setCodigoPartida(int codigoPartida) {
		this.codigoPartida = codigoPartida;
	}
	public ArrayList<Carta> getCartasNaMesa() {
		return cartasNaMesa;
	}
	public void setCartasNaMesa(ArrayList<Carta> cartasNaMesa) {
		this.cartasNaMesa = cartasNaMesa;
	} 

}
