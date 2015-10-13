package cucumbertest;

import java.util.List;

import nl.kadaster.geodatastore.TestClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {
	private static Logger logger = LoggerFactory.getLogger(Stepdefs.class);
	private static boolean useProxy = true;
	private CloseableHttpResponse response = null;
	
	private TestClient testclient = null;

	@Given("^The testclient exists$")
	public void the_testclient_exists() throws Throwable {
		testclient = new TestClient();
		if (useProxy) {
			testclient.setProxy("www-proxy.cs.kadaster.nl", 8082);
		}

		Assert.assertNotNull(testclient);
	}

	@When("^I ask '(.*)' get capabilities with '(.*)' for service '(.*)'$")
	public void i_ask_wfs_get_capabilities_secure_for_service(final String requestType, final String protocol, final String service) throws Throwable {
		String url = protocol + "://geodata.nationaalgeoregister.nl/" + service + "/" + requestType + "?request=GetCapabilities";
		logger.info("Calling service {} with url {}", service, url);
		response = testclient.sendRequest(url, TestClient.HTTPGET);
		Assert.assertNotNull(testclient);
	}

	@Then("^I get status '(\\d+)' as response$")
	public void i_get_status_as_response(final int httpStatus) throws Throwable {
		logger.info("Exected status: {}", httpStatus);
		Assert.assertEquals(httpStatus, response.getStatusLine().getStatusCode());
	}

}
