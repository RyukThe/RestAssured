package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
public class Class1 {

	
	//@Test
	
	public void getRequest()
	{
		baseURI="https://reqres.in/";
		
		String R = given().log().all().header("Content-Type","application/json")
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200).body("data[0].email", equalTo("michael.lawson@reqres.in")).extract().response().asString();
	
			JsonPath jp= new JsonPath(R);
			
		System.out.println(jp.getString("data[0].email"));
	
	}
	
	
	
	//@Test
	public void getRequest2()
	{
		baseURI="https://reqres.in/";
		
	Response re = given().log().all().contentType(ContentType.JSON)
			.when().get("/api/users?page=2");
	
	
		JSONObject j= new JSONObject(re.asPrettyString());
		for(int i=0;i<j.getJSONArray("data").length();i++)
		{
			String rs = j.getJSONArray("data").getJSONObject(i).get("email").toString();
		
			System.out.println(rs);
		}
				
	}
	
	
//	@Test
	public void postUsingPojo()
	{
		baseURI= "https://reqres.in/";
		
		POJO1 p= new POJO1();
		p.setName("Saurav Kasture");
		p.setJob("QA Engineer");
		
		given().log().all().contentType(ContentType.JSON).body(p)
		.when().post("/api/users")
		.then().statusCode(201).log().all();
		
	}
	
	
//	@Test
	public void postbyJSONObject()
	{
		baseURI="https://reqres.in/";
		
		basePath="/api/users";
		
		JSONObject j=new JSONObject();
		j.put("name", "Saurav");
		j.put("job", "listener");
		
		given().log().all().contentType(ContentType.JSON).body(j.toString())
		
		.when().post().then().assertThat().statusCode(201);
	}
	
	
	//@Test
	public void postByUsingExternalFile() throws FileNotFoundException
	{
		baseURI = "https://reqres.in/";
		basePath="/api/users?page=2";
		
		File f=new File(".\\Job.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject j=new JSONObject(jt);
		
		given().log().all().contentType(ContentType.JSON).body(j.toString())
		.when().post().then().assertThat().statusCode(201).log().all();
		
	}
	
	
	int id;
	
	//@Test
	public void postRequest() throws FileNotFoundException
	{
		baseURI="http://localhost:3000";
		basePath="/Students";
		
		File f=new File(".//body.json") ;
		FileReader fr=new FileReader(f);
		JSONTokener jr= new JSONTokener(fr);
		JSONObject jt= new JSONObject(jr);
		
		id=given().log().all().contentType(ContentType.JSON).body(jt.toString())
		.when().post().jsonPath().getInt("id");
		System.out.println(id);
	}
	
	
	//@Test
	public void delete()
	{
		baseURI="http://localhost:3000";
		
		
		for(int i=8;i<=9;i++)
		{
			given().log().all().header("Conetnt-Type","application/json").when().delete("/Students/"+i).then().assertThat().statusCode(200).log().all();
		}
	}
	
	
	
	//@Test
	public void jsonParsing1()
	{
		baseURI="http://localhost:3000";
		basePath="/Store";
		
		Response re = given().log().all().header("Content-Type","application/json").when().get();
	
		System.out.println(re.getBody().asPrettyString());
		JSONObject js=new JSONObject(re.asPrettyString());
		
	boolean status=false;
	
	for(int i=0;i<js.getJSONArray("book").length();i++)
	{
		String authore = js.getJSONArray("book").getJSONObject(i).get("author").toString();
	
		if(authore.equals("Saurav Kasture"))
		{
			status=true;
			break;
		}
	}
			
	
	Assert.assertTrue(status);
	}
	
	
//	@Test
	public void jsonParsing()
	{
		baseURI="http://localhost:3000";
		basePath="/Store";
		String rs = given().log().all().contentType(ContentType.JSON)
		.when().get().then().extract().response().asPrettyString();
	
		JsonPath js= new JsonPath(rs);
			System.out.println	(js.getString("book[3].author"));
	}
	
	
	//@Test
	public void xmlparsing()
	{
		 given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1").then().statusCode(200).log().all().
		 body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	
		
		
	}
	
	
	//@Test
	public void xmlParsing()
	{
		Response r = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath x=new XmlPath(r.asPrettyString());
		System.out.println(x.getString("TravelerinformationResponse.travelers.Travelerinformation[0].name"));
		
		List<String> xc = x.getList("getString(\"TravelerinformationResponse.travelers.Travelerinformation.name");
	
		boolean s=false;
		for(String name:xc)
		{
			if(name.equals("Developer"))
			{
				s=true;
				break;
			}
			
		}
		
		Assert.assertTrue(s);
		
		
	}
	
	
	
	@Test
	public void xmlparsing2()
	{
		Response r = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
			//String s = r.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation[1].email");
	
			//System.out.println(s);
		
		XmlPath m=new XmlPath(r.asPrettyString());
		List<String> emails = m.getList("TravelerinformationResponse.travelers.Travelerinformation.email");
		
		
		boolean s=false;
		
		for(String email:emails)
		{
			if(email.equals("qwwerrwerweeqw@mail.ru"))
			{
				s=true;
				break;
			}
		}
		
		assertTrue(s,"---email id not found---");
	}
}
