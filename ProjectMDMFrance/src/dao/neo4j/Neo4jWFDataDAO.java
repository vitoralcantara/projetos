package dao.neo4j;

import java.util.*;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.helpers.collection.IteratorUtil;

import model.Arbitrage;
import model.BriqueSIWf;
import model.Connector;
import model.DataMDM;
import model.DataValue;
import model.JDBC;
import model.LinkWf;
import model.ModelData;
import model.ModelMDM;
import model.ModelValue;
import model.Nature;
import model.RelationshipWf;
import model.Request;
import model.Validation;
import dao.model.WFDataDAO;
import facade.MappingFacade;


public class Neo4jWFDataDAO extends WFDataDAO{
	
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	
	//Pour la connexion a la base
		private GraphDatabaseService graphDB;
		
		private static enum RelationWfTypes implements RelationshipType{
			LINKWF,
			REQUEST,
			INTRA_WF,
			CONNECT_WF
		}

		
	
	/****************************************************************
	 *                    Methodes de la classe                     *
	****************************************************************/

	/**
	 * Methode permettant la connection à la base
	 * @author Solene
	 * @return true si la connexion est effectuée, false sinon
	 */
	public boolean openConnectionBase(){
		this.graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(path);
		registerShutdownHook(this.graphDB);
		
		//Comment on vérifie que la connexion est bien établie???
		return true;
	}
	
	/**
	 * Methode permettant de clore la connection a la base
	 * @author Solene
	 */
	public void closeConnection(){
		this.graphDB.shutdown();
		
	}

