package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import facade.*;
import model.ModelMDM;
import model.Nature;

/**
 * @author Clement A.
 *
 */

public class TestModelMDM {

	private ModelMDM modelMDM;
	
	@Before
	public void setUp() throws Exception
    {
        this.modelMDM = new ModelMDM(null , "testLabel", "testDescription");
    }
	

	@Test
	public void testGetLabel()
	{
		assertEquals("testLabel", modelMDM.getLabel());
	}
	
	@Test
	public void testGetDescription()
	{
		assertEquals("testDescription", modelMDM.getDescription());
	}

	@Test
	public void testSetLabel()
	{
		modelMDM.setLabel("newLabel");
		assertEquals("newLabel", modelMDM.getLabel());
	}
	
	@Test
	public void testSetDescription()
	{
		modelMDM.setDescription("newDescription");
		assertEquals("newDescription", modelMDM.getDescription());
	}
	
}
