package RestAssured_01;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class HTTPREQUEST_GET 
{
	@Test
	public void getUser()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2") // no need to use ; here because  it interconnected 
		.then()
		.statusCode(200)
		.body("page",equalTo(2)) // this assertion use in rest assured.
		.log().all();//this will show all response on console. 
	}
	
	
}
