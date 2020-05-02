package dao.model;

import model.User;

/**
 * Classe abstraite permettant d'interagir avec une base de donnee quelconque
 * 
 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
 */

public abstract class UserDAO {

	
	/**
	 * Methode qui verifie si le login est deja present dans la base
	 * 
	 * @param login : le login de l'utilisateur dont on veut vérifier qu'il est en base	
	 * 
	 * @return string : renvoie le login si il est dans la base, et renvoie null sinon
	 * 	  
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	
	public abstract String checkLogin(String login);

	
	
	/**
	 * Methode qui verifie si le mail est deja present dans la base
	 * 
	 * @param mail : le mail de l'utilisateur dont on veut vérifier qu'il est en base
	 * 
	 * @return string : renvoie le mail si il est dans la base, et renvoie null sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	
	public abstract String checkMail(String mail);

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
	public abstract String loadUser(User user);
	
	
	/**
	 * Sauvegarde l'user dans la base de donnee
	 * 
	 * @param user : l'instance user que l'on veut sauver 
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	public abstract void saveUser(User user);


}
