package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.WebServiceDAO;

public class WebService extends Connector
{
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	
	private String	url;
	private String	protocol;
	
	
	/****************************************************************
	 *                    Méthodes de la classe                     *
	 ****************************************************************/

	public WebService(String _login, String _password, String _url,
			String _protocol)
	{
		this.setId(null);
		this.setLogin(_login);
		this.setPassword(_password);
		this.setUrl(_url);
		this.setProtocol(_protocol);
	}
	
	public Object saveConnector()
	{
		DAOFactory df = new Neo4jDAOFactory();
		WebServiceDAO dao = df.createWebServiceDAO();
		return dao.saveWebService(this);
	}
	
	public Map<ModelMDM, List<ModelValue>> getWebServiceSchema()
	{
		switch (this.getProtocol())
		{
			case "wsdl":
				return this.getWebServiceSchemaWSDL();
		}
		
		return null;
	}
	
	private Map<ModelMDM, List<ModelValue>> getWebServiceSchemaWSDL()
	{
		Map<ModelMDM, List<ModelValue>> tables = new HashMap<ModelMDM, List<ModelValue>>();
		List<ModelValue> columns;
		
		try
		{
			WSDLFactory f = WSDLFactory.newInstance();
			WSDLReader r = f.newWSDLReader();
	
			r.setFeature("javax.wsdl.verbose", true);
			r.setFeature("javax.wsdl.importDocuments", true);
			Definition d = r.readWSDL(null, this.getUrl());

		}
		catch (WSDLException e)
		{
			e.printStackTrace();
		}
		
		return tables;
	}
	
	
	/****************************************************************
	 *                    Accesseurs de la classe                   *
	 ****************************************************************/

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String _url)
	{
		this.url = _url;
	}

	public String getProtocol()
	{
		return protocol;
	}

	public void setProtocol(String _protocol)
	{
		this.protocol = _protocol;
	}
}
