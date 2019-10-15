package xml_smt_trans;

import java.util.ArrayList;

public class OperandSet {
	
	
	public static final String INTEGER = "ℤ";
	public static final String INTEGER2 = "\u2124";
	public static final String NATURAL = "\u2115";
	public static final String NATURAL1 = NATURAL+1;
	public static final String EMPTYSET = "\u2205";
	
	private final ArrayList<Pair<String, String>> stdCharMap = new ArrayList<Pair<String,String>>();
	
	public OperandSet()
	{
		stdCharMap.add(new Pair<String, String>(NATURAL, "Nat"));
		stdCharMap.add(new Pair<String, String>(NATURAL1, "Nat1"));
		stdCharMap.add(new Pair<String,String>(INTEGER, "Int"));
		stdCharMap.add(new Pair<String,String>(INTEGER2, "Int"));
		stdCharMap.add(new Pair<String,String>("BOOL", "Bool"));
		stdCharMap.add(new Pair<String,String>("TRUE", "True"));
		stdCharMap.add(new Pair<String,String>("FALSE", "False"));
		stdCharMap.add(new Pair<String, String>(EMPTYSET, "emptyset"));
		
	}
	
	public String toString()
	{
		String result = "Listando os Operandos especiais:" + System.getProperty("line.separator");
		result = result + stdCharMap.toString();
		return result;
	}
	
	public String getSMTOperand(String operand)
	{
		for(int i = 0 ; i < stdCharMap.size() ; i++)
		{
			if(operand.equals(stdCharMap.get(i).getFirstElement()))
			{
				return stdCharMap.get(i).getSecondElement();
			}
		}
		return operand;
	}
	
	public boolean isOperand(String operand)
	{
		for(int i = 0 ; i < stdCharMap.size() ; i++ )
		{
			if(operand.equals(stdCharMap.get(i).getFirstElement()))
			{
				return true;
			}
		}
		return false;
	}

}
