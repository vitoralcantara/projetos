package facade;

//import java.sql.Savepoint;
import java.util.ArrayList;
//import java.util.Collection;
import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.DataMDMDAO;
import dao.model.DataValueDAO;
import dao.model.ModelMDMDAO;
import dao.model.ModelValueDAO;
import dao.model.NatureDAO;
import model.*;

/**
 * La facade de CRUDFacade met en place des fonctions simples qui abstraient au
 * maximum la création(create),lecture (read), la mise à jour(update), la
 * suppression(delete). 
 * 
 * 
 * @author : cyril groupe CRUD.
 */

public class CRUDFacade {

	/*----------Variables----------*/

	/*----------Constructeur----------*/

	/**
	 * Constructeur de la classe
	 * 
	 * @author Gaetan
	 */
	public CRUDFacade() {
	}

	/**
	 * Permet de fournir une collection des ModelMDM présentents dans la base de données;
	 * On demande a ModelMDMDAO la liste des identifiants des Models présent dans la base
	 * puis on recherche pour chaque id le model qui correspond on retourne ainsi la
	 * collection de ModelMDM présent dans la base de donnees
	 *
	 * @return collectionModelMDM
	 * @author cyril & edwin 
	 */
	public static ArrayList<ModelMDM> readCollectionModelMDM(){
		
		//on déclare notre liste de modelMDM
		ArrayList<ModelMDM> collectionModelMDM=new ArrayList<ModelMDM>();
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		ArrayList<Object>lesId=m.getAllModelMDMId();
		for (int i=0;i<=lesId.size();i++)
		{
			collectionModelMDM.add(m.load(lesId.get(i)));
		}
		return collectionModelMDM;
	}

	/**
	 * Permet de fournir la liste des modèles fils(récursivement) par rapport au modèle père fournit en paramètre
	 * On demande a ModelMDMDAO la liste des identifiants des Models présent dans la base
	 * dont le model Pere est spécifié en parametre puis on recherche pour chaque id le model qui correspond on retourne ainsi la
	 * collection de ModelMDM présent dans la base de donnees
	 * 
	 * @param modelePere 
	 * 				correspond au modèle père de la liste des modèles fils que l'on cherche
	 * @return  collectionModelMDMfils ; NULL 
	 * @author edwin & cyril 
	 */
	public static ArrayList<ModelMDM> readCollectionModelMDM(ModelMDM modelePere){
		ArrayList<ModelMDM> collectionModelMDM=new ArrayList<ModelMDM>();
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		ArrayList<Object>lesId=m.getAllModelMDMFilsId();
		if (collectionModelMDM.size()==0)
			return null;
		else 
			for (int i=0;i<=lesId.size();i++)
			{
				collectionModelMDM.add(m.load(lesId.get(i)));
				}
		return collectionModelMDM;
	}
	
	
/************************************************************************************************************/	
	
	/**
	 * Permet de retourner la liste des rattachements pour modèle spécifique fournit en paramètre
	 * 
	 * 
	 * @param modele
	 * @return  CollectionRattachementModelMDM ; null
	 * 
	 */
	/*
	 public static ArrayList<RattachementModelMDM> readCollectionRattachementModelMDM(ModelMDM modele){
	ArrayList<RattachementModelMDM> listeRattachementModelMDM=new ArrayList<RattachementModelMDM>();
	DAOFactory df = new Neo4jDAOFactory();
	ModelMDMDAO m= df.createModelMDMDAO();
	//recuperer les rattachements
	return listeRattachementModelMDM;
	}
	*/
/************************************************************************************************************/

	/**
	 * Permet de retourner une collection des models values présents dans la base de données.
	 * On demande a ModelValueDAO la liste des identifiants des Models présent dans la base
	 * puis on recherche pour chaque id le model qui correspond on retourne ainsi la
	 * collection de ModelValue présent dans la base de donnees
	 *
	 * @param modele
	 * 			correspond au modelMDM qui est notre objet de référence possèdant un ou plusieurs modelValue.
	 * @return  collectionModelValue
	 * @author cyril & edwin
	 */
	public static ArrayList<ModelValue> readCollectionModelValue(ModelMDM modele){
		ArrayList<ModelValue> collectionModelValue=new ArrayList<ModelValue>();
		DAOFactory df = new Neo4jDAOFactory();
		ModelValueDAO m= df.createModelValueDAO();
		ArrayList<Object>lesId=m.getAllModelValueId();
		for (int i=0;i<=lesId.size();i++)
		{
			collectionModelValue.add(m.load(lesId.get(i)));
		}
		return collectionModelValue;
	}

