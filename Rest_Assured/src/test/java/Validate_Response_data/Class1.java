package Validate_Response_data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class Class1
{
	
	//@Test
	public void storeApi()
	{
		//Approach 1
	/*	given()
		.contentType("application/json")
		.when()
		.get("http://localhost:3000/Store")
		.then()
		.statusCode(200)
		.body("book[3].title", equalTo("Harry Potter and the Philosopher's Stone"))
		.body("book[2].price", equalTo(19.99F))
		.log().all(); */
		
		Response rs=given()
				.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/Store");
		
		Assert.assertEquals(rs.getStatusCode(), 200); //verification of status code
		Assert.assertEquals(rs.getHeader("Content-Type"), "application/json; charset=utf-8");
		//response store in body we want capture specific field then we to call
		rs.jsonPath().get("book[3].title"); //get() is used to get specific field from data for that we have to pass String json path for that field
	
		Assert.assertEquals(rs.jsonPath().get("book[3].title").toString(), "Harry Potter and the Philosopher's Stone");
		
		
	}
	
	
	
	
}
