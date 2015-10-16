package cucumbertest;

import nl.bsoft.test.cucumbertest.XmlValidation;
import nl.kadaster.geodatastore.TestClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import java.util.UUID;

public class Stepdefs {
	private static Logger logger = LoggerFactory.getLogger(Stepdefs.class);
	private static boolean useProxy = true;
	private CloseableHttpResponse response = null;
	private TestClient testclient = null;
	private String service = null;
	private XmlValidation xv = XmlValidation.getInstance();
	private UUID uuid;

	@Given("^The testclient exists$")
	public void the_testclient_exists() throws Throwable {
		testclient = new TestClient();
		testclient.setConnectTimeOut(10000);
		testclient.setRequestTimeOut(10000);
		testclient.setSocketTimeOut(10000);
		if (useProxy) {
			testclient.setProxy("www-proxy.cs.kadaster.nl", 8082);
		}
		uuid = UUID.randomUUID();
		Assert.assertNotNull(testclient);
	}

	@When("^I ask '(.*)' get capabilities with '(.*)' for service '(.*)'$")
	public void i_ask_wfs_get_capabilities_secure_for_service(final String requestType, final String protocol,
			final String service) throws Throwable {
		this.service = service;
		String url = null;


		if (requestType.toLowerCase().equals("wcs")  
				|| requestType.toLowerCase().equals("wfs")
				|| requestType.toLowerCase().equals("wms")) {
			url = protocol + "://geodata.nationaalgeoregister.nl/" + service + "/" + requestType
					+ "?request=GetCapabilities";
		}
		if (requestType.toLowerCase().equals("wmts")) {
			url = protocol + "://geodata.nationaalgeoregister.nl/tiles/service/" + requestType + "/" + service
					+ "?request=GetCapabilities";
		}
		url +=  "&cucumbertest="+ uuid.toString();

		Assert.assertNotNull(url);
		logger.info("Calling service {} with url {}", service, url);
		response = testclient.sendRequest(url, TestClient.HTTPGET);
		Assert.assertNotNull(testclient);
	}

	@Then("^I get status '(\\d+)' as response$")
	public void i_get_status_as_response(final int httpStatus) throws Throwable {
		logger.info("Expected status: {}", httpStatus);
		Assert.assertEquals(httpStatus, response.getStatusLine().getStatusCode());
	}

	@Then("^I get '(.*)' as validation status for '(.*)'$")
	public void i_get_status_as_xmlvalidationresponse(final String xmlStatus, final String requestType)
			throws Throwable {
		logger.info("Request type: {}, Expected status: {}", requestType, xmlStatus);
		Boolean expectedStatus = new Boolean(xmlStatus);
		HttpEntity entity = response.getEntity();
		String xmlString = EntityUtils.toString(entity);
		logger.debug("Service: {}, result: {}", service, xmlString);
		boolean validXml = false;
		try {
			if (requestType.toLowerCase().equals("wfs")) {
				validXml = xv.validateXMLStringSchemaWFS(xmlString);
			}
			if (requestType.toLowerCase().equals("wms")) {
				validXml = xv.validateXMLStringSchemaWMS(xmlString);
			}
			if (requestType.toLowerCase().equals("wmts")) {
				validXml = xv.validateXMLStringSchemaWMTS(xmlString);
			}
		} finally {
			response.close();
		}
		Assert.assertEquals(expectedStatus, validXml);
	}
}