	/**
	 * Permet la connexion et la déconnexion propre
	 * @author Wensheng Zhang
	 * @param graphDB
	 */
	private static void registerShutdownHook(final GraphDatabaseService graphDB){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				graphDB.shutdown();
			}
		});
	}
	
	/**
	 * Recupere le demandeur de la request associé à un workflow en base
	 * 
	 * @author Ludovic, Vinh et Killian
	 * @param leNode du workflow 
	 * @return string demandeur de la request du workflow
	 */
	
	public String getAskerRequestWF(Node leNode)
	{
		//Création de la chaîne de caractères qui contiendra la requête
		String maRequete;
		String demandeur = "";
		

		//Etablissement de la connexion à la base de données
		if (this.openConnectionBase() == true){
			//Enregistrement de la requête dans le String maRequête
			maRequete = "start m=node("+ leNode +") match n-[r:REQUEST]->m return n;"; //censé retourner le node du demandeur (requete à confirmer car chemin inverse)
			System.out.println(maRequete);
			ExecutionEngine engine = new ExecutionEngine(this.graphDB);
			//Execution de la requête sur la base de données et récupération des résultats
			ExecutionResult result = engine.execute(maRequete);
			Iterator<Node> n_column = result.columnAs(maRequete); // création de l'iterateur qui parcourera chaque ligne du tableau
			for ( Node node : IteratorUtil.asIterable( n_column ))	{  
				demandeur = node + ": " + node.getProperty( "demandeur" ); // recupere le label du demandeur
			}
		}
		return demandeur;
	}
	
	/**
	 * Permet de récupérer la Map associé à un Wf
	 * On récupère dans un premier temps tous les modelMDM associés au Wf.
	 * Pour chaque node récupéré, on prend tous les modelValue associés
	 * qu'on insère dans une liste.
	 * On insère ensuite cette liste dans la map avec en clé le modelMDM associé.
	 * 
	 * @author Ludovic, Vinh et Killian
	 * @param leNode du workflow 
	 * @return map associé au workflow
	 */
	
	public Map getMapWf(Node leNode)
	{
		//Création de la chaîne de caractères qui contiendra la requête
		String maRequete1, maRequete2;
		String type;
		String description;
		ModelMDM modelMDM;
		String defaultValue;
		String label;
		String socle;
		String labelModel;
		String descriptionModel;
		Nature natureModel;
		Map<ModelMDM, List<ModelValue>> tables = new HashMap<ModelMDM, List<ModelValue>>();
		List<ModelValue> columns = null;

		//Etablissement de la connexion à la base de données
		if (this.openConnectionBase() == true){
			//Enregistrement de la requête dans le String maRequête
			maRequete1 = "start m=node("+ leNode +") match n-[r:IntraWF]->m return n;"; //censé retourner le node modelMDM
			System.out.println(maRequete1);
			ExecutionEngine engine = new ExecutionEngine(this.graphDB);
			//Execution de la requête sur la base de données et récupération des résultats
			ExecutionResult result = engine.execute(maRequete1);
			Iterator<Node> n_column = result.columnAs(maRequete1); // création de l'iterateur qui parcourera chaque ligne du tablea
			for ( Node node : IteratorUtil.asIterable( n_column ))	{  
				maRequete2 = "start m=node("+node+") match n-[r:IntraWF]->m return n;"; // Récupère les nodes (modelValue) assocéiés à chaque modelMDM
				ExecutionResult resultage = engine.execute(maRequete2);
				Iterator<Node> n_column2 = resultage.columnAs(maRequete2); // création de l'iterateur qui parcourera chaque ligne du tablea
				labelModel = node + ": " + node.getProperty( "label" );
				descriptionModel = node + ": " + node.getProperty( "Description" );
				natureModel = new Nature(node + ": " + node.getProperty( "nature" ));
				ModelMDM model = new ModelMDM(natureModel,descriptionModel,labelModel);
				for ( Node node2 : IteratorUtil.asIterable( n_column2 ))	{ 
					columns = new ArrayList<ModelValue>();
					type = node + ": " + node.getProperty( "type" );
					description = node + ": " + node.getProperty( "description" );
					defaultValue = node + ": " + node.getProperty( "defaultValue" );
					label = node + ": " + node.getProperty( "label" );
					socle = node + ": " + node.getProperty( "socle" );
					ModelValue modValue = new ModelValue(type, description,model,defaultValue,label,socle);
					columns.add(modValue);
				}
				tables.put(model, columns);
			}
		}
		return tables;
	}
	
	
	
	/**
	 * Recupere le type(équivalent de action) de la request associé à un workflow en base
	 * @author Ludovic, Vinh et Killian
	 * @param leNode du workflow 
	 * @return string de action de la request du workflow
	 */
	
	public String getActionRequestWF(Node leNode)
	{
		//Création de la chaîne de caractères qui contiendra la requête
		String maRequete;
		String action = null;
		

		//Etablissement de la connexion à la base de données
		if (this.openConnectionBase() == true){
			//Enregistrement de la requête dans le String maRequête
			maRequete = "start m=node("+ leNode +") match n-[r:REQUEST]->m return n;"; //censé retourner le node du demandeur (requete à confirmer car chemin inverse)
			System.out.println(maRequete);
			ExecutionEngine engine = new ExecutionEngine(this.graphDB);
			//Execution de la requête sur la base de données et récupération des résultats
			ExecutionResult result = engine.execute(maRequete);
			Iterator<Node> n_column = result.columnAs(maRequete); // création de l'iterateur qui parcourera chaque ligne du tableau
			for ( Node node : IteratorUtil.asIterable( n_column ))	{  
				action = node + ": " + node.getProperty( "action" ); // recupere le label du demandeur
			}
		}
		return action;
	}
	
	
	/**
	 * Recupere le connecteur associé à un workflow en base
	 * @author Ludovic, Vinh et Killian
	 * @param leNode du workflow 
	 * @return Connecteur lié au workflow
	 */
	public Connector getConnectorWf(Node leNode){
	
		String type = "";
		String login="";
		String password = "";
		String port = "";
		String typeDB = "";
		String database = "";
		
		//Dans le cas de WebService
		String url = "";
		String protocole = "";
		
		Connector connector = null;
		
		int host = -1;
		if (this.openConnectionBase() == true){
			//Enregistrement de la requête dans le String maRequête
			String maRequete = "start n=node("+ leNode +") match n-[r:ConnectWf]->m return m;";
			System.out.println(maRequete);
			ExecutionEngine engine = new ExecutionEngine(this.graphDB);
			//Execution de la requête sur la base de données et récupération des résultats
			ExecutionResult result = engine.execute(maRequete);
			Iterator<Node> n_column = result.columnAs(maRequete); // création de l'iterateur qui parcourera chaque ligne du tableau
			for ( Node node : IteratorUtil.asIterable( n_column ))	{  
				type = node + ": " + node.getProperty( "type" );
				login = node + ": " + node.getProperty( "login" );
				password = node + ": " + node.getProperty( "password" );
				host = Integer.parseInt(node + ": " + node.getProperty( "host" ));
				port = node + ": " + node.getProperty( "port" );
				typeDB = node + ": " + node.getProperty( "typeDB" );
				database = node + ": " + node.getProperty( "database" );

			}
			if (type == "JDBC"){
				connector = MappingFacade.createJDBC(login,password,port,host,typeDB,database);
			}
			else{
				//ON CREE UN WEBSERVICE :
				connector = MappingFacade.createWebService(login, password, url, protocole);
			}
		}
		return connector;
	}
	
	
	/**
	 * Récupère dans la base les workflows de type "typeWF" de l'utilisateur "user"
	 * Dans la base on peut récuperer directement 
	 * @author Ludovic, Vinh et Killian
	 * @param user
	 * @param typeWF
	 * @return setWorkflow
	 */
	
	public Set getWorkflow(DataMDM user, String typeWf){
		
		Object identifiant;					// Date à laquelle le Workflow a été créé.
		String description ;
		DataMDM demandeur ;					// Objet contenant le demandeur du Workflow
		String type;
		Nature nature ;	
		Connector connecteur;
		Map<ModelMDM, List<ModelValue>> map = new HashMap<ModelMDM, List<ModelValue>>(); 
		
		//création du Set pour stocker tous les WF
		Set setWorkflow = new HashSet();
		
		//Création de la chaîne de caractères qui contiendra la requête
		String maRequete;

		//Etablissement de la connexion à la base de données
		if (this.openConnectionBase() == true){
			//Enregistrement de la requête dans le String maRequête
			maRequete = "start n=node(*) match n-[r:VALIDATION|COMMENTWF|ARBITRAGE]->m where n.type = \"DataMDM\" and n.label = \"" + user.getLabel() + "\" return m;";
			System.out.println(maRequete);
			ExecutionEngine engine = new ExecutionEngine(this.graphDB);
			//Execution de la requête sur la base de données et récupération des résultats
			ExecutionResult result = engine.execute(maRequete);
			
						
			
			Iterator<Node> n_column = result.columnAs(maRequete); // création de l'iterateur qui parcourera chaque ligne du tableau
			for ( Node node : IteratorUtil.asIterable( n_column ))	{  
				// note: we're grabbing the name property from the node, 
				// not from the n.name in this case. 
				
				// récupération de tous les attributs nécessaires à la création d'un workflow
				
				identifiant = node + ": " + node.getProperty( "id" );
				nature = new Nature( node + ": " + node.getProperty( "type" ));
				demandeur = new DataMDM(this.getAskerRequestWF(node));
				description = node + ": " + node.getProperty( "description" );
				connecteur = this.getConnectorWf(node);
				//Map à reconstituer
				type = this.getActionRequestWF(node);
				map = this.getMapWf(node);
			
				// determiner le constructeur à utiliser
				if (type == "BriqueSIWf")
				{
					//appel du constructeur associé au bon workflow
					BriqueSIWf wfBriqueSI = new BriqueSIWf(identifiant, nature, demandeur, description, connecteur, map, type);
					setWorkflow.add(wfBriqueSI); // EN SUPPOSANT QUE C'EST DES WORKFLOWS QUI SONT RETOURNES xD
				}			
			}

			System.out.println(result);
			//Fin de la connexion
			this.closeConnection();

			//Met le workflow dans le set
		}
		return setWorkflow;
		
	}


	
	/**
	 * Methode générique qui crée un noeud WfBrique en base avec les proprietes 
	 * et le connecteur sous forme de String
	 * @author Solene et Wensheng
	 * @param wfBrique
	 * @return id du noeud créée
	 */
	public Object saveConnector(BriqueSIWf wfBrique){
		
		
		this.openConnectionBase();
		Transaction tx = graphDB.beginTx();
		long idConnecteur = -1;
		try{
			
			if (this.graphDB!=null){
				
				
				//Création du connecteur en base
				Connector c = wfBrique.getConnecteur();
				
				idConnecteur =  Long.parseLong(c.saveConnector().toString()) ;
				Node wfBriqueNode = this.graphDB.getNodeById(Long.parseLong(wfBrique.getIdentifiant().toString()));
				Node connector = this.graphDB.getNodeById(idConnecteur);
				wfBriqueNode.createRelationshipTo(connector, RelationWfTypes.CONNECT_WF);
			}
			
				tx.success();
			}
			finally{tx.finish();}
			this.closeConnection();
		
			return (Object) idConnecteur;
	}
	
	/**
	 * Methode générique qui créée un noeud WfModelData de type 
	 * ModelValue (colonnes) ou ModelMDM (tables)
	 * avec le nom de la colonne ou de la table associee
	 * et l'id supérieur (ModelMDM dans le cas d'une ModelValue, Nature dans le 
	 * cas d'un ModelMDM)
	 * @author Solene et Wensheng
	 * @param wfModelData
	 * @return idWfModelDataNode
	 */
	public Object saveWFModelData(ModelData wfModelData){		
		
		long idWfModelDataNode = -1;
		
		//Connexion a la base
		if (this.openConnectionBase()){
			
			Transaction tx = graphDB.beginTx();
			try{
			//Créée le Noeud WfModelData en base
			Node wfModelDataNode = graphDB.createNode();
			
			//Selon son type, l'instancie avec les attributs associés
			if (wfModelData.getNewDataType().equals("ModelValue")){
				//Si c'est un noeud de type ModelValue, il est rattaché a un ModelMDM
				wfModelDataNode.setProperty("ModelValue", wfModelData.getNewDataType());//A verifier
				
				//A TESTER : si id = -1 alors il faut créer le noeud ModelMDM
				wfModelDataNode.setProperty("idModelMDM", wfModelData.getIdSuperieur());
			}
			
			
			else{
				//Si c'est un noeud de type ModelMDM, il est rattaché à une Nature
				wfModelDataNode.setProperty("ModelMDM", wfModelData.getNewDataType());//A verifier
				
				long idNature = -1;
				//SE DEBROUILLER POUR RECUPERER L'ID DE LA NATURE
				wfModelDataNode.setProperty("idNature", idNature);//A verifier
			}
			
			//Dans les deux cas on lui attribue un nom
			wfModelDataNode.setProperty("nom", wfModelData.getNomObjet());//A verifier
			
			//Récupération de l'id
			idWfModelDataNode =  wfModelDataNode.getId();
			tx.success();
			}
			finally {
				tx.finish();
			}
			//Récupération de l'id :
			
			this.closeConnection();
		}
		
		return (Object)idWfModelDataNode;
		
	}

	
	/**
	 * 
	 * @author Solene & Wensheng
	 * @param value
	 * @param idWfBriqueSI
	 * @return idWfModelDataNode
	 */
	public Object saveWFModelData(ModelValue value, Object idWfBriqueSI){		
		
		long idWfModelDataNode = -1;
		
		//Connexion a la base
		if (this.openConnectionBase()){
			
			Transaction tx = graphDB.beginTx();
			try{
			//Créée le Noeud WfModelData en base
			Node wfModelDataNode = graphDB.createNode();
			
			//Selon son type, l'instancie avec les attributs associés

				//Si c'est un noeud de type ModelValue, il est rattaché a un ModelMDM
				wfModelDataNode.setProperty("ModelValue", "ModelValue");
				wfModelDataNode.setProperty("nom", value.getLabel());
				wfModelDataNode.setProperty("idSuperieur", value.getModelMdm().getIdentifiant());					
				//Récupération de l'id
				
				idWfModelDataNode =  wfModelDataNode.getId();
				Node predecesseur = this.graphDB.getNodeById(Long.parseLong(idWfBriqueSI.toString()));
				predecesseur.createRelationshipTo(wfModelDataNode, RelationWfTypes.INTRA_WF);
				tx.success();
			}
			finally {
				tx.finish();
			}
			//Récupération de l'id :
			
			this.closeConnection();
		}
		
		return (Object)idWfModelDataNode;
		
	}
	
	
	/**
	 * 
	 * @author Solene & Wensheng
	 * @param model
	 * @param idWfBriqueSI
	 * @return idWfModelDataNode
	 */
	public Object saveWFModelData(ModelMDM model, Object idWfBriqueSI){		
		
		long idWfModelDataNode = -1;
		
		//Connexion a la base
		if (this.openConnectionBase()){
			
			Transaction tx = graphDB.beginTx();
			try{
			//Créée le Noeud WfModelData en base
			Node wfModelDataNode = graphDB.createNode();
			
			//Selon son type, l'instancie avec les attributs associés

				//Si c'est un noeud de type ModelValue, il est rattaché a un ModelMDM
				wfModelDataNode.setProperty("ModelMDM", "ModelMDM");
				wfModelDataNode.setProperty("nom", model.getLabel());
				wfModelDataNode.setProperty("idSuperieur", model.getNature().getIdentifiant());	
				
				idWfModelDataNode =  wfModelDataNode.getId();
				model.setIdentifiant((Object)idWfModelDataNode);
				
				Node predecesseur = this.graphDB.getNodeById(Long.parseLong(idWfBriqueSI.toString()));
				predecesseur.createRelationshipTo(wfModelDataNode, RelationWfTypes.INTRA_WF);
				
				tx.success();
			}
			finally {
				tx.finish();
			}
			//Récupération de l'id :
			
			this.closeConnection();
		}
		
		return (Object)idWfModelDataNode;
		
	}
	
	/**
	 * Permet d'enregistrer un noeud de type RelationShip en base
	 * @author Solene
	 * @param wfRelationShip
	 * @return idWfModelDataNode l'identifiant du noeud créée
	 */
	public Object saveWFRelationship(RelationshipWf wfRelationShip){
		
			long idWfRelationshipNode = -1;
			//Connexion a la base
			if (this.openConnectionBase()){
				
				Transaction tx = graphDB.beginTx();
				try{
				//Créée le Noeud WfModelData en base
				Node wfRelationshipNode = graphDB.createNode();
				
				//Remplir le noeud
				wfRelationshipNode.setProperty("Label", wfRelationShip.getTypeRelation());
				
					//!!!!Récupérer le noeud associé à l'objet wfRelationShip.getStart(); et le stocker ici :
				long idStart = -1;
				wfRelationshipNode.setProperty("Start", idStart);
					//!!!!Idem pour wfRelationShip.getEnd();
				long idEnd = -1;
				wfRelationshipNode.setProperty("End", idEnd);
				
				//Récupération de l'id
				idWfRelationshipNode = wfRelationshipNode.getId();
				tx.success();
				}
				finally {
					tx.finish();
				}
				this.closeConnection();
			}
					
			return (Object)idWfRelationshipNode;
	}



	
	/**
	 * Créée l'arc Request entre le DataMDM demandeur et le Noeud WfBrique
	 * On a choisi pour le moment de ne rien renvoyer
	 * @author Solene et Wensheng
	 * @param user est le demandeur et donc l'objet correspondant 
	 * au noeud initial, préexistant en base
	 * @param idWFBrique est linstance du noeud WfBrique préexistant en base
	 * et donc le Noeud final
	 */
	public void createRequestRelationWFBrique(DataMDM user, Object idWFBrique){
		
		//Connexion à la base 
		this.openConnectionBase();
		Transaction tx = graphDB.beginTx();
		
		try{
		if (graphDB!=null){
			Node demandeurNode;
			demandeurNode = graphDB.createNode();
			//Appel de la methode qui permet d'obtenir l'instance du noeud du demandeur
			//et la stocker dans demandeurNode
			
			Node wfBriqueNode = graphDB.createNode();
			//Appel de la méthode qui permet d'obtenir à l'instance du noeud associé à idWFBrqiue 
			//et la stocker dans wfBrique Node
			
			//création de l'arc request entre le noeud DataMDM demandeur et le noeud WfBrique
			Relationship relationRequest = demandeurNode.createRelationshipTo(wfBriqueNode, RelationWfTypes.REQUEST);
			relationRequest.setProperty("Create", null);
		}
		tx.success();
		}
		finally{tx.finish();}
		this.closeConnection();
	}
	


	/**
	 * 
	 * @author Solene & Wensheng
	 * @param user
	 * @param idWFModelData
	 */
	public void createRequestRelationWFData(DataMDM user, Object idWFModelData){
	
	//Connexion à la base 
			this.openConnectionBase();
			Transaction tx = graphDB.beginTx();
			
			try{
			if (graphDB!=null){
				Node demandeurNode;
				demandeurNode = graphDB.createNode();
				//Appel de la methode qui permet d'obtenir l'instance du noeud du demandeur
				//et la stocker dans demandeurNode
				
				Node wfModelDataNode = graphDB.createNode();
				//Appel de la méthode qui permet d'obtenir à l'instance du noeud associé à idWFModelData 
				//et la stocker dans wfModelDataNode
				
				//création de l'arc request entre le noeud DataMDM demandeur et le noeud WfModelData
				Relationship relationRequest = demandeurNode.createRelationshipTo(wfModelDataNode, RelationWfTypes.REQUEST);
				relationRequest.setProperty("Create", null);
			}
			tx.success();
			}
			finally{tx.finish();}
			this.closeConnection();
}

	/**
	 * 
	 * @author Solene
	 * @param user
	 * @param idWFRelationship
	 */
	public void createRequestRelationWFRelationship(DataMDM user, Object idWFRelationship){
	//Connexion à la base 
	this.openConnectionBase();
	Transaction tx = graphDB.beginTx();
	
	try{
	if (graphDB!=null){
		Node demandeurNode;
		demandeurNode = graphDB.createNode();
		//Appel de la methode qui permet d'obtenir l'instance du noeud du demandeur
		//et la stocker dans demandeurNode
		
		Node wfRelationshipNode = graphDB.createNode();
		//Appel de la méthode qui permet d'obtenir à l'instance du noeud associé à idWFRelationship 
		//et la stocker dans wfRelationshipNode
		
		//création de l'arc request entre le noeud DataMDM demandeur et le noeud WfRelationship
		Relationship relationRequest = demandeurNode.createRelationshipTo(wfRelationshipNode, RelationWfTypes.REQUEST);
		relationRequest.setProperty("Create", null);
	}
	tx.success();
	}
	finally{tx.finish();}
	this.closeConnection();
	
}

	/**
	 * Méthode générique qui créée la relation LinkWf 
	 * entre le Wf BRique le noeud Nature associée
	 * @author Solene et Wensheng
	 * @param idWFBrique
	 * @param nature, objet pour lequel on récupère l'instance du noeud associé
	 */
	public void createLinkWfNature(Object idWFBrique, Nature nature){
	
		//Connexion à la base
		this.openConnectionBase();
		Transaction tx = graphDB.beginTx();
		try {
		if(this.graphDB!=null){
			Relationship relationLinkWf;
			
			Node natureNode = graphDB.getNodeById(Long.parseLong((String)idWFBrique));
			
			//Recuperer le noeud associe à la nature et le stocker dans natureNode
			
			Node wfBriqueNode = graphDB.getNodeById(Long.parseLong((String)nature.getIdentifiant()));
			  
			//Récupérer le noeud associé à idWfBrique et le stocker dans wfBriqueNode
			
			//Creer la relation LinkWf entre le noeud wfBriqueNode et natureNode
			relationLinkWf = wfBriqueNode.createRelationshipTo(natureNode, RelationWfTypes.LINKWF);
			relationLinkWf.setProperty("state", "wating");
			
		}tx.success();
		}
		finally{tx.finish();}
		this.closeConnection();	
	}

	

}
