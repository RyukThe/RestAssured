package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PacthRquest {

	
	@Test
	public void PATCHRequest()
	{
		baseURI="https://reqres.in/";
		basePath="/api/users/2";
		
		given().log().all().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"name\": \"Saurav\"\r\n"
				
				+ "}").when().patch().then().log().all().statusCode(200);
	}
}
