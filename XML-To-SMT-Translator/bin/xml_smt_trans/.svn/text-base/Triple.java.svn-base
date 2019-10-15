package xml_smt_trans;


/**This class extends the Pair class with one more variable.
 * 
 * @author Vitor
 *
 */
public class Triple<X,Y,Z> extends Pair<X, Y> {
	
	/**
	 * This generator sets the three generic variables with the parameters.
	 * @param originalOp The first generic variable
	 * @param smtOp The second generic variable
	 * @param level The third generic variable
	 */
	public Triple(X originalOp, Y smtOp, Z level) {
		super(originalOp, smtOp);
		// TODO Auto-generated constructor stub
		this.level = level;
	}
	
	/**
	 * This method only creates the object, do nothing more.
	 */
	public Triple()
	{
		super();
	}
	
	/**
	 * The third generic variable.
	 */
	private Z level;
	
	/**
	 * It returns the third generic variable
	 * @return the third generic variable
	 */
	public Z getThirdElement() {
		return level;
	}
	/**
	 * It sets the third generic variable.
	 * @param level The new value for the third variable.
	 */
	public void setThirdElement(Z level) {
		this.level = level;
	}
	/**
	 * This method overrides the same method in the Pair class. This time, the format is:
	 * (First var).toString + " | " + (Second var).toString + " | " + (Third var).toString
	 * 
	 * Ex. If the first var is "Cool", the second is 17 and the Third is "Cole", then it shows:
	 * 
	 * Cool | 17 | Cole. 
	 * 
	 * @return A String which shows the variable in the format above.
	 * 
	 */
	public String toString()
	{
		return super.getFirstElement().toString() + " | " + super.getSecondElement().toString() + " | " + this.getThirdElement().toString();	
	}


}
