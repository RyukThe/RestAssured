package Parsing_of_Validate_XML_Response_data;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class PxmlParsing {
	
	@Test
	public void xmlparsing()
	{
		
		baseURI="http://restapi.adequateshop.com/";
		basePath="api";
		
		Response re = given().log().all().contentType(ContentType.XML).pathParam("path", "Traveler").queryParam("page", 1)
		
		.when().get("{path}");
		
		XmlPath p=new XmlPath(re.asString());
		List<String> list = p.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		System.out.println(p.getString("TravelerinformationResponse.travelers.Travelerinformation[1].name"));
		boolean isPresent=false;
		for(String s:list)
		{
			//System.out.println(s);
			if(s.equals("Ashor"))
			{
				isPresent=true;
				break;
			}
		}
		
		Assert.assertTrue(isPresent);
	}

}
