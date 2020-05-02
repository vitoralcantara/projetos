package dao.neo4j;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import test.RelationTypeRole;

import model.DataMDM;
import model.ModelMDM;
import dao.model.RoleDAO;

public class Neo4jRoleDAO extends RoleDAO
{
	
	GraphDatabaseService gDB = new GraphDatabaseFactory().newEmbeddedDatabase("D:\\Education\\Neo4j\\graph.db");

	
	private static enum RelationTypeRole implements RelationshipType{
		Tuteur,
		Responsable,
		Membre,
		Associé,
		Refusé,
	}
	
	public void CreateRoleInBase(DataMDM user, ModelMDM community, String Role)
	{
		
		Transaction transact = gDB.beginTx();
		ExecutionEngine engine = new ExecutionEngine(gDB);
		
		Node NodeUser;
		Node NodeCommunity;

		//récupérer les nodes de départs et d'arrivées
		
		Relationship relationRequest = NodeUser.createRelationshipTo(NodeCommunity, RelationTypeRole.Tuteur);
		relationRequest.setProperty(Role, null);
	}
	
	public void CreateRoleInBase(DataMDM user, DataMDM community, String Role)
	{
		
		Transaction transact = gDB.beginTx();
		ExecutionEngine engine = new ExecutionEngine(gDB);
		
		Node NodeUser;
		Node NodeCommunity;
		
		//récupérer les nodes de départs et d'arrivées
		
		Relationship relationRequest = NodeUser.createRelationshipTo(NodeCommunity, RelationTypeRole.Tuteur);
		relationRequest.setProperty(Role, null);
		

	}
	
	public String loadRole(DataMDM user, ModelMDM community) {
		
		String maRequete;

		Transaction transact = gDB.beginTx();
		ExecutionEngine engine = new ExecutionEngine(gDB);

		
		maRequete = "start n=node(*), m=node(*) match n-[r:role] -> m where n.type= \"DataMDM\" And n.label = \"Yannick Paz\" And m.type = \"ModelMDM\" And m.label= \"Université\" return r;";           
		ExecutionResult result = engine.execute( maRequete );
		
		gDB.shutdown();
		return result.toString();
	}

	public void delete(DataMDM user, ModelMDM community) 
	{
		// commande pour delete le role entre l'user et la community
		
	}
	
	
	
}
