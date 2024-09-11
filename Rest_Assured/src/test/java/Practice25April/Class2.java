package Practice25April;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Class2 {

	
	@Test
	public void jsonparsing()
	{
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/Store")
		.then()
		.statusCode(200);
	}
}
