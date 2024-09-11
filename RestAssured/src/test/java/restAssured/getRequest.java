package restAssured;

import static io.restassured.RestAssured.given; // static import // here we add static in-front of that we write static and then from that class which static part we have to import we mention it 

import org.testng.annotations.Test;

//this old concept in java version java 5 //advantage of this static import is that if we want to use one static  method many time then there is no need to write class name again and again. just readability is get increase by doing this. 
import io.restassured.RestAssured;
import static  org.hamcrest.Matchers.equalTo;
public class getRequest
{
	@Test
	public void getrequest()
	{
		//we have to mention end point web site is build with 3 thing resource end point & parameter
		//1st we define end point 
		String r = RestAssured.baseURI="https://reqres.in/"; //end point 
		//RestAssured is class and baseURI is static variable declare in restAssured class
		
		//1st is given section 
		// 2nd section when
		// then section 
		// in given section we write pre-requisite code like parameters authentication  1st we have to set it 
		// before sending request 
		
		//---------------------------------------------------------------------------------------------------------------------		
		// in when section we have to write action which want to perform. like which request / task we want to perform we write in when section 
		//-------------------------------------------------------------------------------------------------		
		
		// in then section we have to write code for validation the response we get after hitting request we get some response code then we will validate that code 
		// here we validate expected and actual response code. all assertion or validation code we write in then section 
		given().log().all().header("Content-Type","application/json")//given () is static method of resAssured class. here while calling static method of another class we dont use class name we just call method name how? because in java there concept called static import 
		//in header we specify that we are sending which type data to server for we use input content-Type and 
		//header is meta data means data about the data here we are sending  information about actual  data to server that we are passing json data
		//logs when execution start then all background processes are monitor/track  by using log.
		//here also we are sending request and server and some background process are going on so to monitor and track that all process we use log().all()
		//Because while sending request if failure occur then to see that at which point actual failure occur this logs helps to  find that point 
		.when().get("api/users?page=2")
		.then()
		
		.log().all()
		.assertThat().statusCode(200).body("page", equalTo(2)).extract().response().asString();
		;
	}
	
}
