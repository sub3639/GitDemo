package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;

public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	@Given("Add Place Playload with {String} {String} {String}")
	public void add_place_playload_with(String name,String language, String address) throws PendingException, IOException {
		

	   resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
          TestDataBuild data = new TestDataBuild();
	   res=given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String resource) throws PendingException {
		APIResources resAPI=APIResources.valueOf(resource);
		System.out.println(resAPI.getResource());
		 response=res.when().post(resAPI.getResource())
				.then().assertThat().spec(resspec).extract().response();
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) throws PendingException {
	    // Write code here that turns the phrase above into concrete actions
	  assertEquals(response.getStatusCode(),200);
	}
		
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Paramkey, String Expectedvalue) throws PendingException {
	    // Write code here that turns the phrase above into concrete actions
		String resp=response.asString();
		JsonPath js=new JsonPath(resp);
		Assert.assertEquals(js.get(Paramkey).toString(),Expectedvalue);
	}


}
