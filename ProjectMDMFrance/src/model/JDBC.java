package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.factory.DAOFactory;
import dao.factory.Neo4jDAOFactory;
import dao.model.JDBCDAO;
import facade.CRUDFacade;

/**
 * La classe JDBC représente un connecteur de type JDBC. C'est un connecteur
 * associé aux base de données relationnelles.
 * 
 * @author GroupeMapping
 * @see Connector
 */
public class JDBC extends Connector
{
	/****************************************************************
	 *                    Membres de la classe                      *
	 ****************************************************************/

	private String	host;
	private int		port;
	private String	typeDB;
	private String	database;

	/****************************************************************
	 *                    Méthodes de la classe                     *
	 ****************************************************************/

	/**
	 * Crée un connecteur de type JDBC (base de données relationnelle)
	 * 
	 * @param _login le login utilisateur d'accès à la base de données
	 * @param _password le psswd utilisateur d'accès à la base de données
	 * @param _host l'adresse de la base de données
	 * @param _port le port de la base de données
	 * @param _typeDB le type de base de données
	 * @param _database la database concernée
	 * 
	 * @return le JDBC correspondant
	 */
	public JDBC(String _login, String _password, String _host, int _port,
			String _typeDB, String _database)
	{
		this.setId(null);
		this.setLogin(_login);
		this.setPassword(_password);
		this.setHost(_host);
		this.setPort(_port);
		this.setTypeDB(_typeDB);
		this.setDatabase(_database);
	}

	/**
	 * Sauvegarde le connecteur en base de données.
	 */
	public Object saveConnector()
	{
		DAOFactory df = new Neo4jDAOFactory();
		JDBCDAO dao = df.createJDBCDAO();
		return dao.saveJDBC(this);
	}

	/**
	 * Retourne un dictionnaire détaillant le schéma de la database avec en clé
	 * les tables et en valeur les listes des colonnes
	 * 
	 * @return Map&lt;Table, List&lt;Colonne&gt;&gt;
	 */
	public Map<ModelMDM, List<ModelValue>> getDatabaseSchema()
	{
		switch (this.getTypeDB())
		{
			case "mysql":
				return this.getDatabaseSchemaMySQL();

			case "oracle":
				return this.getDatabaseSchemaOracle();
		}

		return null;
	}

	private Map<ModelMDM, List<ModelValue>> getDatabaseSchemaOracle()
	{
		// On initialise notre variable de retour
		// Et on déclare la liste des colonnes (réutilisées plusieurs fois)
		Map<ModelMDM, List<ModelValue>> tables = new HashMap<ModelMDM, List<ModelValue>>();
		List<ModelValue> columns;

		try
		{
			// On précise ce que l'on va utiliser comme type de connexion
			// On se connecte à travers les paramètres de notre connecteur
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + this.getHost() + ":"
							+ this.getPort() + ":" + this.getDatabase(),
					this.getLogin(), this.getPassword());

			// Le Statement est utilisé pour pouvoir éxecuter une requête SQL
			// le résultat de cette requête est stocké dans un ResultSet.
			// Grossièrement, le ResultSet est un pointeur sur chaque ligne
			// sélectionnée par la requête.
			Statement sTables = c.createStatement();
			ResultSet rTables = sTables
					.executeQuery("SELECT TABLE_NAME, '' AS COLUMN_COMMENT FROM USER_TABLES");

			// Pour chaque ligne de la requête (table) (pointeur++)
			// (renvoie false si dernière ligne
			// ou pas de ligne)
			while (rTables.next())
			{
				ModelMDM table = new ModelMDM(CRUDFacade.loadNature("Brique"),
						rTables.getString("TABLE_NAME"),
						rTables.getString("COLUMN_COMMENT"));

				// On initialise la liste des colonnes
				// pour cette table
				columns = new ArrayList<ModelValue>();

				// Si l'on lit la doc
				// "only one ResultSet object per Statement object can be open at the same time."
				// On recrée donc le Statement pour éxecuter une nouvelle
				// requête
				Statement sColumns = c.createStatement();
				ResultSet rColumns = sColumns
						.executeQuery("SELECT DATA_TYPE, DATA_DEFAULT, COLUMN_NAME "
								+ "FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '"
								+ rTables.getString("TABLE_NAME") + "'");

				// Pour chaque colonne de la table
				while (rColumns.next())
				{
					// On ajoute son nom à la liste
					columns.add(new ModelValue(rColumns.getString("DATA_TYPE"),
							"", table, rColumns.getString("DATA_DEFAULT"),
							rColumns.getString("COLUMN_NAME"), "public"));
				}

				// Une fois que l'on a tous les noms
				// On ajoute la liste au HashMap des tables
				// avec la table en key
				tables.put(table, columns);

				// Proprement on close ce
				// que l'on utilise plus.
				rColumns.close();
				sColumns.close();
			}

			// Pareil ici
			rTables.close();
			sTables.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return tables;
	}

