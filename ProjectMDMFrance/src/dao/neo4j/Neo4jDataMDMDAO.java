package dao.neo4j;

import java.util.ArrayList;
import java.util.Collection;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import resource.NodesRelationship;

import model.DataMDM;
import model.Role;
import dao.factory.Neo4jDAOFactory;
import dao.model.DataMDMDAO;

public class Neo4jDataMDMDAO extends DataMDMDAO {

	public Neo4jDataMDMDAO() {

	}

	@Override
	public DataMDM load(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Sauvegarde le DataMDM donné en paramètre dans la base.
	 * 
	 * @param dataMDM
	 *            le DataMDM à sauver.
	 * @return L'identifiant du dataMDM inséré dans la base.
	 * 
	 * @author Guillaume G.
	 */
	@Override
	public Long save(DataMDM dataMDM) {
		Long id = null;

		GraphDatabaseService gDS = new GraphDatabaseFactory()
				.newEmbeddedDatabase("");
		Transaction t = gDS.beginTx();

		try {
			// Récupération du noeud ModelMDM correspondant
			Node modelMDMNode = gDS.getNodeById((long) dataMDM.getModelMdm()
					.getIdentifiant());

			// Création du noeud DataMDM
			Node dataMDMNode = gDS.createNode();

			dataMDMNode.setProperty("type", "DataMDM");
			dataMDMNode.setProperty("label", dataMDM.getLabel());

			// Création de la relation DataMDM--INSTANCE_OF-->ModelMDM
			dataMDMNode.createRelationshipTo(modelMDMNode,
					NodesRelationship.INSTANCE_OF);

			// TODO: relation DataMDM père<->fils
		} finally {
			t.finish();
			gDS.shutdown();
		}

		return id;
	}

	@Override
	public Boolean update(DataMDM dataMdm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(DataMDM dataMdm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Ajoute un utilisateur avec le role demande
	 * 
	 * @param user
	 *            Utilisateur � ajouter
	 * @param idCom
	 *            identifiant de la communaute data
	 * @param role
	 *            Role que va avoir l'utilisateur ajoute
	 * 
	 * @author Lydia
	 */
	public void addMember(Object idCom, DataMDM user, Role role) {

		GraphDatabaseService gDB = new GraphDatabaseFactory()
				.newEmbeddedDatabase(null);
		Transaction t = gDB.beginTx();

		// recuperation de l'utilisateur et de la communaute
		Node nodeData = gDB.getNodeById((long) user.getIdentifiant());
		Node nodeModel = gDB.getNodeById(idCom);
		try {
			// creation de la liasion role
			relationship = nodeData.createRelationshipTo(nodeModel,
					MDMRelationship);
			relationship.setProperty("role", role.getName());
			t.success();
		} finally {
			t.finish();
			gDB.shutdown();
		}

	}

	/**
	 * Accesseur pour r�cup�rer le responsable d'une communaut�
	 * 
	 * @return le responsable de la DataMDM donn�e
	 * 
	 * @author Tom Kuhnen
	 */
	public DataMDM getResponsable() {
		return null;
	}

	/**
	 * Accesseur pour r�cup�rer le tuteur d'une communaut�
	 * 
	 * @return le tuteur de la DataMDM donn�e
	 * 
	 * @author Tom Kuhnen
	 */
	public DataMDM getTuteur() {
		return null;
	}

	@Override
	public void setResponsable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTuteur() {
		// TODO Auto-generated method stub

	}

	/**
	 * Modifie le role de l�utilisateur dans une communaut� data de la BD
	 * 
	 * @param id
	 *            Identifiant du data dans la base
	 * @param user
	 *            Utilisateur dont on va modifier le role
	 * @param role
	 *            Role que va avoir l'utilisateur
	 * 
	 * @author Aur�lie :)
	 * 
	 */
	public void updateRole(Object id, DataMDM user, Role role) {
		// requ�te
	}

	@Override
	public ArrayList<Object> getAllDataMDMId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> getAllDataMDMFilsId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> getAllDataValueId(DataMDM dataMDM) {
		// TODO Auto-generated method stub
		return null;
	}
}
