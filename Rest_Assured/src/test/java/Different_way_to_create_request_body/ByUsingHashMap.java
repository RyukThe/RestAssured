package Different_way_to_create_request_body;

import org.testng.TestNG;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ByUsingHashMap 
{
	
	@Test
	public void postRequestbyHashMap()
	{
		HashMap data= new HashMap();
		data.put("name", "Saurav");
		data.put("location", "India");
		data.put("Phone", "85548036XX");
		
		
		String courseARr[]= {"C#","Java"};
		
		data.put("courses", courseARr);
		
		given()
		.contentType("appliction/json")
		.body(data)
		.when()
		.post("")
		.then()
		.statusCode(201)
		.body("name", equalTo("Saurav"))//1st parameter is field and 2nd parameter is expected value.
		.body("location", equalTo("India"))
		.body("phone", equalTo("85548036XX"))
		.body("courses[0]", equalTo("C#"))// if values are in array then we have to vaildate by using indexes
		.body("courses[1]", equalTo("Java"))
		.header("Content-Type", "application/json; charset=uft-8") // validating header information 
		.log().all();
	}

	
	@Test
	public void testDelete()
	{
		given()
		.when()
		.delete("")
		.then()
		.statusCode(204)
		;
	}
	
}