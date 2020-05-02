package facade;

import model.*;
import java.util.*;

/**
 * 
 * @author Groupe Gestion de communauté : Lydia RAHMANI, Aurélie ARNOLIN, Gaston GUY, Vincent PHULPIN, Tom KUHNEN, Jonathan RINALDI
 *
 */
public class GCFacade {

	/** 
	 * Cette méthode permet de demander l’inscription d’un nouvel utilisateur dans une communauté data ou model
	 *
	 *@param idCom
	 *	L'identifiant de la communauté
	 *
	 *@param comName
	 *	Le nom de la communauté
	 *
	 *@param typeCom
	 *	Le type de la communauté
	 *
	 *@param roleName
	 *	Role auquel on veut souscrire dans la communauté
	 *
	 *@param description
	 *	description de la demande
	 *
	 *@author Vincent & Jonathan R.
	 */
	public static void subscribeCommunity(Object idComm, String comName, String typeCom, String roleName, String description) {
		
		Role role = new Role(roleName);
		DataMDM user = SecuriteFacade.getDataMDMAssociateToUser();
		
		if (typeCom.equals("ModelMDM")){
			ModelMDM model = CRUDFacade.loadModelMDM(idComm);
			WfFacade.requestApplicationCommunity(user, model, role, description);
		}
		
		if (typeCom.equals("DataMDM")){
			DataMDM data = CRUDFacade.loadDataMDM(idComm);
			WfFacade.requestApplicationCommunity(user, data, role, description);
		}
		
		if (typeCom.equals("Nature")){
			Nature nature = CRUDFacade.loadNature(idComm);
			WfFacade.requestApplicationCommunity(user, nature, role, description);
		}
	}

	/** demande d’ajout d’un utilisateur, autre que l’utilisateur de la session, dans une communauté data ou model
	  * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 * 
	 * @param idCOm
	 * 		Identifiant de la communauté
	 * @param idUser
	 * 		Identifiant de l'utilisateur à ajouter
	 * @param comName
	 * 		Nom de la communauté dans laquelle on veut ajouter l'utilisateur
	 * @param typeCom
	 * 		Le type de la communauté
	 * @param roleName
	 * 		Le role de l'utilisateur que l'on veut ajouter
	 *@param description
	 *		description de la demande
	 *
	 * @author Vincent & Jonathan R.
	 */
	public static void proposeMember (Object idComm, Object idUser, String comName, String typeCom, String roleName, String description) {
		
		Role role = new Role(roleName);
		DataMDM user = CRUDFacade.loadDataMDM(idUser);
		DataMDM demandeur = SecuriteFacade.getDataMDMAssociateToUser();
		
		if (typeCom.equals("ModelMDM")){
			ModelMDM model = CRUDFacade.loadModelMDM(idComm);
			WfFacade.requestProposeMember(demandeur, user, model, role, description);
		}
		
		if (typeCom.equals("DataMDM")){
			DataMDM data = CRUDFacade.loadDataMDM(idComm);
			WfFacade.requestProposeMember(demandeur, user, data, role, description);
		}
		
		if (typeCom.equals("Nature")){
			Nature nature = CRUDFacade.loadNature(idComm);
			WfFacade.requestProposeMember(demandeur, user, nature, role, description);
		}

	}

	/** Ajoute un utilisateur dans la communauté model donnée avec le role demandé
	 * 
	 * @param leWfAnotifier
	 * 		le workflow qui doit etre fermé apres l'ajout	
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté Model dans laquelle l'utilisateur va être ajouté
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * 
	 * @author Lydia
	 */
	public static void addMember(Wf leWfAnotifier, DataMDM user, ModelMDM com, Role role) 
	{ 
		com.addMember( user, role);
		WfFacade.closeWf(leWfAnotifier);
	}

	/** Ajoute un utilisateur dans la communauté data donnée avec le role demandé
	 * 
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 * 
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté data dans laquelle l'utilisateur va être ajouté
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * 
	 * @author Lydia
	 */
	public static void addMember(Wf leWfAnotifier, DataMDM user, DataMDM com, Role role)  		
	{
		com.addMember( user, role);
		WfFacade.closeWf(leWfAnotifier);
	}

	/** Ajoute un utilisateur dans la communauté nature donnée avec le role demandé
	 * 
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 * 
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param objet
	 * 		Communauté nature dans laquelle l'utilisateur va être ajouté
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * 
	 * @author Lydia
	 */
	public static void addMember(Wf leWfAnotifier, DataMDM user, Nature obj, Role role) 
	{
		obj.addMember( user, role);
		WfFacade.closeWf(leWfAnotifier);
	}

	/** Ajoute un utilisateur dans la communauté model donnée mais avec le role refusé
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté Model dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 * @author Lydia
	 */		
	public static void refuseMember(Wf leWfAnotifier, DataMDM user, ModelMDM com, Role role) {
		Role refuse= new Role("refuse");
		GCFacade.addMember(leWfAnotifier, user, com, refuse);
		
	}
	
