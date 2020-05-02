package model;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.RoleDAO;

public class Role 
{
	private String name;
	private DAOFactory df = new Neo4jDAOFactory();
	private RoleDAO dao = df.createRoleDAO();

	/**
	 * Constructeur de la classe
	 * 
	 * On instancie Role avec son appellation, son nom qui peut être seulement Tuteur, Responsable, Membre, Associé ou Refusé
	 * 
	 * @param name
	 *            : String representant le futur nom du rôle qui peut être seulement Tuteur, Responsable, Membre, Associé ou Refusé
	 * 
	 * @author Jonathan R., Vincent P
	 */
	
	public Role(String name) 
	{
		//on test si le nom est correct
		if(name.equals("Tuteur") || name.equals("Responsable") || name.equals("Membre") || name.equals("Associé") || name.equals("Refusé"))
		this.name = name;
	}

	public Role() {
		
	}

	// Getters and setters
	
	/**
	 * Permet d'obtenir le String contenant la valeur de l'attribut name qui est le nom du rôle
	 * 
	 * @return le String contenant la valeur de l'attribut name qui est le nom du rôle
	 * @author Jonathan R
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Permet de modifier la valeur du String name
	 * 
	 * @param name
	 *            : String contenant la nouvelle valeur a donner a l'attribut
	 *            nom
	 * @author Jonathan R, Vincent P.
	 */
	
	public void setName(String name) {
		if(name.equals("Tuteur") || name.equals("Responsable") || name.equals("Membre") || name.equals("Associé") || name.equals("Refusé"))
		this.name = name;
	}
	
	
	//Méthode
	
	/**
	 * Permet de modifier la valeur du String name
	 * 
	 * @param user
	 *            : DataMDM contenant la valeur de l'user voulant quitter 
	 *            
	 * @param community
	 * 			  : Communauté Model contenant la valeur de la communauté auquel l'user veut se désinscrire           
	 *            
	 * @author Jonathan R, Vincent P.
	 */
	
	public void loadRole(DataMDM user, ModelMDM community)
	{
		name = dao.loadRole(user, community);
	}
	
	public void deleteRole(DataMDM user, ModelMDM community)
	{
		dao.delete(user, community);
	}
	

}
