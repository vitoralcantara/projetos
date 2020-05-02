package dao.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import model.JDBC;
import dao.model.JDBCDAO;

public class Neo4jJDBCDAO extends JDBCDAO
{
	/**
	 * Sauvegarde le JDBC passé en paramètre
	 * 
	 * @param _jdbc le JDBC à sauvegarder
	 * @return le numéro du noeud affecté (long)
	 */
	public Object saveJDBC(JDBC _jdbc)
	{
		GraphDatabaseService gDB = new GraphDatabaseFactory()
				.newEmbeddedDatabase("C:\\Users\\Litz\\Neo4j\\data\\graph.db");

		Transaction t = gDB.beginTx();
		Node jdbc;
		
		if (_jdbc.getId() != null)
		{
			jdbc = gDB.getNodeById((long) _jdbc.getId());
			jdbc.removeProperty("type");
			jdbc.removeProperty("login");
			jdbc.removeProperty("password");
			jdbc.removeProperty("host");
			jdbc.removeProperty("port");
			jdbc.removeProperty("typeDB");
			jdbc.removeProperty("database");
		}
		else
		{
			jdbc = gDB.createNode();
		}
		
		jdbc.setProperty("type", "jdbc");
		jdbc.setProperty("login", _jdbc.getLogin());
		jdbc.setProperty("password", _jdbc.getPassword());
		jdbc.setProperty("host", _jdbc.getHost());
		jdbc.setProperty("port", _jdbc.getPort());
		jdbc.setProperty("typeDB", _jdbc.getTypeDB());
		jdbc.setProperty("database", _jdbc.getDatabase());
		t.success();

		t.finish();
		gDB.shutdown();

		return jdbc.getId();
	}

}
