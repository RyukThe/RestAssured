package Practice25April;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Class1 {
	
	
	
	//@Test
	public void test1()
	{
		//https://reqres.in/api/users/2
		given().
		contentType(ContentType.JSON)
		.pathParam("path", "users")
		.pathParam("path2", 2)
		.when()
		.get("https://reqres.in/api/{path}/{path2}")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

	
	
	//@Test
	public void pub() {
	//https://reqres.in/api/users
		
		HashMap mp=new HashMap();
		mp.put("name", "Saurav Kasture");
		mp.put("job", "UnEmployed");
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("path", "users")
		.body(mp)
		
		.when()
		.post("https://reqres.in/api/{path}")
		
		.then()
		
		.statusCode(201)
		.header("Content-Type", "application/json; charset=utf-8")
		.and()
		.body("name", equalTo("Saurav Kasture"))
		.body("job", equalTo("UnEmployed"));

	}
	
	
//	@Test
	public void put()
	{
		
		JSONObject data=new JSONObject();
		data.put("name", "Saurav Jain");
		data.put("job", "UNP");
		
		
		
		given()
		.contentType(ContentType.JSON)
		.body(data.toString())
		
		.when()
		
		.put("https://reqres.in/api/api/users/2")
		.then()
		.statusCode(200)
		.header("Content-type", "application/json; charset=utf-8")
		.body("name", equalTo("Saurav Jain"));
	}
	
	
	//@Test
	public void delete()
	{
		given().when().delete("https://reqres.in/api/users/2").then().statusCode(204);
	}
	
	
	
	@Test
	public void cookies()
	{
		Response r = given()
		.when()
		.get("https://www.google.com/")
		
		
		;
		
		Map<String, String> cookies = r.getCookies();
	System.out.println(cookies.size());
	for(String cookie:cookies.keySet())
	{
		System.out.println(cookie + "- "+ cookies.get(cookie));
	}
	
	
	
			Headers f = r.headers();
			
			for(Header h:f)
			{
				System.out.println(h.getName() + " -->" + h.getValue());
			}
	}
	
	
}
