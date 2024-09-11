package Practice;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
public class Class1
{
	
	
	
	
//	@Test
	public void m1()
	{
		given()
		.contentType("application/json")
		.when()
		.get("http://localhost:3000/Students")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}

	
	
	@Test
	public void post() throws FileNotFoundException
	{
	/*	HashMap mp=new HashMap();
		mp.put("author", "kumar Saurav");
		mp.put("category", "Mobile testing");
		mp.put("price", "150.50");
		mp.put("title", "Appium Testing");
		
		*//*
		JSONObject mp= new JSONObject();
		mp.put("name", "kumar Saurav");
		mp.put("location", "Mobile testing");
		mp.put("phone", "854712");
		*/
		
		
		File m=new File("D:\\eclipse\\Rest_Assured\\body.json");
		FileReader fr= new FileReader(m);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.post("http://localhost:3000/Students")
		.then()
		.statusCode(201)
	
		.log().all();
		
	}
	
	
	//@Test
	public void delete()
	{
		given()
		.when()
		.delete("http://localhost:3000/Students/6")
		.then()
		.statusCode(200);
	}
	
	
	
}
