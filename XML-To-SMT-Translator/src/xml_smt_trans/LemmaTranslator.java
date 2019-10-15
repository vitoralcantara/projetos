package xml_smt_trans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 */

/**
 * This class is the core of the translation from Rodin-XML format to SMT-LIB format. To make the 
 * translation of a entire document, is necessary to call the class Translator. Each instance of this class makes 
 * the translation of only one lemma.  
 * @author Vitor Alcântara de Almeida
 *
 */
public class LemmaTranslator {
	
	private static final int LEFT_ONLY = 0;
	private static final int RIGHT_ONLY = 1;
	public static final int BOTH_SIDES = 2;
	public static final int NONE = 0;
	public static final int OPERATOR_ONLY = RIGHT_ONLY;
	public static final int ALL_OPERATIONS = BOTH_SIDES;
	public static final int OPERANDS_ONLY = 3;
	public static final int PAIR_SET = NONE;
	public static final int SINGLE_SET = OPERATOR_ONLY;
	public static final int NATURAL = BOTH_SIDES;
	public static final int SINGLE_VARIABLE = 4;
	public static final int INTEGER_VARIABLE = 5;
	public static final int OPERATOR = 6;
	public static final int NOT_DEFINED = 7;
	private boolean onlyTrueHypothesis = false;
	private boolean printDetails = false;
	private String nameOfThisLemma;
	private int numberOfSingleLemma = 0;
	private int numberOfFiniteOp = 0;
	private int pTerm = 0;
	
	private int minimalNumberOfQuots = 0;
	private ArrayList<Triple<String,Integer,String>> quotedVars = new ArrayList<Triple<String,Integer,String>>();
	private HashMap<String, String> mappedQuotedVars;
	
	
	private String printDefinitionsOut;
	private boolean hasNewOperator = false;
	
	File translatedFile;
	String translatedPath;
	boolean neeedsToBeDeleted = true;
	
	private LemmaData lemmaData;
	private String finalPath;
			
	private ArrayList<String> sorts,setOfHypothesis;
	//funs: Primeira Variavel: Nome da Variavel
	//funs: Segunda Variavel: Nome do tipo
	//funs: Terceira Variavel: Tipo de Variavel (single var, single set, pair set...)
	private ArrayList<Triple<String,String,Integer>> funs,listOfVariables,preds;
	private ArrayList<Triple<String, String, String>> minMaxAssumptions;
	private ArrayList<String> alreadyUsedNames;
	private String nameOfLemma, parsedGoal;
	private OperatorSet operatorSet;
	private OperandSet operandSet;
	
	private ArrayList<String> usedOperators = new ArrayList<String>();
	private ArrayList<String> usedTheories = new ArrayList<String>(),requiredTheories = null;
	
	
	private ArrayList<String> problemsEncountered = new ArrayList<String>();
	
	//1: Nome e Numero do Conjunto
	//2: Vetor com as variáveis do Conjunto
	//3: Tipo do Conjunto (Simples ou de Pares)
	//4: Tipo dos Conjuntos 
	private ArrayList<DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>>> macrosOfSets;
	
	public void setNeedDetails(boolean needDetails)
	{
		printDetails = needDetails;
	}	
	
	public void setPathOfTranslatedFile(String path)
	{
		translatedPath = path;
	}
	
	public void setRequiredTheories(ArrayList<String> theories)
	{
		requiredTheories = theories;
	}
	
	public String getDetails()
	{
		return printDefinitionsOut;
	}
	
	private void initContext()
	{
		//enumSets = new ArrayList<DoublePair<String,String,ArrayList<String>,Integer>>();
		minMaxAssumptions = new ArrayList<Triple<String,String,String>>();
		macrosOfSets = new ArrayList<DoublePair<Pair<String,Integer>,ArrayList<Pair<String,String>>,Integer,Pair<String,String>>>();
		operatorSet = new OperatorSet();
		operandSet = new OperandSet();
		funs = new ArrayList<Triple<String,String,Integer>>();
		preds = new ArrayList<Triple<String,String,Integer>>();
		sorts = new ArrayList<String>();
		setOfHypothesis = new ArrayList<String>();
		
		listOfVariables = new ArrayList<Triple<String,String,Integer>>();
	}
	
//	/** Constructs the class which the <code>org.w3c.dom.Element</code> which contains the lemma
//	 * that will be translated, the argument which decides if only necessary hypothesis will be translated
//	 * and the path of the destination folder.	 * 
//	 * @param lemma The lemma that will be translated
//	 * @param onlyTrueHypothesis If true, hypothesis which does not have the attribute 'needed', or do have it
//	 * but it's value is not 'true' won't be translated. If false, all the document will be translated.
//	 * @param PATH The folder where the translated file will be saved.
//	 * @see Translator
//	 */
	
	/**
	 * Return all the problems found during the translation. If there's no error, the arraylist is returned empty (but not null). 
	 * @return the problems found during the translation.
	 */
	public ArrayList<String> getProblems()
	{
		return problemsEncountered;
	}
		 
	/**
	 * Initializes the translation of the lemma.
	 * @param lemma The lemma which is in the <code>org.w3c.Element</code> format.
	 * @param onlyTrueHypothesis Specify if only hypothesis which have the attribute <code>needed</code> and it's value is <code>"true"</code>
	 * @param PATH The path of the file where the translated lemma will be saved.
	 */
//	public void beginParsing(Element lemma, 
//							   boolean onlyTrueHypothesis, 
//							   String PATH
//	)
//	{
//
//		this.onlyTrueHypothesis = onlyTrueHypothesis;
//		initContext();		
//		if(parseLemma())
//		{
//			printLemmaOnFile(PATH);
//		}
//		return;			
//	}
	
	private void addQuotedElementsToHash(String string)
	{
		String[] strings = string.split(" ");
		for(int i = 0 ; i < strings.length ; i++)
		{
			if(strings[i].endsWith("'"))
			{
				int initPos = strings[i].indexOf('\'');
				if(initPos > 0)
				{
					int quantOfquots = 0;
					for(int j = 1 ; j < strings[i].length() ; j++ )
					{
						if (strings[i].charAt(j) == '\'' )
						{
							++quantOfquots;
						}
					}
					String addString = strings[i].substring(0,initPos);
					quotedVars.add(new Triple<String,Integer,String>(addString,quantOfquots,strings[i]));
				}				
			}
		}
	}
	
	
	public void beginParsing(LemmaData lemmaData,
							 boolean onlyTrueHypothesis
							 )
	{
		this.onlyTrueHypothesis = onlyTrueHypothesis;
		this.lemmaData = lemmaData;
		initContext();		
		if(parseLemma())
		{
			printLemmaOnFile();
		}
		return;
	}
	
	
	/**
	 * This method is used to verify if the name of the new file which will contain the new translated lemma is already used in other file of the translated ones.
	 * If so, it returns a new name for the file with a number concatenated in it, and the new name is the name of no other file.  
	 * 
	 * @param actualName The current name for the file that will held the translated lemma.
	 * @return The same name, if it's not already used by other file, a new name otherwise.
	 */
	private String checkNameOfFile(String actualName)
	{
		int i;
		for(i=0 ; i < alreadyUsedNames.size() ; i++)
		{
			if(actualName.equals(alreadyUsedNames.get(i)))
			{
				i = alreadyUsedNames.size() + 1;
			}
		}
		if(i > alreadyUsedNames.size() )
		{
			int c = 0;
			String newName = actualName + c;
			for(i = 0 ; i < alreadyUsedNames.size() ; i++)
			{
				if(newName.equals(alreadyUsedNames.get(i)))
				{
					++c;
					newName = actualName + c;
					i = -1;
				}
			}
			return newName;
		}
		return actualName;		
	}
	
	/**
	 * It returns the name of the translated Lemma.
	 * @return the name of the lemma.
	 */
	public String getNameOfLemma()
	{
		return nameOfThisLemma;
	}
	
	/**
	 * It returns the name of all files that holds the translated lemmas. It's called by the class Translator when it is
	 * translating more than one lemma.  
	 * @param usedNames The list of names of the other files that contains the lemmas translated before this one. 
	 */
	public void setListOfAlreadyUsedNames(ArrayList<String> usedNames)
	{
		alreadyUsedNames = usedNames;
		
	}
	
	public File getTranslatedFile()
	{
		return translatedFile;
	}
	
