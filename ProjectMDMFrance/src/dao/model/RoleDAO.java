package dao.model;

import model.DataMDM;
import model.ModelMDM;

public abstract class RoleDAO 
{

	public abstract String loadRole(DataMDM user, ModelMDM community);

	public abstract void delete(DataMDM user, ModelMDM community);		

	public abstract void CreateRoleInBase(DataMDM user, DataMDM community, String Role);
	
	public abstract void CreateRoleInBase(DataMDM user, ModelMDM community, String Role);
}
