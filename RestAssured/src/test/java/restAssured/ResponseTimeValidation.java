package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;


public class ResponseTimeValidation {

	
	@Test
	public void delete()
	{
		baseURI="https://reqres.in/";
		basePath="/api/users/2";
		
		Response r = given().log().all().contentType(ContentType.JSON)
		.when().delete();
		
		long Time = r.getTime();
	System.out.println(Time);
	ValidatableResponse val = r.then().log().all();
	val.statusCode(204);
	val.time(Matchers.lessThan(3000L));
	}
}
