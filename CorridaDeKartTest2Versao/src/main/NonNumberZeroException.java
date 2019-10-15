package main;

public class NonNumberZeroException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3150294264630799512L;

	public NonNumberZeroException(){
		super("Número é 0");
	}

}
