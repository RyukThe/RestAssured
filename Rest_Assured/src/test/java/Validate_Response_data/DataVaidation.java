package Validate_Response_data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class DataVaidation {
		//@Test
		
		public void datavaldiation()
		{
			Response r = given()
			        .contentType(ContentType.JSON)
			        .when()
			        .get("http://localhost:3000/Store");
			        
			    String re = r.asString();
			    
			    JSONObject o= new JSONObject(re);
			    
			    for (int i = 0; i < o.getJSONArray("book").length(); i++) {
			        System.out.println(o.getJSONArray("book").getJSONObject(i).get("title").toString());
			    }

			
		}	
		
		
		@Test
		public void Particular_Is_present()
		{
			Response res = given()
					.contentType(ContentType.JSON)
			.when()
			.get("http://localhost:3000/Store");
			
			JSONObject j=new JSONObject(res.asString());
			
			boolean status=false;
			
			for(int i=0;i<j.getJSONArray("book").length();i++)
			{
				String title = j.getJSONArray("book").getJSONObject(i).get("title").toString();
				if(title.equals("Harry Potter and the Philosopher's Stone"))
				{
					status=true;
					break;
				}
			
				
			}
			
			
			double totalprice=0;
			for(int i=0;i<j.getJSONArray("book").length();i++)
			{
				String price = j.getJSONArray("book").getJSONObject(i).get("price").toString();
				double price_ = Double.parseDouble(price);
				totalprice=price_+totalprice;
				
			}
			
			Assert.assertEquals(status, true);	
			
			System.out.println(totalprice);
		}
}
