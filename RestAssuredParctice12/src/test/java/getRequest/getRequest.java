package getRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class getRequest {

	@Test
	public void m1()
	{
		//RestAssured.baseURI="https://reqres.in/";
		//RestAssured.basePath="api/users?page=2";
		given().when().get("https://reqres.in/api/users?page=2").then().assertThat().log().all();
	}
}