	/**
	 * permet de fournir la collection des ModelValue ayant un socle (présent dans la base de données).
	 * On demande a ModelValueDAO la liste des identifiants des Models présent dans la base
	 * dont le socle est passé en parametre puis on recherche pour chaque id le model qui correspond 
	 * on retourne ainsi la collection de ModelValue présent dans la base de donnees
	 * 
	 * @param modele
	 * 					correspond aux modelMDM qui possèdera un ou plusieurs modelValue
	 * @param filtreSocle
	 * 					correspond à un type de socle que posséderais notre modelValue
	 * @return collectionModelValue ou null dans le cas ou un des deux paramètres n'existe pas.
	 * @author cyril & clementF & edwin
	 *
	 */
	public static ArrayList<ModelValue> readCollectionModelValue(ModelMDM modele, String filtreSocle){
		ArrayList<ModelValue> collectionModelValue=new ArrayList<ModelValue>();
		DAOFactory df = new Neo4jDAOFactory();
		ModelValueDAO m= df.createModelValueDAO();
		
		if ((modele.getIdentifiant()!= null))  //&&(filtreSocle.getIdentifiant != NULL)
		{
			ArrayList<Object>lesId=m.getAllModelValueId(filtreSocle);
			for (int i=0;i<=lesId.size();i++)
			{
				collectionModelValue.add(m.load(lesId.get(i)));
			}
			return collectionModelValue;
		}
		else{
			return null;
		}
	}
	
	/**
	 * permet de fournir la collection des dataMDM présents dans la base de données. 
	 * On demande a dataMDMDAO la liste des identifiants des data présent dans la base
	 * puis on recherche pour chaque id le data qui correspond on retourne ainsi la
	 * collection de dataMDM présent dans la base de donnees
	 * 
	 * @param modele
	 * 			correspond au modelMDM ayant potentiellement des dataMDM il se peux qu'il en ai aucun
	 * @return collectionDataMDM ou null si le modelMDM fournit en paramêtre n'existe pas.
	 * @author Cyril & edwin & clementF  
	 */	  
	public static ArrayList<DataMDM> readCollectionDataMDM(ModelMDM modele){
		ArrayList<DataMDM> collectionDataMDM=new ArrayList<DataMDM>();
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		
		if (modele.getIdentifiant() != null){
			ArrayList<Object>lesId=d.getAllDataMDMId();
			for (int i=0;i<=lesId.size();i++)
			{
				collectionDataMDM.add(d.load(lesId.get(i)));
			}
			return collectionDataMDM;
		}	
		else
		{
			return null; 
		}
	}

	/**
	 * permet de fournir l'ensemble des dataMDM filles d'une dataMDM donnée. 
	 * On demande a dataMDMDAO la liste des identifiants des data présent dans la base
	 * dont le modelepere est passé en parametre puis on recherche pour chaque id le data qui correspond 
	 * on retourne ainsi la collection de dataMDM présent dans la base de donnees
	 * 
	 * @param donneePere correspond à la DataMDM qui sera père des dataFille recherché
	 * @return collectionDataMDM ou null si la dataMDM fournit en paramètre n'existe pas dans la BD.
	 * @author Cyril & edwin & clementF
	 */
	public static ArrayList<DataMDM> readCollectionDataMDM(DataMDM donneePere){
		ArrayList<DataMDM> collectionDataMDM=new ArrayList<DataMDM>();
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		if (donneePere.getIdentifiant() != null){
			ArrayList<Object>lesId=d.getAllDataMDMFilsId();
			for (int i=0;i<=lesId.size();i++)
			{
				collectionDataMDM.add(d.load(lesId.get(i)));
				readCollectionDataMDM(d.load(lesId.get(i)));
			}
			return collectionDataMDM;	
		}
		else {
			return null;
		}
	}

/********************************************************************************************************************/
	/**
	 * 
	 * @param 
	 * @return  Retourne la collection des rattachements pour une donnée spécifique. Si la donnée n’existe pas,
	 
	public static Collection<null> readCollectionRattachementDataMDM(DataMDM donnée){
	}*/
/********************************************************************************************************************/
	
	
	/**
	 * Permet de fournir l'ensemble des dataValue d'une dataMDM donnee, si celle si existe dans la base de données.
	 * On demande a dataValueDAO la liste des identifiants des data présent dans la base
	 * puis on recherche pour chaque id le data qui correspond on retourne ainsi la
	 * collection de dataValue présent dans la base de donnees
	 * 
	 * @param donnee
	 * 			correspond à 
	 * @return collectionDataValue ou null si 
	 * @author Cyril & clementF & edwin 
	 */
	public static ArrayList<DataValue> readCollectionDataValue(DataMDM donnee){
		ArrayList<DataValue> collectionDataValue=new ArrayList<DataValue>();
		DAOFactory df = new Neo4jDAOFactory();
		DataValueDAO d= df.createDataValueDAO();
		if(donnee.getIdentifiant()!=null) {
			ArrayList<Object>lesId=d.getAllDataValueId();
			for (int i=0;i<=lesId.size();i++)
			{
				collectionDataValue.add(d.load(lesId.get(i)));
			}
			return collectionDataValue;
		}
		else {
			return null;
		}
	}

