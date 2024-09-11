package Cookies_and_Headers;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Headers {

	
	@Test
	public void headers()
	{
	 given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
	 	.header("Content-Encoding","gzip")
	 	.and()
	 	.header("Server", "gws")
	 	
	 	.log().cookies();
	 

	}
	
	
	//@Test
	public void getHeaders()
	{
		Response res = given()
		.when()
		.get("https://www.google.com/");
	
	//String headervalue = res.getHeader("Content-Type");
	//System.out.println(headervalue);
		
		io.restassured.http.Headers myHeaders = res.getHeaders();
	
	
		for(Header head:myHeaders)
		{
			System.out.println(head.getName() +"            "+ head.getValue());
		}
	}
}
