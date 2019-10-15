package principal;

public class CaractereIncorretoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6146516874078639896L;

	public CaractereIncorretoException(){
		super("O caractere nao eh A nem T nem G nem C");
	}

}
