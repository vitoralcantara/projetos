package model;
/**
 * 
 * @author Edwin
 *
 */
public class RattachementModelMDM {
	private ModelMDM modelSup;
	private ModelMDM modelInf;
	private Object niveauRattachement;
	//Je n'ai pas fait la javadoc car osef pour l'instant !
	//constructeur
	public RattachementModelMDM(ModelMDM modelSup,ModelMDM modelInf,Object niveauRatachement)
	{
		this.setModelSup(modelSup);
		this.setModelInf(modelInf);
		this.setNiveauRattachement(niveauRatachement);
	}
	
	//getset
	public ModelMDM getModelSup()
	{
		return this.modelSup;
	}
	
	public void setModelSup(ModelMDM modelSup)
	{
		this.modelSup=modelSup;
	}
	
	public ModelMDM getModelInf()
	{
		return this.modelInf;
	}
	
	public void setModelInf(ModelMDM modelInf)
	{
		this.modelInf=modelInf;
	}
	
	public Object getNiveauRattachement()
	{
		return this.niveauRattachement;
	}
	
	public void setNiveauRattachement(Object niveauRattachement)
	{
		this.niveauRattachement=niveauRattachement;
	}

}
