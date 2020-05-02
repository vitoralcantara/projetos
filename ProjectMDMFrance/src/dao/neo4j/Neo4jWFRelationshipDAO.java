package dao.neo4j;

import model.Nature;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dao.model.WFRelationshipDAO;


public class Neo4jWFRelationshipDAO extends WFRelationshipDAO {
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	
	//Pour la connexion a la base
		private GraphDatabaseService graphDB;
		
		
		private static enum RelationshipWfTypes implements RelationshipType{
			INTRA_WF
		}
	/****************************************************************
	 *                    Methodes de la classe                     *
	 ****************************************************************/

		
	
		/**
		 * Methode permettant la connection à la base
		 * @author Solene
		 * @return true si la connexion est effectuée, false sinon
		 */
		public boolean openConnectionBase(){
			this.graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(path);
			registerShutdownHook(this.graphDB);
			
			//Comment on vérifie que la connexion est bien établie???
			return true;
		}
		
		/**
		 * Methode permettant de clore la connection a la base
		 * @author Solene
		 */
		public void closeConnection(){
			this.graphDB.shutdown();
			
		}
			
		/**
		 * Pour la connexion et deconnexion propre
		 * @author Wensheng Zhang
		 * @param graphDB
		 */
		private static void registerShutdownHook(final GraphDatabaseService graphDB){
			Runtime.getRuntime().addShutdownHook(new Thread(){
				@Override
				public void run(){
					graphDB.shutdown();
				}
			});
		}
		

		
		/**
		 * Méthode générique qui crée la relation intraWf entre le Wf Brique et le WfRelationship
		 * @author Solène et Wensheng
		 * @param idWfBrique
		 * @param nature
		 */
		public void createIntraWfRelationWFBriqueWFRelationship(Object idWFBrique, Nature nature){
		
			//Connexion à la base
			this.openConnectionBase();
			Transaction tx = this.graphDB.beginTx();
			try {
			if (this.graphDB != null){
				Relationship tutRelationIntraWf;
				Relationship respoRelationIntraWf;
				Node wfBriqueNode = this.graphDB.getNodeById(Long.parseLong(idWFBrique.toString()));
							
				Node wfRelationTuteurNode = this.graphDB.createNode();
				String idTuteur = (String) nature.getTuteur().getIdentifiant();
				wfRelationTuteurNode.setProperty("Start", idTuteur);
				wfRelationTuteurNode.setProperty("Role", "Tuteur");
				wfRelationTuteurNode.setProperty("End", "null");
				
				Node wfRelationRespoNode = this.graphDB.createNode();
				String idRespo = (String) nature.getResponsable().getIdentifiant();
				wfRelationRespoNode.setProperty("Start", idRespo);
				wfRelationRespoNode.setProperty("Role", "Responsable");
				wfRelationRespoNode.setProperty("End", "null");
	
				
				//Récupérer le noeud associé à idWFModelData
				
				if ((wfBriqueNode != null) && (wfRelationTuteurNode != null)&&((wfRelationRespoNode != null))){
					//création de l'arc intraWf entre le noeud WfBrique et le noeud WFModelData
					tutRelationIntraWf  = wfBriqueNode.createRelationshipTo(wfRelationTuteurNode, RelationshipWfTypes.INTRA_WF);
					respoRelationIntraWf = wfBriqueNode.createRelationshipTo(wfRelationRespoNode, RelationshipWfTypes.INTRA_WF);
				}
			}tx.success();
			}
			finally{tx.finish();}
			this.closeConnection();
		}
		
	
}
