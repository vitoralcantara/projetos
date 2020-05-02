package dao.factory;

import dao.model.*;

public abstract class DAOFactory {
	/****************************************************************
	 * Groupe Gestion de Communaute
	 ****************************************************************/

	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour
	 * et supprimer un Role dans la base.
	 * 
	 * @return RoleDAO
	 */
	public abstract RoleDAO createRoleDAO();
	
	/**
	 * Permet de creer un DAO permettant de creer un User dans la base.
	 * 
	 * @return UserMDAO
	 */
	public abstract UserDAO createUserDAO();
	
	/**
	 * Permet de creer un DAO permettant de creer une nature dans la base.
	 * 
	 * @return NatureDAO
	 */
	public abstract NatureDAO createNatureDAO();
		
	
	
	/****************************************************************
	 * Groupe Stéphane *
	 ****************************************************************/

	/****************************************************************
	 * Groupe CRUD Mapping - Données *
	 ****************************************************************/
	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour
	 * et supprimer un modelMDM dans la base.
	 * 
	 * @return ModelMDMDAO
	 */
	public abstract ModelMDMDAO createModelMDMDAO();

	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour
	 * et supprimer un DataMDM dans la base.
	 * 
	 * @return DataMDMDAO
	 */
	public abstract DataMDMDAO createDataMDMDAO();

	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour
	 * et supprimer un modelValue dans la base.
	 * 
	 * @return ModelValueDAO
	 */
	public abstract ModelValueDAO createModelValueDAO();

	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour
	 * et supprimer un DataValue dans la base.
	 * 
	 * @return DataValueDAO
	 */
	public abstract DataValueDAO createDataValueDAO();

	/****************************************************************
	 * Groupe IHM *
	 ****************************************************************/

	/****************************************************************
	 * Groupe Workflow *
	 ****************************************************************/
	/**
	 * Permet de creer un DAO permettant d'enregistrer, obtenir, mettre a jour et supprimer 
	 * un workflow de type ModelData 
	 * 
	 * @return WFDataDAO
	 */
	public abstract WFDataDAO createWFDataDAO();
	
	/**
	 * Permet de créer un DAO permettant d'enregistrer, obtenir, 
	 * @return
	 */
	public abstract WFRelationshipDAO createWFRelationshipDAO();
	
	public abstract boolean deleteWFDataDAO(WFDataDAO wfTarget);
	
	public abstract boolean deleteWfRelationshipDAO(WFRelationshipDAO wfTarget);
	
	public abstract WFBriqueSIDAO createWFBriqueSIDAO();

	
	/****************************************************************
	 * Groupe Mapping *
	 ****************************************************************/

	/**
	 * Fonction permettant de creer un DAO utilisant un JDBC
	 * @return
	 */
	public abstract JDBCDAO createJDBCDAO();

	/**
	 * Fonction permettant de creer un DAO utilisant un WebService
	 * @return
	 */
	public abstract WebServiceDAO createWebServiceDAO();
}
