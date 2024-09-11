package PracticeDifferent_way_to_create_request_body;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class PostRequestByUsingJSONObject 
{
	@Test
	public void post()
	{
		JSONObject data= new JSONObject();
		data.put("name", "Nomad");
		data.put("location", "disapear");
		data.put("phone", "8457547");
		
		String coursesar[]= {"Java","Python"};
		data.put("courses", coursesar);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
	
	@Test(priority = 1,dependsOnMethods = "post")
	public void delete()
	{
		given()
		.when()
		.delete("http://localhost:3000/Students")
		.then()
	
		.log().all();
	}

}
