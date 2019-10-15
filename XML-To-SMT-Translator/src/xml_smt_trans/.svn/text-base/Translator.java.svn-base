package xml_smt_trans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 */

/**This class begins the Translation of from Rodin XML to SMT-LIB format.
 *  
 * @author Vitor Alcantara de Almeida
 * 
 * @see LemmaTranslator *
 */
public class Translator {
	
	public static String execProgram(String [] args) throws IOException
	{
		String ln;
		Process p = Runtime.getRuntime().exec(args);
		BufferedReader br = new BufferedReader
		(
			new InputStreamReader
			(
				p.getInputStream()
			)
		);
		String bufferedOut = "";
		while((ln = br.readLine()) != null) 
		{
			bufferedOut += ln;
		}
	//System.out.println("returns:" + p.exitValue());
		return bufferedOut;
	}
	
	
	/**This method removes all white spaces of the input String.
	 * 
	 * @param string The input String
	 * @return The input string without white spaces
	 */
	static public String getOffWhiteSpaces(String string)
	{
		String newString = new String();
		for(int i = 0; i < string.length() ; i++)
		{
			if(string.charAt(i) != ' ')
			{
				newString += string.charAt(i);				
			}
		}
		return newString;
	}
	
	public static ArrayList<LemmaData> createLemmaDatasFromRodinFile(String path) throws ParserConfigurationException, SAXException, IOException
	{
		File f = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);
		Element root = doc.getDocumentElement();
		NodeList nos = root.getElementsByTagName("lemma");
		ArrayList<LemmaData> listOfLemmas = new ArrayList<LemmaData>();
		for(int i = 0 ; i < nos.getLength() ; i++)
		{
			LemmaData ld = createLemmaDataFromRodinLemma((Element)nos.item(i));
			listOfLemmas.add(ld);
		}		
		return listOfLemmas;
	}
	
	private static LemmaData createLemmaDataFromRodinLemma(Element lemma)
	{
		LemmaData ld = new LemmaData();
		NodeList name = lemma.getElementsByTagName("title");
		if(name.getLength() > 0)
			ld.setTitle(name.item(0).getTextContent());
		name = lemma.getElementsByTagName("origin");
		if(name.getLength() > 0)
			ld.setOrigin(name.item(0).getTextContent());
		name = lemma.getElementsByTagName("theories");
		Element theoryset = (Element)name.item(0);
		NodeList manyTheories = theoryset.getElementsByTagName("theory");
		ArrayList<String> listOfTheories = new ArrayList<String>();
		for(int theorindex = 0 ; theorindex < manyTheories.getLength() ; theorindex++)
		{
			Element theory = (Element)manyTheories.item(theorindex);
			listOfTheories.add((theory.getAttribute("name")));
		}
		
		name = lemma.getElementsByTagName("typenv");
		if(name.getLength() > 0)
		{
			Element var = (Element)name.item(0);
			NodeList vars = var.getElementsByTagName("variable");
			if(vars.getLength() > 0)
			{
				ArrayList<Pair<String, String>> varValue = new ArrayList<Pair<String,String>>();
				for(int i = 0 ; i < vars.getLength() ; i++)
				{
					Element v = (Element)vars.item(i);
					varValue.add(new Pair<String, String>(v.getAttribute("name"), v.getAttribute("type")));
				}
				ld.setTypenv(varValue);
			}
			
		}
		
		
		name = lemma.getElementsByTagName("hypothesis");
		if(name.getLength() > 0)
		{
			ArrayList<Pair<String,Boolean>> listOfHypothesis = new ArrayList<Pair<String,Boolean>>();
			for(int i = 0 ; i < name.getLength() ; i++)
			{
				Element hyp = (Element)name.item(i);
				String att = hyp.getAttribute("needed");
				if(att.equals("true"))
				{
					listOfHypothesis.add(new Pair<String, Boolean>(hyp.getTextContent(),true));
				}
				else
				{
					listOfHypothesis.add(new Pair<String, Boolean>(hyp.getTextContent(),false));
				}
			}
			ld.setHypothesis(listOfHypothesis);
		}		
		
		name = lemma.getElementsByTagName("goal");
		{
			ld.setGoal(name.item(0).getTextContent());
		}		
		return ld;		
	}
	
	
	/** Verify if the input String is a Number(well, it checks if it is a float number).
	 * 
	 * @param chars the String to be verified
	 * @return true, if it is a number, false otherwise.
	 */
	static public boolean isNumber(String chars)
	{
		try
		{
			Float.parseFloat(chars);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	/**
	 * This method checks if two ArrayLists of objects of Pair<String,String> are equal. The two ArrayLists
	 * are equals if both have the same size and, for the same position in both arraylist, their objects in
	 * this position are equal. To compare the two pairs, is used the method <code>equals<code> that belong to
	 * them.  
	 * @param a The first array for comparison.
	 * @param b The second array for comparison. 
	 * @return True if they are equal, False if not.
	 * 
	 * @see Pair,ArrayList
	 */
	static public boolean isEqual(ArrayList<Pair<String,String>> a , ArrayList<Pair<String,String>> b)
	{
		if(a.size() != b.size())
		{
			return false;
		}
		for(int i = 0 ; i < a.size() ; i++)
		{
			if(!(a.get(i).equals(b.get(i))))
			{
				return false;
			}		
		}
		return true;
	}
	
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseXML(
			final ArrayList<LemmaData> listOfLemmas,
			final String PATH
			)throws ParserConfigurationException,SAXException,IOException
	{
		return parseLemmas(listOfLemmas, false, null, true, true);
	}
	
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseXML(
			final File xml,
			final String PATH
			)throws ParserConfigurationException,SAXException,IOException
	{
		return parseXML(xml, PATH, false, null, true, true,false);
	}
	
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseLemmas(
			final ArrayList<LemmaData> ld,
			final String PATH
			)throws ParserConfigurationException,SAXException,IOException
	{
		return parseLemmas(ld, false, null, true, true);
	}
	
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseLemmas(
			final ArrayList<LemmaData> listOfLemmas,
			boolean trueOnly,
			ArrayList<String> acceptedTheories,
			boolean withDetails,
			boolean errorDetails
			)throws ParserConfigurationException,SAXException,IOException
	{
		return parseLemmas(listOfLemmas, trueOnly,acceptedTheories,withDetails,errorDetails,null,true);
	}
	
	
	
	
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseLemmas(
			final ArrayList<LemmaData> listOfLemmas,
			boolean trueOnly,
			ArrayList<String> acceptedTheories,
			boolean withDetails,
			boolean errorDetails,
			String translatedPath,
			boolean needsToBeDeleted
			)throws ParserConfigurationException,SAXException,IOException
	{
		ArrayList<Pair<String,String>> encounteredProblems = new ArrayList<Pair<String,String>>();
		ArrayList<String> givenNames = new ArrayList<String>();
		ArrayList<String> details = new ArrayList<String>();
		File translatedFiles = new File("Null");
		for(int i = 0 ; i < listOfLemmas.size() ; i++ )
		{
			//System.out.println(((Element)nos.item(i)).getTagName());
			LemmaTranslator lmt = new LemmaTranslator();
			lmt.setNeedDetails(withDetails);
			lmt.setRequiredTheories(acceptedTheories);
			lmt.setListOfAlreadyUsedNames(givenNames);
			lmt.setPathOfTranslatedFile(translatedPath);
			try
			{
				lmt.beginParsing(listOfLemmas.get(i),trueOnly);//((Element)nos.item(i),trueOnly,PATH);
				String name = lmt.getNameOfLemma();
				details.add(lmt.getDetails());
				if(name != null)
				{
					givenNames.add(name);
				}				
				ArrayList<String> p = lmt.getProblems();
				for(int j = 0 ; j < p.size() ; j++)
				{
					encounteredProblems.add
						(new Pair<String, String>
							(lmt.getNameOfLemma(),p.get(j)));
				}
				if(errorDetails)
				{
					printErrors(encounteredProblems);
				}
				translatedFiles = lmt.getTranslatedFile();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				continue;
			}			
		}		
		
		Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> p = new Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File>(details,encounteredProblems,translatedFiles);
		return p;
	}

	/** This method translate the Rodin XML lemmas. For each lemma in a input document generates a new 
	 * text file with the translated code.	 * 
	 * @param xml The File with the Rodin XML File that will be translated
	 * @param PATH The Path where the translated document will be Saved. It needs to be a directory.
	 * @param trueOnly True: The hypothesis which do not have the attribute 'needed', or do have the
	 *  attribute but the value is not 'true' will not be translated. False: All the document will be translated.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @see LemmaTranslator
	 */
	public static Triple<ArrayList<String>,ArrayList<Pair<String,String>>,File> parseXML(
			File xml, 
			final String PATH,
			boolean trueOnly, 
			ArrayList<String> acceptedTheories,
			boolean withDetails,
			boolean errorDetails,
			boolean filesNeedToBeDeleted
			) throws ParserConfigurationException, SAXException, IOException
	{
		ArrayList<LemmaData> listOfLemmas = createLemmaDatasFromRodinFile(xml.getPath());
		return parseLemmas(listOfLemmas, trueOnly, acceptedTheories, withDetails, errorDetails,PATH,filesNeedToBeDeleted);
	}
	
	public static void printErrors(ArrayList<Pair<String,String>> problems)
	{
		for(int i = 0 ; i < problems.size() ; i++)
		{
			System.out.println(problems.get(i).getFirstElement() + ": " + problems.get(i).getSecondElement());
		}
	}
	
	public static String normalizePathString(String string,char[] token)
	{
		String normalizedPath = "";
		for(int i = 0 ; i < string.length() - 1 ; i++)
		{
			if(string.charAt(i) == '\\')
			{
				if(string.charAt(i+1) == '\\')
				{
					normalizedPath = normalizedPath + '\\';					
				}
				else
				{
					for(int j = 0 ; j < token.length ; j++)
					{
						if(string.charAt(i+1) == token[j])
	                    {
							normalizedPath = normalizedPath + token[j];	
	                    }
					}
				}				
			}
			else
			{
				normalizedPath = normalizedPath + string.charAt(i);
			}		
		}
		return normalizedPath;
	}
		
	public static void printHelp()
	{
		System.out.println
	("This program makes the translation of Rodin-XML Files for SMT-LIB format File. " +
	"This is a help. The forms to use the program are listed below:\n\n" +
	"[-options] RodinFile_path [SMTFolder path]\n\n" +
	"[-options] RodinFolder_path [SMTFolder path]\n\n" +
	"where RodinFile path is the file which will be translated, and SMTFolder path is the folder " +
	"where the translated file will be saved. The options and the SMTFolder are optional." +
	" If a SMTFolder is not specified, the same folder of the Rodin file will be the destination folder.\n	\n"+
	"The options are:\n\n"+
	"[--help] This help message is printed in the console\n\n" +
	"[-t] 	Only hypothesis which does not have the attribute needed or do have it but it's value is "+ 
	"not 'true' won't be translated\n\n"+
	"\n"+
	"[-d] 	A list of details of the parsed file is shown in the console. The format of the details are:" +
	"[Name of translated lemma]:[|list of used theories|]:[|list of used operators|]"+
	"\n"+
	"[-e] 	A message error is thrown for every hypothesis and goal that can't be translated." +
	"\n"+
	"The user can specify the theories that should be translated. If this is the case, lemmas that has" +
	"at least one theory don't specified by the user won't be translated. To specify the selected theories, use this format:" +
	"#[theory 1],[theory 2],... If some theory has space in the name (ex: basic set), it's necessary th put \" before and after this command." +
	"\n" +
	"Examples of calling the program (they're are based on OS Windows, the path of the files must be complete) :\n\n"+
		   
	"Translator -te \"C:/Users/All/Desktop/RodinFile.xml\"\n\n"+
	"Translator \"#basic set,full_set_theory\"  \"C:/Users/All/Desktop/Czar.xml\" \"C:/Users/All/\"\n\n"+
	"Translator -td \"C:/Users/All/Desktop/\""); 
	}
	
	/**This is the main method for the Console version of the program.</br>
	 * This class makes calls the class responsible for doing the translation
	 *  of Rodin-XML to SMT-LIB format.The forms to use the program are listed below:
	 *  </br></br>
		[-options] RodinFile_path [SMTFolder path]
		</br>
		[-options] RidinFolder_path [SMTFolder path]
		</br></br>
	where RodinFile path is the file which will be translated, and SMTFolder path is the folder
	where the translated file will be saved.</br> 
	The options and the SMTFolder are optional.</br>
	 If a SMTFolder is not specified, the same folder of the Rodin file will be the destination folder.</br>
	The options are:
	</br></br>
	<strong>-t</strong> Only hypothesis which does not have the attribute needed or do have it but it's value is 
	not 'true' won't be translated.
	</br></br>
	<strong>-d</strong>		 	A list of details of the parsed file is shown in the console. The format of the details are
	[Name of translated lemma]:[|list of used theories|]:[|list of used operators|]
	</br></br>
	<strong>-e</strong>		 	A message error is thrown for every hypothesis and goal that can't be translated.
	</br></br>
	The user can specify the theories that should be translated. If this is the case, lemmas that has
	at least one theory don't specified by the user won't be translated.
	</br> To specify the selected theories, use this format:
	</br></br>
	#[theory 1],[theory 2],... If some theory has space in the name (ex: basic set), it's necessary to put <strong>"</strong> before and after this command.
	</br></br>
	"Examples of calling the program (they're are based on OS Windows, the path must be complete):
		   </br></br>
	"Translator -te "C:/Users/All/Desktop/RodinFile.xml
	</br>
	"Translator "#basic set,full_set_theory"  "C:/Users/All/Desktop/Czar.xml" "C:/Users/All/
	</br>
	"Translator -td "C:/Users/All/Desktop/
	</br>
	 * 
	 * @param args The arguments for the initialization of the translation
	 */
	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			Translator.printHelp();
			return ;
		}
		int i = 0;
		boolean trueOnly = false;
		boolean withDetails = false;
		ArrayList<String> acceptedTheories = null;
		boolean errorDetails = false;
		if(args[i].startsWith("-"))
		{
			if(args[i].equals("--help"))
			{
				Translator.printHelp();
				return;
			}
			for(int index = 1 ; index < args[i].length(); index++)
			{
				if(args[i].charAt(index) == 't')
				{
					trueOnly = true;
				}
				else if(args[i].charAt(index) == 'd')
				{
					withDetails = true;				
				}		
				else if(args[i].charAt(index) == 'e')
				{
					errorDetails = true;
				}
				else
				{
					System.out.println("The option " +args[i].charAt(index) + " do not exist. Showing the help:");
					Translator.printHelp();
				}
			}
			i++;
		}
		if(i >= args.length)
		{
			System.out.println("Não foram definidos todos os parâmetros. Nenhuma operação foi efetuada.");
			return;
		}	
		
				
//		if(args[i].startsWith("@"))
//		{
//			if(args[i].length() > 1)
//			{
//				args[i] = args[i].substring(1);
//			}
//			else ++i;
				
		if(args[i].startsWith("["))
		{
			if(args[i].length() > 1)
			{
				args[i] = args[i].substring(1);
			}
			else i++;
			String theories = "";			
			while(i < args.length)
			{
				theories = theories + " " + args[i];
				if((args[i].endsWith("]") && !(args[i].length() > 1 && args[i].charAt(args[i].length()-2) == '\\')))
				{
					break;
				}
				++i;
			}
			if(i == args.length)
			{
				System.out.println("O bloco de teorias não foi fechado, por favor, tente novamente.");
				System.out.println("O Tradutor foi finalizado");
				return;
			}
			if(theories.startsWith(" ["))
			{
				theories = theories.substring(2,theories.length() - 1);
			}
			else
			{
				theories = theories.substring(1,theories.length() - 1);
			}
//			if(lemmas.startsWith(" @"))
//			{
//				lemmas = lemmas.substring(2,lemmas.length() - 1);
//			}
//			else
//			{
//				lemmas = lemmas.substring(1,lemmas.length() - 1);
//			}
			
			String[] setOfTheories = theories.split(",");
			if(setOfTheories.length == 0)
			{
				System.out.println("Nenhuma teoria foi especificada. Traduzindo lemmas com todas as teorias.");
			}
			if(acceptedTheories == null)
			{
				acceptedTheories = new ArrayList<String>();
			}
			for(int j = 0 ; j < setOfTheories.length ; j++)
			{
				String actualTheory = setOfTheories[j].trim();
				if(!actualTheory.isEmpty())
				{
					acceptedTheories.add(actualTheory);
				}				
			}			
			i++;			
		}
		if( i >= args.length)
		{
			System.out.println("Não foram definidos os arquivos XML do Rodin a serem traduzidos. A tradução foi efetuada.");
			return;
		}		
		if(args[i].startsWith("@"))
		{
			if(args[i].length() > 1)
			{
				args[i] = args[i].substring(1);
			}
			else ++i;			
			String lemmas = "";
			while(i < args.length)
			{
				lemmas = lemmas + " " +  args[i];
				if(args[i].endsWith("@") && !(args[i].length() > 1 && args[i].charAt(args[i].length()-2) == '\\'))
				{
					break;
				}
				++i;
			}
			if(lemmas.startsWith(" @"))
			{
				lemmas = lemmas.substring(2,lemmas.length() - 1);
			}
			else
			{
				lemmas = lemmas.substring(1,lemmas.length() - 1);
			}	
			char[] c = {'@'};
			normalizePathString(lemmas,c);
			String[] setOflemmas = lemmas.split(",");
			ArrayList<String> lemmasForTranslation = new ArrayList<String>();
			for(int j = 0 ; j < setOflemmas.length ; j++)
			{
				String actualLemmaFile = setOflemmas[j].trim();
				if(!actualLemmaFile.isEmpty())
				{
					lemmasForTranslation.add(actualLemmaFile.replace('\\', '/'));
				}
			}
			for(int j = 0 ; j < lemmasForTranslation.size() ; j++)
			{
				File fileXML = new File(lemmasForTranslation.get(j));
				//String g = fileXML.getPath() + File.separator + lemmasForTranslation.get(i);				
				String withWay;	
				if( i + 1 <= args.length - 1)
				{
					withWay = args[i+1];
				}					
				else
				{
					withWay = fileXML.getParent();
				}				
				try
				{
					Translator.parseXML(fileXML, withWay,trueOnly,acceptedTheories,withDetails,errorDetails,false);
				}
				catch(Exception e)
				{
					System.out.println("The files could not be parsed. Reason: " +e.getMessage()); 
					return;
				}
				
				
			}
			return;		
		}	
			
					
		File fileXML = new File(args[i].trim());
		if(fileXML.isFile())
		{
			String withWay = "";	
			if( i + 1 <= args.length - 1)
			{
				withWay = args[i+1];
			}					
			else
			{
				withWay = fileXML.getParent();
			}					
			try
			{
				Translator.parseXML(fileXML,withWay,trueOnly,acceptedTheories,withDetails,errorDetails,false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("The file could not be parsed. Reason: " +e.getMessage());
				return;
			}
		}
		else if(fileXML.isDirectory())
		{
			FilenameFilter c = new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					if(name.endsWith(".xml"))
					{
						return true;
					}
					else
						return false;				
				}				
			};
			String[] xmlFiles = fileXML.list(c);
			for(int j = 0 ; j < xmlFiles.length ; j++)
			{
				String g = fileXML.getPath() + File.separator + xmlFiles[j];
				
				String withWay;	
				if( i + 1 <= args.length - 1)
				{
					withWay = args[i+1];
				}					
				else
				{
					withWay = fileXML.getPath();
				}				
				try
				{
					Translator.parseXML(new File(g), withWay,trueOnly,acceptedTheories,withDetails,errorDetails,false);
				}
				catch(Exception e)
				{
					System.out.println("The files could not be parsed. Reason: " +e.getMessage()); 
					return;
				}
				
				
			}				
		}
		else
		{
			Translator.printHelp();
		}
	}
}
