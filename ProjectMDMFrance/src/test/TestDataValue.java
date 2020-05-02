package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import facade.*;
import model.DataMDM;
import model.DataValue;
import model.ModelValue;

/**
 * @author Clement A.
 *
 */

public class TestDataValue {

	private DataValue dataValue;
	private DataMDM dataMDM;
	private ModelValue modelValue;
	
	@Before
	public void setUp() throws Exception
    {
        this.dataValue = new DataValue(dataMDM, modelValue,"testValue");
    }
	

	@Test
	public void testGetModelValue()
	{
		assertEquals(modelValue, dataValue.getModelValue());
	}
	
	/*
 	@Test
	public void testSetModelValue()
	{
		private ModelValue newModelValue;
		dataValue.setModelValue(newModelValue);
		assertEquals(newModelValue, dataValue.getLabel());
	}
	*/
	
	@Test
	public void testGetValue()
	{
		assertEquals("testValue", dataValue.getValue());
	}
	
	@Test
	public void testSetValue()
	{
		dataValue.setValue("newValue");
		assertEquals("newValue", dataValue.getValue());
	}

}
