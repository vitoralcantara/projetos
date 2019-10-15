package xml_smt_trans;

/**This is a generic class for storing a pair of variables. It is much often used in the classes
 * Translator and LemmaTranslator, principally for helding a variable and it's type or the
 * original rodinXML operator (or operand) and it's SMT format.
 * 
 * 
 * @author Vitor Alcântara de Almeida
 *
 * @param <X> The first generic variable
 * @param <Y> The second generic variable
 */
public class Pair<X,Y> {
	
	/**
	 * The first generic variable
	 */
	private X originalOp;
	/**
	 * The second generic variable
	 */
	private Y smtOp;
		
	/**
	 * This method only creates an object, do nothing more.
	 */
	public Pair()
	{
		
	}
		
	/**
	 * It initializes an object with the generic variables set as user 
	 * @param originalOp The first variable
	 * @param smtOp The second variable
	 */
	public Pair(X originalOp, Y smtOp)
	{
		this.originalOp = originalOp;
		this.smtOp = smtOp;
	}

	/**
	 * Returns the first generic variable
	 * 
	 * @return The fist generic variable
	 */
	public X getFirstElement() {
		return originalOp;
	}
	/**
	 * Set the first generic variable
	 * @param originalOp the value for the first generic variable
	 */
	public void setFirstElement(X originalOp) {
		this.originalOp = originalOp;
	}
	/**
	 * Returns the second generic variable
	 * @return The second generic variable
	 */
	public Y getSecondElement() {
		return smtOp;
	}
	
	/**
	 * Set the second generic variable
	 * @param smtOp the value for the second generic variable
	 */
	public void setSecondElement(Y smtOp) {
		this.smtOp = smtOp;
	}
	/**
	 * It overhides the Object method toString. It returns the String in the following
	 * format:
	 * (first Variable).toString + " -> " + (second Variable).toString.
	 * 
	 * Ex: if the first var is "House" and the second is "45", it will show:
	 * 
	 * House + -> + 45
	 *  
	 * @return A String which shows the variable in the format above.
	 */
	public String toString()
	{
		return originalOp.toString() + " ->  " + smtOp.toString();
	}
	/**
	 * This method compares two objects of this class. It compares the first variable of 
	 * one object with the first of the other and do the same with the second variable.
	 * If both of the methods above return yes, then this method returns yes. 
	 * @param o The Pair object for comparison.
	 * @return True if the first variable of the two pair objects are equal and the second variable
	 *  of the two pair objects are equal too, else False.
	 */
	public boolean equals(Pair<X,Y> o)
	{
		if(this.getFirstElement().equals(o.getFirstElement()) && this.getSecondElement().equals(o.getSecondElement()))
		{
			return true;
		}
		return false;
	}
	
	
	



}
