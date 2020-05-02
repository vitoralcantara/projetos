package facade;
import java.security.MessageDigest;

import model.User;
import model.DataMDM;

/**
 * La facade de securite met en place des fonctions simples qui abstraient au
 * maximum la representation de la connexion et de l'inscription d'un utilisateur
 * 
 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
 */

public class SecuriteFacade {
	
	public static User target;

	/**
	 * Cette methode sert a transmettre toutes les donnees necessaires a l'inscription de l'user 
	 * 
	 * @param _login : le login de l'utilisateur
	 * @param _nom : le nom de l'utilisateur
	 * @param _nom : le mail de l'utilisateur
	 * @param _pass1 : le password de l'utilisateur
	 * @param _pass2 : le password de l'utilisateur saisi une deuxieme fois
	 * 
	 * @return boolean: vrai si la creation a ete effectuee, faux sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 * 
	 */

	public static boolean askCreationUser(String login, String nom, String mail, String pass1, String pass2)
	{
		if(pass1.equals(pass2))
		{	
			target = new User(login, pass1, nom, mail, "user");
			 if ( target.checkInformationUser(login, mail) )
			{
				 target.saveUser();
				 return true;
			}
			 else 
				 return false;
		}
		else 
		{
				System.out.println("Les mots de passe doivent etre identiques");
				return false;
		}
	}
	
	/**
	 * Cette methode sert a demander la creation du super admin
	 * 
	 * @return boolean: vrai si la creation a ete effectuee, faux sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 * 
	 */
	
	public static boolean askCreationSuperAdmin()
	{
		target = new User("SuperAdmin", "SuperAdmin", "SuperAdmin","SuperAdmin", "SuperAdmin");
		target.checkInformationUser("SuperAdmin", "SuperAdmin");
		target.saveUser();
		return true;
	}
	
	/**
	 * Cette methode demande la connexion d'un utilisateur
	 * 
	 * @param _login : le login de l'utilisateur
	 * @param _password : le password de l'utilisateur
	 * 
	 * @return string: renvoie l'etat de la connexion, c'est a dire
	 * renvoie null si aucun probleme n'a ete detecte, et renvoie 'MAUVAIS_LOGIN' 
	 * ou 'MAUVAIS_PASSWORD' sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 * 
	 */
	
	public static String connect(String login, String password){
		target = new User(login, password);
		String etat = target.loadUser(target);
		return etat;
	}
	
	public static DataMDM getDataMDMAssociateToUser(){
		return null;
		
	}
}
