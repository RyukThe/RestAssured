package restAssuredPracticeDay1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;
public class RestAssuredDay2 {
	
	//@Test
	public void  getCookies()
	{
		baseURI="https://www.google.com/";
		
		Response res = given().log().all().header("Content-Type","application/json")
		.when().get();
		
		Map<String, String> all = res.getCookies();
			Set<String> keys = all.keySet();
			
			for(String key:keys)
			{
				System.out.println(key +"---> "+all.get(key));
			}
			
			
		Headers allh = res.getHeaders();
		
		for(Header h:allh)
		{
			System.out.println(h.getName()+ "---> "  +h.getValue());
		}
	}
	
	
	
	@Test
	public void getRequest()
	{
		baseURI="https://reqres.in/";
		basePath="api";
		
//		String r=given().log().all().contentType(ContentType.JSON).pathParam("path", "users/2")
//		.when().get("{path}").then().assertThat().statusCode(200).log().all().extract().response().asString();
		
//		
//		JsonPath j= new JsonPath(r);
//	System.out.println	(j.getString("page"));
		
//		given().log().all().header("Content-Type","application/json")
//		.when().get("users/2").then().assertThat().statusCode(200).log().all().body("data.email", equalTo("janet.weaver@reqres.in"));
//		
		
		
		Response res = given().log().all().contentType(ContentType.JSON).pathParam("path", "users")
		.queryParam("page", 2).when().get("{path}");
		
		
		
	System.out.println	(res.jsonPath().get("data[0].email"));
	//System.out.println(res.getHeaders());
	
		
	}
	
	

}
