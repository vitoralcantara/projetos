package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import facade.*;
import model.DataMDM;

/**
 * @author Clement A.
 *
 */

public class TestDataMDM {

	private DataMDM dataMDM;
	
	@Before
	public void setUp() throws Exception
    {
        this.dataMDM = new DataMDM("testLabel");
    }
	

	@Test
	public void testGetLabel()
	{
		assertEquals("testLabel", dataMDM.getLabel());
	}
	
	@Test
	public void testSetLabel()
	{
		dataMDM.setLabel("newLabel");
		assertEquals("newLabel", dataMDM.getLabel());
	}

}
