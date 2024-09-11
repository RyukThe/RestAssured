package restAssured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class postRequest {

	
	@Test
	
	public void postRequest1()
	{
		baseURI="https://reqres.in/"; //end point
		// Dividing code in three phases 
		 Response res = given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when()
		.post("/api/users")
		//.then()
		//.assertThat().statusCode(201).log().all().body("name",equalTo("morpheus")).extract().response().toString()
		;
		
		System.out.println(res.jsonPath().get("name")); ;
		 
	}
	
}
