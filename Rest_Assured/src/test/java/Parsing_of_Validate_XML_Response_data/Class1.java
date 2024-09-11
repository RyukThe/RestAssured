package Parsing_of_Validate_XML_Response_data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class Class1 {
	
	//@Test
	public void validateXMLResponse()
	{
		//1st -> without returning response in variable. 
			given()
			.contentType(ContentType.JSON)
			.pathParam("mypath", "Traveler")
			.queryParam("page", 1)
		.when()
		.get("http://restapi.adequateshop.com/api/{mypath}")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1")) // here we are checking that on this node value 1 is present or not
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		;
	}
	
	
	
	
	//@Test
	public void approch2()
	{
		Response r=given()
		.contentType(ContentType.XML)
		.pathParam("path", "Traveler")
		.queryParam("page", 1)
		.when()
		.get("http://restapi.adequateshop.com/api/{path}");
	Assert.assertEquals( r.getStatusCode(),200);
	Assert.assertEquals(r.header("Content-type"),"application/xml; charset=utf-8");
	Assert.assertEquals(r.xmlPath().get("TravelerinformationResponse.page").toString(), "1");
	Assert.assertEquals(r.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString(), "Developer");
	
	String name = r.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	Assert.assertEquals(name, "Developer");
	
	}
	
	
	
	
	@Test
	public void extraValidation()
	{
		Response r=given()
		.contentType(ContentType.XML)
		.pathParam("path", "Traveler")
		.queryParam("page", 1)
		.when()
		
		.get("http://restapi.adequateshop.com/api/{path}");
		
		XmlPath  ob= new XmlPath(r.asString()) ;//
		//like find total number of travelers in xml response 
		//to capture all node present in travelers that's why we use getList() which multiple nodes
		// getList() get all nodes and return type is list of string and as it in list we can use size() of list how many records are there
		List<String> T = ob.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		Assert.assertEquals(T.size(), 10);
		
		
		// verify traveler name is present 1st we have to capture all name from response and then we have to compare 
		// with our expected valued 
		
		List<String> names=ob.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean result=false;
		
		for(String name:names)
		{
			if(name.equals("karen"))
			{
				result=true;
				break;
			}
		}
		
		
		Assert.assertTrue(result, "Name is not present ");
		
		
		
	}
}
