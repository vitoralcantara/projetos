package facade;

import model.*;

import java.util.*;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.WFDataDAO;
import dao.neo4j.Neo4jWFDataDAO;

public class WfFacade {

	
	/****************************************************************
	 *                    Méthodes de la classe                      *
	 ****************************************************************/

	/**
	 * Requête capitale correspondant à la demande d'ajout d'une brique SI au sein du système.
	 * Une fois que cette méthode aura été appelée, le Workflow sera lancé. Suivant l'issue de celui-ci, la brique pourra soit être ajoutée, soit ne pas l'être (si ajout refusé).
	 * @author Bastien F. et Thomas
	 * @param laNature
	 *            Correspond à l'objet Nature BriqueSI (qui va nous servir pour
	 *            retrouver les tuteur et responsable de cette communauté.
	 * @param demandeur
	 *            Correspond au demandeur de la création du Workflow.
	 * @param description
	 *            Correspond à la description du Workflow.
	 * @param connecteur
	 *            Correspond aux informations de connecteur de la brique SI.
	 * @param schema
	 *            Correspond à une liste des ModelValue que l'on veut récupérer
	 *            dans cette brique SI. Concrètement, cela peut être par exemple
	 *            des noms de colonnes d'une base de données.
	 */
	// Demande la création d'une nouvelle brique SI
	public static void requestCreationBrique(Nature laNature, DataMDM demandeur, String description, Connector connecteur, Map<ModelMDM, List<ModelValue>> schema) 
	{
		// 1ere étape : Création du Workflow
		// Utilisation du polymorphisme
		Wf newWf = new BriqueSIWf(null, laNature, demandeur, description, connecteur, schema, "CREATE");

		// IL FAUDRA ICI ENREGISTRER CE WORKFLOW AVEC LE DAO.
	}
	

	/**
	 * Demande la création d'un modèle value en renseignant le type d'attribut,
	 * le ModelMDM sur lequel on ajoute l'attribut, la valeur, et la valeur par
	 * défaut
	 * 
	 * @author Solene, Fanny, Bastien F. et Thomas
	 * @param nomObjet
	 * @param typeAttribut
	 * @param demandeur
	 * @param modeleAssocie
	 * @param modelValue
	 * @param leSocle
	 * @param description
	 */
	 public static void requestCreateModelValue(String nomObjet, String typeAttribut, DataMDM demandeur, ModelMDM modeleAssocie, ModelValue modelValue, Socle leSocle, String description)
	 { 
		// 1ere étape : Création du Workflow
		// Utilisation du polymorphisme
		
		 Wf newWf = new ModelData(null, nomObjet, typeAttribut, demandeur, modeleAssocie, modelValue, leSocle, description, "CREATE");
		// IL FAUDRA ICI ENREGISTRER CE WORKFLOW AVEC LE DAO.
	 }
	 

