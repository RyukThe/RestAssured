package restAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class requestSpecification {

	RequestSpecification reqBuilder;
	
	@BeforeTest
	public void setUp()
	{
		this.reqBuilder= (RequestSpecification) new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.setBasePath("/api/users").addQueryParam("page", 2).build();
		
	}
	
	@Test
	public void get()
	{
		given().log().all()
		.spec(reqBuilder)
		.when().get()
		.then().assertThat().statusCode(200);
	}
}
