package model;

public class Validation {
	
	/****************************************************************
	 *                   Variables de la classe                      *
	 ****************************************************************/
 
	
	private String etat; // Chaîne de caractère pouvant prendre les valeurs
							// "Accepte", "En attente" ou "Refuse".
	private DataMDM validateur; // DataMdm correspondant à un des validateurs de
								// la communauté liée à ce Workflow.
	private Wf workflow; // Le Workflow concerné par le besoin de validation

	
	/****************************************************************
	 *                  Constructeurs de la classe                   *
	 ****************************************************************/

	
	/**
	 * @author Thomas & Bastien F.
	 * @param etat
	 *            Chaîne de caractère pouvant prendre les valeurs "Accepte", "En
	 *            attente" ou "Refuse".
	 * @param validateur
	 *            DataMdm correspondant à un des validateurs de la communauté
	 *            liée à ce Workflow.
	 * @param workflow
	 *            Le Workflow concerné par le besoin de validation
	 */
	public Validation(String etat, DataMDM validateur, Wf workflow) {
		this.etat = etat;
		this.validateur = validateur;
		this.workflow = workflow;
	}

	
	/****************************************************************
	 *               Méthodes de la classe           		        *
	 ****************************************************************/

	
	/**
	 * Permet de valider un Workflow.
	 * @author Thomas & Bastien F.
	 */
	public void valider()
	{
		this.setState("Accepte");
		//save();		
	}
	
	/**
	 * Permet de refuser un Workflow.
	 * @author Thomas & Bastien F.
	 */
	public void refuser()
	{
		this.setState("Refuse");
		//save()
	}
	
	
	/****************************************************************
	 *           Getters/Setters	 de la classe                   *
	 ****************************************************************/

	
	/**
	 * Retourne l'état du Workflow ("Accepte", "En attente" ou "Refuse".
	 * @author Thomas & Bastien F.
	 * @return etat
	 * 		L'état de la validation
	 */
	public String getState() {
		return etat;
	}

	/**
	 * Permet de passer l'état de la méthode à un etat passé en paramètre.
	 * @author Thomas & Bastien F.
	 * @param etat
	 *            Chaîne de caractère pouvant prendre les valeurs "Accepte", "En attente" ou "Refuse".
	 */
	public void setState(String etat) {
		this.etat = etat;
	}

	/**
	 * Retourne le validateur concerné par cet objet validation.
	 * @author Thomas & Bastien F.
	 * @return validateur
	 * 		Un des validateurs de la communauté lié à ce workflow
	 */
	public DataMDM getValidator() {
		return validateur;
	}

	/**
	 * Permet de passer un nouveau validateur (utilisateur) dans l'objet Validation.
	 * @author Thomas & Bastien F.
	 * @param validateur
	 *            Permet de faire passer un nouveau validateur à l'objet.
	 */
	public void setValidator(DataMDM validateur) {
		this.validateur = validateur;
	}

	/**
	 * Permet de récupérer le Workflow concerné par cette validation.
	 * @author Thomas & Bastien F.
	 * @return workflow
	 * 		Le workflow concerné par cette validation
	 */
	public Wf getWorkflow() {
		return workflow;
	}

	/**
	 * @author Thomas & Bastien F.
	 * @param workflow
	 *            Permet de passer un nouveau Workflow dans l'objet Validation.
	 */
	public void setWorkflow(Wf workflow) {
		this.workflow = workflow;
	}

}
