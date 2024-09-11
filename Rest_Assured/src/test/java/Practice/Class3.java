package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.JSONObject;
public class Class3 
{
	
	@Test
	public void parsingOfJsonData()
	{
		given()
		.contentType(ContentType.JSON)
	
		.when()
		.get("http://localhost:3000/Store")
		.then()
		.body("book[0].title", equalTo("Automation practice Using Java Selenium"))
		
		;
	}

	
	@Test
	public void parsingOfJsonData2()
	{
		Response jo = given()
		.contentType(ContentType.JSON)
	
		.when()
		.get("http://localhost:3000/Store");
		
		String title = jo.jsonPath().get("book[0].title").toString();
		
			Assert.assertEquals(title, "Automation practice Using Java Selenium");
	}
	
	
	//@Test
	public void parsing3()
	{
		
		Response rs = given().contentType(ContentType.JSON).when().get("http://localhost:3000/Store");
	
			String jos = rs.asPrettyString();
			
			JSONObject j=new JSONObject(jos);
			
			
			for(int i=0;i<j.getJSONArray("book").length();i++)
			{
				String title = j.getJSONArray("book").getJSONObject(i).get("title").toString();
				
				System.out.println("book title of book "+ (i+1)+" "+title);
			
			
			}
	}

	
	@Test
	public void parsing4()
	{
		
		
		Response rs = given().contentType(ContentType.JSON).when().get("http://localhost:3000/Store");
	
			JSONObject j= new JSONObject(rs.asPrettyString());
			
			
			
			boolean status=false;	
			
			for(int i =0;i<j.getJSONArray("book").length();i++)
			{
				String title = j.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(title);
				if(title.equals("The Great Gatsby"))
				{
					status=true;
					break;
				}
			}
	
			Assert.assertTrue(status);
			
			
			
			
			
			double total=0.0d;
			
			for(int i=0;i<j.getJSONArray("book").length();i++)
			{
				String p = j.getJSONArray("book").getJSONObject(i).get("price").toString();
					
				double pd = Double.parseDouble(p);
				total=total+pd;
				
				
			
			}
		
			System.out.println(total);
			
			Assert.assertEquals(total, 644.98);
			
	}
	
	
	@Test
	public void getCookies()
	{
		//https://reqres.in/api/users?delay=3
		
	Response rs = given()
		.contentType(ContentType.JSON)
		.pathParam("path", "users")
		.queryParam("delay", "3")
		.when()
		.get("https://reqres.in/api/{path}")
		;
	
		Headers heads = rs.getHeaders();
		
		for(Header h:heads)
		{
			System.out.println(h);
		}
		
	}
	
	
	
	@Test
	public void getCookiesName()
	{
		Response rs = given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://www.google.com/");

		
		Map<String, String> cookies = rs.getCookies();
		
		for(String cookiesName:cookies.keySet())
		
		{
			System.out.println(cookiesName);
		}
	}
}
