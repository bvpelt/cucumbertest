package nl.bsoft.test.cucumbertest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class XmlValidationTest {

	private static XmlValidation xv = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (null == xv) {
			xv = XmlValidation.getInstance();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
/*
	// WCS
	@Test
	public void testValidateXMLWCSSchema() {
		boolean result = false;

		result = xv.validateXMLFileSchemaWCS("wcsGetCapabilities.xml");
		Assert.assertEquals(true, result);

	}
*/
	// WFS
	@Test
	public void testValidateXMLWFSSchema() {
		boolean result = false;

		result = xv.validateXMLFileSchemaWFS("wfsGetCapabilities.xml");
		Assert.assertEquals(true, result);

	}

	// WMS
	@Test
	public void testValidateXMLWMSSchema() {

		boolean result = false;

		result = xv.validateXMLFileSchemaWMS("wmsGetCapabilities.xml");
		Assert.assertEquals(true, result);

	}

	// WMTS
	@Test
	public void testValidateXMLWMTSSchema() {

		boolean result = false;

		result = xv.validateXMLFileSchemaWMTS("wmtsGetCapabilities.xml");
		Assert.assertEquals(true, result);

	}

	@Test
	public void testValidateXMLSchemaMultiple() {

		boolean result = false;
		/*
		result = xv.validateXMLFileSchemaWCS("wcsGetCapabilities.xml");
		Assert.assertEquals(true, result);
*/
		result = xv.validateXMLFileSchemaWFS("wfsGetCapabilities.xml");
		Assert.assertEquals(true, result);

		result = xv.validateXMLFileSchemaWMS("wmsGetCapabilities.xml");
		Assert.assertEquals(true, result);

		result = xv.validateXMLFileSchemaWMTS("wmtsGetCapabilities.xml");
		Assert.assertEquals(true, result);

	}

	@Test
	public void testValidateXMLSchemaAsString() {
		boolean result = false;

		String xmlPath = "wfsGetCapabilities.xml";
		ClassLoader classLoader = getClass().getClassLoader();
		File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
		StringBuilder stringBuilder = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(xmlFile));

			String line = null;
			stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = xv.validateXMLStringSchemaWFS(stringBuilder.toString());
		Assert.assertEquals(true, result);
	}
}
