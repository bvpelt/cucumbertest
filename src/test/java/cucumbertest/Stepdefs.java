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

	private CloseableHttpResponse response = null;
	
	private TestClient testclient = null;

	@Given("^The testclient exists$")
	public void the_testclient_exists() throws Throwable {
		testclient = new TestClient();
		Assert.assertNotNull(testclient);
	}

	@When("^I ask wfs get capabilities secure for service '(.*)'$")
	public void i_ask_wfs_get_capabilities_secure_for_service_bag(final String service) throws Throwable {
		String url = "https://geodata.nationaalgeoregister.nl/" + service + "/wfs?request=GetCapabilities";
		logger.info("Calling service {} with url {}", service, url);
		response = testclient.sendRequest(url, TestClient.HTTPGET);
		Assert.assertNotNull(testclient);
	}

	@Then("^I get a success response$")
	public void i_get_a_success_response() throws Throwable {
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}
}
