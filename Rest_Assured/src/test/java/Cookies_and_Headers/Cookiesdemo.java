package Cookies_and_Headers;

import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;
public class Cookiesdemo {
// how capture cookies
	//@Test
	public void get()
	{
		given()
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","")
		.log().all();
	}
	
	@Test
	public void getcookiesinfo()
	{
		io.restassured.response.Response rs=
		given()
		.when()
		.get("https://www.google.com/");
		
		//get single cookies information 
	/*	String cookie_value = rs.getCookie("AEC");
		System.out.println(cookie_value);
		*/
		
		//get all cookies values
		Map<String, String> all_cookies = rs.getCookies(); 
		
		Set<String> keys = all_cookies.keySet();
		
		
		for(String key:keys)
		{
			System.out.println("cookie name: "+key+ "||  value is = "+ all_cookies.get(key) );
			
		}
	
	}
}
