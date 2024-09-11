package PracticeDifferent_way_to_create_request_body;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PostRequestByUsingHashMap 
{
	//@Test
	public void post()
	{
		
		
		HashMap k= new HashMap();
		k.put("name", "Nomad");
		k.put("location", "pune");
		k.put("phone", "xxxxxx");
		
		
		String[]ar= {"Travell","Songs"};
		k.put("courses", ar);
		
		
		given()
		.contentType("application/json")
		.body(k)
		.post("http://localhost:3000/Students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Nomad"))
		.body("location", equalTo("pune"))
		.body("phone", equalTo("xxxxxx"))
		.body("courses[0]", equalTo("Travell"))
		.body("courses[1]", equalTo("Songs"))
		

		;
	
	}
	
	
	
	//@Test
	public void get()
	{
		given()
		.when()
		.get("http://localhost:3000/Students")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//@Test
	public void delete()
	{
		for(int i=4;i<=6;i++)
		{
			given()
			.when()
			.delete("http://localhost:3000/Students/"+i)
			.then()
			.statusCode(200)
			.log().all();
		}
	}

	
	@Test
	public void get1()
	{
		given()
		.when()
		.get("http://localhost:3000/Students")
		.then()
		.statusCode(200)
		.log().all();
	}
}
