package dao.model;

import java.util.*;

import org.neo4j.graphdb.Node;

import model.BriqueSIWf;
import model.DataMDM;
import model.DataValue;
import model.ModelData;
import model.ModelMDM;
import model.ModelValue;
import model.Nature;
import model.RelationshipWf;
import model.Wf;

public abstract class WFDataDAO {
	
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/
	//Depend de la machine sur laquelle on fera le test !! Donc a la fin 
	//il faudra qu'on se mette tous sur celle là pour tester
	public static String path = "D:\\Install\\Neo4J\\data\\graph.db";
	
	
	/****************************************************************
	 *                    Methodes de la classe                     *
	 ****************************************************************/

	//////////// METHODES D'AFFICHAGE
	
	//Permet d'afficher un ensemble de Workflow de type typeWF demandés par un utilisateur user
	public abstract Set getWorkflow(DataMDM user, String typeWF);
	
	

	
	////////////// METHODES DE SAUVEGARDE EN BASE DES OBJETS
	
	//Permet la sauvegarde en base d'une instance WFBrique
	public abstract Object saveConnector(BriqueSIWf wfBrique);
	
	//Permet la sauvegarde en base d'une instance WFModelData
	public abstract Object saveWFModelData(ModelData wfModelData);
	
	public abstract Object saveWFModelData(ModelValue value, Object idWfBriqueSI);
	
	public abstract Object saveWFModelData(ModelMDM model, Object idWfBriqueSI);		

	
	//Permet la sauvegarde en base d'une instance WFRelationship
	public abstract Object saveWFRelationship(RelationshipWf wfRelationShip);
	
	////////////// METHODES DE SAUVEGARDE EN BASE DES RELATIONS
	
	//Permet la sauvegarde en base de la relation LINKWf entre un WfBrique et une nature
	public abstract void createLinkWfNature(Object idWFBrique, Nature nature);
	

}