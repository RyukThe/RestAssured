package Practice;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class Cookies 
{
	//@Test
	public void cookies1()
	{
		
		//https://reqres.in/api/users?page=2&id=5
		given()
		.contentType("Content-Type.json")
		.pathParam("mypath", "users")
		.queryParam("page", "2")
		.queryParam("id", "5")
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200);
		
	}

	
	//@Test
	public void cookies2()
	{
		 Response r = given()
		.contentType("application/json")
	
		.when()
		.get("https://www.google.com/");
		
		System.out.println(r.getCookie("AEC"));
	
		Map<String, String> keys = r.getCookies();
		
		for(String k:keys.keySet())
		{
			System.out.println(k + " = "+keys.get(k));
		}
	}
	
	
	//@Test
	public void getHeaders()
	{
		Response r = given()
		.contentType("application/json")
		.when()
		.get("https://www.google.com/");
		
		Headers headers = r.getHeaders();
		
		for(Header h:headers)
		{
			System.out.println(h.getName()+ " = " + h.getValue());
		}
	}
	
	//@Test
	void cookies3()
	{
		Response r = given()
		.when()
		.get("https://www.google.com/")
		;
		
		Map<String, String> cookies = r.getCookies();
	
		for(String cookie:cookies.keySet())
		{
			System.out.println(cookie +" ---> " +cookies.get(cookie));
		}
	}
	
	@Test
	public void testHeaders()
	{
		Response r=given()
		.when()
		.get("https://www.google.com/");
	//	String hd = r.getHeader("Content-Type");
		//System.out.println(hd);
		
		Headers hds = r.getHeaders();
		
		for(Header hd:hds)
		{
			System.out.println(hd.getName()+ " --> "+ hd.getValue());
		}
	
	}
	
}
