package Different_way_to_create_request_body;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.google.gson.JsonObject;

public class ByUSINGOrg_json 
{
	@Test
	public void postREquestByUsingOrg_json_Laibrary()
	{
	JSONObject data= new JSONObject()
			;// we have to create object of JasonObject Class.
		data.put("name", "Saurav");
		data.put("location", "India");
		data.put("phone", "XXXXXXXXXXX");
		
		String coursear[]= {"C#","Java"};
		data.put("Courses",coursear );
		
		given()
		.contentType("application/json")
		.body(data.toString()) // this convert data from json to string 
		.when()
		.post("")
		
		.then()
		.statusCode(201)
		
		;
		
	}

}
