package restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentication {

	@Test
	public void basicAuth()
	{
		baseURI="https://postman-echo.com/";
		basePath="/basic-auth";
		given().log().all().header("Content-Type","application").auth().preemptive().basic("postman", "password")
		.when().get().then().assertThat().statusCode(200).log().all();
		;
		
	}
}
