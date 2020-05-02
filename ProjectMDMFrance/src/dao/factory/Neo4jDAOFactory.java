package dao.factory;

import dao.model.*;

import dao.neo4j.*;

public class Neo4jDAOFactory extends DAOFactory {
	/****************************************************************
	 * Groupe Lydia *
	 ****************************************************************/
	
	/**
	 * 
	 * @return RoleDAO qui est une instance de Neo4jRoleDAO
	 */
	public RoleDAO createRoleDAO() {
		return new Neo4jRoleDAO();
	}
	
	/**
	 * 
	 * Permet de creer un DAO permettant de creer une nature dans la base.
	 * 
	 * @return NatureDAO qui est une instance de Neo4jNatureDAO
	 */
	public NatureDAO createNatureDAO() {
		return new Neo4jNatureDAO();
	}
	
	/**
	 * 
	 * @return UserDAO qui est une instance de Neo4jUserDAO
	 */
	
	public UserDAO createUserDAO(){
		
		return new Neo4jUserDAO();
		
	}

	
	/****************************************************************
	 * Groupe Stephane *
	 ****************************************************************/

	/****************************************************************
	 * Groupe Gaetan *
	 ****************************************************************/

	/**
	 * 
	 * @return ModelMDMDAO qui est une instance de Neo4jModelMDMDAO
	 */
	public ModelMDMDAO createModelMDMDAO() {
		return new Neo4jModelMDMDAO();
	}

	/**
	 * @return DataMDMDAO qui est une instance de Neo4jDataMDMDAO
	 */
	public DataMDMDAO createDataMDMDAO() {
		return new Neo4jDataMDMDAO();
	}

	/**
	 * @return ModelValueDAO qui est une instance de Neo4jModelValueDAO
	 */
	public ModelValueDAO createModelValueDAO() {
		return new Neo4jModelValueDAO();
	}

	/**
	 * Cette méthode permet de construire une instance de Neo4jDataValueDAO
	 * @author Solene et Wensheng
	 * @return DataValueDAO qui est une instance de Neo4jDataValueDAO
	 */
	public DataValueDAO createDataValueDAO() {
		return new Neo4jDataValueDAO();
	}

	/****************************************************************
	 * Groupe Bastien *
	 ****************************************************************/

	/****************************************************************
	 * Groupe Solene *
	 ****************************************************************/
	
	/**
	 * Cette méthode permet de construire une instance de Neo4jWfDataDAO
	 * @author Solene et Wesheng
	 * @return WfDataDAO (à l'éxécution sera considérée comme un Neo4j d'après le choix de la base)
	 */
	public WFDataDAO createWFDataDAO(){
		return new Neo4jWFDataDAO();
	}
	
	/**
	 * Cette méthode permet de construire une instance de Neo4jWFRelationshipDAO
	 * @author Solene et Wensheng
	 * @return WfRelationshipDAO (considérée à l'éxécution comme un Neo4jWfRelationshipDAO)
	 */
	public WFRelationshipDAO createWFRelationshipDAO(){
		return new Neo4jWFRelationshipDAO();
	}
	public WFBriqueSIDAO createWFBriqueSIDAO(){
		return new Neo4jWfBriqueSIDAO();
	}
	//A FAIRE
	/**
	 * @author 
	 * @param wfTarget
	 * @return
	 */
	public boolean deleteWFDataDAO(WFDataDAO wfTarget){
		return false;
	}
	/**
	 * @author 
	 * @param wfTarget
	 * @return
	 */
	public boolean deleteWfRelationshipDAO(WFRelationshipDAO wfTarget){
		return false;
	}
	
	
	/****************************************************************
	 * Groupe Alix *
	 ****************************************************************/

	/**
	 * 
	 */
	public JDBCDAO createJDBCDAO() {
		return new Neo4jJDBCDAO();
	}

	/**
	 * 
	 */
	public WebServiceDAO createWebServiceDAO() {
		return new Neo4jWebServiceDAO();
	}

}
