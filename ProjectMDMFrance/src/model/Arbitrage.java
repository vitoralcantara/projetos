package model;

public class Arbitrage 
{
	// Déclaration des variables

	private String etat; // Chaîne de caractère pouvant prendre les valeurs "Accepte" (si accepté après arbitrage), "En attente" (si en attente d'arbitrage) ou "Refuse" (si refus après arbitrage).
	private DataMDM validateur; // DataMdm correspondant au tuteur de la
								// communauté liée à ce Workflow.
	private Wf workflow; // Le Workflow concerné par le besoin d'arbitrage.

	/**
	 * @author Thomas et Bastien F.
	 * @param etat :
	 *            Chaîne de caractère pouvant prendre les valeurs "Accepte", "En
	 *            attente" ou "Refuse".
	 * @param validateur :
	 *            DataMdm correspondant au tuteur de la communauté liée à ce
	 *            Workflow.
	 * @param workflow :
	 *            Le Workflow concerné par le besoin d'arbitrage.
	 */
	public Arbitrage(String etat, DataMDM validateur, Wf workflow) {
		this.etat = etat;
		this.validateur = validateur;
		this.workflow = workflow;
	}
	
	
	// Méthodes
	
	
	
	//accesseurs
	
	/**
	 * Permet de récupérer l'état actuel de l'arbitrage. Celui-ci peut prendre trois valeurs : "Accepte", "En attente" ou "Refuse".
	 * @author Thomas et Bastien F.
	 */
	public String getState() {
		return etat;
	}

	/**
	 * Permet de modifier l'état actuel de l'arbitrage.
	 * @author Thomas et Bastien F.
	 * @param etat :
	 *            Chaîne de caractère pouvant prendre les valeurs "Accepte", "En
	 *            attente" ou "Refuse".
	 */
	public void setState(String etat) {
		this.etat = etat;
	}

	/**
	 * Permet de récupérer le validateur concerné par cet arbitrage.
	 * @author Thomas et Bastien F.
	 */
	public DataMDM getValidateur() {
		return validateur;
	}

	/**
	 * Permet d'entrer un nouveau validateur pour cet arbitrage de Workflow. Ce sera à lui à arbitrer.
	 * @author Thomas et Bastien F.
	 * @param validateur :
	 *            DataMdm correspondant au tuteur de la communauté liée à ce
	 *            Workflow.
	 */
	public void setValidateur(DataMDM validateur) {
		this.validateur = validateur;
	}

	/**
	 * Retourne le Workflow concerné par cet arbitrage.
	 * @author Thomas et Bastien F.
	 */
	public Wf getWorkflow() {
		return workflow;
	}

	/**
	 * Permet d'entrer un nouveau Workflow qui aura besoin d'arbitrage.
	 * @author Thomas et Bastien F.
	 * @param workflow :
	 *            Le Workflow concerné par le besoin d'arbitrage.
	 */
	public void setWorkflow(Wf workflow) {
		this.workflow = workflow;
	}

}
