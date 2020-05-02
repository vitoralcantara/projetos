package dao.model;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import model.DataMDM;
import model.Nature;
import model.Role;

public abstract class NatureDAO {
	
	/**
	 * Permet de sauvegarder une nature dans la base de donnees.
	 * @param nature la nature a sauvegarder.
	 * @return l'identifiant de la nature dans la base de donnees.
	 * @author Gaetan
	 */
	public abstract Object save(Nature nature);

	/**
	 * Permet de charger une nature de la base de donnees.
	 * @param id l'identifiant de la nature dans la base de donnees.
	 * @return Nature , la nature de la base de donnees.
	 * @author Gaetan
	 */
	public abstract Nature load(Object id);


	/**
	 * Permte de supprimer la nature de la base. supprime également les liens avec les ModelMDM associe.
	 * @param nature, la nature a supprimer de la base.
	 * @return True si la nature a ete supprime de la base, false sinon.
	 * @author Gaetan
	 */
	public abstract boolean delete(Nature nature);

	/**
	 * Permet de mettre a jour une nature dans la base de donnees.
	 * @param nature la nature a mettre a jour.
	 * @return True si l'update s'est déroule correctement, false sinon.
	 */
	public abstract Boolean update(Nature nature);

	/** Ajoute un utilisateur dans la communauté nature donnée avec le role demandé
	 * 
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param idCom
	 *            identifiant de la communauté nature
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * @author Lydia
	 */
	public abstract void addMember(Object idCom, DataMDM user, Role role);
	
	/** Accesseur pour récupérer le responsable d'une communauté Nature
	 * 
	 * @return le responsable de la Nature donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getResponsable();

	/** Accesseur pour récupérer le tuteur d'une communauté Nature
	 * 
	 * @return le tuteur de la Nature donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getTuteur();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Nature pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	 public abstract void setResponsable();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param com
	 * 		La communauté de type Nature pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	 public abstract void setTuteur();
	 
	 /** Modifie le role de l’utilisateur dans une Communauté Nature de la BD
	  * 
	  * @param id
	  * 		Identifiant du noeud en base
	  * 
	  * @param user
	  * 		Utilisateur dont on va modifier le role
	  *
	  * @param role
	  * 		Le role que l'on va appliquer à l'utilisateur
	  */
	 public abstract void updateRole(Object id, DataMDM user, Role role);
}
