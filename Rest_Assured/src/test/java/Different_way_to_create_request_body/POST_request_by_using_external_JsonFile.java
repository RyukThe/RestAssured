package Different_way_to_create_request_body;
import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class POST_request_by_using_external_JsonFile {

	
	
	@Test
	public void postRequest() throws FileNotFoundException
	{
		File f= new File("D:\\eclipse\\Rest_Assured\\body.json");//or.//body.json // this will open file 
		FileReader fr= new FileReader(f); //this will read data in file
		JSONTokener jt=new JSONTokener(fr); //this will extract data in json object
		JSONObject data= new JSONObject(jt); // here store json data in jsonobject we get JSON obejct i.e. data in json  object then we can pass this data in body
		
		given()
		.body(data.toString())
		.when()
		.post("")
	
		.then()
		.statusCode(201)
		;
	
	}
}