	/**
	 * Permet de fournir la  dataValue d'une dataMDM donnée qui correspond au modelValue donné.
	 * 
	 * 
	 * @param dataMDM
	 * @param modelValue
	 * @return valeur,null
	 * @author Cyril & clementF & Edwin
	 * 
	 * Retourne la valeur d’attribut pour la donnée et l’attribut indiqués.
	 * Si la donnée ou l’attribut n’existe pas, le retour est null. Modification d’éléments de la base (update)
	 */
	public static DataValue readDataValue(DataMDM dataMDM,ModelValue modelValue){
		// /!\ PAS OPTIMISE
		if 	( (dataMDM.getIdentifiant() != null ) && (modelValue.getIdentifiant() != null) ){
			
			int i =0;
			DAOFactory df = new Neo4jDAOFactory();
			DataValueDAO d= df.createDataValueDAO();
			
			ArrayList<DataValue> collectionDataValue=new ArrayList<DataValue>();
			ArrayList<Object>lesId=d.getAllDataValueId();
			
			for (int j=0;j<=lesId.size();j++)
			{
				collectionDataValue.add(d.load(lesId.get(j)));
			}
			
			while ((collectionDataValue.get(i).getDataMdm()!=dataMDM && collectionDataValue.get(i).getModelValue()!=modelValue)) {
				i++;
			}
			return collectionDataValue.get(i);
		}
		else {
			return null;
		}
	}


	/**
	 * Modifie la hierarchie entre le modèle fils et l'ancien modèle père
	 * 
	 * 
	 * @param  ModelMDM modeleFils
	 * @param  ModelMDM nouveauPere
	 * 
	 * @return  Retourne une instance du ModelMDM fils mis à jour si les modifications ont été enregistrées en base, null sinon.
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelMDM updateHierarchieModelMDM(ModelMDM modeleFils,ModelMDM nouveauPere){
		modeleFils.setModelPere(nouveauPere);
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		m.update(modeleFils);
		return modeleFils;
	}

	/**
	 * Modifie et met à jour le socle du ModelValue
	 * 
	 * @param modelValue
	 * @param nouveauSocle
	 * 
	 * @return Retourne une instance du ModelValue mis à jour si les modifications ont été enregistrées en base, null sinon.
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelValue updateSocleModelValue(ModelValue modelValue, String nouveauSocle)
	{
		modelValue.setSocle(nouveauSocle);
		DAOFactory df = new Neo4jDAOFactory();
		ModelValueDAO d= df.createModelValueDAO();
		d.update(modelValue);
		return modelValue;
	}

	/**
	 * Modifie et met à jour la hierarchie entre le modèle fils et le nouveau modèle père
	 * 
	 * @param dataFils
	 * @param nouveauPere
	 * @return Retourne une instance du DataMDM fils mis à jour si les modifications ont été enregistrées en base, null sinon.
	 * @author Cyril & Edwin & Clément A.
	 */
	public static DataMDM updateHierarchieDataMDM(DataMDM dataFils,DataMDM nouveauPere){
		dataFils.setDataPere(nouveauPere);
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		d.update(dataFils);
		return dataFils;
		
	}
	

