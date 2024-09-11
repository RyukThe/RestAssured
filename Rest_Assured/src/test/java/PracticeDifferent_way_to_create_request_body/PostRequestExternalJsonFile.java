package PracticeDifferent_way_to_create_request_body;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PostRequestExternalJsonFile 
{
	@Test
	public void post() throws FileNotFoundException
	{
		File  f=new File("D:\\eclipse\\Rest_Assured\\src\\test\\java\\PracticeDifferent_way_to_create_request_body\\body2.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject data= new JSONObject(jt);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
		.log().all();
		
		
	}

}
