package resource;

import org.neo4j.graphdb.RelationshipType;

/**
 * Enumération des types de relations entre noeuds du graphe.
 * 
 * Ce type est à indiquer à la création d'une relation.
 * 
 * @author Guillaume
 */
public enum NodesRelationship implements RelationshipType {
	ROLE, SECURE, INSTANCE_OF, HAS_NATURE, HAS_FATHER
}