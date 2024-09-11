package restAssured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PUTRequest {

	
	
	@Test
	public void PUTrequest()
	{
		baseURI="https://reqres.in/";
		basePath="/api/users/2";
		
	/*Response r =*/ given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}")
		.when().put().then().log().all().assertThat().statusCode(200).body("job", equalTo("zion resident")).extract().response().toString();
	
	//	System.out.println(r.jsonPath().getString("job"));
	}
}