	/**
	 * Demande la création d'un dataValue en renseignant la valeur, la DataMDM
	 * sur laquelle on ajoute la valeur, et le ModelValue qu'on remplit par
	 * cette valeur
	 * 
	 * @author Solene, Fanny, Bastien F. et Thomas
	 * @param nomObjet
	 * @param dataMDMAssocie
	 * @param demandeur
	 * @param valeur
	 * @param description
	 */
	public static void requestCreateDataValue(String nomObjet, DataMDM dataMDMAssocie, DataMDM demandeur, String valeur, String description) 
	 { 
		// 1ere étape : Création du Workflow
		// Utilisation du polymorphisme
		Wf newWf = new ModelData(null, nomObjet, dataMDMAssocie, demandeur, valeur, description, "CREATE");
		
		// IL FAUDRA ICI ENREGISTRER CE WORKFLOW AVEC LE DAO.
	 }

	
	/**
	 * Méthode permettant de valider un Workflow. Suivant s'il s'agit de la première ou la deuxième validation, et suivant les avis pris par les validateurs, celle-ci pourra soit être mise "en attente d'un second avis", soit validée (2 avis OK), soit refusée (2 avis NOK), soit transformée en demande d'arbitrage pour ce Workflow (les deux avis sont différents).
	 * @author Bastien F. & Thomas
	 * @param leWf
	 * 			Correspond au Workflow que l'on veut valider.
	 * @param decision 
	 * 			Correspond à la décision qui a été prise par l'utilisateur validateur. Cette validation peut prendre les valeurs "Accepte" ou "Refuse".
	 * @param personne 
	 * 			Correspond à la personne qui a fait la validation.
	 */
	public static void validateWorkflow (Wf leWf, Boolean decision, DataMDM personne)
	{
		// Premièrement, nous recherchons les deux instances de Validation qui nous intéressent.
		// N'oublions pas que l'attribut etat de cette classe peut prendre les valeurs : "Accepte", "En attente" ou "Refuse".
		
		//UNE FONCTION DE KIKI ET WENSHENG DEVRA FAIRE CELA ! A PARTIR DU WF CELA SUFFIT NORMALEMENT.
		Validation validateTuteur = leWf.getValidateTuteur(); 
		Validation validateResponsable = leWf.getValidateResponsable(); 
		LinkWf etatGeneralDuWf = leWf.getLinkWf();
		
		// Nous recherchons l'instance de Validation correspondant à la personne venant de valider le Workflow.
		if (validateTuteur.getValidator() == personne)		
		{
			// Si l'autre validation a déjà été effectuée, et qu'elle est positive, il va falloir réagir en fonction.
			if (validateResponsable.getState().equals("Accepte"))	
			{
				// Il va ici falloir valider définitivement le Workflow car les deux décisions sont positives, et appeler la méthode effectuant les modifications adéquates.
				if (decision == true)
				{
					// Validation de l'état général du Workflow.
					etatGeneralDuWf.setState("Accepte") ;
					// save()
					
					// Validation de l'état de l'instance de validation de la personne venant de faire une validation
					validateTuteur.setState("Accepte") ;
					// save()
					
					// Appel de la fonction clé qui va effectuer la modification dans le MDM.
					// Cette fonction est placée dans le Workflow, elle est abstraite dans la super classe et implémentée dans les sous-classes. L'exploitation du polymorphisme permettra d'appeler ici de manière générique la bonne méthode associée à la bonne sous-classe du Workflow.
					leWf.executer() ;
					
					// Eventuellement ici une notification ?
					//ICI LA FONCTION ;
				}
				else
				// Ici il va y avoir une contradiction entre les avis des deux validateurs.
				{
					// On passe l'état général du Workflow en "arbitrage".
					etatGeneralDuWf.setState("Arbitrage") ;
					// save()
					
					// Invalidation de l'état de l'instance de validation de la personne venant de la faire.
					validateTuteur.setState("Refuse") ;
					// save()
					
					// Création d'une instance d'arbitrage.
					Arbitrage arbitration = new Arbitrage ("En attente",validateTuteur.getValidator(),leWf) ; //Initialement getValidateurs mais il me semble que Lydia a mis getValidator
					leWf.setTutorArbitration(arbitration) ;
					// save()	// ATTENTION, ON SAUVE SEULEMENT LE WF ? VU QUE L'INSTANCE D'ARBITRAGE SERA ENTRE A L'INTERIEUR ? OU ON SAUVA AUSSI L'INSTANCE D'ARBITRAGE A PART ?
					
					// Eventuellement ici une notification ?
					//ICI LA FONCTION ;
				}
			}
			else
			{
				// Si l'autre validation a déjà été effectuée et est négative.
				if (validateResponsable.getState().equals("Refuse")) 
				{
					// Ici il va y avoir une contradiction entre les avis des deux validateurs.
					if (decision == true)
					{
						// On passe l'état général du Workflow en "arbitrage".
						etatGeneralDuWf.setState("Arbitrage") ;
						
						// Invalidation de l'état de l'instance de validation de la personne venant de la faire.
						validateTuteur.setState("Accepte") ;
						// save()
						
						// Création d'une instance d'arbitrage.
						Arbitrage arbitration = new Arbitrage ("En attente",validateTuteur.getValidator(),leWf) ;
						leWf.setTutorArbitration(arbitration) ;
						// save()	// ATTENTION, ON SAUVE SEULEMENT LE WF ? VU QUE L'INSTANCE D'ARBITRAGE SERA ENTRE A L'INTERIEUR ? OU ON SAUVA AUSSI L'INSTANCE D'ARBITRAGE A PART ?
						
						// Eventuellement ici une notification ?
						//ICI LA FONCTION ;
					}
					else
					// Il va ici falloir valider définitivement le Workflow car les deux décisions sont positives, et appeler la méthode effectuant les modifications adéquates.
					{
						// Validation de l'état général du Workflow.
						etatGeneralDuWf.setState("Refuse") ;
						// save()
						
						// Validation de l'état de l'instance de validation de la personne venant de faire une validation
						validateTuteur.setState("Refuse") ;
						// save()
						
						// Eventuellement ici une notification ?
						//ICI LA FONCTION ;
					}
				}
				else
				// Dans cet ultime cas, nous sommes en présence de la première validation. Il n'y aura alors que l'objet Validation à modifier (et à entrer en base de données).
				{
					// Il suffit dans ce cas de valider l'instance de Validation adaptée.
					if (decision == true)
					{
						validateTuteur.setState("Accepte") ;
					}
					else
					{
						validateTuteur.setState("Refuse") ;
					}
					// save()
				}
			}
		}
		else
		// Dans ce cas, c'est l'autre instance de Validation qui est concernée. Nous allons faire les mêmes actions, mais dans l'ordre inversé.
		{
			if (validateTuteur.getState().equals("Accepte"))	
			{
				// Il va ici falloir valider définitivement le Workflow car les deux décisions sont positives, et appeler la méthode effectuant les modifications adéquates.
				if (decision.equals("Accepte"))
				{
					// Validation de l'état général du Workflow.
					etatGeneralDuWf.setState("Accepte") ;
					// save()
					
					// Validation de l'état de l'instance de validation de la personne venant de faire une validation
					validateResponsable.setState("Accepte") ;
					// save()
					
					// Appel de la fonction clé qui va effectuer la modification dans le MDM.
					leWf.executer() ;
					
					// Eventuellement ici une notification ?
					//ICI LA FONCTION ;
				}
				else
				// Ici il va y avoir une contradiction entre les avis des deux validateurs.
				{
					// On passe l'état général du Workflow en "arbitrage".
					etatGeneralDuWf.setState("Arbitrage") ;
					// save()
					
					// Invalidation de l'état de l'instance de validation de la personne venant de la faire.
					validateResponsable.setState("Refuse") ;
					// save()
					
					// Création d'une instance d'arbitrage.
					Arbitrage arbitration = new Arbitrage ("En attente",validateTuteur.getValidator(),leWf) ;
					leWf.setTutorArbitration(arbitration) ;
					// save()	// ATTENTION, ON SAUVE SEULEMENT LE WF ? VU QUE L'INSTANCE D'ARBITRAGE SERA ENTRE A L'INTERIEUR ? OU ON SAUVA AUSSI L'INSTANCE D'ARBITRAGE A PART ?
					
					// Eventuellement ici une notification ?
					//ICI LA FONCTION ;
				}
			}
			else
			{
				// Si l'autre validation a déjà été effectuée et est négative.
				if (validateTuteur.getState().equals("Refuse")) 
				{
					// Il va ici falloir valider définitivement le Workflow car les deux décisions sont positives, et appeler la méthode effectuant les modifications adéquates.
					if (decision.equals("Accepte"))
					{
						// On passe l'état général du Workflow en "arbitrage".
						etatGeneralDuWf.setState("Arbitrage") ;
						// save()
						
						// Invalidation de l'état de l'instance de validation de la personne venant de la faire.
						validateResponsable.setState("Accepte") ;
						// save()
						
						// Création d'une instance d'arbitrage.
						Arbitrage arbitration = new Arbitrage ("En attente",validateTuteur.getValidator(),leWf) ;
						leWf.setTutorArbitration(arbitration) ;
						// save()	// ATTENTION, ON SAUVE SEULEMENT LE WF ? VU QUE L'INSTANCE D'ARBITRAGE SERA ENTRE A L'INTERIEUR ? OU ON SAUVA AUSSI L'INSTANCE D'ARBITRAGE A PART ?						
						
						// Eventuellement ici une notification ?
						//ICI LA FONCTION ;
					}
					else
					// Ici il va y avoir une contradiction entre les avis des deux validateurs.
					{
						// Validation de l'état général du Workflow.
						etatGeneralDuWf.setState("Refuse") ;
						// save()
						
						// Validation de l'état de l'instance de validation de la personne venant de faire une validation
						validateResponsable.setState("Refuse") ;
						// save()
						
						// Eventuellement ici une notification ?
						//ICI LA FONCTION ;
					}
				}
				else
				// Dans cet ultime cas, nous sommes en présence de la première validation. Il n'y aura alors que l'objet Validation à modifier (et à entrer en base de données).
				{
					if (decision == true)
					{
						validateResponsable.setState("Accepte") ;
					}
					else
					{
						validateResponsable.setState("Refuse") ;
					}
					// save()
				}
			}
		}
	}
	