	/**
	 * Modifie et met à jour l'instance du DataValue concernée
	 * 
	 * @param dataMDM
	 * @param modelValue
	 * @param value 
	 * @return  Retourne une instance du DataValue mis à jour si les modifications ont été enregistrées en base, null sinon. Suppression d’éléments de la base (delete)
	 * @author Cyril & Edwin & Clément A.
	 * 
	 *
	 */
	public static DataValue updateDataValue(DataMDM dataMDM,ModelValue modelValue, String value)
	{
		// /!\ PAS OPTIMISE
		int i =0;
		DAOFactory df = new Neo4jDAOFactory();
		DataValueDAO d= df.createDataValueDAO();
		
		ArrayList<DataValue> collectionDataValue=new ArrayList<DataValue>();
		ArrayList<Object>lesId=d.getAllDataValueId();
		
		for (int j=0;j<=lesId.size();j++)
		{
			collectionDataValue.add(d.load(lesId.get(j)));
		}
		
		while ((collectionDataValue.get(i).getDataMdm()!=dataMDM && collectionDataValue.get(i).getModelValue()!=modelValue)) {
			i++;
		}
		 collectionDataValue.get(i).setValue(value);
		 d.update(collectionDataValue.get(i));
		return collectionDataValue.get(i);
	}

	
	/*************************************************************************************************************************/
	/**
	 * Vérifie et contrôle la bon déroulement de la suppression du rattachement entre deux ModelMDM
	 * 
	 * @param modèleRattaché
	 * @param aUnModele
	 * @return Vrai si la suppression du rattachement s’est déroulée correctement, faux sinon.
	 * @author Cyril & Edwin & Clément A.
	 */
	/*public static boolean deleteRattachementModelMDM(ModelMDM modèleRattaché,ModelMDM aUnModele){
		boolean bool = false;
		return bool;
	}
*/
/*************************************************************************************************************************/
	
	/**
	 *
	 * Supprime le modelValue dans la base de données.
	 * La suppression d’un ModelValue entraîne la suppression de tous les DataValue qui y sont associés
	 * 
	 * @param modelValue
	 * @return bool 
	 * @author Cyril & Edwin & Clément A.
	 * */
	public static Boolean deleteModelValue(ModelValue modelValue)
	{
		DAOFactory df = new Neo4jDAOFactory();
		ModelValueDAO d= df.createModelValueDAO();
		return d.delete(modelValue);
	}

