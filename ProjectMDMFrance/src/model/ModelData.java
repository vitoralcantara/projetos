package model;

import facade.CRUDFacade;
import facade.GCFacade;

public class ModelData extends Wf
{
	// Variables de la sous classe
	
	private String nomObjet ; 			// Nom de l'objet qui devra être créé.
	private ModelValue modelValueCible; //le model value sur lequel porte la modification si la modification porte sur un model value
	private String newDataType ;		// Type de la donnée dans le cas où le Workflow porte sur une modification de ModelValue.
	//Solene : ca serait super d'avoir l'id du newDataType s'il y en a un
	
	private Object newDataValue ; 		// Nouvelle donnée si modification d'une donnée contenue dans un DataValue.
	private Socle theSocle ;


	
	// Constructeurs
	
	/**
	 * Constructeur de la classe, permettant de créer un nouveau Workflow.
	 * Cette sous-classe concernera les demandes d’écritures relatives aux modèles et aux données : particulièrement le 
	 * mapping structure ModelValue, et la création (ou modification ou suppression) d’un objet ModelMDM. 
	 * Pour le mapping structure, cela correspond ainsi aux demandes d’action sur les objets de type ModelValue.
	 * Pour la création d'un objet ModelMDM, celui-ci sera placé en tant que fils de de l'objet passé en paramètre : modeleAssocie.
	 * Pour la modification d'un objet ModelMDM, ce sera ce dernier qui sera directement modifié.
	 * Il pourra également être possible avec cette méthode d'effectuer une action sur un socle associé à un ModelValue pour un
	 * ModelMDM donné. 
	 * Ces actions sont essentiellement des ajouts ou des modifications.
	 * @author Bastien F. et Thomas
	 * @param nom
	 * 			Indique le nom que pourra prendre le DataValue dans le cas d'une modification du mapping structure, ou le nom de
	 * 		    l'objet ModelMDM dans le cas de l'ajout d'un nouvel objet, ou dans le cas de la modification du nom d'un de ceux déjà
	 * 			existants.
	 * 			Si la proposition d'écriture ne porte pas sur cet attribut, le paramètre sera passé avec la valeur NULL. 
	 * @param typeAttribut
	 * 			Indique le nouveau type d'attribut dans le cas d'une modificiation d'un type d'attribut d'une ModelValue.
	 * 			Cette valeur sera indiquée à NULL si la demande ne porte pas sur la modification du type d'un attribut.
	 * @param demandeur
	 * 			Indique l'utilisateur qui a demandé cette proposition d'écriture.
	 * @param modeleAssocie
	 * 			Indique l'objet de référence ModelMDM sur lequel porte cette modification.
	 * 			C'est la communauté de cet objet qui devra prendre la décision quant à l'issue du Workflow.
	 * 			Dans le cas de l'ajout d'un nouveau ModelMDM, celui-ci sera ajouté comme fils de celui-ci.
	 * @param modelValue
	 * 			Indique l'attribut MDM ModelValue sur lequel porte la modification
	 * @param leSocle
	 * 			Indique le nouveau socle dans le cas de la modification du socle d'une ModelValue.
	 * 			Cette donnée peut être indiquée à NULL dans le cas où le Workflow ne porterait pas sur ce type de modification.
	 * @param description
	 * 			Chaîne de caractères décrivant la proposition d'écriture. Celle-ci sera importante pour la prise de décision.
	 * @param type
	 * 			Indique le type de demande d'écriture du Workflow. Celui-ci peut prendre les valeurs "CREATE", "UPDATE" ou "DELETE".
	 */
	public ModelData (Object identifiant, String nom, String typeAttribut, DataMDM demandeur, ModelMDM modeleAssocie, ModelValue modelValue, Socle leSocle, String description, String type) 
	{
		// Appel du superConstructeur, celui associé ici aux ModelMDM.
		super(identifiant, description, demandeur, modeleAssocie, type);
		
		// Récupération des variables correspondant à cette sous-classe spécifiquement.
		this.modelValueCible = modelValue;
		this.nomObjet = nom ;
		this.newDataType = typeAttribut ;
		this.theSocle = leSocle ;
	}
	
