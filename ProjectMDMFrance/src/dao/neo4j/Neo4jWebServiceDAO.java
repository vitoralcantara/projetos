package dao.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import model.WebService;
import dao.model.WebServiceDAO;

public class Neo4jWebServiceDAO extends WebServiceDAO
{
	public Object saveWebService(WebService _webService)
	{
		GraphDatabaseService gDB = new GraphDatabaseFactory().newEmbeddedDatabase(null);
		Transaction t = gDB.beginTx();
		
		Node webService = gDB.createNode();
		webService.setProperty("type", "webService");
		webService.setProperty("login", _webService.getLogin());
		webService.setProperty("password", _webService.getPassword());
		webService.setProperty("url", _webService.getUrl());
		webService.setProperty("protocol", _webService.getProtocol());
		t.success();
		
		t.finish();		
		gDB.shutdown();
		
		return webService.getId();
	}

}