	private Map<ModelMDM, List<ModelValue>> getDatabaseSchemaMySQL()
	{
		// On initialise notre variable de retour
		// Et on déclare la liste des colonnes (réutilisées plusieurs fois)
		Map<ModelMDM, List<ModelValue>> tables = new HashMap<ModelMDM, List<ModelValue>>();
		List<ModelValue> columns;

		try
		{
			// On précise ce que l'on va utiliser comme type de connexion
			// On se connecte à travers les paramètres de notre connecteur
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://" + this.getHost() + ":" + this.getPort()
							+ "/" + this.getDatabase(), this.getLogin(),
					this.getPassword());

			// Le Statement est utilisé pour pouvoir éxecuter une requête SQL
			// le résultat de cette requête est stocké dans un ResultSet.
			// Grossièrement, le ResultSet est un pointeur sur chaque ligne
			// sélectionnée par la requête.
			Statement sTables = c.createStatement();
			ResultSet rTables = sTables
					.executeQuery("SELECT DISTINCT TABLE_NAME, COLUMN_COMMENT "
							+ "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='"
							+ this.getDatabase() + "';");

			// Pour chaque ligne de la requête (table) (pointeur++)
			// (renvoie false si dernière ligne
			// ou pas de ligne)
			while (rTables.next())
			{
				ModelMDM table = new ModelMDM(CRUDFacade.loadNature("Brique"),
						rTables.getString("TABLE_NAME"),
						rTables.getString("COLUMN_COMMENT"));

				// On initialise la liste des colonnes
				// pour cette table
				columns = new ArrayList<ModelValue>();

				// Si l'on lit la doc
				// "only one ResultSet object per Statement object can be open at the same time."
				// On recrée donc le Statement pour éxecuter une nouvelle
				// requête
				Statement sColumns = c.createStatement();
				ResultSet rColumns = sColumns
						.executeQuery("SELECT DATA_TYPE, COLUMN_COMMENT, COLUMN_DEFAULT, COLUMN_NAME "
								+ "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"
								+ this.getDatabase()
								+ "' AND TABLE_NAME = '"
								+ rTables.getString("TABLE_NAME") + "';");

				// Pour chaque colonne de la table
				while (rColumns.next())
				{
					// On ajoute son nom à la liste
					columns.add(new ModelValue(rColumns.getString("DATA_TYPE"),
							rColumns.getString("COLUMN_COMMENT"), table,
							rColumns.getString("COLUMN_DEFAULT"), rColumns
									.getString("COLUMN_NAME"), "public"));
				}

				// Une fois que l'on a tous les noms
				// On ajoute la liste au HashMap des tables
				// avec la table en key
				tables.put(table, columns);

				// Proprement on close ce
				// que l'on utilise plus.
				rColumns.close();
				sColumns.close();
			}

			// Pareil ici
			rTables.close();
			sTables.close();
			c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return tables;
	}

	public Map<DataMDM, List<DataValue>> getDatabaseValues()
	{
		// <ModelMDM, List<ModelValue>>
		Map<DataMDM, List<DataValue>> lignes = new HashMap<DataMDM, List<DataValue>>();
		return lignes;
	}
	
	/****************************************************************
	 *                    Accesseurs de la classe                   *
	 ****************************************************************/

	public String getHost()
	{
		return this.host;
	}

	public void setHost(String _host)
	{
		this.host = _host;
	}

	public int getPort()
	{
		return this.port;
	}

	public void setPort(int _port)
	{
		this.port = _port;
	}

	public String getTypeDB()
	{
		return this.typeDB;
	}

	public void setTypeDB(String _typeDB)
	{
		this.typeDB = _typeDB;
	}

	public String getDatabase()
	{
		return this.database;
	}

	public void setDatabase(String _database)
	{
		this.database = _database;
	}
}
