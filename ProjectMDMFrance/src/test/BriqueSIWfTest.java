package test;

import static org.junit.Assert.*;

import model.BriqueSIWf;
import model.Connector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facade.MappingFacade;

public class BriqueSIWfTest {
	
	BriqueSIWf wfBrique;
	Connector connecteur;

	@Before
	public void setUp() throws Exception {
		wfBrique = new BriqueSIWf(1,null, null, "je suis une brique", connecteur, null, null);
		connecteur = MappingFacade.createJDBC("solene","1234", "localhost", 8080, "Neo4j", "graphDB");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetSchema() {
		
		
	}

	@Test
	public void testSetSchema() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConnecteur() {
		assertEquals(connecteur, wfBrique.getConnecteur());
	}

	@Test
	public void testSetConnecteur() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNature() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNature() {
		fail("Not yet implemented");
	}

	@Test
	public void testBriqueSIWf() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveMap() {
		fail("Not yet implemented");
	}

}