	private void setLowestValueToQuotedElements()
	{
		for(int i = 0; i < quotedVars.size() ; i++ )
		{
			for(int j = 0 ; j < listOfVariables.size() ; j++)
			{
				if(listOfVariables.get(j).getFirstElement().contains(quotedVars.get(i).getFirstElement()))
				{
					String sub = listOfVariables.get(j).getFirstElement().substring(quotedVars.get(i).getFirstElement().length() - 1 , listOfVariables.get(j).getFirstElement().length());
					try
					{
						int x = Integer.parseInt(sub);
						if (x > minimalNumberOfQuots)
						{
							minimalNumberOfQuots = x;
						}
						
					}
					catch(NumberFormatException n)
					{
						continue;
					}					
				}
			}
			
			for(int j = 0 ; j < funs.size() ; j++)
			{
				if(funs.get(j).getFirstElement().contains(quotedVars.get(i).getFirstElement()))
				{
					String sub = listOfVariables.get(j).getFirstElement().substring(quotedVars.get(i).getFirstElement().length(), funs.get(j).getFirstElement().length());
					try
					{
						int x = Integer.parseInt(sub);
						if (x > minimalNumberOfQuots)
						{
							minimalNumberOfQuots = x;
						}
						
					}
					catch(NumberFormatException n)
					{
						continue;
					}					
				}
			}
			
			for(int j = 0 ; j < preds.size() ; j++)
			{
				if(preds.get(j).getFirstElement().contains(quotedVars.get(i).getFirstElement()))
				{
					String sub = preds.get(j).getFirstElement().substring(quotedVars.get(i).getFirstElement().length() - 1 , preds.get(j).getFirstElement().length());
					try
					{
						int x = Integer.parseInt(sub);
						if (x > minimalNumberOfQuots)
						{
							minimalNumberOfQuots = x;
						}
						
					}
					catch(NumberFormatException n)
					{
						continue;
					}					
				}
			}
			
			for(int j = 0 ; j < sorts.size() ; j++)
			{
				if(sorts.get(j).contains(quotedVars.get(i).getFirstElement()))
				{
					String sub = sorts.get(j).substring(quotedVars.get(i).getFirstElement().length() - 1 , sorts.get(j).length());
					try
					{
						int x = Integer.parseInt(sub);
						if (x > minimalNumberOfQuots)
						{
							minimalNumberOfQuots = x;
						}
						
					}
					catch(NumberFormatException n)
					{
						continue;
					}					
				}
			}			
		}
		
		for(int i = 0; i < quotedVars.size() ; i++ )
		{
			for(int j = 0 ; j < listOfVariables.size() ; j++)
			{
				if(listOfVariables.get(j).getFirstElement().equals(quotedVars.get(i).getThirdElement()))
				{
					Triple<String,String,Integer> x = listOfVariables.get(j);
					x.setFirstElement(quotedVars.get(i).getFirstElement() + (quotedVars.get(i).getSecondElement() + minimalNumberOfQuots));
					listOfVariables.set(j, x);
				}
			}
			
			for(int j = 0 ; j < funs.size() ; j++)
			{
				if(funs.get(j).getFirstElement().equals(quotedVars.get(i).getThirdElement()))
				{
					Triple<String,String,Integer> x = funs.get(j);
					x.setFirstElement(quotedVars.get(i).getFirstElement() + (quotedVars.get(i).getSecondElement() + minimalNumberOfQuots));
					funs.set(j, x);
				}
			}
			
			for(int j = 0 ; j < preds.size() ; j++)
			{
				if(preds.get(j).getFirstElement().equals(quotedVars.get(i).getThirdElement()))
				{
					Triple<String,String,Integer> x = listOfVariables.get(j);
					x.setFirstElement(quotedVars.get(i).getFirstElement() + (quotedVars.get(i).getSecondElement() + minimalNumberOfQuots));
					preds.set(j, x);
				}
			}
			
			for(int j = 0 ; j < sorts.size() ; j++)
			{
				if(sorts.get(j).equals(quotedVars.get(i).getThirdElement()))
				{
					String x = sorts.get(j);
					x = (quotedVars.get(i).getFirstElement() + (quotedVars.get(i).getSecondElement() + minimalNumberOfQuots));
					sorts.set(j, x);
				}
			}			
		}	
	}
	
	
	
	
	
	
	
	/**
	 * This method print all the the translated file to a .SMT file, which
	 * will be saved on the <code>PATH</code> folder.
	 * @param PATH The folder where the translated file will be saved.
	 */
	private void printLemmaOnFile()
	{
		String benchmark = "(benchmark smts ";//nameOfThisLemma;
		final String FINAL_PATH = translatedPath + File.separator + nameOfThisLemma + ".smt";
		
		
		
//		if(nameOfThisLemma == null)
//		{
//			System.out.println("O NAMEOFTHISLEMMA esta NULL");
//		}
		
		
		printDefinitionsOut = nameOfThisLemma + ":";
		
		if(!usedTheories.isEmpty())
		{
			for(int d = 0 ; d < usedTheories.size() - 1; d++)
			{
				printDefinitionsOut = printDefinitionsOut + usedTheories.get(d) + ",";
			}		
			printDefinitionsOut = printDefinitionsOut + usedTheories.get(usedTheories.size() - 1) + ":";
		}		
		
		if(!usedOperators.isEmpty())
		{
			for(int d = 0 ; d < usedOperators.size() - 1 ; d++)
			{
				printDefinitionsOut = printDefinitionsOut + usedOperators.get(d) + ",";
			}		
			printDefinitionsOut = printDefinitionsOut + usedOperators.get(usedOperators.size() - 1) + ".";
		}		
		if(printDetails)
		{
			System.out.println(printDefinitionsOut);
		}
		
		try
		{
			String s = "";
			if(translatedPath != null)
			{
				s = translatedPath;
			}
			else
			{
				s = System.getProperty("user.home");
			}			
			translatedFile = new File(s + "/" + nameOfThisLemma + ".smt"); //"/temp.smt");
			
				//File.createTempFile("tempSMT", ".smt",new File(System.getProperty("user.dir")));
//			if(translatedFile.exists())
//			{
//				translatedFile.delete();
//			}
			if(!translatedFile.exists())
			{
				translatedFile.createNewFile();
			}						
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(translatedFile)));
			out.println(benchmark);
			out.println(":logic UNKNOWN");
			if(!sorts.isEmpty())
			{				
				String extrasorts = ":extrasorts (";
				for(int i = 0 ; i < sorts.size() ; i++)
				{
					extrasorts = extrasorts + " " + sorts.get(i);
				}
				extrasorts = extrasorts + ")";
				out.println(extrasorts);
			}
			
			if(!preds.isEmpty())
			{
				String extrafuns = ":extrapreds (";
				for(int i = 0 ; i < preds.size() ; i++)
				{
					extrafuns = extrafuns + "(" + preds.get(i).getFirstElement() 
					+ " " + preds.get(i).getSecondElement() + ")";
				}
				extrafuns = extrafuns + ")";
				out.println(extrafuns);
			}
			
			
			if(!funs.isEmpty())
			{
				String extrafuns = ":extrafuns (";
				for(int i = 0 ; i < funs.size() ; i++)
				{
					extrafuns = extrafuns + "(" + funs.get(i).getFirstElement() 
					+ " " + funs.get(i).getSecondElement() + ")";
				}
				extrafuns = extrafuns + ")";
				out.println(extrafuns);
			}
			
			
			
			out.println(":extramacros(");
			
			out.println("(union (lambda (?p1 ('t boolean)) (?q1 ('t boolean)) . (lambda (?x6 't) . (or (?p1 ?x6) (?q1 ?x6)))))");
			out.println("(emptyset (lambda (?x5 't). false))");
			out.println("(inter (lambda (?pd ('sd boolean))(?qd ('sd boolean)) . (lambda (?x7d 'sd) . (and (?pd ?x7d) (?qd ?x7d)))))");
			out.println("(setminus (lambda (?p2 ('t boolean)) (?q2 ('t boolean)) . (lambda (?x8 't) . (and (?p2 ?x8) (not (?q2 ?x8))))))");
			out.println("(in (lambda (?x9 't) (?p3 ('t boolean)) . (?p3 ?x9)))");
			out.println("(subseteq (lambda (?s ('t boolean)) (?h ('t boolean)) . (forall (?t 't). (implies (?s ?t) (?h ?t)))))");
			out.println("(subset (lambda (?p4 ('t boolean)) (?q3 ('t boolean)) . (and (subseteq ?p4 ?q3) 	(not (= ?p4 ?q3	)))))");
			
