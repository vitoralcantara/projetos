package model;

import java.io.*;
import java.util.regex.Pattern;
import java.util.ArrayList;
/**
 * Cette classe permettra de configurer la base de donnÃ©es, creer les communautÃ© nature et le superadmin.
 * Elle permettra Ã©galement la dÃ©signation des tuteurs et responsables pour la communautÃ© nature.
 * @author Groupe Installation
 *
 */
public class Install {

public static final int MIN_LENGHT_PASSWORD = 6;
public static final int MAX_LENGHT_PASSWORD = 18;
public static final String AUTHORIZED_CHARACTERS = "[a-zA-Z0-9]";

private static final String[]NATURES_NAMES={"Personne","Structure","Ressource","Brique","Service"}; 
private static final int NATURE_NUMBER = NATURES_NAMES.length;

public Install(){
	
}

/**
 * Cette methode permet de sauvegarder l'adresse et le mot de passe de la base de donnÃ©es dans le fichier resources/infosDB.txt
 * Le mot de passe ne doit pas contenir de " ou de \
 * @param address String
 * 			Adresse de connexion a la DB
 * @param mdp String
 * 			Mot de passe de la DB 
 * @autor RÃ©my BANNES
 */
public static void saveInfoDB(String address, String passwd)	{
	File resourceDirectory = new File("src/resource");
	resourceDirectory.mkdir();
	try {
		RandomAccessFile passwdFile = new RandomAccessFile("src/resource/infoDB.txt","rw");
		
		if (passwdFile.read() != 0){
			passwdFile.setLength(0);
		}
		
		String newLine = new String(System.getProperty("line.separator"));
		String content = new String(address+newLine+passwd);
		passwdFile.writeBytes(content);
		passwdFile.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
/**
 * Cette mÃ©thode permet de rÃ©cupÃ©rer la valeur du mot de passe de la base de donnÃ©es dans le fichier resources/infosDB.txt
 * 	
 * @return res String
 * 		Contient le mot de passe contenu dans le fichier infoDB.txt (Non cryptÃ©) 
 * @autor RÃ©my BANNES
 */
public static String getPasswdDB(){
	String res = new String();
	try {
		RandomAccessFile passwdFile = new RandomAccessFile("src/resource/infoDB.txt","rw");
		String passwd = new String();
		
			passwd = passwdFile.readLine();
			passwd = passwdFile.readLine();
			
		res = passwd;
		passwdFile.close();
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return res;
}
/**
 * Cette mÃ©thode permet de rÃ©cupÃ©rer l'adresse de la base de donnÃ©es dans le fichier resources/infosDB.txt
 * 	@return res String
 * 		Retourne l'adresse de la base de donnÃ©es depuis le fichier infoDB.txt (non cryptÃ©)
 * @autor RÃ©my BANNES
 */
public static String getAddressDB(){
	String res = new String();
	try {
		RandomAccessFile passwdFile = new RandomAccessFile("src/resource/infoDB.txt","rw");
		String address = new String();
		
			address = passwdFile.readLine();
			
		res = address;
		passwdFile.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return res;
}

/**
 * 
 * Cette mÅ½thode crÃ©e le super administrateur et les communautÃ©s natures et les implÃ©mente dans la BD
 * @autor Paul GAVOILLE, Simon BARRAT
 */
public static void initDB(){
	facade.SecuriteFacade.askCreationSuperAdmin();
	
	for (int i=0; i < NATURE_NUMBER; i++){
		facade.CRUDFacade.createNature(NATURES_NAMES[i]);
	}
	
}


/** Permet de rÃ©cupÃ©rer la liste des Natures, si jamais des nouvelles 
 * natures venaient Ã  Ãªtre ajoutÃ©es Ã  la base de donnÃ©es il faut complÃ©ter 
 * le champ natureNames
 * @param Variables globales NATURES_NAMES et NATURE_NUMBER
 * 		permettant d'Ã©tablir la liste des natures
 * @return natureArray ArrayList<Nature>
 * 		 Retourne un ArrayList de toutes les natures
 * @author RÃ©my BANNES
 */
public static ArrayList<Nature> getAllNature(){
	 
	ArrayList<Nature> natureArray = new ArrayList<Nature>();
	
	for (int i=0; i<(NATURE_NUMBER); i++){
		natureArray.add(facade.CRUDFacade.loadNature(NATURES_NAMES[i]));
	}
	
	return natureArray;
	
}
/**
 * RÃ©cupÃ¨re l'ensemble des nature qui n'ont pas de responsables
 * @return natureArrayWithoutResp ArrayList<Nature>
 * 		ArrayList de Nature qui n'ont pas de responsables
 * @author RÃ©my BANNES
 */
public static ArrayList<Nature> getAllNatureWithoutResp(){
	ArrayList<Nature> natureArray = new ArrayList<Nature>();
	ArrayList<Nature> natureArrayWithoutResp = new ArrayList<Nature>();
	natureArray = getAllNature();
	
	for (int i=0; i<(NATURE_NUMBER); i++){
		if (facade.GCFacade.getResponsable(natureArray.get(i)) == null){
			natureArrayWithoutResp.add(natureArray.get(i));
		}
	}
	return natureArrayWithoutResp;
	
}

/**
 * RÃ©cupÃ¨re l'ensemble des nature qui n'ont pas de tuteur, utilise la fonction getAllNature()
 * @return natureArrayWithoutTuteur ArrayList<Nature>
 * 		ArrayList de Nature qui n'ont pas de tuteur
 * @author RÃ©my BANNES
 */
public static ArrayList<Nature> getAllNatureWithoutTuteur(){
	ArrayList<Nature> natureArray = new ArrayList<Nature>();
	ArrayList<Nature> natureArrayWithoutTuteur = new ArrayList<Nature>();
	natureArray = getAllNature();
	
	for (int i=0; i<(NATURE_NUMBER); i++){
		if (facade.GCFacade.getTuteur(natureArray.get(i)) == null){
			natureArrayWithoutTuteur.add(natureArray.get(i));
		}
	}
	return natureArrayWithoutTuteur;
}
/**
 * 
 * Cette methode sert a designer le responsable pour une communaute
 * @autor Maroua BOURIAL et personne ne touche à cette méthode SVP je la fais
 */
public static void respNatureDesignation(ModelData nat, ModelMDM resp){
	Role role =new Role("responsable"); 
	// wf worflow = new wf();  ??
	facade.GCFacade.addMember(wf,resp,nat,role );
}

/**
 * 
 * Cette mÅ½thode sert Ë† designer le tuteur pour une communautÅ½
 * @autor Maroua BOURIAL et personne ne touche à cette méthode SVP je la fais
 */
public static void tutorNatureDesignation (ModelData nat, ModelMDM tutor){
	Role role = new Role("tuteur");
	
	facade.GCFacade.addMember(wf,resp,nat,role);
}

/**
 * Cette mŽthode vŽrifie que le password respecte les r�gles de syntaxes dŽfinies.
 * @return
 * 	0 : le password est correct
 * 	1 : le password est trop court
 *  2 : le password est trop long
 *  3 : le password utilise un caract�re interdit
 *  4 : le password est null
 * @param pswd 
 * 			Mot de passe de la DB
 * @autor Alexis Debourdieu, Simon Barrat
 */
public static int passwordVerification(String pswd){
	int lngh;
	if(pswd==null){
		return 4;
	}
	else if((lngh=pswd.length())<MIN_LENGHT_PASSWORD){
		return 1;
	}
	else if(lngh>MAX_LENGHT_PASSWORD){
		return 2;
	}
	else if(Pattern.matches(AUTHORIZED_CHARACTERS+"*",pswd)==false){
		return 3;
	}
	else{
		return 0;
	}
}

}