	/**
	 * Méthode permettant d'arbitrer un Workflow.
	 * L'arbitrage survient après deux validations différente
	 * C'est au tuteur de la communauté de trancher
	 * @author Bastien F. & Thomas
	 * @param leWf
	 * 			Correspond au Workflow que l'on veut valider.
	 * @param decision 
	 * 			Correspond à la décision qui a été prise par l'utilisateur arbitre.
	 * @param arbitre 
	 * 			Correspond au tuteur qui fait l'arbitrage.
	 */
	public static void ArbitrateWorkflow(Wf leWf, boolean decision, DataMDM arbitre)
	{
		Arbitrage arbitration = leWf.getTutorArbitration();
		LinkWf etatGeneralDuWorkflow = leWf.getLinkWf();
		//si on 
		if(decision == true)
		{
			arbitration.setState("Accepte");
			//save
			
			//le workflow est indiqué comme accepté
			etatGeneralDuWorkflow.setState("Accepte");
			
			//on exécute la demande
			leWf.executer();
		}
		else
		{
			//le worflow est indiqué comme refusé.
			etatGeneralDuWorkflow.setState("Refuse");
		}
	}
	
	
	//Cette partie là est à voir si on garde selon les fonctions codées en tout premier par Bastien et Thomas
	
	/**
	 * Demande la création d'un ModelMDM fils d'un ModelMDM père, avec un label
	 * et une description
	 * 
	 * @author Solene et Fanny
	 * @param modeleMDMPere
	 * @param label
	 * @param description
	 */
	// Il nous faut le demandeur
	public static void requestCreateModelMDM(ModelMDM modeleMDMPere, String label, String description) {
		
	}

