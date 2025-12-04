package activities;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity1 {
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestWithQueryParam() {
		// Send request, save the response
		Response response = RestAssured.given().
		// Request spec
				baseUri("https://petstore.swagger.io/v2").
				header("Content-Type", "application/json").
				queryParam("status", "sold").
		// Send request and receive response
		when().get("/pet/findByStatus");

		// Get the response code
		System.out.println("Status Code: " + response.getStatusCode());
		// Get the response headers
		System.out.println("Headers: " + response.headers());
		// Get the response body
		System.out.println("Body: \n" + response.getBody().asPrettyString());
		
	}
	
	// GET https://petstore.swagger.io/v2/pet/{petId}
		@Test
		public void getRequestWithPathParam() {
			// Send request, save the response
			RestAssured.given().
			// Request spec
					baseUri("https://petstore.swagger.io/v2").
					header("Content-Type", "application/json").
					pathParam("petId", 12).
			// Send request and receive response
			when().get("/pet/{petId}").
			then().
					// Response spec
					statusCode(200).body("id", Matchers.equalTo(12));
		}
}