	/**
	 * Constructeur de la classe, permettant de créer un nouveau Workflow.
	 * Cette sous-classe concernera les demandes d’écritures relatives aux objets et aux données : création (ou modification 
	 * ou suppression) d’un objet DataMDM, ou d'une modification correspondant au mapping donnée DataValue. Cela correspond ainsi 
	 * respectivement aux demandes d’action sur les objets de type DataMdm ou DataValue.
	 * @author Bastien F. et Thomas
	 * @param nom
	 * 			Indique le nom que pourra prendre le DataMDM créé, ou son nouveau nom dans le cas d'une modification de celui-ci
	 * 			pour un DataMDM déjà existant.
	 * @param dataMDMAssocie
	 * 			Indique l'objet de référence DataMDM sur lequel porte cette modification.
	 * 			C'est la communauté de cet objet qui devra prendre la décision quant à l'issue du Workflow.
	 * 			Dans le cas de l'ajout d'un nouveau DataMDM, celui-ci sera ajouté comme fils de celui-ci.
	 * @param demandeur
	 * 			Indique l'utilisateur qui a demandé cette proposition d'écriture.
	 * @param description
	 * 			Chaîne de caractères décrivant la proposition d'écriture. Celle-ci sera importante pour la prise de décision.
	 * @param valeur
	 * 			Indique la nouvelle valeur à entrer dans une DataValue, dans le cas d'une modification d'une DataValue.
	 * @param type
	 * 			Indique le type de demande d'écriture du Workflow. Celui-ci peut prendre les valeurs "CREATE", "UPDATE" ou "DELETE".
	 */
	public ModelData (Object identifiant, String nom, DataMDM dataMDMAssocie, DataMDM demandeur, String valeur, String description, String type)
	{
		// Appel du superConstructeur, celui associé ici aux ModelMDM.
		super(identifiant, description, demandeur, dataMDMAssocie, type);
		
		// Récupération des variables correspondant à cette sous-classe spécifiquement.
		nomObjet = nom ;
		newDataValue = valeur ;
	}
	
	/**
	 * Permet d'executer la demande après que le workflow concernant un model ou un data soit validé
	 * @author Bastien F. et Thomas
	 */
	public void executer()
	{
	}

	
//****************Accesseurs******************************
	
	/**
	 * Permet de récupérer le nom de l'objet.
	 * @author Bastien F. et Thomas
	 * @return nomObjet
	 * 		Retourne un String correspondant au nom de l'objet à ajouter.
	 */
	public String getNomObjet() {
		return nomObjet;
	}

	/**
	 * Permet de passer un nouveau nom pour cet objet.
	 * @author Bastien F. et Thomas
	 * @param nomObjet
	 * 		Nom du String correspondant au nom de l'objet à ajouter.
	 */
	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}

	/**
	 * Permet de récupérer le nouveau type de Data (mapping structure).
	 * Ceci correspond au cas où la demande porte sur la classe ModelValue, comportant le type d'un champs.
	 * @author Bastien F. et Thomas
	 * @return newDataType
	 * 		Retourne un String correspondant au type de l'objet à ajouter ou modifier.
	 */
	public String getNewDataType() {
		return newDataType;
	}

	/**
	 * Permet de passer un nouveau type de données sur un ModelValue (mapping structure).
	 * Ceci correspond au cas où la demande porte sur la classe ModelValue, comportant le type d'un champs.
	 * @author Bastien F. et Thomas
	 * @param newDataType
	 * 		De type String permettant de passer le type du champs.
	 */
	public void setNewDataType(String newDataType) {
		this.newDataType = newDataType;
	}

	/**
	 * Permet de récupérer la valeur contenue dans une dataValue (mapping données).
	 * C'est la donnée contenue réellement pour un champs d'un objet DataMDM.
	 * @author Bastien F. et Thomas
	 * @return newDataValue
	 * 		Retourne un Object correspondant à la valeur de ce DataValue.
	 */
	public Object getNewDataValue() 
	{
		return newDataValue;
	}

	/**
	 * Permet de passer une nouvelle valeur de données sur un ModelValue (mapping structure).
	 * Ceci correspond au cas où la demande porte sur la classe ModelValue, comportant le type d'un champs.
	 * @author Bastien F. et Thomas
	 * @param newDataType
	 * 		De type Object permettant de passer la nouvelle valeur du champs.
	 */
	public void setNewDataValue(Object newDataValue) 
	{
		this.newDataValue = newDataValue;
	}

	/**
	 * Permet de récupérer le socle demandé pour ce Workflow.
	 * @author Bastien F. et Thomas
	 * @return theSocle
	 * 		Retourne le socle concerné Workflow.
	 */
	public Socle getTheSocle() 
	{
		return theSocle;
	}

	/**
	 * Permet de passer un nouveau socle pour ce Workflow
	 * @author Bastien F. et Thomas
	 * @param theSocle
	 * 		Le socle à entrer pour cette demande d'écriture ou modification.
	 */
	public void setTheSocle(Socle theSocle) 
	{
		this.theSocle = theSocle;
	}

	/**
	 * Permet de récupérer le ModelValue concerné.
	 * @author Bastien F. et Thomas
	 * @return modelValueCible
	 * 		Retourne le ModelValue concerné.
	 */
	public ModelValue getModelValueCible() {
		return modelValueCible;
	}

	/**
	 * Permet de passer un nouveau ModelValue pour ce Workflow.
	 * @author Bastien F. et Thomas
	 * @param modelValueCible
	 * 		Le ModelValue à entrer dans le Workflow.
	 */
	public void setModelValueCible(ModelValue modelValueCible) {
		this.modelValueCible = modelValueCible;
	}

	//Solene : A VOIR et a discuter
	public Object getIdSuperieur() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
