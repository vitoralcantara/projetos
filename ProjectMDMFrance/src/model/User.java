package model;

import java.security.MessageDigest;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.UserDAO;

/**
 * Classe utilisateur 
 * 
 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
 */

public class User {

	private Object id;
	private String login;	
	private String password;
	private String name;
	private String mail;
	private String role_apps;
	private boolean isConnected;
	
	
	/**
	 * Constructeur d'un user
	 * 
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public User() {
		// TODO Auto-generated constructor stub
		this.login = "";
		this.password = "";
		this.name = "";
		this.mail="";
		this.role_apps= "user";
		this.isConnected= false;
	}
	
	/**
	 * Constructeur d'un user
	 * 
	 * @param login et password
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public User( String login,String pass) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.password = sha256(pass);
		this.name = "";
		this.mail="";
		this.role_apps= "";
		this.isConnected=false;
	}
	

	/**
	 * Constructeur d'un user
	 * 
	 * @param login et password, nom, mail, role
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public User( String login,String pass,String name,String mail,String role) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.password = sha256(pass);
		this.name = name;
		this.mail=mail;
		this.role_apps= role;
		this.isConnected= false;
	}

	/**
	 * Cette fonction indique si un User est connecte au Mdm 
	 * 
	 * @return booleen : renvoie vrai si l'user est connecte, faux sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public boolean isConnected(){
		return isConnected;
	}
	
	/**
	 * setter pour l'etat isConnected
	 * 
	 * @param booleen : modifie a vrai ou a faux l'etat de la connexion de l'user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 * 
	 */
	
	public void setConnected(boolean v){
		isConnected=v;
	}

	/**
	 * Setter pour l'id user
	 * 
	 * @param id : Object
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public void setId(Object id){
		this.id=id;
	}

	/**
	 * Setter pour le login user
	 * 
	 * @param login : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public void setLogin(String login){
		this.login=login;
	}

	/**
	 * Setter pour le name user
	 * 
	 * @param name : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public void setName(String name){
		this.name=name;
	}

	/**
	 * Setter pour le mail user
	 * 
	 * @param mail : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public void setMail(String mail){
		this.mail=mail;
	}
	
	/**
	 * Setter pour le password user
	 * Le password sera préalablement hache
	 * 
	 * @param password : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	
	public void setPassword(String password){
		this.password=sha256(password);
	}
	
	/**
	 * Setter pour le role
	 * 
	 * @param role : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public void setRole(String role){
		this.role_apps=role;
	}

	/**
	 * Getter pour l'id user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public Object getId(){
		return this.id;
	}

	/**
	 * Getter pour le login user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public String getLogin(){
		return this.login;
	}

	/**
	 * Getter pour le name user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * Getter pour le mail user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public String getMail(){
		return this.mail;
	}
	
	/**
	 * Getter pour le password user
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 * Getter pour le roleApps
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public String getroleApps(){
		return this.role_apps;
	}
	
	
	/**
	 * Cette fonction va verifier si un utilisateur avec
	 * le login ou le mail donne n'est pas deja present 
	 * dans la base. 
	 * 
	 * @param login : String 
	 * @param mail : String
	 * 
	 * @return boolean : vrai si la creation est possible
	 * 					 faux si le login ou le mail est deja utilise dans la base
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */
	public boolean checkInformationUser(String login, String mail){

		DAOFactory df = new Neo4jDAOFactory();
		UserDAO dao = df.createUserDAO();
		String s1 = dao.checkLogin(login);		// string recevant le login s'il est deja dans la base, null sinon
		String s2 = dao.checkMail(mail);			// string recevant le mail s'il est deja dans la base, null sinon

		//System.out.println("s1 :"+s1);
		//System.out.println("s2 :"+s2);
		
		if ( s1.equals("") )
		{
			if ( s2.equals(""))
			{
				System.out.println("On peut creer l'user");
				return true;
			}
			else 
			{
				System.out.println("Mail deja existant dans la base.");
				return false;
			}

		}	
		else 
		{
			System.out.println("Login deja existant dans la base.");
			return false;
		}

	}
	
	
	/**
	 * Verifie dans la base les infos (login, password) concernant l'user passe en parametre 
	 * 
	 * @param user : l'instance user que l'on veut tester
	 * 
	 * @return string : renvoie l'etat du test , c'est a dire
	 * renvoie null si aucun probleme n'a ete detecte, et renvoie 'MAUVAIS_LOGIN' 
	 * ou 'MAUVAIS_PASSWORD' sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */		
	
	public String loadUser(User user){

		String msgEtat="";
		DAOFactory df = new Neo4jDAOFactory();
		UserDAO dao = df.createUserDAO();

		msgEtat = dao.loadUser(user);
	
		if( msgEtat.equals(""))
			user.setConnected(true);
		else
			user.setConnected(false);
		
		return msgEtat;
	}

	/**
	 * Sauvegarde l'user dans la base de donnee
	 * 
	 * @param user : l'instance user que l'on veut sauver 
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	
	public void saveUser(){

		DAOFactory df = new Neo4jDAOFactory();
		UserDAO dao = df.createUserDAO();
		dao.saveUser(this);

	}


	/**
	 * Cette methode sert à hasher les mots de passe avant leur stockage dans la base de données en utilisant la méthode SHA-256.
	 * 
	 * @param _pass le password à hasher
	 * @return le password hashé sous forme hexadécimale
	 * 
	 */
	public static String sha256(String pass) {
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pass.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