			out.println("(Nat (lambda (?i Int) . (<= 0 ?i)))");
			out.println("(ismax (lambda (?m Int) (?pi (Int boolean)) . (and (?pi ?m)(forall (?i1 Int) . (implies (?pi ?i1) (<= ?i1 ?m))))))");
			out.println("(ismin (lambda (?m2 Int) (?ta (Int boolean)) . (and(in ?m2 ?ta)(forall (?xb Int) . (implies (in ?xb ?ta)(<=?m2 ?xb))))))");
			out.println("(Nat1 (lambda (?i Int) . (<= 1 ?i)))");
			out.println("(cartesianproduct (lambda (?p12 ('t1 boolean)) (?q12 ('t2 boolean)) . (lambda (?x1 't1) (?x2 't2) . (and (?p12 ?x1) (?q12 ?x2)))))");			
			out.println("(range (lambda (?i1 Int) (?i2 Int) . (lambda (?i Int) . (and (<= ?i1 ?i) (<= ?i ?i2)))))");			
			out.println("(subseteq2 (lambda (?p11 ('t1 't2 boolean)) (?q ('t1 't2 boolean)) . (forall (?x1 't1) (?x2 't2) . (implies (?p11 ?x1 ?x2) (?q ?x1 ?x2)))))");
			out.println("(union2 (lambda (?p2c ('t1c 't2c boolean)) (?q2c ('t1c 't2c boolean)) . (lambda (?x1c 't1c) (?x2c 't2c) . (or (?p2c ?x1c ?x2c) (?q2c ?x1c ?x2c)))))");
			out.println("(emptyset2 (lambda (?x 't1) (?y 't2). false))");
			out.println("(inter2 (lambda (?p ('t1 't2 boolean)) (?q ('t1 't2 boolean)) . (lambda (?x 't1) (?y 't2) . (and (?p ?x ?y) (?q ?x ?y)))))");
			out.println("(pair (lambda (?e1 't) (?e2 't) . (lambda (?f1 't) (?f2 't) . (and (= ?f1 ?e1) (= ?f2 ?e2)))))");			
			out.println("(finite (lambda (?tb ('s boolean)) (?pe boolean) (?f ('s Int)) (?k Int).(iff ?pe (and (forall (?xa 's).(implies (in ?xa ?tb)(in (?f ?xa)(range 1 ?k))))(forall (?xa 's)(?ya 's).(implies (and (in ?xa ?tb)(in ?ya ?tb)(not (= ?xa ?ya)))(not (= (?f ?xa)(?f ?ya)))))))))");
			
			if(hasNewOperator)
			{
				//Domain, range and relational image
				out.println("(domain (lambda (?r ('t1 't2 boolean)) . (lambda (?x1 't1) . (exists (?x2 't2) . (?r ?x1 ?x2)))))");
				out.println("(ran (lambda (?r ((pair 's 't) boolean) (lambda (?y 't)(exists (?x 's)(r (pair ?x ?y)))))))");
				out.println("(img (lambda (?r ((pair 's 't) boolean)(?p ('s boolean) (lambda (?y 't) (exists (?x 's) (and (?p ?x)(r (pair ?x ?y)))))))))");
				
				//Todas essas macros estão feitas sem os pontos, inclusive a macro img acima
				//Domain restriction and subtraction, range restriction and subtraction
				out.println("(domr (lambda (?r ((pair 's 't) boolean)(?s ('s boolean)) (lambda (?p (pair 's 't)(and (?r ?p)(?s (fst ?p)))))))) ");
				out.println("(doms (lambda (?r ((pair 's 't) boolean)(?s ('s boolean)) (lambda (?p (pair 's 't)(and (?r ?p)(not (?s (fst ?p)))))))))");
				out.println("(ranr (lambda (?r ((pair 's 't) boolean)(?s ('t boolean)) (lambda (?p (pair 's 't)(and (?r ?p)(?s (snd ?p))))))))");
				out.println("(rans (lambda (?r ((pair 's 't) boolean)(?s ('t boolean)) (lambda (?p (pair 's 't)(and (?r ?p)(not (?s (snd ?p)))))))))");
				
				//Inverse, composition, overwrite and identidy
				out.println("(inv (lambda (?r ((pair 's 't) boolean) (lambda (?p (pair 's 't)(?r(pair (snd ?p)(fst ?p))))))))");
				out.println("(comp (lambda (?r1 ((pair 's 't) boolean)(?r2 ((pair 't 'u) boolean) (lambda (?p (pair 's 'u)) (exists (?x 't)(and (?r1 (pair (fst ?p) ?x)) (?r2 (pair ?x (snd ?p))))))))))");
				out.println("(ovr (lambda (?r1 ((pair 's 't) boolean)(?r2 ((pair 's 't) boolean) (lambda (?p (pair 's 'u))(or (?r2 ?p)(and (?r1 ?p)(not(exists(?q (pair 's 't)) (and (?r2 ?q) (= (fst ?q)(fst ?p)))))))))))) ");
				out.println("(id (lambda (?s ('t boolean)) (lambda ?p (pair 't 't)) (and (?s (fst ?p)) (= (fst ?p)(snd ?p)))))");
				
				//Auxiliary properties on relations
				out.println("(funp (lambda (?R ((pair 's 't) boolean)) (forall (?p (pair 's 't))(?p1 (pair 's 't)) (implies (and (?R ?p)(?R ?p1))(implies (= (fst ?p)(fst ?p1))(= (snd ?p)(snd ?p1)))))))");
				out.println("(injp (lambda (?R ((pair 's 't) boolean))(funp (inv ?R))))");
				out.println("(totp (lambda (?X ('s boolean))(?R((pair 's 't) boolean)) (forall (?p (pair 's 't)) (= (?R ?p)(?X (fst ?p))))))");
				out.println("(surp (lambda (?Y ('t boolean))(?R ((pair 's 't) boolean)) (forall (?p (pair 's 't)) (= (?R ?p)(?Y (snd ?p))))))");
				
				//Sets of relations, functions (partial/total, injective/surjective/bijective);
				out.println("(rel  (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean)) (forall (?p (pair 's 't)) (implies (?R ?p)(and (?X (fst ?p))(?Y (snd ?p))))))))");
				out.println("(pfun (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((rel ?X ?Y)  ?R) (funp ?R)))))");
				out.println("(tfun (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((pfun ?X ?Y) ?R)(totp ?X ?R)))))");
				out.println("(pinj (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((pfun ?X ?Y) ?R)(injp ?R)))))");
				out.println("(tinj (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((pinj ?X ?Y) ?R)(totp ?X ?R)))))");
				out.println("(psur (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((pfun ?X ?Y) ?R)(surp ?Y ?R)))))");
				out.println("(tsur (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((psur ?X ?Y) ?R)(totp ?X ?R)))))");
				out.println("(bij  (lambda (?X ('s boolean))(?Y ('s boolean)) (lambda (?R ((pair 's 't) boolean))(and ((tsur ?X ?Y) ?R)((tinj ?X ?Y) ?R)))))");
			}
			
			numberOfSingleLemma = macrosOfSets.size()+1;
			for(int i = 0 ; i < macrosOfSets.size() ; i++)
			{
				if(macrosOfSets.get(i).getThirdElement() == SINGLE_SET)
				{
					out.println("("+macrosOfSets.get(i).getFirstElement().getFirstElement() + " (lambda (?elem"+macrosOfSets.get(i).getFirstElement().getSecondElement() + " " + macrosOfSets.get(i).getFourthElement().getFirstElement()+") . (or");
					for(int j = 0 ; j < macrosOfSets.get(i).getSecondElement().size() ; j++)
					{
						out.println("\t(= ?elem"+macrosOfSets.get(i).getFirstElement().getSecondElement()+" "+macrosOfSets.get(i).getSecondElement().get(j).getFirstElement()+")");
					}
					out.println(")))");
				}
				else
				{
					String s1 = "?elem"+numberOfSingleLemma;
					String s2 = "?elem"+(numberOfSingleLemma+1);
					String p1 = "?elem"+numberOfSingleLemma + " " + macrosOfSets.get(i).getFourthElement().getFirstElement();
					String p2 = "?elem"+(numberOfSingleLemma+1) + " " + macrosOfSets.get(i).getFourthElement().getSecondElement();
					out.println("("+macrosOfSets.get(i).getFirstElement().getFirstElement() + " (lambda ("+ p1 + ") (" + p2 + ") . (or");
					for(int j = 0 ; j < macrosOfSets.get(i).getSecondElement().size() ; j++)
					{
						out.println("\t(= (pair " + s1 + " " + s2 + ") (pair " + macrosOfSets.get(i).getSecondElement().get(j).getFirstElement() + " " + macrosOfSets.get(i).getSecondElement().get(j).getSecondElement() + "))");
					}
					out.println(")))");
					numberOfSingleLemma = numberOfSingleLemma+2;
				}
			}			
			out.println(")");
			
			for(int i = 0; i < minMaxAssumptions.size() ; i ++ )
			{
				out.println(":assumption (" + minMaxAssumptions.get(i).getThirdElement() + " " 
						+ minMaxAssumptions.get(i).getFirstElement()
						+ " " + minMaxAssumptions.get(i).getSecondElement() + ")" );
			}
			
