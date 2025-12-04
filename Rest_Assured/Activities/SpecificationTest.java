package examples;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationTest {
	// Declare request and response specification objects;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;

	@BeforeClass //Setup function
	public void setUp() {
		// Create the request specification
		requestSpec = new RequestSpecBuilder().
			setBaseUri("https://petstore.swagger.io/v2").
			addHeader("Content-Type", "application/json").
			build();
		
		// Create the response specification
		responseSpec = new ResponseSpecBuilder().
			expectStatusCode(200).
			expectBody("status", Matchers.equalTo("alive")).
			expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).
			build();
	}

	// POST https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	public void postRequestTest() {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77232);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");
		// Send request, save the response
		Response response = 
		given().
			spec(requestSpec).body(reqBody).
			log().all().
		when().
			post("/pet");
		// Extract the pet id from the response
		this.petId = response.then().extract().path("id");
		// Assertions
		response.then().spec(responseSpec).log().all();
	}
	// GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 2)
	public void getRequestTest() {
		// Send request, receive response, and assert
		given().spec(requestSpec).pathParam("petId", this.petId).
		when().get("/pet/{petId}").
		then().spec(responseSpec);
	}
	// DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deleteRequestTest() {
		// Send request, receive response, and assert
		given().spec(requestSpec).pathParam("petId", this.petId).
		when().delete("/pet/{petId}").
		then().statusCode(200).body("message", Matchers.equalTo(""+this.petId));
		//As response returns petId as string, in above line concatenating with "" to make it as string.
	}
}