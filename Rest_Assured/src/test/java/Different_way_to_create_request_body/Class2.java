package Different_way_to_create_request_body;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Class2 {

	
	@Test
	public void GetRequest()
	{
		given()
		
		.when()
		
		.get("")
		.then()
		.statusCode(200)
		.body("phone", equalTo("XXXXXXXXX"))
		.header("Content-type", "application/json; charset=uft-8")
		;
	}
}
