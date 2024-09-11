package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class deleteRequest {

	
	@Test
	public void DeleteRequest()
	{
		baseURI="https://reqres.in/";
		basePath="/api/users/2";
		
		given().log().all().contentType(ContentType.JSON)
		.when().delete()
		.then().assertThat().statusCode(204).log().all();
	}
}
