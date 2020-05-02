package model;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.ModelMDMDAO;

public class ModelMDM {

	/*----------Variables----------*/

	// identifiant du modelMDM dans la base de donnees
	Object identifiant;
	String label;
	String description;
	Nature nature;
	ModelMDM modelPere;
	

	/*----------Contructeur----------*/

	/**
	 * Constructeur l'identifiant sera initialise a -1, il devra être ajoute
	 * lors de l'enregistrement du modelValue dans la base.
	 * 
	 * @param label
	 *            String designant de facon unique le modelMDM a enregistrer
	 *            dans la base
	 * @param description
	 *            String donnant une breve description du modelMDM
	 * @author Gaetan
	 */
	public ModelMDM(Nature nature, String label, String description) {
		this.description = description;
		this.nature = nature;
		this.label = label;
		this.identifiant = null;
		this.modelPere=null;
		
	}
	
	/**
	 * Constructeur l'identifiant sera initialise a -1, il devra être ajoute
	 * lors de l'enregistrement du modelValue dans la base.
	 * 
	 * @param label
	 *            String designant de facon unique le modelMDM a enregistrer
	 *            dans la base
	 * @param description
	 *            String donnant une breve description du modelMDM
	  @param modelPere
	 *            model pere du model courant
	 * @author Gaetan
	 */
	public ModelMDM(Nature nature, String label, String description,ModelMDM modelPere) {
		this.description = description;
		this.nature = nature;
		this.label = label;
		this.identifiant = null;
		this.modelPere=modelPere;
		
	}

	/*----------Getters and setters----------*/

	/**
	 * @return l'identifant du modelMDM dans la base. Si le model n'a pas ete
	 *         enregistre, retourne null
	 */
	public Object getIdentifiant() {
		return identifiant;
	}

	/**
	 * Methode a appeler lors de l'enregistrement du modelMDM dans la base, pour
	 * enregistrer l'identifiant.
	 * 
	 * @param int correspondant a l'identifiant du modelMDM dans la base.
	 */
	public void setIdentifiant(Object identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * permt d'obtenir le label du modelMDM
	 * @return le label du modelMDM
	 * @author Gaetan
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * permet de modifier la valuer du label du ModelMDMs
	 * @param label string contenant le nouveau label a donner au modelMDM
	 * @author Gaetan
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * permt d'obtenir le label du modelMDM
	 * @return le label du modelMDM
	 * @author Gaetan
	 */
	public Nature getNature() {
		return this.nature;
	}

	/**
	 * permet de modifier la valuer du label du ModelMDMs
	 * @param label string contenant le nouveau label a donner au modelMDM
	 * @author Gaetan
	 */
	public void setNature(Nature nature) {
		this.nature = nature;
	}

	/**
	 * Permet d'obtenir la description du modelMDM.
	 * @return String contenant la description du modelMDM
	 * @author Gaetan
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Permet de modifier la description du modelMDM
	 * @param description : String contenant la nouvelle description du modelMDM.
	 * @author Gaetan
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public ModelMDM getModelPere() {
		return this.modelPere;
	}

	/**
	 * Permet de modifier la description du modelMDM
	 * @param description : String contenant la nouvelle description du modelMDM.
	 * @author Gaetan
	 */
	public void setModelPere(ModelMDM modelPere) {
		this.modelPere = modelPere;
	}

	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le responsable en dur
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le responsable
	 * @author Gaston Guy
	 */
	public void setResponsable() {
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		m.setResponsable();
	}
	
	/** Méthode utilisée uniquement lors de l'installation 
	 *  pour modifier le tuteur en dur
	 * 
	 * @param com
	 * 		La communauté de type Model pour laquelle on veut récupérer le tuteur
	 * @author Gaston Guy
	 */
	public void setTuteur() {
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		m.setTuteur();
	}
	
	/** Ajoute un utilisateur dans la communauté model donnée avec le role demandé
	 * 
	 * @param user	
	 * 		Utilisateur à ajouter
	 * @param com
	 * 		Communauté Model dans laquelle l'utilisateur va être ajouté
	 * @param role
	 * 		Role que va avoir l'utilisateur ajouté
	 * 
	 * @author Lydia
	 */
	public void addMember(DataMDM user, Role role) 
	{
		Object id= this.getIdentifiant();
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		m.addMember(id, user, role);
	}

	/** Modifie le role de l’utilisateur dans une communauté model de la BD
	 * 
	 * @param user
	 * 		Utilisateur dont on va modifier le role
	 * @param role
	 * 		Role que va avoir l'utilisateur
	 * 
	 * @author Aurélie :)
	 * 	 
	 */
	public void updateRole(DataMDM user, Role role)
	{
		Object id = this.getIdentifiant();  // on recupere l'identifiant du modelMDM
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO modele = df.createModelMDMDAO();
		modele.updateRole(id,user, role);
	}
	
}
