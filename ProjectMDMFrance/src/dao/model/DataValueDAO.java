package dao.model;

import java.util.ArrayList;

import model.DataValue;

public abstract class DataValueDAO {

	/*----------Variables-----------*/
	/*----------Constructeur-----------*/
	/*----------Getters and setters-----------*/
	/*----------Methodes-----------*/

	/*----------Variables-----------*/

	/*----------Constructeur-----------*/

	/*----------Getters and setters-----------*/

	/*----------Methodes-----------*/

	/**
	 * Permet de charger une dataValue a partir de son identifiant depuis la
	 * base de donnees.
	 * 
	 * @return DataMDM correspondant dans la base de donnees. return null si
	 *         l'object n'est pas trouve.
	 */
	public abstract DataValue load(Object id);

	/**
	 * Permet de sauvegarder une dataValue dans la base de donnees. Et creee les
	 * relations avec la dataMDM et le modelValue etant dans ses attribut
	 * 
	 * @param dataValue
	 *            l'objet dataValue a sauvegarder dans la base de donnees.
	 * @return Object correspondant a l'identifiant de l'object dans la base de
	 *         donnees.
	 */
	public abstract Object save(DataValue datavalue);

	/**
	 * Permet de mettre a jour une dataValue dans la base de donnees.
	 * 
	 * @param datavalue
	 *            la datavalue a mettre a jour dans la base de donnees.
	 * @return Boolean signifiant que la mise a jour a ete effectuee dans la
	 *         base de donnees.
	 */
	public abstract Boolean update(DataValue datavalue);

	/**
	 * Permet de supprimer une DataValue de la base de donnees. ainsi que chaque
	 * relation associé a la dataMDM.
	 * 
	 * @param dataMdm
	 *            a supprimer de la base.
	 * @return True si la suppression a ete effectue, False sinon.
	 */
	public abstract Boolean delete(DataValue dataValue);

	public abstract ArrayList<Object> getAllDataValueId();
}
