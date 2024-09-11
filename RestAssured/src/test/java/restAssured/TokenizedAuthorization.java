package restAssured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TokenizedAuthorization {

	
	@Test
	public void generateToken()
	{
		/*HashMap mp=new HashMap();
		mp.put("userName", "Prathmesh11");
		mp.put("password", "Velocity@1235"); */
		
		baseURI="https://bookstore.toolsqa.com/";
		String R = given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "  \"userName\": \"Prathmesh11\",\r\n"
				+ "  \"password\": \"Velocity@1235\"\r\n"
				+ "}")
		.when().post("/Account/v1/GenerateToken").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(R);
		
		JsonPath j= new JsonPath(R);
		String t=j.getString("token");
		System.out.println(t);
	}
}