	/** Ajoute un utilisateur dans la communauté data donnée mais avec le role refusé
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté data dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 * @author Lydia
	 */	
	public static void refuseMember(Wf leWfAnotifier, DataMDM user, DataMDM com, Role role) {
		Role refuse= new Role("refuse");
		GCFacade.addMember(leWfAnotifier, user, com, refuse);
		
	}
	
	/** Ajoute un utilisateur dans la communauté nature donnée mais avec le role refusé
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté nature dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 * @author Lydia
	 */
	public static void refuseMember(Wf leWfAnotifier, DataMDM user, Nature obj, Role role) 
	{
		Role refuse= new Role("refuse");
		GCFacade.addMember(leWfAnotifier, user, obj, refuse);
		
	}

	/** Demande de modification du role de l’utilisateur dans une communauté data ou model de la BD
	 * @param idCOm
	 * 		Identifiant de la communauté
	 * @param comName
	 * 		Nom de la communauté dans laquelle on veut modifier un role
	 * @param typeCom
	 * 		Type de la communauté dans laquelle on veut modifier un role
	 * @param newRole
	 * 		Le nouveau role que l'on veut
	 *@param description
	 *	description de la demande
	 *
	 * @author Aurélie :)
	 */	
	public static void demandUpdatingRole(Object idComm, String comName, String typeCom, Role newRole, String description) {
		DataMDM user = SecuriteFacade.getDataMDMAssociateToUser();

		if (typeCom.equals("ModelMDM"))
		{ 	ModelMDM modeleMDM = CRUDFacade.loadModelMDM(idComm);
		WfFacade.requestModificationRole(user, modeleMDM, newRole, description);
		}
		else if (typeCom.equals("DataMDM"))
		{	DataMDM dataMDM = CRUDFacade.loadDataMDM(idComm);
		WfFacade.requestModificationRole(user, dataMDM, newRole, description);
		}
		else if (typeCom.equals("Nature"))
		{	Nature nature = CRUDFacade.loadNature(idComm);
		WfFacade.requestModificationRole(user, nature, newRole, description);
		}

	}
	
	/** Modification du role de l’utilisateur dans une communauté model de la BD
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté nature dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 *
	 * @author Aurélie :)
	 */	
	public static void updateRole (Wf leWfAnotifier, DataMDM user, ModelMDM com, Role role) 
	{
		com.updateRole(user, role);
		WfFacade.closeWf(leWfAnotifier);
	}
		
	/** Modification du role de l’utilisateur dans une communauté data de la BD
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté nature dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 *
	 * @author Aurélie :)
	 */	
	public static void updateRole (Wf leWfAnotifier, DataMDM user, DataMDM com, Role role) 
	{
		com.updateRole(user,role);
		WfFacade.closeWf(leWfAnotifier);
	}
	
	/** Modification du role de l’utilisateur dans une communauté nature de la BD
	 * @param leWfAnotifier
	 * le workflow qui doit etre fermé apres l'ajout	
	 *  
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param obj
	 * 		Communauté nature dans laquelle l'utilisateur est ajouté
	 * @param role
	 * 		Role qui est refusé
	 *
	 * @author Aurélie :)
	 */	
	public static void updateRole (Wf leWfAnotifier, DataMDM user, Nature obj, Role role) 
	{
		obj.updateRole(user,role);
		WfFacade.closeWf(leWfAnotifier);
	}

	/** Affiche la liste de l’ensemble des membres d’une communauté
	 * 
	 * @param comName
	 * 		Nom de la communauté pour laquelle on veut afficher la liste des membres
	 * @param typeCom
	 * 		Type de la communauté
	 * @return
	 * 		La liste des membres d'une communauté 
	 * @author Gaston Guy
	 */
	public static List<String> displayListMember(String comName, String typeCom) {
			
		List<String> memberList = new ArrayList<String>();
		
		
		
		if (typeCom.equals("Model")) // Si de type Model
		{
			
		}
		else if (typeCom.equals("Data")) // Si de type Data
		{
			
		}
		else if (typeCom.equals("Nature")) // Si de type Nature
		{
			
		}
		
		return memberList;
	}

	/** Demande la désinscription de l’utilisateur dans la communauté donnée
	 * 
	 * @param idCOm
	 * 		Identifiant de la communauté
	 * @param comName
	 * 		Nom de la communauté dans laquelle on veut modifier un role
	 * @param typeCom
	 * 		Type de la communauté dans laquelle on veut modifier un role
	 *@param description
	 *	description de la demande
	 *
	 * @author Jonathan R. & Vincent
	 */
	public static void unsubscribeCommunity(Object idComm,String comName, String typeCom, String description) 