	/**
	 * Procédure visant à supprimer un rattachement entre deux dataMDM
	 * 
	 * @param donneeRattachee
	 * @param aUneDonne
	 * @return Vrai si le lien de rattachement a été supprimé dans la base de donnée, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	/*public static boolean deleteRattachementDataMDM(DataMDM donneeRattachee,DataMDM aUneDonnee){
		boolean bool = false;
		return bool;
	}
*/
	/**
	 * Permet de supprimer une dataValue dans la base de données.
	 * 
	 * 
	 * @param dataMDMAssocie
	 * @param modelValueAssocie
	 * @return Vrai si l'instance du DataValue a été supprimée dans la base de donnée, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static boolean  deleteDataValue(DataMDM dataMDMAssocie,ModelValue modelValueAssocie){
		boolean bool = false;
		
		return bool;
	}
	


	
	/*----------Getters and Setters----------*/

	
	/*----------Methodes CREATE-----------*/
	
	
	/**
	 * Permet la creation d'un nouvel ModelMDM dans la base de donnée
	 * 
	 * @param nature 
	 * @param label
	 * @param description
	 * @return Retourne l’instance du nouveau ModelMDM s’il a pu être enregistre en base, null sinon.
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelMDM createModelMDM(Nature nature, String label, String description) {

		ModelMDM modelMDM=new ModelMDM(nature,label,description);
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		modelMDM.setIdentifiant(m.save(modelMDM));
		return modelMDM;
	}

	/**
	 * Permet la creation d'un nouvel ModelMDM fils dans la base de donnée 
	 * Il n’y a pas de nature en paramètre, car s’il y a un père il s’agit d’une structure.
	 * 
	 * 
	 * @param modelePere
	 * @param label
	 * @param description
	 * @return Retourne l’instance du nouveau ModelMDM s’il a pu être enregistre en base, null sinon. 
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelMDM createModelMDM(ModelMDM modelePere, String label, String description) {
		ModelMDM modelMDM=new ModelMDM(modelePere.getNature(),label,description);
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();//Hierarchical
		modelMDM.setIdentifiant(m.save(modelMDM));
		return modelMDM;
	}

	/**
	 * Permet la supression d'une instance d'un ModelMDM dans la base de donnée
	 * 
	 * @param modelMDM
	 * @return Retourne vrai si l’instance du ModelMDM a été supprimée en base, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static Boolean deleteModelMDM(ModelMDM modelMDM)
	{
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		return m.delete(modelMDM);
	}
	
	/**
	 * Permet d'ajouter un RattachementModelMDM entre deux modelMDM
	 * 
	 * @param modèleAyantUnRattachement
	 * @param aUnModele
	 * @return Retourne vrai si le rattachement a ete effectue en base de donnees, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static Boolean createRattachementModelMDM(
			ModelMDM modèleAyantUnRattachement, ModelMDM aUnModel) {
		return true;
	}

	/**
	 * Permet la création d'un nouveau ModelValue dans la base de donnée
	 * Pour cela il faut spécifier le ModelMDM associé à ce ModelValue ainsi que son socle d'appartenance
	 * Type sera le type de l’attribut.
	 * 
	 * @param typeAttribut
	 * @param modeleAssocie
	 * @param leSocle
	 * @param description
	 * @param valeurParDefaut
	 * @param label le label
	 * @return Retourne l’instance du nouveau ModelValue s’il a pu être enregistré en base, null sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelValue createModelValue(String typeAttribut, ModelMDM modeleAssocie, String leSocle, String description, String valeurParDefaut, String label) {
		
		ModelValue modelValue=new ModelValue(typeAttribut,description,modeleAssocie,valeurParDefaut,label,leSocle);//hierarchical
		DAOFactory df = new Neo4jDAOFactory();
		ModelValueDAO d= df.createModelValueDAO();
		modelValue.setIdentifiant(d.save(modelValue));
		return modelValue;
	}
	
	
	
	/**
	 * Permet la création d'une instance de DataMDM dans la base de donnée
	 * Pour celà il faut spécifier en paramètre le modeleMDM associé à cette DataMDM
	 * 
	 * @param modeleAssocie
	 * @param label
	 * @return Retourne l’instance du nouveau DataMDM s’il a pu être enregistré en base, null sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static DataMDM createDataMDM(ModelMDM modeleAssocie, String label) {
		DataMDM dataMDM=new DataMDM(modeleAssocie,label);//hierarchical
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		dataMDM.setIdentifiant(d.save(dataMDM));
		return dataMDM;
	}

	/**
	 * Permet la création d'une instance de DataMDM fils dans la base de donnée
	 * Pour celà il faut spécifier en paramètre le modeleMDM associé à cette DataMDM ainsi que son DataMDM père
	 * De plus, dataMDM sert à constituer une hiérarchie entre les données, uniquement pour une nature le permettant (comme Structure).
	 * 
	 * @param modeleAssocie
	 * @param dataMDMPere
	 * @param label
	 * @return Retourne l’instance du nouveau DataMDM s’il a pu être enregistré en base, null sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static DataMDM createDataMDM(ModelMDM modeleAssocie, DataMDM dataMDMPere, String label) {
		DataMDM dataMDM=new DataMDM(modeleAssocie,label);//hierarchical
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		dataMDM.setIdentifiant(d.save(dataMDM));
		return dataMDM;
	}
	
	
	/**
	 * Permet de supprimer une dataMDM dans la base de données.
	 * 
	 * @param dataMDM
	 * @return Vrai si l'instance du DataMDM a été supprimée dans la base de donnée, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static Boolean deleteDataMDM(DataMDM dataMDM)
	{
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		
		return d.delete(dataMDM);//voir la hierarchie
	}

	/**
	 * Permet de créer un lien de rattachement entre deux DataMDM 
	 * 
	 * @param donneeAyantUnRattachement
	 * @param aUneDonne
	 * @return Retourne vrai si l’instance du nouveau RattachementDataMDM s’il a pu être enregistré en base, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static Boolean createRattachementDataMDM(DataMDM donneeAyantUnRattachement, DataMDM aUneDonnee) {
		return true;
	}

	/**
	 * Permet la création d'un DataValue dans la base de donnée
	 * 
	 * @param dataMDMAssocie
	 * @param modeleValueAssocie
	 * @param valeur
	 * @return Retourne l’instance du nouveau DataValue s’il a pu être enregistré en base, null sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static DataValue createDataValue(DataMDM dataMDMAssocie, ModelValue modelValueAssocie, String valeur) {
		DataValue dataValue=new DataValue(dataMDMAssocie,modelValueAssocie,valeur);
		DAOFactory df = new Neo4jDAOFactory();
		DataValueDAO d= df.createDataValueDAO();
		dataValue.setIdentifiant(d.save(dataValue));
		return dataValue;
	}
	
	/**
	 * Permet la verification et le contrôle du bon dérloulement de la suppression d'une dataValue dans la base de donnée
	 * 
	 * @param dataValue
	 * @return Vrai si le DataValue a pu être supprimer de la base, faux sinon
	 * @author Cyril & Edwin & Clément A.
	 */
	public static Boolean deleteDataValue(DataValue dataValue)
	{
		DAOFactory df = new Neo4jDAOFactory();
		DataValueDAO d= df.createDataValueDAO();
		return d.delete(dataValue);

	}
	
	
	

