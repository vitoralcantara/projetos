package dao.model;

import model.Nature;


public abstract class WFRelationshipDAO {
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	/**
	 * Permet l'accès à la base de données
	 * Dépend de la machine sur laquelle on fera le test.
	 * Statique
	 */
	public static String path = "D:\\Install\\Neo4J\\data\\graph.db";
	

	
	/****************************************************************
	 *                    Methodes de la classe                     *
	 ****************************************************************/
	
	/**
	 * Permet de sauvegarder une relation INTRAWF entre un noeud de type WfBrique
	 * et un WfRelationship
	 * @param idWFBrique
	 * @param nature
	 */
	public abstract void createIntraWfRelationWFBriqueWFRelationship(Object idWFBrique, Nature nature);
		
	
}
