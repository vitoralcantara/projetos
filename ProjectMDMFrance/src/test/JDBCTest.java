package test;

import static org.junit.Assert.*;

import model.JDBC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JDBCTest {

	private JDBC jdbc;
	
	@Before
	public void setUp() throws Exception {
		
		jdbc=new JDBC("coco", "lapin", "127.0.0.1", 4545, "Database","graph.db");
	}
		@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveConnector() {
		fail("Not yet implemented");
	}

	@Test
	public void testJDBC() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDatabaseSchema() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHost() {
		
		assertEquals(jdbc.getHost(),"127.0.0.1");

	}

	@Test
	public void testSetHost() {
		
		String host="135.233.52.1";
		jdbc.setHost(host);
		assertEquals(jdbc.getHost(),host);
	
	}

	@Test
	public void testGetPort() {
		
		assertEquals(jdbc.getPort(),4545);
	
	}

	@Test
	public void testSetPort() {
		
		int port=8585;
		jdbc.setPort(port);
		assertEquals(jdbc.getPort(),port);

	}

	@Test
	public void testGetTypeDB() {
		
		
		assertEquals(jdbc.getTypeDB(),"Database");

	}

	@Test
	public void testSetTypeDB() {
		
		String db="Data";
		jdbc.setTypeDB(db);
		assertEquals(jdbc.getTypeDB(),db);
	
	}

	@Test
	public void testGetDatabase() {
		
		assertEquals(jdbc.getDatabase(),"graph.db");
		
	}

	@Test
	public void testSetDatabase() {
		String db="Data";
		jdbc.setDatabase(db);
		assertEquals(jdbc.getDatabase(),db);
		
	}

	@Test
	public void testGetId() {
		
		assertEquals(jdbc.getId(),null);

	}

	@Test
	public void testSetId() {
		long id=45;
		jdbc.setId(id);
		assertEquals(jdbc.getId(),id);
	
	}

	@Test
	public void testGetLogin() {
		
		assertEquals(jdbc.getLogin(),"coco");

	}

	@Test
	public void testSetLogin() {
		String log="log";
		jdbc.setLogin(log);
		assertEquals(jdbc.getLogin(),log);
	}

	@Test
	public void testGetPassword() {
		
		assertEquals(jdbc.getPassword(),"lapin");
		
	}

	@Test
	public void testSetPassword() {
		String pass="jean";
		jdbc.setPassword(pass);
		assertEquals(jdbc.getPassword(),pass);
	}

}
