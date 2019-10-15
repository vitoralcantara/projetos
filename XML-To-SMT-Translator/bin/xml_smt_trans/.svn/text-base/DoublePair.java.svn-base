package xml_smt_trans;

/**This class extends the Triple class with one more variable.
 * 
 * @author Vitor
 * @see Triple , Pair
 *
 */
public class DoublePair<X,Y,Z,K> extends Triple<X, Y, Z> {

	/**
	 * The fourth generic variable
	 */
	private K element;
	
	/**
	 * It returns the fourth generic variable. 
	 * @return the fourth generic variable.
	 */
	public K getFourthElement() {
		return element;
	}
	
	/**
	 * It calls the constructor of the superclass with no parameters.
	 * 
	 * @see Triple
	 */
	public DoublePair()
	{
		super();
	}

	/**
	 * It sets the value of the fourth generic variable.
	 * @param element The nwe value
	 */
	public void setFourthElement(K element) {
		this.element = element;
	}

	/**
	 * This generator sets the three generic variables that belongs to the superclass.
	 * @param originalOp The first generic variable
	 * @param smtOp The second generic variable
	 * @param level The third generic variable
	 * 
	 * @see Triple
	 */
	public DoublePair(X originalOp, Y smtOp, Z level) {
		super(originalOp, smtOp, level);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This generator sets the four generic variablesto the object of this class.  
	 * @param originalOp The first generic variable
	 * @param smtOp The second generic variable
	 * @param level The third generic variable
	 * @param element The fourth generic variable
	 * 
	 * @see Triple
	 */
	public DoublePair(X originalOp, Y smtOp, Z level,K element) {
		super(originalOp, smtOp, level);
		this.element = element;
		// TODO Auto-generated constructor stub
	}

}
