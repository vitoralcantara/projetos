package dao.model;

import model.JDBC;

public abstract class JDBCDAO
{
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	
	
	/****************************************************************
	 *                    Méthodes de la classe                     *
	 ****************************************************************/

	/**
	 * Sauvegarde le JDBC passé en paramètre
	 * 
	 * @param _jdbc le JDBC à sauvegarder
	 * @return Object
	 */
	public abstract Object saveJDBC(JDBC _jdbc);
	
	
	/****************************************************************
	 *                    Accesseurs de la classe                   *
	 ****************************************************************/
	
}
