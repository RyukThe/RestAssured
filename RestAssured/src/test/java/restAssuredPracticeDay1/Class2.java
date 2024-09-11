package restAssuredPracticeDay1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Class2 {

	
	//@Test
	public void getRequest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all().header("Content-Type","application/json")
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200);
	}
	
	//@Test
	public void getRequest1()
	{
		RestAssured.baseURI="https://reqres.in/";
		given().log().all().header("Content-Type","application")
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test
	public void getRequest3()
	{
		RestAssured.baseURI="https://reqres.in/";
		
	
		given().log().all()
		.contentType(ContentType.JSON)
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test
	public void getRequest4()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all().header("Content-Type","application/json")
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	//@Test
	public void getRequest5()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		
		given().log().all().header("Content-type","application/json")
		.when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void getRequest6()
	{
	baseURI="https://reqres.in/";
		
		
		given().log().all().header("Content-Type","application/json")
	
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200);
	}
}
