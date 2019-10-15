package xml_smt_trans;

import java.util.ArrayList;

public class LemmaData {
	
	private String title;
	private String origin;
	private ArrayList<Pair<String,String>> typenv;
	private ArrayList<Pair<String,Boolean>> hypothesis;
	private String goal;
	private ArrayList<String> theories;
	
	
	public ArrayList<Pair<String, Boolean>> getHypothesis() {
		return hypothesis;
	}


	public void setHypothesis(ArrayList<Pair<String, Boolean>> hypothesis) {
		this.hypothesis = hypothesis;
	}


	public ArrayList<String> getTheories() {
		return theories;
	}


	public void setTheories(ArrayList<String> theories) {
		this.theories = theories;
	}


	public void setTypenv(ArrayList<Pair<String, String>> typenv) {
		this.typenv = typenv;
	}
	
	
	public LemmaData()
	{
		title = origin = goal =  "";
		hypothesis = new ArrayList<Pair<String,Boolean>>();
		theories = new ArrayList<String>();	
		typenv = new ArrayList<Pair<String,String>>();
	}
	
	
	public LemmaData(String title,
					 String origin,
					 ArrayList<String> typenv,
					 String goal
					 )
	{
		this.title = title;
		this.origin = origin;
		this.typenv = new ArrayList<Pair<String,String>>();
		this.hypothesis = new ArrayList<Pair<String,Boolean>>();
		for(int i = 0 ; i < typenv.size() ; i++)
		{
			Pair<String, Boolean> p = new Pair<String, Boolean>();
			p.setFirstElement(typenv.get(i));
			p.setSecondElement(true);
			this.hypothesis.add(p);			
		}
		this.goal = goal;		
	}
	
	public void printOut()
	{
		String s = "Nome: " + title + "\nOrigem: " + origin + "\ntypenv:\n";
		for(int i = 0 ; i < typenv.size() ; i++)
		{
			s = s + typenv.get(i).toString() + "\n";
		}
		s = s + "hypothesis:\n";
		for(int i = 0 ; i < hypothesis.size() ; i++)
		{
			s = s + hypothesis.get(i).toString() + "\n";
		}
		s = s + "goal: " + goal;	
		System.out.println(s);
	}
	
	
	
	public void setListOfHypothesis(ArrayList<String> hypothesis)
	{
		for(int i = 0 ; i < hypothesis.size() ; i++)
		{
			Pair<String, Boolean> p = new Pair<String, Boolean>();
			p.setFirstElement(hypothesis.get(i));
			p.setSecondElement(true);
			this.hypothesis.add(p);
		}					
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public ArrayList<Pair<String, String>> getTypenv() {
		return typenv;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	

}
