package RestAssured_01;

import org.testng.annotations.Test;

import groovy.transform.Pure;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Class2
{
	
	int id;
	@Test(priority = 1)
	public void getRequest()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		
		.statusCode(200)
		.body("page", equalTo(2))
		;
	}

	
	@Test(priority = 2)
	public void post()
	{
		HashMap<String , String>
		data= new HashMap<String, String>();
		
		data.put("name", "Saurav Kasture");
		data.put("job", "QA");
		
		id=given()
		
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	/*	.then()
		.statusCode(201)
		.log().all(); */
	}
	
	
	 @Test(priority = 3, dependsOnMethods = "post")
	 public void putRequest()
	 {
		HashMap<String, String>
		 data= new HashMap<String, String>();
		data.put("name", "Saurav kasture");
		data.put("job","Test engineer");
		 given()
		 .contentType("application/json")
		 .body(data)
		 .when()
		.put("https://reqres.in/api/users/"+id)
		 
		 .then()
		 .statusCode(200)
		 .log().all();
		 ;
	 }
	 
	 
	 @Test(priority = 4, dependsOnMethods = "putRequest")
	 public void deleteRequest()
	 {
		 given()
		 .when()
		 .delete("https://reqres.in/api/users/"+id)
		 .then()
		 .statusCode(204)
		 .log().all();
	 }
}
