package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PUTRequestByUsingPojoClass {

	
	@Test
	public void PUT()
	{
		POJORequestBody pojo=new POJORequestBody();
		pojo.setName("morpheus");
		pojo.setJob("zion resident");
		baseURI="https://reqres.in/";
		basePath="/api/users/2";
		
		POJOResponseBody res = given().log().all().contentType(ContentType.JSON).body(pojo).expect().defaultParser(Parser.JSON)
		.when().put()
		.then().log().all().assertThat().statusCode(200).extract().response().as(POJOResponseBody.class);
		System.out.println(res.getName());
		System.out.println(res.getJob());
		System.out.println(res.getUpdatedAt());
	}
}
