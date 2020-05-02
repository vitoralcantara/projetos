package model;

public class LinkWf {
	/****************************************************************
	 *                    Variables de la classe                     *
	 ****************************************************************/


	private String etat; // Correspond à l'état du Workflow (chaîne de
							// caractères pouvant prendre les valeurs "Valide",
							// "En attente", "Refuse", "Arbitrage".
	private Wf workflow; // Le Workflow concerné par l'état
	private Object cible; //il s'agit de la communauté cible du workflow : nature, dataMDM, modelMDM...

	
	
	/****************************************************************
	 *                    Constructeurs de la classe                 *
	 ****************************************************************/


	/**
	 * Constructeur de la classe LinkWf.
	 * 
	 * @author Thomas & Bastien F.
	 * @param workflow
	 *            Le Workflow concerné par l'état
	 * @param etat
	 *            Correspond à l'état du Workflow (chaîne de caractères pouvant
	 *            prendre les valeurs "Valide", "En attente" ou "Refuse".
	 * @param cible
	 *            La communauté cible du workflow
	 */
	public LinkWf(Wf workflow, String etat, Object cible) {
		this.workflow = workflow;
		this.etat = etat;
		this.cible = cible;
	}

	
	/****************************************************************
	 *                    Getters/Setters de la classe              *
	 ****************************************************************/

	/**
	 * Permet de récupérer l'état du Workflow concerné.
	 * @author Thomas & Bastien F.
	 * @return etat qui retourne l'état associé au Workflow
	 */
	public String getState() {
		return etat;
	}

	/**
	 * Permet d'entrer un nouvel état pour le Workflow concerné.
	 * @param etat
	 *            Correspond à l'état du Workflow (chaîne de caractères pouvant
	 *            prendre les valeurs "Valide", "En attente" ou "Refuse".
	 */
	public void setState(String etat) {
		this.etat = etat;
	}

	/**
	 * Permet de récupérer le Workflow concerné par ce LinkWf.
	 * Peut notamment être utile pour récupérer la liste des Wf nécessitant une validation.
	 * @author Thomas & Bastien F.
	 * @return workflow donc le workflow concerné par ce LinkWf
	 */
	public Wf getWorkflow() {
		return workflow;
	}

	/**
	 * Permet de passer un nouveau Workflow concerné par cet état.
	 * @author Thomas & Bastien F.
	 * @param workflow
	 *            Le Workflow concerné par l'état.
	 */
	public void setWorkflow(Wf workflow) {
		this.workflow = workflow;
	}

	/**
	 * Permet de récupérer la cible du workflow (communauté de type DataMDM, ModelMDM ou Nature)
	 * @return cible qui est la cible du workflow
	 */
	public Object getCible() {
		return cible;
	}

	/**
	 * Permet de passer une nouvelle cible concerné par cet état
	 * @param cible
	 * La cible concerné par l'état
	 */
	public void setCible(Object cible) {
		this.cible = cible;
	}

}
