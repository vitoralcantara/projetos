package model;

public class DataValue {

	/*----Variables-----*/
	// identifiant de la data value dans la base
	Object identifiant;
	ModelValue modelValue;
	DataMDM dataMdm;
	Object value;

	/*----------Constructeur----------*/
	/**
	 * Contructeur de la classe A la construction, l'identifiant de la base est
	 * initialisé a -1, Il faudra passer l'identifiant une fois que la dataValue
	 * ait ete enregistree dans la base
	 * 
	 * @param dataMdm
	 *            : DataMDM correspondant a la dataMDM associe a la dataValue
	 * @param modelValue
	 *            : ModelValue du modelValue associe a la dataValue
	 * @param value
	 *            : String valeur de la dataValue
	 * @author Gaetan
	 */
	public DataValue(DataMDM dataMDM, ModelValue modelValue, String value) {
		this.dataMdm = dataMDM;
		this.modelValue = modelValue;
		this.value = value;
		this.identifiant = null;
	}

	/**
	 * Contructeur de la classe A la construction, l'identifiant de la base est
	 * initialisé a -1, Il faudra passer l'identifiant une fois que la dataValue
	 * ait ete enregistree dans la base, la valeur etant la valeur par defaut
	 * 
	 * @param dataMdm
	 *            : DataMDM correspondant a la dataMDM associe a la dataValue
	 * @param modelValue
	 *            : ModelValue du modelValue associe a la dataValue
	 * @author Gaetan
	 */
	public DataValue(DataMDM dataMDM, ModelValue modelValue) {
		this.dataMdm = dataMDM;
		this.modelValue = modelValue;
		this.value = this.modelValue.getDefaultValue();
		this.identifiant = null;
	}

	/*----------Getters and Setters----------*/

	/**
	 * Permet de récuperer l'identifiant de la dataValue dans la base de
	 * donnees, null si la dataValue n'a pas ete enrregistree en base.
	 * 
	 * @return l'identifiant
	 */
	public Object getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant
	 *            l'identifiant a donner pour la data value. cet identifiant
	 *            correspond a l'identifiant de la dataValue dans la base de
	 *            donnee
	 */
	public void setIdentifiant(Object identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Permet de recuperer le modelValue associe a la dataValue.
	 * 
	 * @return ModelValue du modelValue associe a la dataValue.
	 * @author Gaetan
	 */
	public ModelValue getModelValue() {
		return modelValue;
	}

	/**
	 * Permet de changer le modelValue associe a la dataValue.
	 * 
	 * @param modelValue
	 *            : ModelValue nouveau modelValue a associer a la dataValue.
	 * @author Gaetan
	 */
	public void setModelValue(ModelValue modelValue) {
		this.modelValue = modelValue;
	}

	/**
	 * Permet de recuperer l'identifant de la dataMDM associe a la dataValue.
	 * 
	 * @return DataMDM correspondant a la dataMDM associe a la dataValue.
	 * @author Gaetan
	 */
	public DataMDM getDataMdm() {
		return dataMdm;
	}

	/**
	 * Permet de changer la dataMDM associe a la dataValue, en modifiant
	 * l'identifiant dataMDM
	 * 
	 * @param dataMdm
	 *            : nouveau dataMDM a associer a la dataValue.
	 * @author Gaetan
	 */
	public void setDataMdm(DataMDM dataMdm) {
		this.dataMdm = dataMdm;
	}

	/**
	 * Permet de recuperer l'identifant du modelValue associe a la dataValue.
	 * 
	 * @return int correspondant a l'identifiant du modelValue associe a la
	 *         dataValue.
	 * @author Gaetan
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Permet de modifier la valeur de la dataValue
	 * 
	 * @param value
	 *            : String contenant la nouvelle valeur de la dataValue
	 * @author Gaetan
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
