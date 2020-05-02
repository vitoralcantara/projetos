package dao.neo4j;

import java.util.Iterator;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dao.model.UserDAO;
import model.User;

/**
 * Classe permettant d'interagir avec la base de donnee neo4j
 * Cette classe herite de la classe abstraite UserDAO
 * 
 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
 */

public class Neo4jUserDAO extends UserDAO{

	/**
	 * Methode verifiant si le login est deja present dans la base
	 * 
	 * @param login : le login de l'utilisateur dont on veut verifier s'il est en base
	 * 
	 * @return string : renvoie le login s'il est deja present dans la base, null sinon
	 * 
	 * * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	public String checkLogin(String login) {
	
		String log = "";

		GraphDatabaseService maConnexion = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Ribos\\Downloads\\neo4j\\graph.db");
		ExecutionEngine engine = new ExecutionEngine(maConnexion);
		String maRequete = "start n=node(*)  where n.type = \"user\" and n.login = \""+login+"\" return n.login;";
//        System.out.println(maRequete);
        
		ExecutionResult result = engine.execute( maRequete );
		Iterator<Map<String, Object>> it = result.iterator();	
//		System.out.println("resultat=>"+ it);
		
		/* Si le login est présent dans la BD, on le retourne */
		if( it.hasNext())
			log= it.next().get("n.login").toString();

		maConnexion.shutdown();		
		return log;
	}


	/**
	 * Methode verifiant si le login est deja present dans la base
	 * 
	 * @param mail : le mail de l'utilisateur dont on veut verifier s'il est en base
	 * 
	 * @return string : renvoie le mail s'il est deja present dans la base, null sinon
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	
	public String checkMail(String mail) {

		String mailBD = "";
		
		GraphDatabaseService maConnexion = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Ribos\\Downloads\\neo4j\\graph.db");
		ExecutionEngine engine = new ExecutionEngine(maConnexion);
		
		String maRequete = "start n=node(*) return n;";
		ExecutionResult result = engine.execute( maRequete );
		System.out.println("resultat=>"+ result);		
		
		maRequete = "start n=node(*)  where n.type = \"user\" and n.mail = \""+mail+"\" return n.mail;";
        System.out.println(maRequete);
        
        result = engine.execute( maRequete );
		
		/* On recupere le resultat de la requete */
		Iterator<Map<String, Object>> it = result.iterator();		
//		System.out.println("resultat=>"+ it);		
		
		/* Si le mail est présent dans la BD, on le retourne*/
		if(  it.hasNext())
			mailBD= it.next().get("n.mail").toString();
		
		maConnexion.shutdown();	
		return mailBD;
	}
	
	/**
	 * Methode qui verifie si le login et le password sont valides
	 * pour l'user courant
	 * 
	 * @param login : String
	 * @param pass : String
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	public void checkLoginAndPassword(String login, String pass, String loginBD, String passBD)
	{
		loginBD = "";
		passBD= "";
		
		GraphDatabaseService maConnexion = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Ribos\\Downloads\\neo4j\\graph.db");
		ExecutionEngine engine = new ExecutionEngine(maConnexion);		
		
		/* On verifie d'abord si le login existe */
		String maRequete = "start n=node(*)  where n.type = \"user\" and n.login = \""+login+"\" return n;";
        System.out.println(maRequete);
        ExecutionResult result = engine.execute( maRequete );
        /* On recupere le resultat de la requete */
		Iterator<Map<String, Object>> it = result.iterator();		
		System.out.println("resultat=>"+ it);	
		
		/* Si le login existe */
		if(  it.hasNext()){
			
		
			loginBD= it.next().get("n.login").toString();
        
		
			/* Si le login existe on verifie si le password est OK */
			maRequete = "start n=node(*)  where n.type = \"user\" and n.login = \""+loginBD+"\" and n.password = \""+pass+"\" return n;";
	        System.out.println(maRequete);
	        
	        result = engine.execute( maRequete );
			
			/* On recupere le resultat de la requete */
			it = result.iterator();		
			System.out.println("resultat=>"+ it);		
			
			/* Si le password correspond */
			if(  it.hasNext())
				passBD= it.next().get("n.password").toString();

		
		}
		
		maConnexion.shutdown();	
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
	
	public String loadUser(User user)
	{
		/* */
		String msgEtat="";
		String testLogin="", testPass="";
		

		checkLoginAndPassword(user.getLogin(),user.getPassword(),testLogin,testPass);
		/* si le login n'est pas dans la base */
		if(testLogin.equals("") )
		{
			msgEtat="MAUVAIS_LOGIN";
		}
		else if(testPass.equals("")){
			msgEtat="MAUVAIS_PASSWORD";
		}
		else{ /* On a peut charger l'user */
			GraphDatabaseService maConnexion = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Ribos\\Downloads\\neo4j\\graph.db");
			ExecutionEngine engine = new ExecutionEngine(maConnexion);	
			
			String maRequete = "start n=node(*)  where n.type = \"user\" and n.login = \""+testLogin+"\" and n.password = \""+testPass+"\" return n;";
	        System.out.println(maRequete);
	        
	        ExecutionResult result = engine.execute( maRequete );
			
			/* On recupere le resultat de la requete */
			Iterator<Map<String, Object>> it = result.iterator();		
//			System.out.println("resultat=>"+ it);		
			
			/* Si le mail est présent dans la BD, on le retourne*/
			if(  it.hasNext()){
			 //	user.setId(id)    !!!!!!! RESTE CELUI A AJOUTER
				user.setMail(it.next().get("n.mail").toString());
				user.setName(it.next().get("n.password").toString());
				user.setRole(it.next().get("n.role_apps").toString());
			}
				
		}
		
		
		return msgEtat;
	}

	/**
	 * Sauvegarde l'user dans la base de donnee
	 * 
	 * @param user : l'instance user que l'on veut sauver 
	 * 
	 * @author GroupeSecurite (Julian, Jonathan F, Pierrick, Ludwig)
	 */	
	
	public void saveUser(User user) {
		
		System.out.println("Test Save User");
		// TODO Auto-generated method stub	
		GraphDatabaseService gDB = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Ribos\\Downloads\\neo4j\\graph.db");

		Transaction t = gDB.beginTx();

		Node nodeUser = gDB.createNode();
		nodeUser.setProperty("type", "user");
		nodeUser.setProperty("login",user.getLogin() );
		nodeUser.setProperty("name", user.getName());
		nodeUser.setProperty("mail", user.getMail());
		nodeUser.setProperty("password",user.getPassword());
		nodeUser.setProperty("role_apps",user.getroleApps());
		t.success();

		/* Utiliser creerDataMDM de CRUDFacade */
		t.finish();		
		gDB.shutdown();	
		/* On mets a jour l'ID de l'user */
		user.setId(nodeUser.getId()); 
	}
}
