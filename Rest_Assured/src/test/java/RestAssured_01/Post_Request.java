package RestAssured_01;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class Post_Request 
{
	int id; //we can use this id in another method
	@Test(priority = 1)
	public void postRequest()
	{
		
		HashMap<String, String> mp = new HashMap<String, String>();
		mp.put("name", "Saurav");
		mp.put("job", "QA");
		
		
		
		id=given()
		
		//1 content type
		// body or data which we want send 
		.contentType("application/json")
		.body(mp)
		.when()
		.post("https://reqres.in/api/users")
			.jsonPath().getInt("id"); 
		System.out.println(id);
	
		
	/*	.then()
		
		.statusCode(201)
		.body("job", equalTo("QA"))
		.log().all()
		*/
		
		
		
		
		
	}
	
	
	@Test(priority = 2,dependsOnMethods = "postRequest")
	public void putRequest()
	{
		
		HashMap<String, String> mp=new HashMap<String, String>();
		mp.put("name", "Saurav Kasture");
		mp.put("job", "Test Engineer");
		
		
		given()
		
		.contentType("application/json")
		.body(mp)
		
		.when()
		.put("https://reqres.in/api/users/"+id) // here we set value instated
		
		
		
		.then()
		.statusCode(200)
		.log().all();
	}

	
	@Test(priority = 3,dependsOnMethods = {"postRequest","putRequest"})
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
