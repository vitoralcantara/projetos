package dao.model;

import java.util.ArrayList;

import model.ModelMDM;
import model.ModelValue;

public abstract class ModelValueDAO {

	
	
	/****************************************************************
	 * Membres de la classe *
	 ****************************************************************/

	/****************************************************************
	 * Méthodes de la classe *
	 ****************************************************************/

	/**
	 * Permet de sauvegarder un modelValue dans la base de donnees, et creer le
	 * lien avec le ModelMDM et le socle associe
	 * 
	 * @param modelValue
	 *            le model a sauvegarder dans la base.
	 * @return Object correspondant a l'id du noeud dans la base de donnees.
	 * @author Gaetan
	 */
	public abstract Object save(ModelValue modelValue);

	/**
	 * Permet charger un modelValue de la base de donnees a partir de son
	 * identifiant.
	 * 
	 * @param id
	 *            : identifiant du modelMDM dans la base de donnees.
	 * 
	 * @return le modelValue correspondant a l'id passe en parametre.
	 * @author Gaetan
	 */
	public abstract ModelValue load(Object id);

	/**
	 * Permet de supprimer un modelValue de la base de donnees. supprime donc la relation avec le ModelMDM
	 * 
	 * @param model
	 *            le model a supprimer
	 * @return True si la suppression a bien eu lieu, false sinon.
	 * @author Gaetan
	 */
	public abstract boolean delete(ModelValue model);

	/**
	 * Permet de mettre a jour un modelValue enregistre dans la base de donnees.
	 * 
	 * @param model
	 *            le model a mettre a jour.
	 * @return True si l'update s'est bien deroulee, false sinon.
	 * @author Gaetan
	 */
	public abstract Boolean update(ModelValue model);
	
	public abstract ArrayList<Object> getAllModelValueId();
	
	public abstract ArrayList<Object> getAllModelValueId(String socle);
}