			if(setOfHypothesis != null && !setOfHypothesis.isEmpty())
			{
				for(int i = 0 ; i < setOfHypothesis.size() ; i++)
				{
					out.println(":assumption " + setOfHypothesis.get(i));
				}
			}
			if(parsedGoal != null &&  !parsedGoal.isEmpty())
			{
				out.println(":formula " + parsedGoal);
			}
			
			out.println(")");
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method extracts the type inside a powerset variable, that is,
	 * it returns the string inside a ℙ().  
	 * @param powerSet The String that is a powerset.
	 * @return If powerSet has the form ℙ(), this will return the string inside the parenthesis,
	 * else it only returns <code>powerSet</code>. 
	 */
	private Pair<String, Integer> getTypeOfSet(String type, boolean isSet)
	{
		
//		String[] split = type.split("↔");
//		if(split.length == 2)
//		{
//			String string1 = parseTypePar(operandSet.getSMTOperand(split[0]).trim());
//			String string2 = parseTypePar(operandSet.getSMTOperand(split[1]).trim());
//			type = operandSet.getSMTOperand(string1 + " " + string2);
//			return new Pair<String, Integer>(type, PAIR_SET);
//		}
//		else
//		{
		type = parseTypePar(type);
		type = operandSet.getSMTOperand(type);
		if(isSet)
		{
			return new Pair<String, Integer>(type, SINGLE_SET);
		}
		else
		{
			return new Pair<String, Integer>(type, SINGLE_VARIABLE);
		}		
	}
	
	/**
	 * If a string is name of a Set defined in a macro, it returns the type of this set. An example:
	 * Given this macro:
	 * 
	 * (enum (lambda (?val Int) . (or
	 *	(= ?val 3)
	 *	(= ?val 6)
	 *	(= ?val 9)
	 *	)))
	 *
	 *  If the value of <code>nameofSet</code> is <code>"val"</code>, then the method returns the type string "Int".
	 * 
	 *  
	 * @param nameOfSet the name of a Set declared as a macro.
	 * @return It's type, or the parameter itself, if there is no set with the same name of <code>nameOfSet</code>.
	 */
	private String getKindOfSet(String nameOfSet)
	{
		for(int i = 0 ; i < macrosOfSets.size() ; i++)
		{
			if(macrosOfSets.get(i).getFirstElement().getFirstElement().equals(nameOfSet))
			{
				return macrosOfSets.get(i).getFourthElement().getFirstElement();
			}
		}
		return nameOfSet;
	}
	
	
	/**
	 * This method verifies if <code>setEnumName</code> begins with <code>"enum"</code>, ,<code>"elem"</code> or <code>"p"</code>.
	 * If so, it verifies if the rest of the string is a Number. If so, it sums <code>numberOfSingleLemma</code> or <code>numberOfFiniteOp</code>,
	 * depending of the prefix. 
	 * This action is necessary to distinguish new from existing variables. See the description of <code>numberOfSingleLemma</code> and <code>numberOfFiniteOp</code>
	 * for more details.
	 * If <code>setEnumName</code> has a different prefix, the method does nothing. 
	 * @param setEnumName The String that will be evaluated according to the rules above.
	 */
	private void checkSetEnumName(String setEnumName)
	{
		if(setEnumName.startsWith("enum") && setEnumName.length() > 4)
		{
			String number = setEnumName.substring(4, setEnumName.length()-1);
			try
			{
				int num = Integer.parseInt(number);
				if(num > numberOfSingleLemma)
				{
					numberOfSingleLemma = num+1;
				}
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
				return;
			}
		}
		if(setEnumName.startsWith("elem") && setEnumName.length() > 4)
		{
			String number = setEnumName.substring(4, setEnumName.length()-1);
			try
			{
				int num = Integer.parseInt(number);
				if(num > numberOfFiniteOp)
				{
					numberOfFiniteOp = num+1;
				}
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
				return;
			}
		}
		if(setEnumName.startsWith("p") && setEnumName.length() > 1)
		{
			String number = setEnumName.substring(1, setEnumName.length()-1);
			try
			{
				int num = Integer.parseInt(number);
				if(num > numberOfFiniteOp)
				{
					pTerm = num+1;
				}
			}
			catch(NumberFormatException e)
			{
				return;
			}
		}
	}
	
	
	/**
	 * It verifies if a given String is a cartesian product. 
	 * 
	 * @param string A evaluated string.
	 * @return Yes, if it's a cartesian product, False otherwise.
	 */
	private boolean isCartesianProduct(String string)
	{
		for(int i = 0 ; i < string.length() ; i++)
		{
			if(string.charAt(i) == '×') //|| string.charAt(i) == '↔')
			{
				return true;
			}
		}
		return false;
	}
	
		
	/**
	 * This method checks if a String is a standard variable, a variable defined on the lemma or 
	 * a number. 
	 * @param chars The String to be checked.
	 * @return True if <code>chars</code> is a standard variable, a variable defined on the lemma or 
	 * a number, False otherwise. 
	 */
	@SuppressWarnings("unused")
	private boolean isOperand(String chars)
	{
		if (Translator.isNumber(chars))
		{
			return true;
		}
		if(chars.startsWith("{") && chars.endsWith("}"))
		{
			return true;
		}
		
		for(int i = 0 ; i < funs.size() ; i++)
		{
			if(chars.equals(funs.get(i).getFirstElement()))
			{
				return true;
			}		
		}		
		for(int i = 0 ; i < preds.size() ; i++)
		{
			if(chars.equals(preds.get(i).getFirstElement()))
			{
				return true;
			}		
		}
		for(int i = 0 ; i < sorts.size() ; i++)
		{
			if(chars.equals(sorts))
			{
				return true;
			}		
		}
		for(int i = 0 ; i < minMaxAssumptions.size() ; i++)
		{
			if(chars.equals(minMaxAssumptions.get(i).getFirstElement()))
			{
				return true;
			}
		}
		for(int i = 0 ; i < listOfVariables.size() ; i++)
		{
			if(chars.equals(listOfVariables.get(i).getFirstElement()))
			{
				return true;
			}
			if(chars.startsWith("{") && chars.endsWith("}"))
			{
				return true;
			}			
		}		
		return false;
	}
	