	/**
	 * Permet de demander la création d'une brique SI, l'objet de retour sera un ModelMDM
	 * 
	 * @param description
	 * @param label
	 * @param connecteurId
	 * @return Retourne l'instance de la brique SI créee
	 * @author Cyril & Edwin & Clément A.
	 */
	public static ModelMDM createBriqueSI(String description, String label, Object connecteurId) {

		ModelMDM brique = new ModelMDM(loadNature("Brique"), label, description);
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		brique.setIdentifiant(m.save(brique));
		return brique;

	}

	/**
	 * Permet de charger un ModelMDM quelconque depuis la base de données la fonction 
	 * 
	 * @param id : l'identifiant du modelmdm dans la base de donnees
	 * @return Retourne le ModelMDM manipulé
	 * @author Cyril & Edwin & Clément A.
	 */
	public static  ModelMDM loadModelMDM(Object id) {
		DAOFactory df = new Neo4jDAOFactory();
		ModelMDMDAO m= df.createModelMDMDAO();
		ModelMDM modelMDM= m.load(id);
		return modelMDM;
	}

	/**
	 * Permet de charger un DataMDM quelconque depuis la base de données la fonction
	 * 
	 * @param id : l'identifiant de l'object dans la base de donnees
	 * @return Retourne le DataMDM manipulé
	 * @author Cyril & Edwin & Clément A.
	 */
	public static DataMDM loadDataMDM(Object id) {
		DAOFactory df = new Neo4jDAOFactory();
		DataMDMDAO d= df.createDataMDMDAO();
		DataMDM dataMDM= d.load(id);
		return dataMDM;
	}
	
	/**
	 * Permet de creer une nature a partir d'un String passé en parametre
	 * 
	 * @param String label
	 * @return nature
	 * @author Gaetan
	 */
	public static Nature createNature(String label){
		Nature nature = new Nature(label);
		DAOFactory df = new Neo4jDAOFactory();
		NatureDAO n= df.createNatureDAO();
		nature.setIdentifiant(n.save(nature));
		return nature;
	}
	
	/**
	 * Permet de recuperer une nature a partir d'un identifiant passé en parametre
	 * 
	 * @param String label
	 * @return nature
	 * @author Gaetan
	 */
	
	public static Nature loadNature(Object id){
		DAOFactory df = new Neo4jDAOFactory();
		NatureDAO n= df.createNatureDAO();
		Nature nature= n.load(id);
		return nature;
	}
	
	/**
	 * Permet de recuperer une nature a partir d'un String passé en parametre
	 * 
	 * @param String label
	 * @return nature
	 * @author Gaetan
	 */
	public static Nature loadsNature(String type){
		DAOFactory df = new Neo4jDAOFactory();
		NatureDAO n= df.createNatureDAO();
		Nature nature= n.load(type);
		return nature;
	}
	
	

}