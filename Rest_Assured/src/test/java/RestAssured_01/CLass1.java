package RestAssured_01;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class CLass1
{
	
	int id;
	
	@Test (priority = 1)
	public void getRequest()
	{
		given()
		
		
		
		.when()
		
		.get("https://reqres.in/api/users?page=2")
		
		
		
		
		.then()
		
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all()
		
		;
	}

	
	
	@Test(priority = 2)
	public void postRequest()
	{
		
		HashMap<String, String> mp= new HashMap<String, String>();
		mp.put("name", "Saurav Kasture");
		mp.put("job", "QA Analyst");
		
		
		
		id=given()
		.contentType("application/json")
		.body(mp)
		
		.when()
		
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		/*.then()
		.statusCode(201)
		.log().all();
		*/
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = "postRequest")
	public void putRequest()
	{
		HashMap<String , String> data= new HashMap<String, String>();
		
		
		data.put("name", "Saurav Kasture");
		data.put("job", "QA");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test(priority = 4, dependsOnMethods = {"putRequest"})
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