	/**
	 * Demande la création d'un ModelMDM de nature indiquée, avec le label et la
	 * description
	 * 
	 * @author Solene et Fanny
	 * @param nature
	 * @param label
	 * @param description
	 */
	// Il nous faut le demandeur
	/*
	 * public void requestCreateModelMDM(Nature nature, String label, String
	 * description){ }
	 */
	/**
	 * Demande la création d'un DataMDM instance d'un ModelMDM fils d'un autre
	 * ModelMDM, et il indique donc le dataMDMPere associé
	 * 
	 * @author Solene et Fanny
	 * @param modelAssocie
	 * @param dataMDMPere
	 * @param description
	 */
	// Il nous faut le demandeur
	public static void requestCreateDataMDM(ModelMDM modelAssocie, DataMDM dataMDMPere, String description) {

	}

	/**
	 * Demande la création d'un DataMDM
	 * 
	 * @author Solene et Fanny
	 * @param modelAssocie
	 */
	public static void requestCreateDataMDM(ModelMDM modelAssocie) {

	}
	
	
	//Fin de la partie à considérer à garder 
	
	
	/**
	 * Demande d'une inscription d'un demandeur au sein d'une communauté DataMDM nomCom pour un role indiqué
	 * RelationshipWf concernera les propositions d’écriture relatives aux relations entre objets (rôle et niveau de rattachement). 
	 * Elle contiendra les propriétés Start et End correspondant au sens du niveau de rattachement (évoqué à plusieurs reprises plus haut dans le rapport) et relationName 
	 * correspondant au nom de la relation (dans le cas d’un ajout de rôle : le nom du rôle, dans le cas d’un ajout de rattachement : principal, normal ou marginal)
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du Workflow
	 * @param nomCom
	 * 		La Communauté DataMDM concernée par ce workflow
	 * @param role
	 * 		Le role demandé par le demandeur dans la communité nomCom
	 * @param description
	 * 		La description associée à ce workflow
	 */
	// Il nous faut le demandeur
	public static void requestApplicationCommunity(DataMDM demandeur, DataMDM nomCom, Role role, String description) 
	{
		// Création du nouveau Workflow
		Wf newWf = new RelationshipWf (null,demandeur, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	/**
	 * Demande d'une inscription d'un demandeur au sein d'une communauté ModelMDM nomCom pour un role indiqué
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow
	 * @param nomCom
	 * 		La communauté ModelMDM concernée par ce workflow
	 * @param role
	 * 		Le role demandé par le demandeur dans la communauté nomCom
	 * @param description
	 * 		La description associée à ce workflow
	 */
	// Il nous faut le demandeur
	public static void requestApplicationCommunity(DataMDM demandeur, ModelMDM nomCom, Role role, String description) 
	{
		// Création du nouveau Workflow
		Wf newWf = new RelationshipWf(null, demandeur, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	/**
	 * Demande d'une inscription d'un user au sein d'une communauté sur une Nature nomCom pour un role indiqué
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow
	 * @param nomCom
	 * 		La communauté portant sur une nature concernée par ce workflow
	 * @param role
	 * 		Le role demandé par le demandeur dans la communauté nomCom
	 * @param description
	 * 		La description associée à ce workflow
	 */
	// Il nous faut le demandeur
	public static void requestApplicationCommunity(DataMDM demandeur, Nature nomCom, Role role, String description) 
	{
		// Création du nouveau Workflow
		Wf newWf = new RelationshipWf(null, demandeur, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}

	/**
	 * un utilisateur fait la demande pour intégrer un autre utilisateur au sein
	 * d'une communauté portant sur un DataMDM pour un rôle donné
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow
	 * @param user_proposed
	 * 		L'utilisateur que le demandeur veut intégrer au sein de la communauté
	 * @param nomCom
	 * 		La communauté DataMDM dans laquelle le user_proposed serait intégré
	 * @param role
	 * 		Le role avec lequel le user_proposed serait intégré dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestProposeMember(DataMDM demandeur, DataMDM user_proposed, DataMDM nomCom, Role role, String description) 
	{
		// demande d’ajout d’un autre utilisateur dans une communauté data ou model
		Wf newWf = new RelationshipWf(null,demandeur, user_proposed, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	/**
	 * Un utilisateur fait la demande pour intégrer un autre utilisateur au sein d'une
	 * communauté portant sur un ModelMDM pour un rôle donné
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow
	 * @param user_proposed
	 * 		L'utilisateur que le demandeur veut intégrer au sein de la communauté
	 * @param nomCom
	 * 		La communauté ModelMDM dans laquelle le user_proposed serait intégré
	 * @param role
	 * 		Le role avec lequel le user_proposed serait intégré dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestProposeMember(DataMDM demandeur, DataMDM user_proposed, ModelMDM nomCom, Role role, String description) {
		// demande d’ajout d’un autre utilisateur dans une communauté data ou model
		Wf newWf = new RelationshipWf(null,demandeur, user_proposed, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}

	/**
	 * Un utilisateur fait la demande pour intégrer un autre utilisateur au sein d'une
	 * communauté portant sur une Nature pour un rôle donné
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow
	 * @param user_proposed
	 * 		L'utilisateur que le demandeur veut intégrer au sein de la communauté
	 * @param nomCom
	 * 		La communauté portant sur une Nature dans laquelle le user_proposed serait intégré
	 * @param role
	 * 		Le role avec lequel le user_proposed serait intégré dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestProposeMember(DataMDM demandeur, DataMDM user_proposed, Nature nomCom, Role role, String description) {
		// demande d’ajout d’un autre utilisateur dans une communauté data ou model
		Wf newWf = new RelationshipWf(null,demandeur, user_proposed, nomCom, role, description, "CREATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	
	/*
	 * public void requestAjouterMembre (DataMDM user, ModelMDM com, Role role,
	 * String description){ //ajoute un utilisateur dans la communauté avec le
	 * role demandé //à mettre dans DataMDM et ModelMDM }
	 * 
	 * public void requestAjouterMembre (DataMDM user, DataMDM com, Role role,
	 * String description){ //ajoute un utilisateur dans la communauté avec le
	 * role demandé //à mettre dans DataMDM et ModelMDM }
	 * 
	 * public void requestRefuserMembre(DataMDM user, ModelMDM com, Role role,
	 * String description){ //ajoute un utilisateur dans la communauté avec le
	 * role refusé //à mettre dans DataMDM et ModelMDM }
	 * 
	 * 
	 * public void requestRefuserMembre(DataMDM user, DataMDM com, Role role,
	 * String description){ //ajoute un utilisateur dans la communauté avec le
	 * role refusé //à mettre dans DataMDM et ModelMDM }
	 */
	
	
	/**
	 *  Demande de désinscription de l'utilisateur dans la communauté portant sur un DataMDM
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici se désinscrire
	 * @param nomCom
	 * 		La communauté DataMDM que le demandeur veut quitter
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestUnsubscribe(DataMDM demandeur, DataMDM nomCom, String description) 
	{
		// demande la désinscription de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom, description,"UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}

	/**
	 * Demande de désincription de l'utilisateur dans la communauté portant sur un ModelMDM
	 * Le demandeur passe donc de son rôle actuel au rôle "refusé". On fait donc un update
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici se désinscrire
	 * @param nomCom
	 * 		La communauté ModelMDM que le demandeur veut quitter
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestUnsubscribe(DataMDM demandeur, ModelMDM nomCom, String description) 
	{
		// demande la désinscription de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom, description, "UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	
	/**
	 * Demande de désincription de l'utilisateur dans la communauté portant sur une Nature
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici se désinscrire
	 * @param nomCom
	 * 		La communauté portant sur une nature que le demandeur veut quitter
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestUnsubscribe(DataMDM demandeur, Nature nomCom, String description) 
	{
		// demande la désinscription de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom,  description, "UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}


	
	/**
	 * Demande de modification de role dans une communauté portant sur un DataMDM
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici modifier son role
	 * @param nomCom
	 * 		La communauté DataMDM dans laquelle le demandeur veut changer son role
	 * @param role
	 * 		Le role que le demandeur veut dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	// Il manque le demandeur
	public static void requestModificationRole(DataMDM demandeur, DataMDM nomCom, Role role, String description) 
	{	
		// demande de
		// modification du role de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom, role, description, "UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	/**
	 * Demande de modification de role dans une communauté portant sur un ModelMDM
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici modifier son role
	 * @param nomCom
	 * 		La communauté ModelMDM dans laquelle le demandeur veut changer son role
	 * @param role
	 * 		Le role que le demandeur veut dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestModificationRole(DataMDM demandeur, ModelMDM nomCom, Role role, String description) {// demande de
		// modification du role de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom, role, description, "UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	
	
	/**
	 * Demande de modification de role dans une communauté portant sur une Nature
	 * @author Fanny
	 * @param demandeur
	 * 		Le demandeur à l'origine du workflow qui veut ici modifier son role
	 * @param nomCom
	 * 		La communauté portant sur une nature dans laquelle le demandeur veut changer son role
	 * @param role
	 * 		Le role que le demandeur veut dans la communauté
	 * @param description
	 * 		La description associée à ce workflow
	 */
	public static void requestModificationRole(DataMDM demandeur, Nature nomCom, Role role, String description) {// demande de
		// modification du role de l’utilisateur dans la communauté donnée
		Wf newWf = new RelationshipWf(null,demandeur, nomCom, role, description, "UPDATE");
		
		// Sauvegarde de ce nouveau Workflow dans la base
		//newWf.save() ;
	}
	

	/**
	 * Demande de création d'une hiérarchie entre deux modèleMDM, le père et le
	 * fils
	 * 
	 * @author Solene et Fanny
	 * @param demandeur
	 * @param modelPere
	 * @param fils
	 * @param description
	 */
	// Il nous manque le demandeur
	/*public static void requestCreateHierarchy(DataMDM demandeur, ModelMDM modelPere, ModelMDM fils, String description) {
		
	}
*/
	/**
	 * Demande de création d'un rattachement à un DataMDM sur un autre DataMDM
	 * 
	 * @author Solene et Fanny
	 * @param donneeAyantUnRattachement
	 * @param aUneDonne
	 * @param description
	 */
	// Il nous manque le demandeur
/*	public static void requestCreateAttachementDataMDM(DataMDM donneeAyantUnRattachement, DataMDM aUneDonne,String description) {

	}
	
*/
	/**
	 * Demande d'affichage de l'ensemble des workflow associé à un DataMDM (utilisateur)
	 * Ne nécessite pas le type, nous ne sommes pas en charge de faire le filtrage.
	 * Nous leur offrons juste de récupérer tous les Wf d'un DataMDM, et les getters
	 * afin qu'ils puissent faire eux-même le filtrage.
	 *
	 * @author Vinhou et Ludo
	 * @param User
	 * 		L'utilisateur dont on veut cherche les workflows associés
	 * @return setWorkflow
	 * 		L'ensemble des workflows associés à l'user
	 */
	public static Set readSetWorkflowType (DataMDM user){
		Set setWorkflow = new HashSet();
		DAOFactory df = new Neo4jDAOFactory();
		WFDataDAO dao = df.createWFDataDAO();
		setWorkflow = dao.getWorkflow(user, "ModelData");
		return setWorkflow;
	}
	
	
	/**
	 * Retourne l'ensemble des commentaires liés au Workflow passé en paramètre.
	 * @author Bastien F. et Thomas
	 * @param leWf
	 * 		Le workflow pour lequel on souhaite les commentaires.
	 */
	public static List<Comments> askForComments(Wf _leWf)
	{
		// ALLER CHERCHER DANS LA BASE TOUS LES COMMENTAIRES LIES AU WF PASSE EN PARAMETRE.
		
		return null;
	}
	
	
	/**
	 * Demande de fermeture d'un workflow car celui ci est terminé
	 * @author Fanny
	 * @param wf
	 * 		Le workflow que l'on souhaite fermer
	 */
	public static void closeWf(Wf wf){
		wf.closeWf();
	}
	
	/**
	 * @author Vinhou, Killian , Ludo
	 * 
	 * Méthode de la façade permettant de récupérer le type de la requête
	 * Utile par exemple pour l'IHM afin d'effectuer le filtrage.
	 * @param wf
	 * @return Le String correspondant au type du WF (Create, Update, Delete ...)
	 */
	
	public static String getRequestType(Wf wf){
		return wf.getRequestType();
	}
}
