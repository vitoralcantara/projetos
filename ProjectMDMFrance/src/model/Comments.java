package model;

import java.util.List;
import java.util.Map;

public class Comments 
{
	// Variables de classe
	
	String comment ;		// Correspond au commentaire qui a été posté
	int timeStamp ;			// Correspond à l'heure de post du commentaire
	Wf leWf ;				// Correspond au Workflow sur lequel porte ce commentaire
	
	
	// Constructeurs
	
	public Comments(String _comment, Wf _leWf)
	{
		comment = _comment ;
		leWf = _leWf ;
	}
	
	
	// Méthodes
	
	/**
	 * Permet de modifier le commentaire.
	 * @author Bastien F. et Thomas
	 * @param _comment
	 * 			Correspond au commentaire qui sera entré.
	 */
	public void setComment(String _comment)
	{
		this.comment = _comment ;
	}
	
	/**
	 * Permet de modifier le commentaire.
	 * @author Bastien F. et Thomas
	 * return _comment
	 * 			Commentaire renvoyé.
	 */
	public String getComment()
	{
		return(this.comment) ;
	}
	
	/**
	 * Permet de modifier le TimeStamp
	 * @author Bastien F. et Thomas
	 * @param _timeStamp
	 * 			Correspond à la nouvelle date qui sera entrée.
	 */
	public void setTimeStamp(int _timeStamp)
	{
		this.timeStamp = _timeStamp ;
	}
	
	/**
	 * Permet de récupérer le TimeStamp.
	 * @author Bastien F. et Thomas
	 * return int
	 * 			Renvoie la date à laquelle a été posté le commentaire.
	 */
	public int getTimeStamp()
	{
		return(this.timeStamp) ;
	}
	
	/**
	 * Permet de modifier le Workflow associé.
	 * @author Bastien F. et Thomas
	 * @param _Wf
	 * 			Correspond au nouveau Wf entré.
	 */
	public void setWf(Wf _Wf)
	{
		this.leWf = _Wf ;
	}
	
	/**
	 * Permet de récupérer le Workflow associé.
	 * @author Bastien F. et Thomas
	 * return Wf
	 * 			Renvoie le nouveau Wf.
	 */
	public Wf getWf()
	{
		return(this.leWf) ;
	}
}
