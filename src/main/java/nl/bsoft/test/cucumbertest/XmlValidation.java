package nl.bsoft.test.cucumbertest;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class XmlValidation {
	private static Logger logger = LoggerFactory.getLogger(XmlValidation.class);

	private static XmlValidation instance = null;
	private SchemaFactory factory = null;

	
	// WCS
	private Schema schemaWCS = null;
	private Validator validatorWCS = null;
	
	// WFS
	private Schema schemaWFS = null;
	private Validator validatorWFS = null;
	// WMS
	private Schema schemaWMS = null;
	private Validator validatorWMS = null;
	// WMTS
	private Schema schemaWMTS = null;
	private Validator validatorWMTS = null;

	protected XmlValidation() {
		try {
			String xsdPathWCS = "wcsGetCapabilities.xsd";
			String xsdPathWFS = "wfs.xsd";
			String xsdPathWMS = "wms.xsd";
			String xsdPathWMTS = "wmtsGetCapabilities_response.xsd";

			factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			ClassLoader classLoader = getClass().getClassLoader();

			
			// WCS
			File xsdFileWCS = new File(classLoader.getResource(xsdPathWCS).getFile());
			schemaWCS = factory.newSchema(xsdFileWCS);
			validatorWCS = schemaWCS.newValidator();
			
			// WFS
			File xsdFileWFS = new File(classLoader.getResource(xsdPathWFS).getFile());
			schemaWFS = factory.newSchema(xsdFileWFS);
			validatorWFS = schemaWFS.newValidator();
			// WMS
			File xsdFileWMS = new File(classLoader.getResource(xsdPathWMS).getFile());
			schemaWMS = factory.newSchema(xsdFileWMS);
			validatorWMS = schemaWMS.newValidator();
			// WMTS
			File xsdFileWMTS = new File(classLoader.getResource(xsdPathWMTS).getFile());
			schemaWMTS = factory.newSchema(xsdFileWMTS);
			validatorWMTS = schemaWMTS.newValidator();
		} catch (SAXException e) {
			logger.error("Cann't create xmlvalidator, reason:", e);
		}
	}

	public static XmlValidation getInstance() {
		if (null == instance) {
			instance = new XmlValidation();
		}
		return instance;
	}

	
	// WCS
	public boolean validateXMLFileSchemaWCS(String xmlPath) {
		boolean result = false;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
			validatorWCS.validate(new StreamSource(xmlFile));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wcs file:", e);
			result = false;
		}
		return result;
	}

	public boolean validateXMLStringSchemaWCS(String xmlString) {
		boolean result = false;
		try {
			StringReader reader = new StringReader(xmlString);
			validatorWCS.validate(new StreamSource(reader));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wcs string: ", e);
			result = false;
		}
		return result;
	}
	
	
	// WFS
	public boolean validateXMLFileSchemaWFS(String xmlPath) {
		boolean result = false;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
			validatorWFS.validate(new StreamSource(xmlFile));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wfs file:", e);
			result = false;
		}
		return result;
	}

	public boolean validateXMLStringSchemaWFS(String xmlString) {
		boolean result = false;
		try {
			StringReader reader = new StringReader(xmlString);
			validatorWFS.validate(new StreamSource(reader));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wfs string: ", e);
			result = false;
		}
		return result;
	}

	// WMS
	public boolean validateXMLFileSchemaWMS(String xmlPath) {
		boolean result = false;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
			validatorWMS.validate(new StreamSource(xmlFile));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wms file:", e);
			result = false;
		}
		return result;
	}

	public boolean validateXMLStringSchemaWMS(String xmlString) {
		boolean result = false;
		try {
			StringReader reader = new StringReader(xmlString);
			validatorWMS.validate(new StreamSource(reader));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wms string: ", e);
			result = false;
		}
		return result;
	}

	// WMTS
	public boolean validateXMLFileSchemaWMTS(String xmlPath) {
		boolean result = false;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
			validatorWMTS.validate(new StreamSource(xmlFile));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wmts file:", e);
			result = false;
		}
		return result;
	}

	public boolean validateXMLStringSchemaWMTS(String xmlString) {
		boolean result = false;
		try {
			StringReader reader = new StringReader(xmlString);
			validatorWMTS.validate(new StreamSource(reader));
			result = true;
		} catch (IOException | SAXException e) {
			logger.error("Error during validation of wmts string: ", e);
			result = false;
		}
		return result;
	}
}
