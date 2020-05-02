package model;

public class RelationshipWf extends Wf
{

	/****************************************************************
	 *                    Variables de la classe                      *
	 ****************************************************************/

	String typeRelation ;   
		// Si ajout d'un nouveau rôle : contient le nom du rôle.
		// Si ajout d'un rattachement : contient le type de ce rattachement "principal", "normal" et "marginal".
		// VOIR POUR CI-DESSUS, PEUT-ETRE PLUTOT CREER DEUX VARIABLES DIFFERENTES : ROLE (car la classe va exister) ET RATTACHEMENT (à créer éventuellement).

	DataMDM start ;	//le demandeur associé au workflow
	
	Role role; 	//role que l'on va récupérer de la façade car en interne, nous n'en avons pas besoin
				//on va donc le stocker ici pour le renvoyer plus tard si besoin
	
	DataMDM userPropose; 	//l'utilisateur qu'un membre de la communauté pourra proposé
							//on le stocke ici pour pouvoir le réutiliser plus tard si besoin car en interne 
							//nous n'en avons pas besoin pour l'instant
	
	
	
	/****************************************************************
	 *                 Constructeurs de la classe                    *
	 ****************************************************************/

	/**
	 * Constructeur pour l'inscription ou le changement
	 * de role d'un user dans une commaunuté portant sur un objet DataMDM
	 * @author Fanny
	 * @param identifiant
	 * 		Identifiant du noeud associé au workflow Relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param nomCom
	 * 		la communauté DataMDM concernée par ce workflow
	 * @param _role
	 * 		le role associé au demandeur (qu'il veut ou qu'on doit modifier)
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, DataMDM nomCom, Role _role, String description, String type)
	{
		super(identifiant,description, demandeur, nomCom, type);
		role = _role;
		userPropose = null;
		typeRelation = null;
		start = null;
	}
	
	
	/**
	 * Constructeur pour l'inscription ou le changement
	 * de role d'un user dans une communauté portant sur un objet ModelMDM 
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param nomCom
	 * 		la communauté ModelMDM concernée par ce workflow
	 * @param _role
	 * 		le role associé au demandeur (qu'il veut ou qu'on doit modifier)
	 * @param description
	 * 		la description associée au workflow
	 * @param type 
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, ModelMDM nomCom, Role _role, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = _role;
		userPropose = null;
		typeRelation = null;
		start = null;
	}
	
	/**
	 * Constructeur pour l'inscription ou le changement 
	 * de role d'un user dans une communauté portant sur une nature
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param nomCom
	 * 		la communauté portant sur une nature concernée par ce workflow
	 * @param _role
	 * 		le role associé au demandeur (qu'il veut ou qu'on doit modifier)
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, Nature nomCom, Role _role, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = _role;
		userPropose = null;
		typeRelation = null;
		start = null;
	}
	
	/**
	 * Constructeur pour la proposition d'un membre par une autre personne dans une communauté portant sur une DataMDM
	 * pour un role donné
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param user_proposed
	 * 		l'user que le demandeur aura proposé
	 * @param nomCom
	 * 		la communauté DataMDM concernée par ce workflow
	 * @param _role
	 * 		le role que l'on veut donner à l'user_proposed dans la communauté
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, DataMDM user_proposed, DataMDM nomCom, Role _role, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = _role;
		userPropose = user_proposed;
		typeRelation = null;
		start = null;
	}
	
	
	/**
	 * Constructeur pour la proposition d'un membre par une autre personne dans une communauté portant sur une ModelMDM
	 * pour un role donné
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param user_proposed
	 * 		l'user que le demandeur aura proposé
	 * @param nomCom
	 * 		la communauté ModelMDM concernée par ce workflow
	 * @param _role
	 * 		le role que l'on veut donner à l'user_proposed dans la communauté
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, DataMDM user_proposed, ModelMDM nomCom, Role _role, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = _role;
		userPropose = user_proposed;
		typeRelation = null;
		start = null;
	}
	
	
	/**
	 * Constructeur pour la proposition d'un membre par une autre personne dans une communauté portant sur une Nature
	 * pour un role donné
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship
	 * @param user_proposed
	 * 		l'user que le demandeur aura proposé
	 * @param nomCom
	 * 		la communauté portant sur une Nature concernée par ce workflow
	 * @param role
	 * 		le role que l'on veut donner à l'user_proposed dans la communauté
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf (Object identifiant, DataMDM demandeur, DataMDM user_proposed, Nature nomCom, Role _role, String description, String type){
		super(identifiant,description, demandeur, nomCom, type);
		
		role = _role;
		userPropose = user_proposed;
		typeRelation = null;
		start = null;
	}
	
	/**
	 * Constructeur pour la désinscription d'un membre dans une communauté
	 * portant sur un DataMDM
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship (qui veut ici se désincrire)
	 * @param nomCom
	 * 		la communauté DataMDM dont le demandeur veut se désinscrire
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf(Object identifiant, DataMDM demandeur, DataMDM nomCom, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = null;
		userPropose = null;
		typeRelation = null;
		start = null;
	
	}
	
	
	/**
	 * Constructeur pour la désinscription d'un membre dans une communauté 
	 * portant sur un ModelMDM
	 * @author Fanny
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship (qui veut ici se désinscrire)
	 * @param nomCom
	 * 		la communauté ModelMDM dont le demandeur veut se désinscrire
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf(Object identifiant, DataMDM demandeur, ModelMDM nomCom, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = null;
		userPropose = null;
		typeRelation = null;
		start = null;
	
	}
	
	/**
	 * Constructeur pour la désinscription d'un membre dans une communauté
	 * portant sur une Nature
	 * @param identifiant
	 * 		identifiant du noeud associé au workflow relationship
	 * @param demandeur
	 * 		le demandeur associé au workflow relationship (qui veut ici se désinscrire)
	 * @param nomCom
	 * 		la communauté portant sur une Nature dont le demandeur veut se désinscrire
	 * @param description
	 * 		la description associée au workflow
	 * @param type
	 * 		le type de la demande (CREATE, DELETE ou UPDATE)
	 */
	public RelationshipWf(Object identifiant, DataMDM demandeur, Nature nomCom, String description, String type){
		super(identifiant, description, demandeur, nomCom, type);
		
		role = null;
		userPropose = null;
		typeRelation = null;
		start = null;
	
	}
	
	
	/****************************************************************
	 *              Getters/Setters de la classe                      *
	 ****************************************************************/

	
	/**
	 * Permet d'obtenir le type relation lié au workflow
	 * @author Fanny
	 * @return typeRelation
	 * 		Le typeRelation du workflow
	 */
	public String getTypeRelation() {
		return typeRelation;
	}
	
