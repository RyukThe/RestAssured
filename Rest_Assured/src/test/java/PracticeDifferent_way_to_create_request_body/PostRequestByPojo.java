package PracticeDifferent_way_to_create_request_body;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PostRequestByPojo 
{

	//@Test
	private void post() {
		POJOCLASS data=new POJOCLASS();
		data.setName("Saurav");
		data.setLocation("Karanja");
		data.setPhone("xxxxxxx");
		String crs[]= {"Java","python"};
		data.setCourses(crs);
		
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.header("Content-Type","application/json; charset=utf-8");

	}
	
	
	
	@Test
	public void get()
	{
		given()
		.when()
		.get("http://localhost:3000/Students")
		.then()
		.log().all();
	}
	
	
	@Test
	public void delete()
	{
		for(int i=5;i<=8;i++)
		{
			given()
		
		.when()
		.delete("http://localhost:3000/Students/"+i)
		.then()
		.log().all();
		}
	}
}
