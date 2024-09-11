package restAssuredPracticeDay1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Class1 {

	
	@Test
	public void getRequest()
	{
		
		
		RestAssured.baseURI="https://reqres.in/";
		
		String r = given().log().all().header("Content-Type","application/json")
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200).header("Content-Type","application/json; charset=utf-8" ).extract().response().asString();
	System.out.println(r);
	
	JsonPath j =new JsonPath(r);
			String value = j.getString("per_page");
	String	email=	j.getString("data[0].email");
	System.out.println(email);		
	System.out.println(value);
			
			
	}
}