	/**
	 * Permet d'entrer un nouveau type relation
	 * @author Fanny
	 * @param _typeRelation
	 * 		Le nouveau type relation
	 */
	public void setTypeRelation(String _typeRelation){
		typeRelation = _typeRelation;
	}
	
	/**
	 * Permet d'obtenir le role que le demandeur veut, que l'userPropose voudrait dans la communauté
	 * @author Fanny
	 * @return Role
	 * 		Le role de l'userPropose ou du demandeur
	 */
	public Role getRole(){
		return this.role;
	}
	
	/**
	 * Permet d'entrer un nouveau role pour le workflow
	 * @author Fanny
	 * @param _role
	 * 		Le nouveau role voulu (pour changer celui que voulait l'userPropose ou le demandeur)
	 */
	public void setRole(Role _role){
		role = _role;
	}
	
	/**
	 * Permet d'obtenir le demandeur associé au workflow
	 * @author Fanny
	 * @return start
	 * 		Le demandeur associé au workflow
	 */
	public DataMDM getStart(){
		return this.start;
	}
	
	/**
	 * Permet d'entrer un nouveau demandeur pour le workflow
	 * @author Fanny
	 * @param _start
	 * 		Le nouveau demandeur associé au workflow
	 */
	public void setStart(DataMDM _start){
		this.start = _start;
	}
	
	/**
	 * Permet d'obtenir l'userPropose pour le workflow
	 * @author Fanny
	 * @return userPropose
	 * 		L'user proposé par le demandeur pour le workflow
	 */
	public DataMDM getUserPropose(){
		return this.userPropose;
	}
	
	/**
	 * Permet d'entrer un nouveau userPorpose pour le workflow
	 * @author Fanny
	 * @param _userPropose
	 * 		Le nouvel userPropose pour le workflow
	 */
	public void setUserPropose(DataMDM _userPropose){
		userPropose = _userPropose;
	}
	
}