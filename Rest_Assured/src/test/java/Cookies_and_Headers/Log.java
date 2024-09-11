package Cookies_and_Headers;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Log 
{
	@Test
	public void logMethod()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log().headers()
		.log().cookies()
		.log().status()
			;
	}

}