	{
		DataMDM user = SecuriteFacade.getDataMDMAssociateToUser();
		
		if (typeCom.equals("ModelMDM")){
			ModelMDM model = CRUDFacade.loadModelMDM(idComm);
			WfFacade.requestUnsubscribe(user, model, description);
		}
		
		if (typeCom.equals("DataMDM")){
			DataMDM data = CRUDFacade.loadDataMDM(idComm);
			WfFacade.requestUnsubscribe(user, data, description);
		}
		
		if (typeCom.equals("Nature")){
			Nature nature = CRUDFacade.loadNature(idComm);
			WfFacade.requestUnsubscribe(user, nature, description);
		}
		
	}
	
	/** Supprime le noeud role de l’utilisateur relié à la communauté model donnée
	 * @param NotifyWf
	 * 	le workflow qui doit etre fermé apres la suppression	
	 * @param user
	 * 		Le Membre à supprimer
	 * @param com
	 * 		La Communauté Model dans laquelle on supprime le membre
	 * 
	 * @author Jonathan R. & Vincent
	 */
	public static void deleteMember(Wf NotifyWF, DataMDM user, ModelMDM com) 
	{
		Role role = new Role();
		role.deleteRole(user, com);
		
	} 
		
	/** Supprime le noeud role de l’utilisateur relié à la communauté data donnée
	 * @param NotifyWf
	 * 	le workflow qui doit etre fermé apres la suppression	
	 * @param user
	 * 		Le Membre à supprimer
	 * @param com
	 * 		La Communauté Model dans laquelle on supprime le membre
	 * 
	 * @author Jonathan R. & Vincent
	 */
	public static void deleteMember(Wf NotifyWF, DataMDM user, DataMDM com) { 
		
	}

	/** Supprime le noeud role de l’utilisateur relié à la communauté nature donnée
	 * @param NotifyWf
	 * 	le workflow qui doit etre fermé apres la suppression	
	 * @param user
	 * 		Le Membre à supprimer
	 * @param com
	 * 		La Communauté Model dans laquelle on supprime le membre
	 * 
	 * @author Jonathan R. & Vincent
	 */
	public static void deleteMember(Wf NotifyWF, DataMDM user, Nature obj) {

	}


	// ACCESSEURS 

	/** Accesseur pour récupérer le responsable d'une communauté
	 * 
	 * @param nature
	 * 		La communauté de type Nature pour laquelle on veut récupérer le responsable
	 * 
	 * @return le responsable de la Nature donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getResponsable(Nature nature) {
		// TODO Auto-generated method stub
		return nature.getResponsable();
	}
	
	/** Accesseur pour récupérer le responsable d'une communauté
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le responsable
	 * 
	 * @return le responsable de la DataMDM donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getResponsable(DataMDM com) {
		// TODO Auto-generated method stub
		return com.getResponsable();
	}
	
	/** Accesseur pour récupérer le responsable d'une communauté
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le responsable
	 * 
	 * @return le responsable du ModelMDM donné
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getResponsable(ModelMDM com) {
		// TODO Auto-generated method stub
		return com.getResponsable();
	}

	/** Accesseur pour récupérer le tuteur d'une communauté Nature
	 * 
	 * @param nature
	 * 		La communauté de type Nature pour laquelle on veut récupérer le tuteur
	 * 
	 * @return le tuteur de la Nature donnée
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getTuteur(Nature nature) {
		// TODO Auto-generated method stub
		return nature.getTuteur();
	}
	
	/** Accesseur pour récupérer le tuteur d'une communauté
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le tuteur
	 * 
	 * @return le tuteur de la DataMDM donné
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getTuteur(DataMDM com) {
		// TODO Auto-generated method stub
		return com.getTuteur();
	}
	
	/** Accesseur pour récupérer le tuteur d'une communauté
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le tuteur
	 * 
	 * @return le tuteur du ModelMDM donné
	 * 
	 * @author Tom Kuhnen
	 */
	public static DataMDM getTuteur(ModelMDM com) {
		// TODO Auto-generated method stub
		return com.getTuteur();
	}


	// MODIFICATEURS
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param nature
	 * 		La communauté de type Nature pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	public static void setResponsable(Nature nature) {
		nature.setResponsable();
	}
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	public static void setResponsable(DataMDM com) {
		com.setResponsable();
	}
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	public static void setResponsable(ModelMDM com) {
		com.setResponsable();
	}

	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param nature
	 * 		La communauté de type Nature pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	public static void setTuteur(Nature nature) {
		nature.setTuteur();
	}
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param com
	 * 		La communauté de type Data pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	public static void setTuteur(DataMDM com) {
		com.setTuteur();
	}
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param nature
	 * 		La communauté de type Model pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	public static void setTuteur(ModelMDM com) {
		com.setTuteur();
	}
}
