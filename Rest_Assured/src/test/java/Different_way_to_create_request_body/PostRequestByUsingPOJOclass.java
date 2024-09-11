package Different_way_to_create_request_body;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequestByUsingPOJOclass 
{ 
	@Test
	public void postRequest()
	{
		OPJO_Post_Request data=new OPJO_Post_Request();
		data.setName("Saurav");
		data.setLocation("India");
		data.setPhone("XXXXXXXX");
		// for array 1st we have to create courses array  
		String ar[]= {"C#","Java"};
		data.setCourse(ar);
		//for this we set the data 
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Saurav"))
		.header("Content-Type", "application/json; charset=uft-8")
		;
	}
	
	@Test
	public void deleteRequest()
	{
		given()
		.when()
		.delete("")
		.then()
		.statusCode(204);
	}
	
	

}
