package model;

public class ModelValue {

	/*----------Variables----------*/

	// identifiant du modelValue dans la base de donnees
	Object identifiant;
	String typeAtt;
	String description;
	ModelMDM modelMdm;
	String defaultValue;
	String label;
	String socle;

	/*----------Constructeur----------*/

	/**
	 * Constructeur de la classe
	 * 
	 * l'identifiant sera initialise a -1, il devra être ajoute lors de
	 * l'enregistrement du modelValue dans la base.
	 * 
	 * @param type
	 *            : String representant le type de la valeur contenue dans le
	 *            modelValue (exemple : "Interger").
	 * @param description
	 *            : String présentant de manière rapide le modelValue.
	 * @param modelMdm
	 *            : modelMDM associe.
	 * @param defaultvalue
	 *            : String representant la valeur par defaut du modelValue.
	 * @param label
	 *            : Nom associe a ce modelValue
	 * 
	 * @author Gaetan
	 */

	public ModelValue(String type, String description, ModelMDM modelMDM,
			String defaultValue, String label, String socle) {
		this.typeAtt = type;
		this.description = description;
		this.modelMdm = modelMDM;
		this.defaultValue = defaultValue;
		this.label = label;
		this.identifiant = null;
		this.socle = socle;
	}

	/*----------Getters and setters----------*/

	/**
	 * @return l'identifant du modelValue dans la base. Si le model n'a pas ete
	 *         enregistre, retourne -1
	 */
	public Object getIdentifiant() {
		return identifiant;
	}

	/**
	 * Methode a appeler lors de l'enregistrement du modelValue dans la base,
	 * pour enregistrer l'identifiant.
	 * 
	 * @param int correspondant a l'identifiant du modelValue dans la base.
	 */
	public void setIdentifiant(Object identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Permet d'obtenir une String contenant la valeur de l'attribut TypeAtt
	 * 
	 * @return Une string contenant la valeur de TypeAtt
	 * @author Gaetan
	 */
	public String getTypeAtt() {
		return typeAtt;
	}

	/**
	 * Permet de modifier la valeur de la variable typeAtt
	 * 
	 * @param typeAtt
	 *            : String contenant le nouveau type d'attribut que doit avoir
	 *            l'instance du modelValue
	 * @author Gaetan
	 */
	public void setTypeAtt(String typeAtt) {
		this.typeAtt = typeAtt;
	}

	/**
	 * Permet d'obtenir une String contenant la valeur de l'attribut description
	 * 
	 * @return String contenant la valeur de l'attribut description
	 * @author Gaetan
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Permet de modifier la valeur de la variable description
	 * 
	 * @param description
	 *            String contenant la nouvelle valeur a donner a la variable
	 *            description
	 * @author Gaetan
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Permet d'obtenir l'entier representant l'id du modelMDM associe au
	 * modelValue
	 * 
	 * @return un entier representant l'id du modelMDM associe au modelValue
	 * @author Gaetan
	 */
	public ModelMDM getModelMdm() {
		return modelMdm;
	}

	/**
	 * Permet de modifier la valeur de la variable modelMDMId
	 * 
	 * @param modelMdm
	 *            modelMDM representant le nouveau ModelMDM a
	 *            associer au modelValue
	 * @author Gaetan
	 */
	public void setModelMdm(ModelMDM modelMdm) {
		this.modelMdm = modelMdm;
	}

	/**
	 * Permet d'obtenir une String contenant la valeur de l'attribut
	 * defaultValue
	 * 
	 * @return une string contenant la valeur de la variable defaultValue.
	 * @author Gaetan
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Permet de modifier la valeur de la variable defaultValue
	 * 
	 * @param defaultValue
	 *            : String contenant la nouvelle valeur a donner a l'attribut
	 *            defaultValue
	 * @author Gaetan
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * Permet d'obtenir une String contenant la valeur de l'attribut label
	 * 
	 * @return une string contenant la valeur contenue dans l'atribut label
	 * @author Gaetan
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Permet de modifier la valeur de la String label
	 * 
	 * @param label
	 *            : String contenant la nouvelle valeur a donner a l'attribut
	 *            label
	 * @author Gaetan
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Permet de modifier la valeur du socle
	 * 
	 * @param socle
	 *            : String contenant le nouveau type de socle que doit avoir
	 *            l'instance du modelValue
	 * @author Edwin & Clément A.
	 */
	public void setSocle(String socle) {
		this.socle = socle;
	}

	/**
	 * Permet d'obtenir une String contenant la valeur du socle 
	 * 
	 * @return String contenant la valeur de la valeur du socle
	 * @author Edwin & Clément A.
	 */
	public String getSocle() {
		return socle;
	}
	/*----------Methode----------*/
}
