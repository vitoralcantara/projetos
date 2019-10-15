package main;

public class OrdemNaoCrescenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3866895140411888914L;
	
	public OrdemNaoCrescenteException(){
		super("Valores nao estao em ordem crescente");
	}

}
