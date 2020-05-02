package dao.model;

import java.util.ArrayList;

import model.DataMDM;
import model.ModelMDM;
import model.Role;

public abstract class ModelMDMDAO {

	/****************************************************************
	 * Membres de la classe *
	 ****************************************************************/

	/****************************************************************
	 * Méthodes de la classe *
	 ****************************************************************/

	/**
	 * Permet de sauvegarder un modelMDM dans la base de donnees, et creer le
	 * lien avec la nature associe.
	 * 
	 * @param modelMdm
	 *            le model a sauvegarder dans la base.
	 * @return Object correspondant a l'id du noeud dans la base de donnees.
	 * @author Gaetan
	 */
	public abstract Object save(ModelMDM modelMdm);

	/**
	 * Permet charger un modelMDM de la base de donnees a partir de son
	 * identifiant.
	 * 
	 * @param id
	 *            : identifiant du modelMDM dans la base de donnees.
	 * 
	 * @return le modelMDM correspondant a l'id passe en parametre.
	 * @author Gaetan
	 */
	public abstract ModelMDM load(Object id);

	/**
	 * Permet de supprimer un modelMDM de la base de donnees. supprime donc tous
	 * les modelValue et dataMDM associé a ce modelMDM
	 * 
	 * @param model
	 *            le model a supprimer
	 * @return True si la suppression a bien eu lieu, false sinon.
	 * @author Gaetan
	 */
	public abstract boolean delete(ModelMDM model);

	/**
	 * Permet de mettre a jour un modelMDM enregistre dans la base de donnees.
	 * 
	 * @param model
	 *            le model a mettre a jour.
	 * @return True si l'update s'est bien deroulee, false sinon.
	 * @author Gaetan
	 */
	public abstract Boolean update(ModelMDM model);

	/****************************************************************
	 * Accesseurs de la classe *
	 ****************************************************************/

	/**
	 * Ajoute un utilisateur dans la communauté model donnée avec le role
	 * demandé
	 * 
	 * @param user
	 *            Utilisateur à ajouter
	 * @param idCom
	 *            identifiant de la communauté model
	 * @param role
	 *            Role que va avoir l'utilisateur ajouté
	 * 
	 * @author Lydia
	 */
	public abstract void addMember(Object idCom, DataMDM user, Role role);
	
	
	/** Accesseur pour récupérer le tuteur d'une communauté
	 * 
	 * @return le tuteur du ModelMDM donné
	 *  
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getTuteur();
	
	/** Accesseur pour récupérer le responsable d'une communauté
	 * 
	 * @return le responsable du ModelMDM donné
	 *	
	 * @author Tom Kuhnen
	 */
	public abstract DataMDM getResponsable();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	 public abstract void setResponsable();
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	 public abstract void setTuteur();
	

	 /** Modifie le role de l’utilisateur dans une communauté model de la BD
	  * 
	  * @param id
	  * 		Identifiant du modelMDM dans la base
	  * @param user
	  * 		Utilisateur dont on va modifier le role
	  * @param role
	  * 		Role que va avoir l'utilisateur
	  * 
	  * @author Aurélie :)
	  * 	 
	  */
	public abstract void updateRole(Object id, DataMDM user, Role role);
	
	public abstract ArrayList<Object>getAllModelMDMId();
	
	public abstract ArrayList<Object>getAllModelMDMFilsId();
}
