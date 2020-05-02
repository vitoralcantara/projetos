package dao.model;

import model.BriqueSIWf;

public abstract class WFBriqueSIDAO {
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	//Depend de la machine sur laquelle on fera le test !! Donc a la fin 
	//il faudra qu'on se mette tous sur celle là pour tester
	public static String path = "D:\\Install\\Neo4J\\data\\graph.db";
	
	/****************************************************************
	 *                    Methodes de la classe                     *
	 ****************************************************************/
	/**
	 * @author Wensheng Zhang et Solene
	 * @param briqueSI
	 * @return
	 */
	public abstract Object saveBriqueSIWf(BriqueSIWf briqueSI);
}
