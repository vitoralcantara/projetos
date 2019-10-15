package xml_smt_trans;

import java.util.ArrayList;

/**
 * 
 */

/**This class is used by the LemmaTranslator when making the translation of the hypothesis and the goal.
 * It holds data about the operators and the operands.
 * @author Vitor
 * 
 * @see xml_smt_trans.LemmaTranslator
 */
public class Relation implements Comparable<Relation> {

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	private String symbol;
	private int priority = 0;
	private int parenthesisLevel = 0;
	private ArrayList<Integer> positions = new ArrayList<Integer>();
	private Integer typeOfRelation;
	private boolean needsQuestionMark = false;
	
	public Relation()
	{
		symbol = "";
	}
	
	public int getParenthesisLevel() {
		return parenthesisLevel;
	}

	public void setParenthesisLevel(int parenthesisLevel) {
		this.parenthesisLevel = parenthesisLevel;
	}


	
	public Relation(String symbol,int position, int level)
	{
		this.setSymbol(symbol);
		positions.add(new Integer(position));
		parenthesisLevel = level;
		typeOfRelation = new Integer(0);
	}
	
	public Relation(String symbol,int position, int level, Integer typeOfRelation)
	{
		this.setSymbol(symbol);
		positions.add(new Integer(position));
		parenthesisLevel = level;
		this.setTypeOfRelation(typeOfRelation);	
		;
	}
		
	public ArrayList<Integer> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Integer> positions) {
		this.positions = positions;
	}

	public Relation(String symbol)
	{
		this.setSymbol(symbol);
		
	}
	 
	public String getSymbol() {
		return symbol;
	}
	
	//Lembrando: Simbolo que tem menor prioridade é processado antes
	public void setSymbol(String symbol) {
		this.symbol = symbol;
		OperatorSet operatorSet = new OperatorSet();
		this.priority = operatorSet.getPriority(symbol); 		
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Relation o) {
		// TODO Auto-generated method stub
		if(parenthesisLevel < o.getParenthesisLevel())
		{
			return 1;
		}
		else if(parenthesisLevel == o.getParenthesisLevel())
		{
			if(priority > o.getPriority())
			{
				return 1;
			}
			if(priority < o.getPriority())
			{
				return -1;
			}
			else if(priority == o.getPriority())
			{
				return 0;
			}
		}		
		return 0;
	}
	
	public String toString()
	{
		return symbol + " |" + priority + " | " + parenthesisLevel + " |[ " + positions + " ]| " + typeOfRelation; 
		
	}

	public void setTypeOfRelation(Integer typeOfRelation) {
		this.typeOfRelation = typeOfRelation;
	}

	public Integer getTypeOfRelation() {
		return typeOfRelation;
	}

	public void setNeedsQuestionMark(boolean needsQuestionMark) {
		this.needsQuestionMark = needsQuestionMark;
	}

	public boolean isNeedsQuestionMark() {
		return needsQuestionMark;
	}

}
