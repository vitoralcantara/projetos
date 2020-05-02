/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import model.*;
import facade.*;


/**
 * @author Thomas
 *
 */
public class TestWf 
{
	private Wf workflow;
	
	@Before
	public void setUp() throws Exception
    {
        this.workflow = new BriqueSIWf(1, CRUDFacade.loadNature("Brique"), new DataMDM("demandeur"), "description", null, null, "CREATE");
    }
	
	@Test
	public void testGetDescription()
	{
		assertEquals("description", workflow.getDescription());
	}
	
	@Test
	public void testGetIdentifiant()
	{
		assertEquals(1, workflow.getIdentifiant());
	}
	
	@Test
	public void testGetRequestType()
	{
		assertEquals("CREATE", workflow.getRequestType());
	}
	
	@Test
	public void testSetDescription()
	{
		workflow.setDescription("changementDescription");
		assertEquals("changementDescription", workflow.getDescription());
	}
	
	@Test
	public void testSetIdentifiant()
	{
		workflow.setIdentifiant(2);
		assertEquals(2, workflow.getIdentifiant());
	}
	
	@Test
	public void testSetRequestType()
	{
		workflow.setRequestType("UPDATE");
		assertEquals("UPDATE", workflow.getRequestType());
	}	 
	 
}
