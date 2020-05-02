package dao.model;

import java.util.ArrayList;
import java.util.Collection;

import model.DataMDM;
import model.Role;

public abstract class DataMDMDAO {

	/*----------Variables-----------*/

	/*----------Constructeur-----------*/

	/*----------Getters and setters-----------*/

	/*----------Methodes-----------*/

	/**
	 * Permet de charger une dataMDM a partir de son identifiant depuis la base
	 * de donnees.
	 * 
	 * @return DataMDM correspondant dans la base de donnees. return null si
	 *         l'object n'est pas trouve.
	 */
	public abstract DataMDM load(Object id);

	/**
	 * Permet de sauvegarder une DataMDM dans la base de donnees.
	 * 
	 * @param dataMdm
	 *            l'objet DataMDM a sauvegarder dans la base de donnees.
	 * @return Object correspondant a l'identifiant de l'object dans la base de
	 *         donnees.
	 */
	public abstract Object save(DataMDM dataMdm);
	/**
	 * Permet de mettre a jour une dataMDM dans la base de donnees.
	 * 
	 * @param dataMdm
	 *            la data a mettre a jour dans la base de donnees.
	 * @return Boolean signifiant que la mise a jour a ete effectuee dans la
	 *         base de donnees.
	 */
	public abstract Boolean update(DataMDM dataMdm);
	/**
	 * Permet de supprimer une DataMDM de la base de donnees. ainsi que chaque
	 * relation associé a la dataMDM et les dataValue associe.
	 * 
	 * @param dataMdm
	 *            a supprimer de la base.
	 * @return True si la suppression a ete effectue, False sinon.
	 */
	public abstract Boolean delete(DataMDM dataMdm);

	
	/** Ajoute un utilisateur dans la communauté data donnée avec le role demandé
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param idCom
	 *            identifiant de la communauté data
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * @author Lydia
	 */
	public abstract void addMember(Object idCom, DataMDM user, Role role);
	
	
	/** Accesseur pour récupérer le responsable d'une communauté
	 * 
	 * @return le responsable de la DataMDM donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getResponsable();
	
	
	/** Accesseur pour récupérer le tuteur d'une communauté
	 * 
	 * @return le tuteur de la DataMDM donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getTuteur();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	 public abstract void setResponsable();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	 public abstract void setTuteur();
	 
	 
	 
	 /**
		 * @author edwin
		 */
	 public abstract ArrayList<Object> getAllDataMDMId();
	 
	 public abstract ArrayList<Object> getAllDataValueId(DataMDM dataMDM);
	 
	 public abstract ArrayList<Object> getAllDataMDMFilsId();
	 

	 /** Modifie le role de l’utilisateur dans une communauté data de la BD
	  * 
	  * @param id
	  * 		Identifiant du data dans la base
	  * @param user
	  * 		Utilisateur dont on va modifier le role
	  * @param role
	  * 		Role que va avoir l'utilisateur
	  * 
	  * @author Aurélie :)
	  * 	 
	  */
	 public abstract void updateRole(Object id, DataMDM user, Role role);
}