	/**
	 * This method checks if <code>evaluatedName</code> is a Sort. See the Translation paper for details.
	 * @param evaluatedName The variable to be evaluated if is a Sort or No.
	 * @return Yes if it's sort, False otherwise.
	 */
	private boolean isSort(String evaluatedName)
	{
		for(int i = 0 ; i < sorts.size() ; i++)
		{
			if(evaluatedName.equals(sorts.get(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method parses sets founds in the hypothesis and in the goal, i.e.,
	 * the substrings contained between '{' and '}'.
	 * @param symbol the substring between '{' and '}'
	 * @return the String which represent the parsed set and the type of variable (single set, pair set or single variable).
	 */
	private Triple<String, Integer,Integer> parseSet(String symbol)
	{
			String[] pieces = symbol.split(",");
			String[] elementOfSets = pieces[0].split(OperatorSet.PAIR_ARROW);
			if(elementOfSets.length == 1)
			{
				String type = getTypeOfVariable(pieces[0].trim()).getFirstElement();
				ArrayList<Pair<String,String>> setVars = new ArrayList<Pair<String,String>>();
				for(int i = 0 ; i < pieces.length ; i++)
				{
					setVars.add(new Pair<String, String>(pieces[i].trim(),""));
				}
				for(int i = 0 ; i < macrosOfSets.size() ; i++ )
				{
					//if(setVars.equals(macrosOfSets.get(i).getSmtOp()))
					if(Translator.isEqual(macrosOfSets.get(i).getSecondElement(), setVars))
					{
						return new Triple<String, Integer, Integer>(macrosOfSets.get(i).getFirstElement().getFirstElement(),SINGLE_SET,0);
					}
				}
				String name = "enum" + numberOfSingleLemma++;
				macrosOfSets.add(new DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>>
					(new Pair<String, Integer>(name,macrosOfSets.size()),setVars,SINGLE_SET,new Pair<String, String>(type,"")));
				return new Triple<String, Integer, Integer>(name,SINGLE_SET,0);		
			}
			else if(elementOfSets.length == 2)
			{
				String type1 = getTypeOfVariable(elementOfSets[0].trim()).getFirstElement();
				String type2 = getTypeOfVariable(elementOfSets[1].trim()).getFirstElement();
				ArrayList<Pair<String, String>> setVars = new ArrayList<Pair<String,String>>();
				for(int i = 0 ; i < pieces.length ; i++)
				{
					elementOfSets = pieces[i].split(OperatorSet.PAIR_ARROW);
					setVars.add(new Pair<String, String>(elementOfSets[0].trim(),elementOfSets[1].trim()));
				}
				for(int i = 0 ; i < macrosOfSets.size(); i++)
				{
					if(Translator.isEqual(macrosOfSets.get(i).getSecondElement(), setVars))
					//if(setVars.equals(macrosOfSets.get(i).getSmtOp()))
					{
						return new Triple<String, Integer, Integer>(macrosOfSets.get(i).getFirstElement().getFirstElement(),PAIR_SET,0);
					}
				}
				String name = "enum" + numberOfSingleLemma++;
				macrosOfSets.add(new DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>>
				(new Pair<String, Integer>(name,macrosOfSets.size()),setVars,PAIR_SET,new Pair<String, String>(type1,type2)));
				return new Triple<String, Integer,Integer>(name, PAIR_SET,0);
								
			}				
			return new Triple<String, Integer,Integer>(symbol, SINGLE_VARIABLE,0);
	}
	
	
	/** Returns the type of a variable. The Pair returned contains the type and a number
	 * which says if it is a single variable, single set, pair set...
	 * 
	 * @param var the variable.
	 * @return the <code>var</code> type.
	 */
	private Pair<String, Integer> getTypeOfVariable(String var)
	{
				
		if(Translator.isNumber(var))
		{
			return new Pair<String, Integer>("Int", SINGLE_VARIABLE);
		}
		for(int i = 0 ; i < funs.size() ; i++)
		{
			if(var.equals(funs.get(i).getFirstElement()))
			{
				return new Pair<String, Integer>(funs.get(i).getSecondElement(), funs.get(i).getThirdElement());
			}
		}
		for(int i = 0 ; i < preds.size() ; i++)
		{
			if(var.equals(preds.get(i).getFirstElement()))
			{
				return new Pair<String, Integer>(preds.get(i).getSecondElement(), preds.get(i).getThirdElement());
			}			
		}
		for(int i = 0 ; i < sorts.size() ; i++)
		{
			if(var.equals(sorts.get(i)))
			{
				return new Pair<String, Integer>(sorts.get(i),SINGLE_SET);
			}
		}
		for(int i = 0 ; i < listOfVariables.size() ; i++)
		{
			if(listOfVariables.get(i).getFirstElement().equals(var))
			{
				return new Pair<String, Integer>(listOfVariables.get(i).getSecondElement(),SINGLE_SET);
			}			
		}
		return new Pair<String, Integer>(operandSet.getSMTOperand(var), SINGLE_SET);
	}
	
	/**
	 *  This method adds an operator in the list of used operators of the lemma. They are not duplicated.
	 *  
	 * @param op The operator to be added in the list of used operators.
	 */
	private void addUsedOperator(String op)
	{
		for(int i = 0 ; i < usedOperators.size() ; i++)
		{
			if(op.equals(usedOperators.get(i)))
			{
				return;
			}
		}
		usedOperators.add(op);
	}
	
	
	/**
	 * This method adds a theory in the list of used theories of the lemma. They are not duplicated.
	 * @param the theory to be added in the list of theories.
	 */
	private void addUsedTheory(String theory)
	{
		for( int i = 0 ; i < usedTheories.size() ; i++)
		{
			if(theory.equals(usedTheories.get(i)))
			{
				return;
			}
		}
		usedTheories.add(theory);
	}
	
	
	
	
	/**
	 * This method is called through other parseHypothesis method which receives
	 * a String as parameter. this method receives a list with a operand
	 * or operator in each space, in the same order as the hypothesis or the goal
	 * String.
	 * <br></br> 
	 * Before this method is called, it is necessary to parse some special types of operand
	 * and operators, so it is far not recommended to split the hypothesis String
	 * and use this method directly.
	 * <br></br> 
	 * @param hypo the list filled with the operands and operators of the hypothesis
	 * that will be translated, in the same order as it appears in the 
	 * hypothesis and the goal String.
	 * @return The parsed hypothesis.
	 * @throws HypothesisException 
	 */
	private String parseHypothesis(ArrayList<Triple<String, Integer,Integer>> hypo) throws HypothesisException
	{
		int parenthesisLevel = 0;
		boolean needOperator = true;
		ArrayList<Relation> operators = new ArrayList<Relation>();
		LinkedList<Relation> operands = new LinkedList<Relation>(); 
		for(int i = 0, j = 0 ; i < hypo.size() ; i++)
		{			
			if(hypo.get(i).getFirstElement().trim().equals("(")  )
			{
				parenthesisLevel += 1;
			}
			else if(hypo.get(i).getFirstElement().equals(")")  )
			{
				parenthesisLevel -= 1;
			}
			else if(operatorSet.isOperator(hypo.get(i).getFirstElement()))
			{
				operators.add(new Relation(hypo.get(i).getFirstElement(),j,parenthesisLevel,hypo.get(i).getSecondElement()));
				++j;
			}
			else
			{
				Relation s = new Relation(hypo.get(i).getFirstElement(),j,parenthesisLevel,hypo.get(i).getSecondElement());
				if(needsQuestionMark(s.getSymbol()))
				{
					s.setNeedsQuestionMark(true);
				}
				operands.add(s);
				++j;				
			}
			
		}
		Collections.sort(operators);
		for(int i = 0 ; i < operators.size() ; i++)
		{
			Relation before = new Relation();
			Relation after = new Relation();
			Relation r = new Relation();
			ArrayList<Integer> pos = new ArrayList<Integer>();
			String symbol = operators.get(i).getSymbol();
			if(OperatorSet.isNewOperator(symbol))
			{
				hasNewOperator = true;
			}			
			String mappedSymbol = operatorSet.getSMTOperator(symbol);
			
			addUsedOperator(mappedSymbol);
			
			int type = OperatorSet.operatorType(symbol);
						
			if(type == LEFT_ONLY || type == BOTH_SIDES)
			{
				firstFor:for(int j = 0 ; j < operands.size() ; j++)
				{
					ArrayList<Integer> positions = operands.get(j).getPositions();
					for(int k = 0 ; k < positions.size() ; k++)
					{
						if(positions.get(k).intValue() == operators.get(i).getPositions().get(0).intValue() - 1)
						{
							before = operands.get(j);
							//before = " " + operands.get(j).getSymbol();
							pos.addAll(positions);								
							operands.remove(j);
							break firstFor;
						}
					}
				}
			}
			
			if(type == RIGHT_ONLY || type == BOTH_SIDES)
			{
				firstFor:for(int j = 0 ; j < operands.size() ; j++)
				{
					ArrayList<Integer> positions = operands.get(j).getPositions();
					for(int k = 0 ; k < positions.size() ; k++)
					{
						if(positions.get(k).intValue() == operators.get(i).getPositions().get(0).intValue() + 1)
						{
							after = operands.get(j);
							//after = " " + operands.get(j).getSymbol();
							pos.addAll(positions);
							operands.remove(j);
							break firstFor;
						}
					}
				}
			}
			if(type == BOTH_SIDES)
			{
				if(before.getSymbol().equals("emptyset"))
				{
					if(after.getTypeOfRelation().equals(PAIR_SET))
					{
						before.setSymbol(before.getSymbol() + 2);
						before.setTypeOfRelation(PAIR_SET);
					}
				}
				if(after.getSymbol().equals("emptyset"))
				{
					if(before.getTypeOfRelation().equals(PAIR_SET))
					{
						after.setSymbol(after.getSymbol() + 2);
						after.setTypeOfRelation(PAIR_SET);
					}
				}
			}								
			pos.addAll(operators.get(i).getPositions());
			r.setPositions(pos);
			if(symbol.equals("="))
			{
				if(isSort(before.getSymbol()))
				{
					DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>> enumSet = getEnumSet(after.getSymbol());
					{
						if(enumSet != null)
						{
							++numberOfSingleLemma;
							String forall = "(forall (?elem"+numberOfSingleLemma+" "+enumSet.getFourthElement().getFirstElement() + ") (or";
							for(int k = 0 ; k < enumSet.getSecondElement().size() ; k++)
							{
								forall = forall + " (= ?elem"+ numberOfSingleLemma + " " + enumSet.getSecondElement().get(k).getFirstElement() + ")";
							}
							forall = forall + "))";
							after.setSymbol(forall);
							before.setSymbol("");
							needOperator = false;
							++numberOfSingleLemma;
						}
					}
				}
				else if(isSort(after.getSymbol()))
				{
					DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>> enumSet = getEnumSet(before.getSymbol());
					{
						if(enumSet != null)
						{
							String forall = "(forall (?elem"+numberOfSingleLemma+" "+enumSet.getFourthElement().getFirstElement() + "(or";
							for(int k = 0 ; k < enumSet.getSecondElement().size() ; k++)
							{
								forall = forall + " (= ?elem"+numberOfSingleLemma+ " " + enumSet.getSecondElement().get(k).getFirstElement() + ")";
							}
							forall = forall + "))";
							before.setSymbol(forall);
							after.setSymbol("");
							needOperator = false;
						}
					}
				}
			}
			if(mappedSymbol.equals("-"))
			{
				if(before == null)
				{
					before = new Relation();
					before.setTypeOfRelation(null);
				}
			}			
			int e = resultTypeOfOperation(before.getTypeOfRelation(),after.getTypeOfRelation(),mappedSymbol,type);
			if(symbol.equals(OperatorSet.IN))
			{
				if(before.getTypeOfRelation() == NOT_DEFINED && after.getTypeOfRelation() == SINGLE_SET)
				{
					String kind = getKindOfSet(after.getSymbol());
					funs.add(new Triple<String, String, Integer>(before.getSymbol(),kind,SINGLE_VARIABLE));
				}
				else if(after.getTypeOfRelation() == NOT_DEFINED && before.getTypeOfRelation() == SINGLE_SET)
				{
					String kind = getKindOfSet(before.getSymbol());
					funs.add(new Triple<String, String, Integer>(after.getSymbol(),kind,SINGLE_VARIABLE));
				}
				else if(e == SINGLE_SET)
				{
					mappedSymbol = "subseteq";
				}
			}				
			if((symbol.equals(OperatorSet.SUBSETEQ) || symbol.equals(OperatorSet.UNION) || symbol.equals(OperatorSet.INTER)) && e == PAIR_SET)
			{
				mappedSymbol = mappedSymbol + '2';
				r.setTypeOfRelation(PAIR_SET);
			}
			else
			{
				r.setTypeOfRelation(resultTypeOfOperation(before.getTypeOfRelation(),after.getTypeOfRelation(),mappedSymbol,type));
			}		
			String fullString = "";
			if(needOperator)
			{
				fullString = "(" + mappedSymbol;
			}
			if(!before.getSymbol().equals(""))
			{
				if(before.isNeedsQuestionMark())
				{
					before.setSymbol("?"+before.getSymbol());
				}
				fullString = fullString + " " + before.getSymbol();
			}
			if(!after.getSymbol().equals(""))
			{
				if(after.isNeedsQuestionMark())
				{
					after.setSymbol("?"+after.getSymbol());
				}
				fullString = fullString + " " + after.getSymbol();
			}
			if(needOperator)
			{
				fullString = fullString + ")";
			}			
			needOperator = true;
			r.setSymbol(fullString);
			operands.add(r);
		}
		return operands.get(0).getSymbol();
			
	}
	
	
	/**
	 * 
	 * @param statement
	 * @return
	 * @throws HypothesisException
	 */
	private Pair<String,Integer> createSetFromCardStatement(String statement) throws HypothesisException
	{
		String[] rangeSplit = statement.split("‥");
		if(rangeSplit.length > 1)
		{
			String first = parseHypothesis(rangeSplit[0].trim());
			String second = parseHypothesis(rangeSplit[1].trim());
			setOfHypothesis.add("(in elem" + numberOfFiniteOp + " (range " + first + " " + second + "))");
			String name = "elem" + (numberOfSingleLemma-1);
			return new Pair<String, Integer>("Int",SINGLE_SET);
		}
		else
		{
			Pair<String, Integer> cardVarType = getTypeOfVariable(statement.trim());
			return cardVarType;
		}
	}
	
	/**
	 * 
	 * @param enumS
	 * @return
	 */
	private DoublePair<Pair<String,Integer>, ArrayList<Pair<String,String>>, Integer, Pair<String,String>> getEnumSet(String enumS)
	{
		for(int i = 0 ; i < macrosOfSets.size() ; i++)
		{
			if(enumS.equals(macrosOfSets.get(i).getFirstElement().getFirstElement()))
			{
				return macrosOfSets.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Given two operands and the operator, it returns the result type of them. The types that can be returned 
	 * are <code>PAIR_SET</code>, <code>SINGLE_SET</code>, or <code>SINGLE_VARIABLE</code>.
	 * If one of the operators are null, the method returns the type of the other operand.    
	 * 
	 * @param type1 The first operand.
	 * @param type2 The second operand.
	 * @param operator The operator.
	 * @param sideType It defines if the operator is, or only one of the operands will be evaluated.
	 * 			if sideType == BOTH_SIDES, then it's a binary relation.
	 * @return
	 */
	private int resultTypeOfOperation(Integer type1,Integer type2,String operator,int sideType)
	{
		operator = operator.trim();
		if(operator.equals("-"))
		{
			if(type1 == null)
			{
				return type2.intValue();
			}
		}
		if(sideType == BOTH_SIDES)
		{
			if(type1.intValue() == SINGLE_SET && type2.intValue() == SINGLE_SET && operator.equals("cartesianproduct"))
			{
				return PAIR_SET;
			}
			else if(type1.intValue() == SINGLE_SET && type2.intValue() == SINGLE_SET)
			{
				return SINGLE_SET;
			}
			else if(type1.intValue() == PAIR_SET && type2.intValue() == PAIR_SET)
			{
				return PAIR_SET;
			}
			else return SINGLE_VARIABLE;
		}
		else if(sideType == RIGHT_ONLY)
		{
			if(operator.equals("domain"))
			{
				return SINGLE_SET;
			}
			return type2.intValue();
		}
		else return type1.intValue();		
				
	}	
	/**
	 * It parses the operators 'min' and 'max', according to the ABZ Document.
	 * @param type The substring which is held by the 'max' or 'min' statement, i.e.,
	 * The substring between '(' and ')' that belongs to the operator.
	 * @param operator If it is 'min' or 'max'. Any other string put as parameter
	 * will be saved normally.
	 * @return the name of the variable which represents the parsed operand.
	 * @throws HypothesisException If the String type has not a valid syntax.
	 */
	private String addMinMaxStatement(String type,String operator) throws HypothesisException
	{
		String content = parseHypothesis(type);
		for(int i = 0 ; i < minMaxAssumptions.size() ; i++ )
		{
			if(minMaxAssumptions.get(i).getSecondElement().equals(content))
				return minMaxAssumptions.get(i).getFirstElement();
		}
		String name = "m" + minMaxAssumptions.size();
		funs.add(new Triple<String, String, Integer>(name, "Int", SINGLE_VARIABLE));
		minMaxAssumptions.add(new Triple<String, String, String>(name, content, "is" + operator));
		return name;	
	}
	
	/**
	 * 
	 * @param hypoth
	 * @return
	 * @throws HypothesisException
	 */
	private String parseHypothesis(String hypoth) throws HypothesisException
	{
		addQuotedElementsToHash(hypoth);
		String string = "";
		String operator = "";
		int status = NONE;
		int parenthesis = 0;
		ArrayList<Triple<String, Integer,Integer>> terms = new ArrayList<Triple<String,Integer,Integer>>();
		for(int i = 0 ; i < hypoth.length() ; i++ )
		{
			if(hypoth.charAt(i) == 'ℙ')
			{
				String partsString = "";
				++i;
				while(!(hypoth.charAt(i) == ')') && i < hypoth.length() )
				{
					partsString = partsString + hypoth.charAt(i);
					++i;
				}
				if(i < hypoth.length() && hypoth.charAt(i) == ')')
				{
					partsString = partsString + ')';
				}
				if(partsString.trim().startsWith("(") && partsString.trim().endsWith(")") )
				{
					Pair<String, Integer> typeO = getTypeOfSet(partsString.substring(1,partsString.length()-1),true);
					terms.add(new Triple<String, Integer, Integer>(typeO.getFirstElement(), typeO.getSecondElement(), 0));
					string = "";
					status = NONE;
					continue;
				}
			}		
			if(hypoth.charAt(i) == '(')
			{
				if(string.equals("max")||string.equals("min"))
				{
					String set = "";
					++i;
					int pLevel = 1;
					while(pLevel != 0)
					{
						if(hypoth.charAt(i) == '(')
						{
							++pLevel;
						}
						else if(hypoth.charAt(i) == ')')
						{
							--pLevel;
						}
						if(pLevel == 0)
						{
							break;
						}
						else
						{
							set = set + hypoth.charAt(i);
							++i;
						}						
					}
					terms.add(new Triple<String, Integer,Integer>(addMinMaxStatement(set, string), INTEGER_VARIABLE,0));
					addUsedOperator(string);
					string = "";
					continue;
				}
				else if (string.equals("card"))
				{
					++i;
					String cardVar = "";
					while(hypoth.charAt(i) != ')')
					{
						cardVar = cardVar + hypoth.charAt(i);
						++i;
					}
					Pair<String,Integer> cardVarType = createSetFromCardStatement(cardVar);					
					//Pair<String, Integer> cardVarType = getTypeOfVariable(cardVar);
					String first = "elem" + numberOfFiniteOp++;
					String second = "elem" + numberOfFiniteOp++;
					funs.add(new Triple<String, String, Integer>(first,"Int",SINGLE_VARIABLE));
					funs.add(new Triple<String, String, Integer>(second,cardVarType.getFirstElement() + " Int",SINGLE_VARIABLE));
					setOfHypothesis.add("(> " + first + " 0)");
					String third = "elem" + numberOfFiniteOp++;
					String fourth = "elem" + numberOfFiniteOp++;
					String fifth = "elem" + numberOfFiniteOp++;
					String cardHypothesis = "(forall (?" + third 
					+ " " + cardVarType.getFirstElement() + " ) (and (<= 1 (" + second + " ?" + third
					+ ")) (<= (" + second + " ?" + third + ") " + first + ")))";
					setOfHypothesis.add(cardHypothesis);
					cardHypothesis = "(forall (?" + fourth + " Int) (implies (in ?" + fourth + " (range 1 " 
					+ first + ")) (exists (?" + fifth + " " + cardVarType.getFirstElement()
					+ ") (= (" + second + " ?" + fifth + ") ?" + fourth + "))))";
					setOfHypothesis.add(cardHypothesis);
					terms.add(new Triple<String, Integer, Integer>(first,SINGLE_VARIABLE,0));
					addUsedOperator(string);
					string = "";
					continue;
				}
				else if(string.equals("finite"))
				{
					++i;
					String finiteVar = "";
					while(hypoth.charAt(i) != ')')
					{
						finiteVar = finiteVar + hypoth.charAt(i);
						++i;
					}
					String first = "p"+pTerm++;
					String third = "elem"+numberOfFiniteOp++;
					String fourth = "elem"+numberOfFiniteOp++;					
					preds.add(new Triple<String, String, Integer>(first,"",SINGLE_VARIABLE));
					funs.add(new Triple<String, String, Integer>(third,"Int Int",SINGLE_VARIABLE));
					funs.add(new Triple<String, String, Integer>(fourth,"Int",SINGLE_VARIABLE));
					String finiteAssumption = "(finite " + finiteVar + " " + first + " " + third + " " +  fourth + ")";
					terms.add(new Triple<String, Integer, Integer>(finiteAssumption,SINGLE_VARIABLE,0));
					addUsedOperator(string);
					string = "";				
					continue;
				}
				else
				{
					parenthesis += 1;
					if(i > 0)
						status = OPERATOR_ONLY;
					operator = String.valueOf(hypoth.charAt(i));
				}
			}
			else if(hypoth.charAt(i) == ')')
			{
				parenthesis -= 1;
				status = ALL_OPERATIONS;
				operator = String.valueOf(hypoth.charAt(i));
			}
			else if(hypoth.charAt(i) == ' ')
			{
				status = ALL_OPERATIONS;
			}
			else if (operatorSet.isOneLengthOperator(hypoth.charAt(i)))
			{
				operator = String.valueOf(hypoth.charAt(i));
				status = OPERANDS_ONLY;
			}
			else if(operatorSet.isNotImplementedOneLengthOperator(hypoth.charAt(i)))
			{
				problemsEncountered.add("Lemma: \"" + hypoth + "\": The operator " + hypoth.charAt(i) + " is not suppported yet. The translation of this lemma was aborted.");
				return "";
				
			}
			else if(hypoth.charAt(i) == '{')
			{
				String set = "";
				++i;
				while(!(hypoth.charAt(i) == '}'))
				{
					set = set + hypoth.charAt(i);
					++i;
				}
				Triple<String, Integer,Integer> mappedOperand = parseSet(set);
				terms.add(mappedOperand);
				
				listOfVariables.add(new Triple<String, String,Integer>(mappedOperand.getFirstElement(),mappedOperand.getFirstElement(),0));
				string = "";
				operator = "";
			}
			else
			{
				string = string + hypoth.charAt(i);
				status = NONE;
				continue;
			}
			if((status == OPERATOR_ONLY || status == ALL_OPERATIONS) && operatorSet.isOperator(string) )
			{
				if(string.equals("mod"))
				{
					funs.add(new Triple<String, String, Integer>("mod","Int Int Int",OPERATOR));
				}
				terms.add(new Triple<String, Integer,Integer>(string, OPERATOR,0));
				string = "";
			}
			if(status == OPERANDS_ONLY || status == ALL_OPERATIONS)
			{
				if(operandSet.isOperand(string))
				{
					string = operandSet.getSMTOperand(string);
					listOfVariables.add(new Triple<String, String,Integer>(string, string,0));	
					Pair<String, Integer> type0 = getTypeOfVariable(string);
					terms.add(new Triple<String, Integer,Integer>(string,type0.getSecondElement(),0));
					string = "";
				}
				else if(string.trim().length() > 0 && !operator.trim().equals(OperatorSet.FORALL)) 
				{
					Triple<String, String,Integer> var = getOperand(string);
					terms.add(new Triple<String, Integer,Integer>(var.getFirstElement(),var.getThirdElement(),0));
					string = "";
				} 	
			}
			if(operator.equals(OperatorSet.FORALL) || operator.equals(OperatorSet.EXISTS))
			{
				++i;
				string = "";
				while(hypoth.charAt(i) != OperatorSet.MIDDLE_POINT )
				{
					string = string + hypoth.charAt(i);
					++i;
				}
				String[] newVars = string.split(",");
				{
					String varAndType = "";
					for(int z = 0 ; z < newVars.length ; z++ )
					{
						listOfVariables.add(new Triple<String, String,Integer>(newVars[z].trim(),"Int",1));
						varAndType = varAndType + "(?" + newVars[z].trim() + " Int)";
						listOfVariables.add(new Triple<String, String,Integer>(varAndType, "Int",0));
					}
					terms.add(new Triple<String, Integer,Integer>(varAndType, SINGLE_VARIABLE,0));
					terms.add(new Triple<String, Integer,Integer>(operator, OPERATOR,0));
					string = "";
					operator = "";
				}			
				status = NONE;
				continue;
			}
			if(!operator.isEmpty())
			{
				terms.add(new Triple<String, Integer,Integer>(operator, OPERATOR,0));
				operator = "";
			}			
		}	
		if(string.length() > 1 && operatorSet.isNotImplementedOperator(string))
		{
			problemsEncountered.add("Lemma: \"" + hypoth + "\": The operator " + string + " is not suppported yet. The translation of this lemma was aborted.");
			return "";
		}
		
		if(operandSet.isOperand(string))
			{
				string = operandSet.getSMTOperand(string);
				listOfVariables.add(new Triple<String, String,Integer>(string, string,0));					
				terms.add(new Triple<String, Integer,Integer>(string, SINGLE_SET,0));
				string = "";
			}
			else if(string.trim().length() > 0)
			{
				Triple<String, String,Integer> var = getOperand(string);
				terms.add(new Triple<String, Integer,Integer>(var.getFirstElement(),var.getThirdElement(),0));
				string = "";
			} 	
		if(!string.equals("") || parenthesis != 0)
			throw new HypothesisException();
		return parseHypothesis(terms);
	}

	private Triple<String, String,Integer> getOperand(String string)
	{
		if(Translator.isNumber(string))
		{
			return new Triple<String, String, Integer>(string, string,SINGLE_VARIABLE);
		}
		for(int i = 0 ; i < funs.size() ; i++ )
		{
			if(funs.get(i).getFirstElement().equals(string))
			{
				return funs.get(i);
			}
		}	
		for(int i = 0 ; i < preds.size() ; i++ )
		{
			if(preds.get(i).getFirstElement().equals(string))
			{
				return preds.get(i);
			}
		}
		for(int i = 0 ; i < sorts.size() ; i++)
		{
			if(sorts.get(i).equals(string))
			{
				return new Triple<String, String, Integer>(string, string, SINGLE_SET);
			}
		}
		for(int i = 0 ; i < listOfVariables.size() ; i++)
		{
			if(listOfVariables.get(i).getFirstElement().equals(string))
			{
				return new Triple<String, String, Integer>(string,"Int",SINGLE_VARIABLE);
			}
		}
		return new Triple<String, String, Integer>(string, string,NOT_DEFINED);
	}
	
	private boolean needsQuestionMark(String variable)
	{
		for(int i = 0 ; i < listOfVariables.size() ; i++)
		{
			if(listOfVariables.get(i).getFirstElement().equals(variable))
			{
				if(listOfVariables.get(i).getThirdElement().intValue() == 0)
					return false;
				return true;
			}
		}
		return false;
	}
	
	private Object[] split(String string)
	{
		ArrayList<String> p = new ArrayList<String>();
		String temp = "";
		for(int i = 0 ; i < string.length() ; i++)
		{
			if(string.charAt(i) == '|')
			{
				p.add(temp);
				temp = "";
			}
			else
			{
				temp = temp + string.charAt(i);
			}				
		}
		if(!temp.isEmpty())
		{
			p.add(temp);
		}
		return p.toArray();
	}
	
	private boolean checkTheories(ArrayList<String> requiredTheories)
	{
		for(int i = 0 ; i < usedTheories.size() ; i++ )
		{
			if(!requiredTheories.contains(usedTheories.get(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	public String getNameOfLemma1()
	{
		return nameOfThisLemma;
	}
	
	
	//private boolean parseLemma(Element lemma)
	private boolean parseLemma()
	{
		//NodeList theories = lemma.getElementsByTagName("theories");
		//if( theories.getLength() == 1)
		//{
		//	Element theoryset = (Element)theories.item(0);
		//	NodeList manyTheories = theoryset.getElementsByTagName("theory");
		//	for(int theorindex = 0 ; theorindex < manyTheories.getLength() ; theorindex++)
		//	{
		//		Element theory = (Element)manyTheories.item(theorindex);
		//		addUsedTheory(theory.getAttribute("name"));
		//	}
		//}
		for(int i = 0; i < lemmaData.getHypothesis().size() ; i++)
		{
			addUsedTheory(lemmaData.getHypothesis().get(i).getFirstElement());
		}		
		if(requiredTheories != null)
		{
			if( !checkTheories(requiredTheories))
			{
				return false;
			}
		}		
		//nameOfLemma = lemma.getElementsByTagName("title").item(0).getTextContent();
		nameOfLemma = lemmaData.getTitle();
		if(nameOfLemma.isEmpty())
		{
			//if(!lemma.getElementsByTagName("origin").item(0).getTextContent().isEmpty())
			if(!lemmaData.getOrigin().isEmpty())
			{
				Object[] origins = split(lemmaData.getOrigin());//(lemma.getElementsByTagName("origin").item(0).getTextContent());
				if (origins.length > 2)
				{
					nameOfLemma = ((String)origins[0]).trim() + "_" + ((String)origins[2]).trim();
				}
				else
				{
					nameOfLemma = ((String)origins[0]).trim(); 
				}
			}			
		}
		String normalNameOfLemma = nameOfLemma.replace('.', '_');
		normalNameOfLemma = normalNameOfLemma.replace('\\', '_');
		normalNameOfLemma = normalNameOfLemma.replace('/', '_');
		normalNameOfLemma = normalNameOfLemma.replace('-', '_');
		normalNameOfLemma = checkNameOfFile(normalNameOfLemma);
		nameOfThisLemma = normalNameOfLemma;		
				
		//NodeList typenv = lemma.getElementsByTagName("typenv");
		//if(typenv.getLength() > 0)
		//{
		//	if (!parseTypeEnv((Element)(typenv.item(0))))
		//	{
		//		return false;
		//	}
		//}
		//NodeList hypothesis = lemma.getElementsByTagName("hypothesis");
		//if(hypothesis.getLength() > 0)
		//{
			//for(int i = 0; i < hypothesis.getLength() ; i++ )
			//{
				//try
				//{
		parseTypeEnv();		
		if(!lemmaData.getHypothesis().isEmpty())
		{
			for(int i = 0 ; i < lemmaData.getHypothesis().size() ; i++)
			{
				try
				{					
					if(onlyTrueHypothesis == true)
					{
					//if(((Element)hypothesis.item(i)).getAttribute("needed").equals("true"))
						if(lemmaData.getHypothesis().get(i).getSecondElement() == true)
						{
							String tell = parseHypothesis(lemmaData.getHypothesis().get(i).getFirstElement());//(((Element)hypothesis.item(i)).getTextContent().trim());
							//System.out.println(tell);
							if(tell.isEmpty())
							{
								return false;
							//	setOfHypothesis.add(tell);								
							}			
							setOfHypothesis.add(tell);		
						}
					}
					else
					{
						String tell = parseHypothesis(lemmaData.getHypothesis().get(i).getFirstElement());//(((Element)hypothesis.item(i)).getTextContent().trim());
						//System.out.println(tell);
						if(tell.isEmpty())
						{
							return false;
							//	setOfHypothesis.add(tell);
						}			
						setOfHypothesis.add(tell);					
					}
				}
				catch(HypothesisException e)
				{
					problemsEncountered.add(e.getMessage());
				}
			}
		}
		//NodeList goal = lemma.getElementsByTagName("goal");
		//if(goal.getLength() > 0)
		if(!lemmaData.getGoal().isEmpty())
		{
			try
			{
				parsedGoal = parseGoal(lemmaData.getGoal());//((Element)goal.item(0));
				if(parsedGoal.isEmpty())
				{
					return false;
				}
			}
			catch(HypothesisException e)
			{
				problemsEncountered.add(e.getMessage());
			}
		}
		return true;
	}
	
	private String parseTypePar(String string)
	{
		if(string.contains(OperatorSet.CARTESIAN_PRODUCT))
		{
			String[] els = string.split(OperatorSet.CARTESIAN_PRODUCT);
			return "(pair " + operandSet.getSMTOperand(els[0].trim()) + " " + operandSet.getSMTOperand(els[1].trim()) + ")";
		}
		else if (string.contains(OperatorSet.RELATION))
		{
			String[] els = string.split(OperatorSet.RELATION);
			return "(pair " + operandSet.getSMTOperand(els[0].trim()) + " " + operandSet.getSMTOperand(els[1].trim()) + ")";
		}
		else
		{
			return operandSet.getSMTOperand(string);
		}
	}
	
	
	/**
	 * This method parses the variables of the lemma
	 * @param typeEnvironment The element of the document of the lemma which contains the variables.
	 */
	//private boolean parseTypeEnv(Element typeEnvironment)
	private boolean parseTypeEnv()
	{
		//NodeList variables = typeEnvironment.getElementsByTagName("variable");
		//if( variables.getLength() > 0)
		if(!lemmaData.getTypenv().isEmpty())
		{
			//for(int i = 0 ; i < variables.getLength() ; i++ )
			for(int i = 0 ; i < lemmaData.getTypenv().size() ; i++)
			{
				String varName = lemmaData.getTypenv().get(i).getFirstElement();//((Element)variables.item(i)).getAttribute("name").trim();
				String varType = lemmaData.getTypenv().get(i).getSecondElement();//((Element)variables.item(i)).getAttribute("type").trim();
				addQuotedElementsToHash(varName);
				addQuotedElementsToHash(varType);
//				if (isCartesianProduct(varType))
//				{
//					if(printDetails)
//					{
//						System.out.println("The type " + varType + " is a cartesian product. This type of variable is not implemented yet. The translation of this lemma was aborted.");
//					}
//					return false; 
//				}
			//	String[] split = varType.split("↔");
				
				//listOfVariables.add(new Triple<String, String,Integer>(varName, varType,0));		
				
				//Regra 4
				if(varName.equals(varType))
				{
					sorts.add(varType);
					checkSetEnumName(varType);
				}
				
				//Regra 6
				else if(varType.startsWith("ℙ"))
				{
					if(varType.charAt(1) == '(' && varType.endsWith(")"))
					{
						varType = varType.substring(2, varType.length()-1);
						Pair<String, Integer> parsedType = getTypeOfSet(varType, true);
						//varType = operandSet.getSMTOperand(getTypeOfPowerSet(varType));
						if(varName.equals(parsedType.getFirstElement()))
						{
							sorts.add(varType);
							checkSetEnumName(varType);
							
						}
						else
						{
							preds.add(new Triple<String, String, Integer>(varName,parsedType.getFirstElement() , parsedType.getSecondElement()));
							checkSetEnumName(varName);
						}					
					}
				}				
//				else if(split.length == 2)
//				{
//					Pair<String, Integer> parsedType = getTypeOfSet(varType, false);
//					preds.add(new Triple<String, String, Integer>(varName, parsedType.getFirstElement(), parsedType.getSecondElement()));
//					checkSetEnumName(varName);
//				}
				else
				{
					Pair<String, Integer> parsedType = getTypeOfSet(varType, false);
					funs.add(new Triple<String, String, Integer>(varName, parsedType.getFirstElement(), parsedType.getSecondElement()));
					checkSetEnumName(varName);	
				}				
			}	
			
		}
		return true;	
	}
	
	
	private String parseGoal(String goal) throws HypothesisException
	{
		String parsedGoal = parseHypothesis(lemmaData.getGoal()); //goal;//parseHypothesis(goal.getTextContent().trim());
		
		if(!parsedGoal.isEmpty())
		{
			parsedGoal = "(not " + parsedGoal + ")";
		}		
		return parsedGoal;
	}
	
	public void print()
	{
		System.out.println("Predicados: " + preds.toString() );
		System.out.println("Funcoes: " + funs.toString() );
		System.out.println("Conjuntos: " + sorts.toString() );
	}
}
